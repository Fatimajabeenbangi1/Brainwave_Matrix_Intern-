package com.Brainwavetask;


import java.util.Scanner;

//Account class to represent a bank account
class Account {
	private double balance;
	private String accountNumber;
	private double dailyWithdrawLimit = 500.0; // Daily withdrawal limit
	private double dailyWithdrawn = 0.0; // Amount withdrawn today

	public Account(String accountNumber, double initialBalance) {
		this.accountNumber = accountNumber;
		this.balance = initialBalance;
	}

	// Method to get current balance
	public double getBalance() {
		return balance;
	}

	// Method to deposit money
	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println("\nSuccessfully deposited: $" + amount);
		} else {
			System.out.println("\nInvalid amount. Deposit failed.");
		}
	}

	// Method to withdraw money with daily limit check
	public boolean withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			if ((dailyWithdrawn + amount) <= dailyWithdrawLimit) {
				balance -= amount;
				dailyWithdrawn += amount;
				System.out.println("\nSuccessfully withdrew: $" + amount);
				System.out.println("Daily withdrawal limit remaining: $" + (dailyWithdrawLimit - dailyWithdrawn));
				return true;
			} else {
				System.out.println("\nWithdrawal failed. Daily withdrawal limit exceeded. Remaining limit: $"
						+ (dailyWithdrawLimit - dailyWithdrawn));
				return false;
			}
		} else {
			System.out.println("\nInvalid amount or insufficient balance. Withdrawal failed.");
			return false;
		}
	}

	// Method to reset daily withdrawal amount
	public void resetDailyWithdrawn() {
		dailyWithdrawn = 0.0;
	}

	// Method to transfer money
	public boolean transfer(Account targetAccount, double amount) {
		if (amount > 0 && amount <= balance) {
			this.withdraw(amount);
			targetAccount.deposit(amount);
			System.out.println(
					"\nSuccessfully transferred: $" + amount + " to account: " + targetAccount.getAccountNumber());
			return true;
		} else {
			System.out.println("\nInvalid amount or insufficient balance. Transfer failed.");
			return false;
		}
	}

	// Method to display account details
	public void displayAccountDetails() {
		System.out.println("Account Number: " + accountNumber);
		System.out.println("Current Balance: $" + balance);
		System.out.println("Daily Withdrawal Limit: $" + dailyWithdrawLimit);
		System.out.println("Amount Withdrawn Today: $" + dailyWithdrawn);
	}

	// Getter for account number
	public String getAccountNumber() {
		return accountNumber;
	}
}

//ATM class to simulate ATM functionality
class ATM {
	private Account account;
	private Account otherAccount; // For transfer operations

	public ATM(Account account, Account otherAccount) {
		this.account = account;
		this.otherAccount = otherAccount;
	}

	// Method to display the ATM menu
	public void displayMenu() {
		System.out.println("\n========== ATM Menu ==========");
		System.out.println("1. Check Balance");
		System.out.println("2. Deposit");
		System.out.println("3. Withdraw");
		System.out.println("4. Transfer Money");
		System.out.println("5. Account Details");
		System.out.println("6. Reset Daily Withdraw Limit");
		System.out.println("7. Exit");
		System.out.println("=============================");
	}

	// Method to handle user input and operations
	public void start() {
		Scanner scanner = new Scanner(System.in);
		boolean running = true;

		while (running) {
			displayMenu();
			System.out.print("\nEnter your choice: ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("\nYour current balance: $" + account.getBalance());
				break;
			case 2:
				System.out.print("\nEnter the amount to deposit: $");
				double depositAmount = scanner.nextDouble();
				account.deposit(depositAmount);
				break;
			case 3:
				System.out.print("\nEnter the amount to withdraw: $");
				double withdrawAmount = scanner.nextDouble();
				account.withdraw(withdrawAmount);
				break;
			case 4:
				System.out.print("\nEnter the amount to transfer: $");
				double transferAmount = scanner.nextDouble();
				account.transfer(otherAccount, transferAmount);
				break;
			case 5:
				account.displayAccountDetails();
				break;
			case 6:
				account.resetDailyWithdrawn();
				System.out.println("\nDaily withdrawal limit has been reset.");
				break;
			case 7:
				System.out.println("\nThank you for using the ATM. Goodbye!");
				running = false;
				break;
			default:
				System.out.println("\nInvalid choice. Please try again.");
			}
		}
		scanner.close();
	}
}

//Main class to run the ATM system
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Account setup for two accounts
		System.out.print("Enter primary account number: ");
		String accountNumber1 = scanner.nextLine();
		System.out.print("Enter initial balance for primary account: $");
		double initialBalance1 = scanner.nextDouble();
		scanner.nextLine();

		System.out.print("Enter secondary account number (for transfers): ");
		String accountNumber2 = scanner.nextLine();
		System.out.print("Enter initial balance for secondary account: $");
		double initialBalance2 = scanner.nextDouble();

		// Create accounts and ATM objects
		Account primaryAccount = new Account(accountNumber1, initialBalance1);
		Account secondaryAccount = new Account(accountNumber2, initialBalance2);
		ATM atm = new ATM(primaryAccount, secondaryAccount);

		System.out.println("\nWelcome to the ATM!\n");
		atm.start();
		scanner.close();
	}
}
