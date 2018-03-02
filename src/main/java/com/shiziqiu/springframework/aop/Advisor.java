package com.shiziqiu.springframework.aop;

import org.aopalliance.aop.Advice;
/**
 * @title : Advisor
 * @author : shiziqiu
 * @date : 2018年3月2日 下午1:46:21
 * @Fun :
 */
public interface Advisor {

	//获取通知事件
    Advice getAdvice();
}
