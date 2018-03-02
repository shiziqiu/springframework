package com.shiziqiu.springframework.aop;

/**
 * @author yihua.huang@dianping.com
 */
/**
 * @title : ClassFilter
 * @author : shiziqiu
 * @date : 2018年3月2日 下午1:52:36
 * @Fun : 匹配Class实例
 */
public interface ClassFilter {

    boolean matches(Class targetClass);
}
