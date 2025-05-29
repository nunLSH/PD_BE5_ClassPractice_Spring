package com.grepp.spring.infra.config;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.security.jackson2.CoreJackson2Module;
import org.springframework.security.jackson2.SecurityJackson2Modules;
import org.springframework.security.web.jackson2.WebJackson2Module;

@Configuration
@EnableRedisRepositories
public class RedisConfig {

    @Value("${spring.data.redis.port}")
    private int port;
    @Value("${spring.data.redis.host}")
    private String host;
    @Value("${spring.data.redis.username}")
    private String username;
    @Value("${spring.data.redis.password}")
    private String password;

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setPort(port);
        configuration.setHostName(host);
        configuration.setPassword(password);
        configuration.setUsername(username);

        return new LettuceConnectionFactory(configuration);
    }

    @Bean
    public RedisSerializer<Object> springSessionDefaultRedisSerializer() {

        ClassLoader loader = getClass().getClassLoader();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModules( SecurityJackson2Modules.getModules(loader));

        // 1. Java 8 Date/Time API 지원을 위한 모듈 등록 (필수 권장)
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); // 날짜를 타임스탬프가 아닌 문자열로 직렬화

        // 2. Spring Security 객체 직렬화/역직렬화 지원 (가장 중요한 부분)
        // 이 두 모듈은 'spring-security-core' 및 'spring-security-web' 내부에 포함되어 있습니다.
        mapper.registerModule(new CoreJackson2Module());
        mapper.registerModule(new WebJackson2Module());

        mapper.activateDefaultTyping(
            BasicPolymorphicTypeValidator.builder()
                .allowIfBaseType("org.springframework.security.") // 기존 설정 (유지)
                .allowIfBaseType("com.grepp.spring.")    // 당신의 도메인 객체 패키지 (유지)
                .allowIfSubType(Object.class)
                .build(),
            ObjectMapper.DefaultTyping.NON_FINAL,
            JsonTypeInfo.As.PROPERTY
        );

        return new GenericJackson2JsonRedisSerializer(mapper);
    }

}