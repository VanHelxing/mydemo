package com.van.common.cache;

/**
 *
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
public interface CacheFactory {

    public Object get(String key);

    public void set(String key, Object object);
}
