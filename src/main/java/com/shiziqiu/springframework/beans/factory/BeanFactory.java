package com.shiziqiu.springframework.beans.factory;
/**
 * @title : BeanFactory
 * @author : crazy
 * @date : 2017年9月11日 上午11:01:30
 * @Fun : bean 容器、工厂
 */
public interface BeanFactory {

	/**
	 * 根据beanName获取bean的实列
	 * @param beanName
	 * @return
	 * @throws Exception
	 */
	Object getBean(String beanName) throws Exception;
}
