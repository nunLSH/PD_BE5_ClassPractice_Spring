package com.grepp.spring.infra.config;

import com.grepp.spring.app.model.auth.RefreshTokenRepository;
import com.grepp.spring.app.model.auth.entity.RefreshToken;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Slf4j
@SpringBootTest
class RedisConfigTest {

    @Autowired
    LettuceConnectionFactory connectionFactory;
    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Test
    public void testRedisTemplate() {
        refreshTokenRepository.save(new RefreshToken("test@test.com"));
    }
}