package com.shiziqiu.springframework.beans.factory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.shiziqiu.springframework.beans.BeanDefinition;
import com.shiziqiu.springframework.beans.BeanPostProcessor;
/**
 * @title : AbstractBeanFactory
 * @author : shiziqiu
 * @date : 2017年9月11日 上午11:04:49
 * @Fun : 抽象bean工厂
 */
public abstract class AbstractBeanFactory implements BeanFactory {

	/**
	 * bean工厂里维护类的字典，类名  Class对象
	 */
	private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

	/**
	 * bean 的名称集合
	 */
	private final List<String> beanDefinitionNames = new ArrayList<String>();
	
	/**
	 * 前后通知处理器
	 */
	private List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

	/**
	 * 获取bean的时候，才创建类的实例对象， 原来只是保存类名和类的Class对象， 到这一步会根据Class对象创建类的实例
	 * 
	 * @return
	 * @throws Exception 
	 */
	public Object getBean(String beanName) throws Exception {
		BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
		if (null == beanDefinition) {
			throw new IllegalArgumentException("No bean named " + beanName + " is defined");
		}

		Object bean = beanDefinition.getBean();
		if (null == bean) {
			/**
			 * 创建对象，其他什么都还没做
			 */
			bean = doCreateBean(beanDefinition);
			/**
			 * 初始化对象
			 */
			bean = initializeBean(bean,beanName);
			/**
			 * 这的bean是初始化之后的的bean，与刚开始创建的bean不一样的
			 */
            beanDefinition.setBean(bean);
		}
		return bean;
	}

	/**
	 * 创建bean
	 * 
	 * @return
	 * @throws Exception
	 */
	protected Object doCreateBean(BeanDefinition beanDefinition)
			throws Exception {
		/**
		 * 创建bean的实例对象
		 */
		Object bean = createBeanInstance(beanDefinition);
		/**
		 * 将bean的实例对象设置到beandefinition中去
		 */
		beanDefinition.setBean(bean);
		/**
		 * 设置bean的引用的实例对象
		 */
		applyPropertyValues(bean, beanDefinition);
		return bean;

	}

	/**
	 * 创建bean的实例对象
	 * @param beanDefinition
	 * @return
	 * @throws Exception
	 */
	protected Object createBeanInstance(BeanDefinition beanDefinition)
			throws Exception {
		return beanDefinition.getBeanClass().newInstance();
	}
	
	/**
	 * @param bean
	 * @param beanName
	 * @return
	 * 初始化bean，即做一些初始化的工作
	 * @throws Exception 
	 */
	protected Object initializeBean(Object bean ,String beanName) throws Exception {
		for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
			bean = beanPostProcessor.postProcessBeforeInitialization(bean, beanName);
		}
		for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            bean = beanPostProcessor.postProcessAfterInitialization(bean, beanName);
		}
        return bean;
	}
	
	/**
	 * 注册bean，即将类名和类的定义保存到内存（map对象）中
	 */
	public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
		beanDefinitionMap.put(beanName, beanDefinition);
		/**
		 * beanName 的一个集合，
		 * 
		 */
		beanDefinitionNames.add(beanName);
	}
	
	/**
	 * 重新验证一下，以免被GC回收了，
	 * 如果被回收的话就重新创建类的实例
	 * @throws Exception 
	 */
	@SuppressWarnings("rawtypes")
	public void preInstantiateSingletons() throws Exception {
		if(null != this.beanDefinitionNames && this.beanDefinitionNames.size() > 0) {
			for (Iterator it = beanDefinitionNames.iterator();it.hasNext();) {
				String beanName = (String) it.next();
				getBean(beanName);
			}
		}
	}
	
	public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) throws Exception {
		this.beanPostProcessors.add(beanPostProcessor);
	}
	
	/**
	 * 根据类型返回beans
	 * @param type
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List getBeansForType(Class type) throws Exception {
		List beans = new ArrayList<Object>();
		for (String beanDefinitionName : beanDefinitionNames) {
			if (type.isAssignableFrom(beanDefinitionMap.get(beanDefinitionName).getBeanClass())) {
				beans.add(getBean(beanDefinitionName));
			}
		}
		return beans;
	}
	
	protected void applyPropertyValues(Object bean,BeanDefinition beanDefinition) throws Exception {}

}
