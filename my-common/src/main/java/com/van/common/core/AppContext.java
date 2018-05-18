package com.van.common.core;

import com.van.common.cache.MyCache;
import com.van.common.cache.MyCacheFactory;
import com.van.common.domain.LoginInfo;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * 系统应用上下文
 *
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
public class AppContext {

    /**
     * DEFAULT_EXPIRE_TIME
     */
    private static long DEFAULT_EXPIRE_TIME = 1800000l; //30min

    /**
     * cache
     */
    private static MyCache cache;

    /**
     * instance
     */
    private static AppContext instance;

    /**
     * App context.
     */
    private AppContext() {
    }

    /**
     * Get instance app context.
     *
     * @return the app context
     * @author : yangjunqing / 2018-05-18
     */
    public static AppContext getInstance(){
        if (instance == null){
            synchronized (AppContext.class){
                instance = new AppContext();
                MyCacheFactory factory = new MyCacheFactory();
                cache = factory.createRedisCache();
            }
        }
        return instance;
    }


    /**
     * 当前会话用户信息
     *
     * @return the login info
     * @author : yangjunqing / 2018-05-18
     */
    public LoginInfo getLoginInfo(){
        String sessionId = RequestContextHolder.getRequestAttributes().getSessionId();
        if(sessionId != null || !"".equals(sessionId.trim())){
            String key = MyCache.LOGIN_KEY + sessionId;
            return cache.getLoginInfo(key);
        }
        return null;
    }

    /**
     * Get login info login info.
     *
     * @param key the key
     * @return the login info
     * @author : yangjunqing / 2018-05-18
     */
    public LoginInfo getLoginInfo(String key){
        return cache.getLoginInfo(key);
    }

    /**
     * Set login info.
     *
     * @param key       the key
     * @param loginInfo the login info
     * @author : yangjunqing / 2018-05-18
     */
    public void setLoginInfo(String key, LoginInfo loginInfo){
        cache.setLoginInfo(key, loginInfo, DEFAULT_EXPIRE_TIME);
    }

    /**
     * Uodate expire time. 使用默认时间
     *
     * @param key the key
     * @author : yangjunqing / 2018-05-18
     */
    public void updateExpireTime(String key){
        cache.updateExpireTime(key, DEFAULT_EXPIRE_TIME);
    }

    /**
     * Update expire time.
     *
     * @param key        the key
     * @param expireTime the expire time
     * @author : yangjunqing / 2018-05-18
     */
    public void updateExpireTime(String key, long expireTime){
        cache.updateExpireTime(key, expireTime);
    }

}
