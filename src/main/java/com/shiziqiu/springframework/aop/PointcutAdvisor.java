package com.shiziqiu.springframework.aop;
/**
 * @title : PointcutAdvisor
 * @author : shiziqiu
 * @date : 2018年3月2日 下午1:53:27
 * @Fun : ?未知
 */
public interface PointcutAdvisor extends Advisor{

   Pointcut getPointcut();
}
