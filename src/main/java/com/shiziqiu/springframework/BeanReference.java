package com.shiziqiu.springframework;
/**
 * @title : BeanReference
 * @author : shiziqiu
 * @date : 2017年9月11日 下午3:24:26
 * @Fun :
 * 2018-03-02修改备注
 * 保存引用，bean的引用
 *   <property name="helloService" ref="helloService"></property>
 */
public class BeanReference {

	private String name;
	private Object bean;
	
	public BeanReference(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getBean() {
		return bean;
	}

	public void setBean(Object bean) {
		this.bean = bean;
	}
	
}
