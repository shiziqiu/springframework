package com.shiziqiu.springframework.aop;

import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * @title : JdkDynamicAopProxy
 * @author : shiziqiu
 * @date : 2018年3月2日 下午1:52:13
 * @Fun : 基于jdk的动态代理
 */
public class JdkDynamicAopProxy extends AbstractAopProxy implements InvocationHandler {

    public JdkDynamicAopProxy(AdvisedSupport advised) {
        super(advised);
    }

    //获取代理类的实例，调用代理的类的方法，会自定先调用拦截器方法吗？
	public Object getProxy() {
		return Proxy.newProxyInstance(getClass().getClassLoader(), advised.getTargetSource().getInterfaces(), this);
	}

	//调用代理 类方法，实质调用原始类的方法
	public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
		//提取拦截method方法
		MethodInterceptor methodInterceptor = advised.getMethodInterceptor();
		//比较传入的方法和原始对象的方法是否一致，如果一致则调用传入的方法，那拦截的方法什么时候调用？
		System.out.println(args);
		System.out.println(method);
		System.out.println(advised.getMethodMatcher());
		System.out.println(advised.getTargetSource().getTarget());
		
		if (advised.getMethodMatcher() != null
				&& advised.getMethodMatcher().matches(method, advised.getTargetSource().getTarget().getClass())) {
			//这里应该是先调用拦截的方法，然后调用原始对象的方法。但是一般括号里的东西不是优先吗？括号里面好像就只有赋值操作而已。
			return methodInterceptor.invoke(new ReflectiveMethodInvocation(advised.getTargetSource().getTarget(),method, args));
		} else {
			return method.invoke(advised.getTargetSource().getTarget(), args);
		}
	}

}
