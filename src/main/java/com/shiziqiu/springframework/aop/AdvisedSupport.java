package com.shiziqiu.springframework.aop;

import org.aopalliance.intercept.MethodInterceptor;
/**
 * 
 * @title : AdvisedSupport
 * @author : shiziqiu
 * @date : 2018年3月2日 下午1:45:59
 * @Fun : 代理相关的元数据
 */
public class AdvisedSupport {

	//原始对象的实例，类的Class和接口
	private TargetSource targetSource;

	//方法拦截器
    private MethodInterceptor methodInterceptor;

    //方法匹配器？拦截那些方法，这个就是去找那些方法的。
    private MethodMatcher methodMatcher;

    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }

    public MethodMatcher getMethodMatcher() {
        return methodMatcher;
    }

    public void setMethodMatcher(MethodMatcher methodMatcher) {
        this.methodMatcher = methodMatcher;
    }
}
