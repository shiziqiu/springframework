package com.shiziqiu.springframework.aop;
import org.aopalliance.intercept.MethodInterceptor;
import com.shiziqiu.springframework.beans.BeanPostProcessor;
import com.shiziqiu.springframework.beans.factory.AbstractBeanFactory;
import com.shiziqiu.springframework.beans.factory.BeanFactory;
import java.util.List;

/**
 * @title : AspectJAwareAdvisorAutoProxyCreator
 * @author : shiziqiu
 * @date : 2018年3月2日 下午1:49:48
 * @Fun :
 */
public class AspectJAwareAdvisorAutoProxyCreator implements BeanPostProcessor, BeanFactoryAware {

	private AbstractBeanFactory beanFactory;

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
		if (bean instanceof AspectJExpressionPointcutAdvisor) {
			return bean;
		}
		if (bean instanceof MethodInterceptor) {
			return bean;
		}
		List<AspectJExpressionPointcutAdvisor> advisors = beanFactory.getBeansForType(AspectJExpressionPointcutAdvisor.class);
		for (AspectJExpressionPointcutAdvisor advisor : advisors) {
			if (advisor.getPointcut().getClassFilter().matches(bean.getClass())) {
                ProxyFactory advisedSupport = new ProxyFactory();
				advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
				advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());

				TargetSource targetSource = new TargetSource(bean, bean.getClass(), bean.getClass().getInterfaces());
				advisedSupport.setTargetSource(targetSource);

				return advisedSupport.getProxy();
			}
		}
		return bean;
	}

	public void setBeanFactory(BeanFactory beanFactory) throws Exception {
		this.beanFactory = (AbstractBeanFactory) beanFactory;
	}
}
