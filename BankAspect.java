package com.example.demo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BankAspect {

	@Before("execution(public int getMoney(int))")
	public void beforeGetMoney()
	{
		System.out.println("I hope I have enough money!!");
	}
	
}
