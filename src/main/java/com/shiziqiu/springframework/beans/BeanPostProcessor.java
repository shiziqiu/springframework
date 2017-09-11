package com.shiziqiu.springframework.beans;
/**
 * @title : BeanPostProcessor
 * @author : shiziqiu
 * @date : 2017年9月11日 上午11:47:55
 * @Fun :
 * 初始化前后处理器
 */
public interface BeanPostProcessor {

	/**
	 * 前置處理器
	 * @param bean
	 * @param beanName
	 * @return
	 * @throws Exception
	 */
	Object postProcessBeforeInitialization(Object bean,String beanName) throws Exception;
	
	/**
	 * 后置处理器
	 * @param bean
	 * @param beanName
	 * @return
	 * @throws Exception
	 */
	Object postProcessAfterInitialization(Object bean, String beanName) throws Exception;
	
}
