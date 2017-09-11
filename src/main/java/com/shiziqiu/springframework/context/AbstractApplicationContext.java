package com.shiziqiu.springframework.context;

import java.util.List;

import com.shiziqiu.springframework.beans.BeanPostProcessor;
import com.shiziqiu.springframework.beans.factory.AbstractBeanFactory;

/**
 * @title : AbstractApplicationContext
 * @author : shiziqiu
 * @date : 2017年9月11日 下午4:24:29
 * @Fun :
 */
public abstract class AbstractApplicationContext implements ApplicationContext{

	protected AbstractBeanFactory beanFactory;

	public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}
	
	public void refresh() throws Exception {
		//加载bean
		loadBeanDefinitions(beanFactory);
		//注册之前，干点什么事情
		registerBeanPostProcessors(beanFactory);
		onRefresh();
	}
	
	protected void registerBeanPostProcessors(AbstractBeanFactory beanFactory) throws Exception {
		List beanPostProcessors = beanFactory.getBeansForType(BeanPostProcessor.class);
		for (Object beanPostProcessor : beanPostProcessors) {
			beanFactory.addBeanPostProcessor((BeanPostProcessor) beanPostProcessor);
		}
	}
	
	protected void onRefresh() throws Exception{
        beanFactory.preInstantiateSingletons();
    }
	
	//调用beanfactory工厂获取bean的实例对象
	public Object getBean(String name) throws Exception {
		return beanFactory.getBean(name);
	}
	
	protected abstract void loadBeanDefinitions(AbstractBeanFactory beanFactory) throws Exception;
}
