package com.van.common.cache;

/**
 * 生产环境下使用的Cahce
 *
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
public class ProductCache implements CacheFactory {




    @Override
    public Object get(String key) {
        return null;
    }

    @Override
    public void set(String key, Object object) {

    }
}
