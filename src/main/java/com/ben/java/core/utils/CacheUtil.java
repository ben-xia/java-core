package com.ben.java.core.utils;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;

/**
 * @author xiabo
 * @date 2019/12/20
 * @Description token缓存管理器
 **/
public class CacheUtil {
    private static final Logger logger = Logger.getLogger(CacheUtil.class);
    public static Cache<String, String> cacheToken = CacheBuilder.newBuilder().expireAfterWrite(60*60, TimeUnit.SECONDS) // 过期时间7200s,TimeUnit.SECONDS可改
            .maximumSize(1000)// 最大缓存数量
            .build();

    public static String getToken(String key) {
        return cacheToken.getIfPresent(key);
    }

    public static void putToken(String key, String value) {
        cacheToken.put(key, value);
    }


    public static void remove(String key) {
        cacheToken.invalidate(key);
    }
}
