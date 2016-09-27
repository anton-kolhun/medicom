package com.springapp.config;


import com.hazelcast.config.Config;
import com.hazelcast.config.MaxSizeConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableCaching
public class HazelCastConfig {

    private static final int HZ_CACHE_TTL_SEC = 15;
    public static final String ACCOUNTS_TREE_LOOKUP_DATA = "lookup";


    @Bean
    public HazelcastInstance hazelcastInstance() {
        Config config = new Config();
        config
                .getMapConfig(ACCOUNTS_TREE_LOOKUP_DATA)
                .setTimeToLiveSeconds(HZ_CACHE_TTL_SEC)
                .setMaxSizeConfig(new MaxSizeConfig(25,
                        MaxSizeConfig.MaxSizePolicy.FREE_HEAP_PERCENTAGE));
        return Hazelcast.newHazelcastInstance(config);
    }


    @Bean
    public CacheManager hazelCastCacheManager() {
        return new com.hazelcast.spring.cache.HazelcastCacheManager(hazelcastInstance());
    }

}
