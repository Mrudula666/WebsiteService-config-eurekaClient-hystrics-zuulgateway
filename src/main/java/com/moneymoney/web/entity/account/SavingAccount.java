package com.moneymoney.web.entity.account;

public class SavingAccount extends Account{
	private boolean salary;

	public SavingAccount() {
		
	}

	public SavingAccount(Integer accountNumber, String accountHolderName, Double currentBalance, boolean salary) {
		super(accountNumber, accountHolderName, currentBalance);
		this.salary = salary;
	}

	public SavingAccount(Integer accountNumber, String accountHolderName, boolean salary) {
		super(accountNumber, accountHolderName);
		this.salary = salary;
	}

	public boolean isSalary() {
		return salary;
	}

	public void setSalary(boolean salary) {
		this.salary = salary;
	}

}
