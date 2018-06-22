package com.aa.beans;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * when i call proxy.add(a,b)
 * instead of control going to the add(), it comes to the loggingAdvice class
 * 
 * If we want to perform AroundAdvice we need to inform the compiler to perform aroundadvice
 * that's the reason we are implementing class using MethodInterceptor.
 *  
 * and override the invoke() in that we need to perform cross cutting logic
 *
 */
public class LoggingAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		
		String methodName=methodInvocation.getMethod().getName();
		Object[] args=methodInvocation.getArguments();
		System.out.print("entering into "+methodName+"(");
		
		for(int i=0;i<args.length;i++){
			if(i==0){
				System.out.print(args[0]);
				continue;
			}
			System.out.print(","+args[i]);
		}
		System.out.println(")");
		
		/**
		 * 1st Control Point
		 * we may modify the args values if required 
		 */
		args[0]=(Integer)args[0]+1;
		args[1]=(Integer)args[1]+1;
		
		/**
		 * 2nd Control Point
		 * If i will call the target method or else i won't
		 */
		Object ret=methodInvocation.proceed();
		
		/**
		 * 3rd Control Point
		 * I may modify the return values
		 */
		ret=(Integer)ret+1;
		
		System.out.println("return value is "+ret);
		
		return ret;
	}

}
