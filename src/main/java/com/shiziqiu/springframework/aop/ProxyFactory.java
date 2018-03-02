package com.shiziqiu.springframework.aop;
/**
 * @title : ProxyFactory
 * @author : shiziqiu
 * @date : 2018年3月2日 下午1:53:44
 * @Fun :
 */
public class ProxyFactory extends AdvisedSupport implements AopProxy {

	public Object getProxy() {
		return createAopProxy().getProxy();
	}

	protected final AopProxy createAopProxy() {
		return new Cglib2AopProxy(this);
	}
}
