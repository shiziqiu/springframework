package com.shiziqiu.springframework.aop;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
/**
 * @title : ReflectiveMethodInvocation
 * @author : shiziqiu
 * @date : 2018年3月2日 下午1:53:59
 * @Fun : ?未知
 */
public class ReflectiveMethodInvocation implements MethodInvocation {

	//目标对象
	protected Object target;

    protected Method method;

    protected Object[] arguments;

	public ReflectiveMethodInvocation(Object target, Method method, Object[] arguments) {
		this.target = target;
		this.method = method;
		this.arguments = arguments;
	}

	public Method getMethod() {
		return method;
	}

	public Object[] getArguments() {
		return arguments;
	}

	public Object proceed() throws Throwable {
		//对象的方法调用（参数）
		//p.say("hello");和方法调用一样，只是采用反射的方式
		return method.invoke(target, arguments);
	}

	public Object getThis() {
		return target;
	}

	public AccessibleObject getStaticPart() {
		return method;
	}
}
