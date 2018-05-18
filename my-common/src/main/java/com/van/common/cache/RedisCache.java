package com.van.common.cache;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.van.common.domain.LoginInfo;
import com.van.common.util.JacksonUtil;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Redis Cache
 *
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
public class RedisCache implements MyCache {

    /**
     * String redis template
     */
    private StringRedisTemplate stringRedisTemplate;


    /**
     * Redis cache.
     *
     * @param stringRedisTemplate the string redis template
     */
    public RedisCache(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }


    /**
     * Get t.
     *
     * @param <T>       the type parameter
     * @param key       the key
     * @param classType the class type
     * @return the t
     * @author : yangjunqing / 2018-05-18
     */
    @Override
    public <T> T get(String key, Class<T> classType) {

        T t = null;
        String json = stringRedisTemplate.opsForValue().get(key);

        try {
            t = JacksonUtil.jsonToBean(json, classType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return t;
    }

    /**
     * Set.
     *
     * @param key    the key
     * @param object the object
     * @author : yangjunqing / 2018-05-18
     */
    @Override
    public void set(String key, Object object) {
        String json;

        try {
            json = JacksonUtil.beanToJson(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return;
        }

        stringRedisTemplate.opsForValue().set(key, json);
    }

    /**
     * Set.
     *
     * @param key        the key
     * @param object     the object
     * @param expireTime the expire time
     * @author : yangjunqing / 2018-05-18
     */
    @Override
    public void set(String key, Object object, long expireTime) {
        String json;

        try {
            json = JacksonUtil.beanToJson(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return;
        }

        stringRedisTemplate.opsForValue().set(key, json, expireTime);
    }

    /**
     * Get login info login info.
     *
     * @param key the key
     * @return the login info
     * @author : yangjunqing / 2018-05-18
     */
    @Override
    public LoginInfo getLoginInfo(String key) {
        LoginInfo loginInfo = null;
        String json = stringRedisTemplate.opsForValue().get(key);

        try {
            loginInfo = JacksonUtil.jsonToBean(json, LoginInfo.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loginInfo;
    }

    /**
     * Sets login info.
     *
     * @param key        the key
     * @param loginInfo  the login info
     * @param expireTime the expire time
     * @author : yangjunqing / 2018-05-18
     */
    @Override
    public void setLoginInfo(String key, LoginInfo loginInfo, long expireTime) {
        String json;
        try {
            json = JacksonUtil.beanToJson(loginInfo);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return;
        }

        stringRedisTemplate.opsForValue().set(key, json, expireTime, TimeUnit.MILLISECONDS);
    }

    /**
     * Update expire time.
     *
     * @param key        the key
     * @param expireTime the expire time
     * @author : yangjunqing / 2018-05-18
     */
    @Override
    public void updateExpireTime(String key, long expireTime) {
        stringRedisTemplate.expire(key, expireTime, TimeUnit.MILLISECONDS);
    }

    /**
     * Remove.
     *
     * @param key the key
     * @author : yangjunqing / 2018-05-18
     */
    @Override
    public void remove(String key) {
        stringRedisTemplate.delete(key);
    }

    /**
     * Get all login info map.
     *
     * @return the map
     * @author : yangjunqing / 2018-05-18
     */
    @Override
    public Map<String, LoginInfo> getAllLoginInfo() {
        Set<String> keys = stringRedisTemplate.keys(LOGIN_KEY + "*");
        Map<String, LoginInfo> loginInfoMap = null;

        if (keys != null && keys.size() != 0){
            for (Iterator<String> ite = keys.iterator(); ite.hasNext();){
                String key = ite.next();
                String json = stringRedisTemplate.opsForValue().get(key);
                try {
                    LoginInfo loginInfo = JacksonUtil.jsonToBean(json, LoginInfo.class);
                    loginInfoMap.put(key, loginInfo);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return loginInfoMap;
    }
}
