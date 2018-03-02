package com.shiziqiu.context;

import org.junit.Test;

import com.shiziqiu.service.HelloWorldService;
import com.shiziqiu.springframework.context.ApplicationContext;
import com.shiziqiu.springframework.context.ClassPathXmlApplicationContext;

/**
 * @title : ApplicationContextTest
 * @author : shiziqiu
 * @date : 2017年9月11日 下午4:23:25
 * @Fun :
 */
public class ApplicationContextTest {

	@Test
	public void testApplicationContext() throws Exception {
		/**
		 * 就是把beanfactory封装一下，使调用更加方便。注册，全部初始化。
		 */
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("testioc.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();
	}
	
	@Test
	public void TestPostBeanProcessor() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("testioc-postbeanprocessor.xml");
		HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
		helloWorldService.helloWorld();
	}
}
