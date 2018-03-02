package com.shiziqiu.springframework.aop;

/**
 * 
 * @title : AbstractAopProxy
 * @author : shiziqiu
 * @date : 2018年3月2日 下午1:45:42
 * @Fun :
 */
public abstract class AbstractAopProxy implements AopProxy {

	
    protected AdvisedSupport advised;

    //传入通知事件
    public AbstractAopProxy(AdvisedSupport advised) {
        this.advised = advised;
    }
}
