package com.van.common.cache;

import com.van.common.domain.LoginInfo;

import java.util.Map;

/**
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
public interface MyCache {

    public final static String LOGIN_KEY = "LOGIN-";

    /**
     * Get t.
     *
     * @param <T>       the type parameter
     * @param key       the key
     * @param classType the class type
     * @return the t
     * @author : yangjunqing / 2018-05-18
     */
    public <T> T get(String key, Class<T> classType);

    /**
     * Set.
     *
     * @param key    the key
     * @param object the object
     * @author : yangjunqing / 2018-05-18
     */
    public void set(String key, Object object);

    /**
     * Set.
     *
     * @param key        the key
     * @param object     the object
     * @param expireTime the expire time
     * @author : yangjunqing / 2018-05-18
     */
    public void set(String key, Object object, long expireTime);

    /**
     * Get login info login info.
     *
     * @param key the key
     * @return the login info
     * @author : yangjunqing / 2018-05-18
     */
    public LoginInfo getLoginInfo(String key);

    /**
     * Sets login info.
     *
     * @param key        the key
     * @param loginInfo  the login info
     * @param expireTime the expire time
     * @author : yangjunqing / 2018-05-18
     */
    public void setLoginInfo(String key, LoginInfo loginInfo, long expireTime);

    /**
     * Update expire time.
     *
     * @param key        the key
     * @param expireTime the expire time
     * @author : yangjunqing / 2018-05-18
     */
    public void updateExpireTime(String key, long expireTime);

    /**
     * Remove.
     *
     * @param key the key
     * @author : yangjunqing / 2018-05-18
     */
    public void remove(String key);

    /**
     * Get all login info map.
     *
     * @return the map
     * @author : yangjunqing / 2018-05-18
     */
    public Map<String, LoginInfo> getAllLoginInfo();
}
