package com.shiziqiu.springframework.beans.factory;
/**
 * @title : BeanFactoryAware
 * @author : shiziqiu
 * @date : 2017年9月11日 下午1:21:39
 * @Fun :
 */
public interface BeanFactoryAware {

	void setBeanFactory(BeanFactory beanFactory) throws Exception;
}
