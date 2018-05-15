package com.van.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 获得Spring应用上下文
 */
public class AppContextUtil implements ApplicationContextAware {

    public static ApplicationContext applicationContext = null;

    /**
     * Spring 启动时,会将ApplicationContext的实例注入进来
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        applicationContext = applicationContext;
    }


    /**
     * 通过Bean Name查询Spring容器中已的bean实例
     * @param s
     * @param <T>
     * @return
     * @throws BeansException
     */
    public static <T> T getBean(String s) throws BeansException {
        return (T) applicationContext.getBean(s);
    }
}
