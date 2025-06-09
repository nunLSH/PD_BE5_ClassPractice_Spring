package com.grepp.spring.infra.auth.oauth2.user;

import com.grepp.spring.app.model.auth.AuthService;
import com.grepp.spring.app.model.auth.token.RefreshTokenService;
import com.grepp.spring.infra.auth.token.JwtProvider;
import com.grepp.spring.infra.auth.token.code.TokenType;
import io.jsonwebtoken.Claims;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OAuth2FailureHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final AuthService authService;
    private final JwtProvider jwtProvider;
    private final RefreshTokenService refreshTokenService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
        Authentication authentication) throws IOException, ServletException {

        String requestAccessToken = jwtProvider.resolveToken(request, TokenType.ACCESS_TOKEN);
        String requestRefreshToken = jwtProvider.resolveToken(request, TokenType.REFRESH_TOKEN);

        if (requestAccessToken == null && requestRefreshToken == null) {
            return;
        }

        Claims claims = jwtProvider.parseClaim(requestAccessToken);
        refreshTokenService.deleteByAccessTokenId(claims.getId());
    }
}
