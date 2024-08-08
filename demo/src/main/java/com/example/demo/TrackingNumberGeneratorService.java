package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TrackingNumberGeneratorService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public synchronized String generateTrackingNumber() {
        String trackingNumber = UUID.randomUUID().toString();
        while (redisTemplate.hasKey(trackingNumber)) {
            trackingNumber = UUID.randomUUID().toString();
        }
        redisTemplate.opsForValue().set(trackingNumber, "1");
        return trackingNumber;
    }
}
