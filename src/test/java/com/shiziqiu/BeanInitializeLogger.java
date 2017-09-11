package com.shiziqiu;

import com.shiziqiu.springframework.beans.BeanPostProcessor;
/**
 * @title : BeanInitializeLogger
 * @author : shiziqiu
 * @date : 2017年9月11日 下午4:54:40
 * @Fun :
 */
public class BeanInitializeLogger implements BeanPostProcessor{

	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws Exception {
		System.out.println("初始化....Initialize bean " + beanName + " start!");
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws Exception {
		System.out.println("初始化......Initialize bean " + beanName + " end!");
		return bean;
	}

}
