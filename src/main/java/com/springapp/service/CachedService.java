package com.springapp.service;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CachedService {

    @Cacheable(value = "lookup")
    public String useCache(String key) {
        System.out.println("was not cached");
        return key;
    }
}
