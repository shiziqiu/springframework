package com.shiziqiu.springframework.aop;
/**
 * @title : Pointcut
 * @author : shiziqiu
 * @date : 2018年3月2日 下午1:53:15
 * @Fun : 切点接口，Class匹配和方法匹配
 */
public interface Pointcut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();

}
