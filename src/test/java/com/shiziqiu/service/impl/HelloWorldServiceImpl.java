package com.shiziqiu.service.impl;
import com.shiziqiu.service.HelloWorldService;
/**
 * @title : HelloWorldServiceImpl
 * @author : shiziqiu
 * @date : 2017年9月11日 下午3:32:43
 * @Fun :
 */
public class HelloWorldServiceImpl implements HelloWorldService{
	
	private String text;
	private String age;

	public void helloWorld() {
		// outputService.output(text,age);
		System.out.println(text + "===" + age);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
}
