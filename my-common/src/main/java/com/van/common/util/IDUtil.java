package com.van.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 分布式系统唯一ID生成
 *
 */
public class IDUtil {

    /**
     * UUID  无规则的36位数字，业务表不建议使用
     * @return
     */
    public static String uuid(){
        return UUID.randomUUID().toString();
    }

    /**
     *  在uuid生产无规则的字符串加入tag标识。
     *  例如 Customer表可以用Cu，送货表用De
     *  从而达到通过主键可以辨识是数据什么业务数据
     * @param tag
     * @return
     */
    public static String uuidWithTag(String tag){
        if (tag == null || "".equals(tag.trim())){
            throw new IllegalArgumentException("tag号不能为空！");
        }
        return tag + UUID.randomUUID().toString();
    }

    /**
     *  在uuid生产无规则的字符串加入tag标识和日期
     *  从而达到通过主键可以辨识是数据什么业务数据,什么时间产生的
     * @param tag
     * @return
     */
    public static String uuidWithTagDate(String tag){
        if (tag == null || "".equals(tag.trim())){
            throw new IllegalArgumentException("tag号不能为空！");
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

        return tag + format.format(new Date()) + UUID.randomUUID().toString();
    }



    /**
     * twitter 开源的方法，生成唯一ID IDWork
     * @return
     */
//    public static String twitterId(){
//
//    }



    public static void main(String[] args) {
        System.out.println(IDUtil.uuid());
        System.out.println(IDUtil.uuidWithTag("CU"));
        System.out.println(IDUtil.uuidWithTagDate("CU"));
    }
}
