package com.shiziqiu.aop;

import org.junit.Assert;
import org.junit.Test;

import com.shiziqiu.service.HelloWorldService;
import com.shiziqiu.service.impl.HelloWorldServiceImpl;
import com.shiziqiu.springframework.aop.AspectJExpressionPointcut;
/**
 * @title : AspectJExpressionPointcutTest
 * @author : shiziqiu
 * @date : 2018年3月2日 下午1:56:04
 * @Fun :
 */
public class AspectJExpressionPointcutTest {

    @Test
    public void testClassFilter() throws Exception {
        String expression = "execution(* com.shiziqiu.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getClassFilter().matches(HelloWorldService.class);
        
        
        System.out.println(matches);
        Assert.assertTrue(matches);
    }

    @Test
    public void testMethodInterceptor() throws Exception {
        String expression = "execution(* com.shiziqiu.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getMethodMatcher().matches(HelloWorldServiceImpl.class.getDeclaredMethod("helloWorld"),HelloWorldServiceImpl.class);
       System.out.println(matches);
        Assert.assertTrue(matches);
    }
}
