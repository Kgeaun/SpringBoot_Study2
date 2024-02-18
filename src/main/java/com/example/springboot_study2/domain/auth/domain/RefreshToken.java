package com.example.springboot_study2.domain.auth.domain;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@Builder
@RedisHash
public class RefreshToken {

    @Id
    private String accountId;

    @Indexed
    private String token;

    @TimeToLive
    private Long ttl;

    public void updateToken(String token, Long ttl) {
        this.token = token;
        this.ttl = ttl;
    }
}