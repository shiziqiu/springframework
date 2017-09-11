package com.shiziqiu.springframework.beans;

import java.util.HashMap;
import java.util.Map;

import com.shiziqiu.springframework.beans.io.ResourceLoader;

/**
 * @title : AbstractBeanDefinitionReader
 * @author : shiziqiu
 * @date : 2017年9月11日 下午2:55:34
 * @Fun : 从配置中读取BeanDefinition，抽象类
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

	/**
	 * bean集合
	 */
	private Map<String, BeanDefinition> registry;

	/**
	 * 资源加载器
	 */
	private ResourceLoader resourceLoader;

	public AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
		this.registry = new HashMap<String, BeanDefinition>();
		this.resourceLoader = resourceLoader;
	}

	public Map<String, BeanDefinition> getRegistry() {
		return registry;
	}

	public ResourceLoader getResourceLoader() {
		return resourceLoader;
	}

}
