package com.shiziqiu.beanfactory;

import java.util.Map;

import org.junit.Test;

import com.shiziqiu.service.HelloWorldService;
import com.shiziqiu.springframework.beans.BeanDefinition;
import com.shiziqiu.springframework.beans.PropertyValue;
import com.shiziqiu.springframework.beans.PropertyValues;
import com.shiziqiu.springframework.beans.factory.AbstractBeanFactory;
import com.shiziqiu.springframework.beans.factory.AutowireCapableBeanFactory;
import com.shiziqiu.springframework.beans.io.ResourceLoader;
import com.shiziqiu.springframework.beans.xml.XmlBeanDefinitionReader;

/**
 * @title : BeanFactoryTest
 * @author : shiziqiu
 * @date : 2017年9月11日 下午3:29:04
 * @Fun : 测试用例
 */
public class BeanFactoryTest {

	@Test
	public void testLazy() throws Exception {
		// 1 读取配置
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(
				new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions("testioc.xml");

		// 2 初始化BeanFactory，并注册所有bean相关信息，无论是直接引用还间接引用
		AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
		for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader
				.getRegistry().entrySet()) {

			// System.out.println(beanDefinitionEntry.getKey() +"   " +
			// beanDefinitionEntry.getValue().getBeanClassName());

			/*
			 * for (PropertyValue iterable_element :
			 * beanDefinitionEntry.getValue
			 * ().getPropertyValues().getPropertyValues()) {
			 * System.out.println("==="+iterable_element.getName());
			 * System.out.println("===="+iterable_element.getValue()); }
			 */

			beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(),
					beanDefinitionEntry.getValue());
		}

		// 3 获取bean，这里从工厂里找到对应类的相关信息，然后创建类的实例，如果类有其他引用，就实例化其他引用，然后调用相关方法
		HelloWorldService helloWorldService = (HelloWorldService) beanFactory
				.getBean("helloWorldService");
		helloWorldService.helloWorld();
	}

	@Test
	public void testPreInstantiate() throws Exception {
		/**
		 * 1.读取配置
		 */
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(
				new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions("testioc.xml");

		/**
		 * 2.初始化BeanFactory并注册bean
		 */
		AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
		for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader
				.getRegistry().entrySet()) {
			beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(),
					beanDefinitionEntry.getValue());

			// System.out.println(beanDefinitionEntry.getKey() +"   " +
			// beanDefinitionEntry.getValue().getBeanClassName());
		}

		/**
		 * 3.初始化bean，提前预初始化所有注册的类。
		 */
		beanFactory.preInstantiateSingletons();

		/**
		 * 4.获取bean
		 */
		HelloWorldService helloWorldService = (HelloWorldService) beanFactory
				.getBean("helloWorldService");
		helloWorldService.helloWorld();
	}

	@Test
	public void getBeanPeoperties() throws Exception {
		/**
		 * 1.初始化beanfactory
		 */
		AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
		
		/**
		 * 2.注入bean
		 */
		BeanDefinition beanDefinition = new BeanDefinition();
		beanDefinition.setBeanClassName("com.shiziqiu.service.HelloWorldService");
		
		/**
		 * 3.设置属性
		 */
		PropertyValues propertyValues = new PropertyValues();
		propertyValues.addPropertyValue(new PropertyValue("text", "Hello World!"));
		propertyValues.addPropertyValue(new PropertyValue("age","23"));
		beanDefinition.setPropertyValues(propertyValues);
		
		beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);
		
		/**
		 * 4.获取bean
		 */
		HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
		helloWorldService.helloWorld();

	}

}
