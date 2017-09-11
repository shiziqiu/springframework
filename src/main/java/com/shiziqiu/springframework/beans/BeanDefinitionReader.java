package com.shiziqiu.springframework.beans;
/**
 * @title : BeanDefinitionReader
 * @author : shiziqiu
 * @date : 2017年9月11日 下午2:50:43
 * @Fun :
 * 从配置中读取BeanDefinition，加载所有bean
 */
public interface BeanDefinitionReader {

	/**
	 * 加载配置文件
	 * @param location
	 * @throws Exception
	 */
	void loadBeanDefinitions(String location) throws Exception;
}
