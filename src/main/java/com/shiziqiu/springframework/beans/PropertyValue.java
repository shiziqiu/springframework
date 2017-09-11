package com.shiziqiu.springframework.beans;

/**
 * @title : PropertyValue
 * @author : shiziqiu
 * @date : 2017年9月11日 上午11:13:03
 * @Fun : 用于bean的属性注入，配置属性 例 spring 配置里的 <property name="text"
 *      value="Hello World!"></property> <property name="age"
 *      value="22"></property>
 */
public class PropertyValue {

	/**
	 * 名称
	 */
	private final String name;
	/**
	 * 对应的值
	 */
	private final Object value;

	public PropertyValue(String name, Object value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}

}
