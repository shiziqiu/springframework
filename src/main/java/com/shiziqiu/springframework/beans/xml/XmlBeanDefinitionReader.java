package com.shiziqiu.springframework.beans.xml;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.shiziqiu.springframework.BeanReference;
import com.shiziqiu.springframework.beans.AbstractBeanDefinitionReader;
import com.shiziqiu.springframework.beans.BeanDefinition;
import com.shiziqiu.springframework.beans.PropertyValue;
import com.shiziqiu.springframework.beans.io.ResourceLoader;

/**
 * @title : XmlBeanDefinitionReader
 * @author : shiziqiu
 * @date : 2017年9月11日 下午3:04:13
 * @Fun :
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

	public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
		super(resourceLoader);
	}

	/**
	 * 加载
	 */
	public void loadBeanDefinitions(String location) throws Exception {
		// 加载输入流
		InputStream inputStream = getResourceLoader().getResource(location).getInputStream();
		doLoadBeanDefinitions(inputStream);
	}

	/**
	 * 加载输入流
	 * 
	 * @param inputStream
	 * @throws Exception
	 */
	protected void doLoadBeanDefinitions(InputStream inputStream)
			throws Exception {

		// xml解析
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = factory.newDocumentBuilder();
		Document doc = docBuilder.parse(inputStream);
		// 解析bean
		registerBeanDefinitions(doc);
		inputStream.close();
	}

	/**
	 * 解析Document
	 * 
	 * @param doc
	 */
	public void registerBeanDefinitions(Document doc) {
		Element root = doc.getDocumentElement();
		// 解析Element
		parseBeanDefinitions(root);
	}

	/**
	 * 解析Element
	 */
	protected void parseBeanDefinitions(Element root) {
		NodeList nl = root.getChildNodes();
		for (int i = 0; i < nl.getLength(); i++) {
			Node node = nl.item(i);
			if (node instanceof Element) {
				Element ele = (Element) node;
				processBeanDefinition(ele);
			}
		}
	}

	protected void processBeanDefinition(Element ele) {
		/**
		 * 获取id和classname
		 */
		String name = ele.getAttribute("id");
		String className = ele.getAttribute("class");
		BeanDefinition beanDefinition = new BeanDefinition();
		/**
		 * 处理属性
		 */
		processProperty(ele, beanDefinition);
		// 注册Class
		beanDefinition.setBeanClassName(className);
		getRegistry().put(name, beanDefinition);
	}
	
	/**
	 * 添加bean的属性，和ref引用
	 * @param ele
	 * @param beanDefinition
	 */
	private void processProperty(Element ele, BeanDefinition beanDefinition) {
		NodeList propertyNode = ele.getElementsByTagName("property");
		if(null != propertyNode) {
			for (int i = 0; i < propertyNode.getLength(); i++) {
				Node node = propertyNode.item(i);
				if (node instanceof Element) {
					Element propertyEle = (Element) node;
					String name = propertyEle.getAttribute("name");
					String value = propertyEle.getAttribute("value");
					if(null != value && value.length() > 0) {
						beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, value));
					} else {
						String ref = propertyEle.getAttribute("ref");
						if(null == ref || ref.length() == 0) {
							throw new IllegalArgumentException("Configuration problem: <property> element for property '"
									+ name + "' must specify a ref or value");
						}
						
						/**
						 * bean对其他对象的引用，直接放到自己的属性里面
						 */
						BeanReference beanReference = new BeanReference(ref);
						beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, beanReference));
					}
				}
			}
		}
		
	}

}
