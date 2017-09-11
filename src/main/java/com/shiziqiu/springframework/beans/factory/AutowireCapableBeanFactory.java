package com.shiziqiu.springframework.beans.factory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.shiziqiu.springframework.BeanReference;
import com.shiziqiu.springframework.beans.BeanDefinition;
import com.shiziqiu.springframework.beans.PropertyValue;

/**
 * @title : AutowireCapableBeanFactory
 * @author : shiziqiu
 * @date : 2017年9月11日 下午1:18:33
 * @Fun : 可自动装配内容的BeanFactory
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory{

	@Override
	protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
		if(bean instanceof BeanFactoryAware) {
			((BeanFactoryAware) bean).setBeanFactory(this);
		}
		
		for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()) {
			Object value = propertyValue.getValue();
			/**
			 * 获取bean的引用类名
			 */
			if (value instanceof BeanReference) {
				BeanReference beanReference = (BeanReference) value;
				/**
				 * 这里返回的是引用对象的实例，即先初始化第A类，如果A类关联B类，就去找到
				 */
				value = getBean(beanReference.getName());
			}
			
			try {
				Method declaredMethod = bean.getClass().getDeclaredMethod(
						"set" + propertyValue.getName().substring(0,1).toUpperCase()
						+ propertyValue.getName().substring(1),value.getClass());
				declaredMethod.setAccessible(true);
				/**
				 * 直接调用bean的方法setXXX(类名)方法
				 */
				declaredMethod.invoke(bean, value);
			} catch (Exception e) {
				Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
				declaredField.setAccessible(true);
				declaredField.set(bean, value);
			}
		}
	}
	
}
