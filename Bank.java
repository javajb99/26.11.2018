package com.example.demo;

public class Bank {

	
	private int current_balance;
	
	private int max_minus;
	
	public int getMoney(int amount) throws Exception {
		System.out.println("Getting money " + amount);
		if (this.current_balance - amount > this.max_minus)
		{
			this.current_balance -= amount;
			return amount;
		}
		throw new Exception("You went under the minus !!!");
	}
	
	public void depositMoney(int amount)
	{
		this.current_balance += amount;
	}
	
	public int goToTheBank() 
	{
		int num = (int) Math.floor(Math.random() * 101);
		if (num > 50)
			return 1;
		return 0;
			
	}

	public int getCurrent_balance() {
		return current_balance;
	}

	public void setCurrent_balance(int current_balance) {
		this.current_balance = current_balance;
	}

	public int getMax_minus() {
		return max_minus;
	}

	public void setMax_minus(int max_minus) {
		this.max_minus = max_minus;
	}

	@Override
	public String toString() {
		return "Bank [current_balance=" + current_balance + ", max_minus=" + max_minus + "]";
	}
	
	
}
