package com.van.common.cache;

import com.van.common.core.AppContext;
import com.van.common.util.AppContextUtil;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
public class MyCacheFactory {

    /**
     * My cache factory.
     */
    public MyCacheFactory() {
    }


    /**
     * Create redis cache redis cache.
     *
     * @return the redis cache
     * @author : yangjunqing / 2018-05-18
     */
    public RedisCache createRedisCache(){
        if (AppContextUtil.applicationContext != null){
            StringRedisTemplate redisTemplate = AppContextUtil.getBean("stringRedisTemplate");
            return new RedisCache(redisTemplate);
        }
        throw new RuntimeException("获取bean失败！");
    }
}
