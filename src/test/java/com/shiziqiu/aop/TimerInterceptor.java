package com.shiziqiu.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
/**
 * @title : TimerInterceptor
 * @author : shiziqiu
 * @date : 2018年3月2日 下午2:00:00
 * @Fun :
 */
public class TimerInterceptor implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("==============start=================");
		long time = System.nanoTime();
		System.out.println("Invocation of Method======开始======== " + invocation.getMethod().getName() + " start!");
		Object proceed = invocation.proceed();
		System.out.println("Invocation of Method=======结束======= " + invocation.getMethod().getName() + " end! takes " + (System.nanoTime() - time)
				+ " nanoseconds.");
		System.out.println("===============end====================");
		return proceed;
	}

}
