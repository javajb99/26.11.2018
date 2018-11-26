package com.example.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	@AfterReturning(pointcut = "execution(public int goToTheBank())", returning = "returnInt")
	public void getNumberReturnedFromGoToBank(int returnInt)
	{
		System.out.println("After going to the bank the method returned " + returnInt);
		if (returnInt == 1)
			System.out.println("Bank is open!");
		else
			System.out.println("Bank is closed!");
	}
	
	@Around("execution(public int com.example.demo.Bank.goToTheBank())")
	public int handleIntReturnMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
	{
		System.out.println("=============== handle int");
		System.out.println( proceedingJoinPoint.getSignature() );
		//return (int)proceedingJoinPoint.proceed();
		return 1;
		//return 
	}
	
	
	@Around("execution(public String com.example.demo.Bank.toString())")
	public String handleToString(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
	{
		System.out.println("=============== handle String");
		System.out.println( proceedingJoinPoint.getSignature() );
		return (String)proceedingJoinPoint.proceed() + " Aspect was here!!!";
		//return 
	}	
	
}
