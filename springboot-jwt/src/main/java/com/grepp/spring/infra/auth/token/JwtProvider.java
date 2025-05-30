package com.grepp.spring.infra.auth.token;

import com.grepp.spring.app.model.auth.RefreshTokenRepository;
import com.grepp.spring.app.model.auth.domain.Principal;
import com.grepp.spring.app.model.auth.entity.RefreshToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.crypto.SecretKey;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class JwtProvider {

    private RefreshTokenRepository refreshTokenRepository;

    @Value("${jwt.secrete}")
    private String key;

    @Getter
    @Value("${jwt.access-expiration}")
    private long atExpiration;

    @Getter
    @Value("${jwt.refresh-expiration}")
    private long rtExpiration;

    private SecretKey secretKey;


    public SecretKey getSecretKey(){
        if(secretKey == null){
            String base64Key = Base64.getEncoder().encodeToString(key.getBytes());
            this.secretKey = Keys.hmacShaKeyFor(base64Key.getBytes(StandardCharsets.UTF_8));
        }
        return this.secretKey;
    }

    public String generateAccessToken(Authentication authentication){
        String authorities = authentication.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.joining());

        long now = new Date().getTime();
        Date atExpiresIn = new Date(now + atExpiration);
        return Jwts.builder()
            .subject(authentication.getName())
            .claim("auth", authorities)
            .expiration(atExpiresIn)
            .signWith(getSecretKey())
            .compact();
    }

    public Authentication generateAuthentication(String accessToken){
        Claims claims = parseClaim(accessToken);
        List<? extends GrantedAuthority> authorities =
            Arrays.stream(claims.get("auth").toString().split(","))
                .map(SimpleGrantedAuthority::new)
                .toList();

        Principal principal = new Principal(claims.getSubject(), "", authorities);
        return new UsernamePasswordAuthenticationToken(principal, "", authorities);
    }

    private Claims parseClaim(String accessToken) {
        return Jwts.parser().verifyWith(getSecretKey()).build()
            .parseSignedClaims(accessToken).getPayload();
    }


}
