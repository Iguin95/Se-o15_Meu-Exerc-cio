package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exception.DomainException;
/*Fazer um programa para ler os dados de uma conta bancária e depois realizar um 
saque nesta conta bancária, mostrando o novo saldo. Um saque não pode ocorrer 
ou se não houver saldo na conta, ou se o valor do saque for superior ao limite de 
saque da conta. */
public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		
		try {
		System.out.println("Enter account data:");		
		System.out.print("Number: ");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.print("Holder: ");
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		double balance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		double withdrawLimit = sc.nextDouble();
		
		Account acc = new Account(number, holder, balance, withdrawLimit);
		
		System.out.println();
		
		System.out.print("Enter amount for withdraw: ");
		double amount = acc.withdram(sc.nextDouble());
		
		System.out.println(acc);
		}
		
		catch(DomainException e){
			System.out.println("Withdraw error: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		
		
		sc.close();

	}

}
