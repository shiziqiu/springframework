package com.shiziqiu.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @title : PropertyValues
 * @author : shiziqiu
 * @date : 2017年9月11日 上午11:16:12
 * @Fun :
 * 包装一个对象所有的PropertyValue。
 * 
 */
public class PropertyValues {

	/**
	 * 属性的集合
	 */
	private final List<PropertyValue> propertyValueList = new ArrayList<PropertyValue>();

	public PropertyValues() {}
	
	public void addPropertyValue(PropertyValue pv) {
        //这里可以对于重复propertyName进行判断，直接用list没法做到
		this.propertyValueList.add(pv);
		
	}

	public List<PropertyValue> getPropertyValues() {
		return this.propertyValueList;
	}
}
