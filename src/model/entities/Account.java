package model.entities;

import model.exception.DomainException;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit; //Limite de retirada
	
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}


	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	public double deposit(double amount) {
		return this.balance += amount;
	}
	
	public double withdram(double amount) throws DomainException {
		
		if(amount > this.withdrawLimit) {
			throw new DomainException("The amount exceeds withdraw limit"); //Erro de saque: o valor excede o limite de saque
		}
		if(amount > this.balance) {
			throw new DomainException("Not enough balance");//Erro de saque: saldo insuficiente
		}
		
		return this.balance -= amount;
	}
	
	@Override
	public String toString() {
		return "New balance: "
				+ balance;
		
	}

}
