package com.shiziqiu.springframework.aop;

import org.aopalliance.aop.Advice;
/**
 * @title : AspectJExpressionPointcutAdvisor
 * @author : shiziqiu
 * @date : 2018年3月2日 下午1:51:38
 * @Fun : 切点通知方法？未知
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    private AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();

    private Advice advice;

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public void setExpression(String expression) {
        this.pointcut.setExpression(expression);
    }

	public Advice getAdvice() {
		return advice;
	}

	public Pointcut getPointcut() {
		return pointcut;
	}
}
