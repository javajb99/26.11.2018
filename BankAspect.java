package com.example.demo;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BankAspect {

	@Before("execution(public int getMoney(int))")
	public void beforeGetMoney()
	{
		System.out.println("I hope I have enough money!!");
	}
	
	@After("execution(public int get*(int))")
	public void afterGetMoney()
	{
		System.out.println("I got the money!! yeah!!");
	}
	
	@AfterThrowing(pointcut = "within(com.example.demo.Bank)", throwing="ex")
	public void afterThownException(Exception ex)
	{
		System.out.println("Watch out! exception is about to be thrown!! " + ex.getMessage());
	}
	
}
