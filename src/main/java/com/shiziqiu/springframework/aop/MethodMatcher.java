package com.shiziqiu.springframework.aop;

import java.lang.reflect.Method;
/**
 * @title : MethodMatcher
 * @author : shiziqiu
 * @date : 2018年3月2日 下午1:52:55
 * @Fun : 匹配Class实例
 */
public interface MethodMatcher {

    boolean matches(Method method, Class targetClass);
}
