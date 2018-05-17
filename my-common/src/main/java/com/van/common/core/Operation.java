package com.van.common.core;

import java.lang.annotation.*;

/**
 * 配合操作日志使用, 注解在Controller Bean 的方法上
 *
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Operation {

    /**
     * 模块名称
     *
     * @return the string
     * @author : yangjunqing / 2018-05-17
     */
    String module() default "";

    /**
     *
     * @return the string
     * @author : yangjunqing / 2018-05-17
     */
    OperationMethod method() default OperationMethod.unkown;
}
