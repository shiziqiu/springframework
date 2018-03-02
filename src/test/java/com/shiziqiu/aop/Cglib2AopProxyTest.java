package com.shiziqiu.aop;

import org.junit.Test;

import com.shiziqiu.service.HelloWorldService;
import com.shiziqiu.service.impl.HelloWorldServiceImpl;
import com.shiziqiu.springframework.aop.AdvisedSupport;
import com.shiziqiu.springframework.aop.Cglib2AopProxy;
import com.shiziqiu.springframework.aop.TargetSource;
import com.shiziqiu.springframework.context.ApplicationContext;
import com.shiziqiu.springframework.context.ClassPathXmlApplicationContext;
/**
 * @title : Cglib2AopProxyTest
 * @author : shiziqiu
 * @date : 2018年3月2日 下午1:57:18
 * @Fun :
 */
public class Cglib2AopProxyTest {

	@Test
	public void testInterceptor() throws Exception {
		// --------- helloWorldService without AOP
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("testioc.xml");
		HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
		//helloWorldService.helloWorld();

		// --------- helloWorldService with AOP
		// 1. 设置被代理对象(Joinpoint)
		AdvisedSupport advisedSupport = new AdvisedSupport();
		TargetSource targetSource = new TargetSource(helloWorldService, HelloWorldServiceImpl.class,HelloWorldService.class);
		advisedSupport.setTargetSource(targetSource);

		// 2. 设置拦截器(Advice)
		TimerInterceptor timerInterceptor = new TimerInterceptor();
		advisedSupport.setMethodInterceptor(timerInterceptor);

		// 3. 创建代理(Proxy)
        Cglib2AopProxy cglib2AopProxy = new Cglib2AopProxy(advisedSupport);
		HelloWorldService helloWorldServiceProxy = (HelloWorldService) cglib2AopProxy.getProxy();

		// 4. 基于AOP的调用
		helloWorldServiceProxy.helloWorld();

	}
}
