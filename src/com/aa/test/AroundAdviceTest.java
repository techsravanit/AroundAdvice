package com.aa.test;

import org.springframework.aop.framework.ProxyFactory;

import com.aa.beans.Calculator;
import com.aa.beans.LoggingAdvice;

public class AroundAdviceTest {

	public static void main(String[] args) {
		Calculator calculator=new Calculator();
		LoggingAdvice loggingAdvice=new LoggingAdvice();
		ProxyFactory pf=new ProxyFactory();
		
		pf.setTarget(calculator);
		pf.addAdvice(loggingAdvice);
		
		Calculator proxy=(Calculator) pf.getProxy();
		int sum=proxy.add(10, 20);
	}

}
