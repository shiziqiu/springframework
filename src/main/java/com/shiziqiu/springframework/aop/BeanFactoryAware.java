package com.shiziqiu.springframework.aop;

import com.shiziqiu.springframework.beans.factory.BeanFactory;

/**
 * @title : BeanFactoryAware
 * @author : shiziqiu
 * @date : 2018年3月2日 下午1:50:16
 * @Fun : 设置bean工厂
 */
public interface BeanFactoryAware {

    void setBeanFactory(BeanFactory beanFactory) throws Exception;

	Object postProcessBeforeInitialization(Object bean, String beanName)
			throws Exception;
}
