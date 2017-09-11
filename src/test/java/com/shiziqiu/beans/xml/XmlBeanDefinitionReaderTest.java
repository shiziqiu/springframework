package com.shiziqiu.beans.xml;

import java.util.Map;
import java.util.Map.Entry;

import junit.framework.Assert;

import org.junit.Test;

import com.shiziqiu.springframework.BeanReference;
import com.shiziqiu.springframework.beans.BeanDefinition;
import com.shiziqiu.springframework.beans.PropertyValue;
import com.shiziqiu.springframework.beans.io.ResourceLoader;
import com.shiziqiu.springframework.beans.xml.XmlBeanDefinitionReader;

/**
 * @title : XmlBeanDefinitionReaderTest
 * @author : shiziqiu
 * @date : 2017年9月11日 下午5:10:49
 * @Fun :
 */
public class XmlBeanDefinitionReaderTest {

	@Test
	public void BeanDefinitionReaderTest() throws Exception {
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions("testioc.xml");
		Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
		for (Entry<String, BeanDefinition> reg : registry.entrySet()) {
			for (PropertyValue pro : reg.getValue().getPropertyValues().getPropertyValues()) {
				if(pro.getValue() instanceof BeanReference){
					BeanReference aa = (BeanReference) pro.getValue();
					System.out.println("==end==" + aa.getName());
				}
			}
		}
		
		Assert.assertTrue(registry.size() > 0);
	}
}
