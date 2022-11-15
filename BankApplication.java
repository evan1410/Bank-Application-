
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BankApplication {

	private static Set<Account> accounts = new HashSet<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int choice = 0;

		while (choice != 3) {
			System.out.println("Welcome to the Bank!");
			System.out.println("1. Create Account");
			System.out.println("2. Banking Services");
			System.out.println("3. Exit");
			System.out.print("Choose Service : ");
			choice = sc.nextInt();
			switch (choice) {
				case 1:
					AccountCreation();
					break;
				case 2:
					BankService();
					break;
				case 3:
					break;
				default:
					System.out.println("Invalid Choice");
					break;
			}
			if (choice == 3)
				break;
			System.out.println();
		}
		System.out.println("Successfully Exit, Thank you");

	}

	private static void BankService() {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		System.out.print("Enter Account Number : ");
		String code = sc.nextLine();
		while (choice != 4) {
			System.out.println("1. Show Balance");
			System.out.println("2. Deposit Amount");
			System.out.println("3. Withdraw Amount");
			System.out.println("4. Cancel");
			System.out.print("Choose service : ");

			choice = sc.nextInt();

			switch (choice) {
				case 1:
					checkBalance(code);
					break;
				case 2:
					deposite(code);
					break;
				case 3:
					withdraw(code);
					break;
				case 4:
					break;
				default:
					System.out.println("Invalid Choice");
					break;
			}
			if (choice == 4)
				break;
			System.out.println();
		}
	}

	private static void withdraw(String code) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Withdrawl Amount : ");
		double withdraw_amount = sc.nextDouble();
		double current_balance = -1;
		int withdrawn = 0;
		int isAccountExist = 0;
		for (Account account : accounts) {
			if (account.getCode().equals(code)) {
				isAccountExist = 1;
				current_balance = account.getBalance();
				if (current_balance >= withdraw_amount) {
					account.setBalance(current_balance - withdraw_amount);
					current_balance -= withdraw_amount;
					withdrawn = 1;
				}
				break;
			}

		}
		if (isAccountExist == 0) {
			System.out.println("Invalid Account Number");
		}
		if (withdrawn == 1) {
			System.out.println("Successfully Withdrawl ");
			System.out.println("Updated Balance = " + current_balance);
		} else
			System.out.println("Insufficeint Balance");

	}

	private static void deposite(String code) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Deposite Amount : ");
		double deposite_amount = sc.nextDouble();
		double current_balance = 0;
		for (Account account : accounts) {
			if (account.getCode().equals(code)) {
				current_balance = account.getBalance();
				account.setBalance(current_balance + deposite_amount);
				current_balance += deposite_amount;
			}

		}
		if (current_balance > 0) {
			System.out.println("Successfully Deposited ");
			System.out.println("Updated Balance = " + current_balance);
		} else
			System.out.println("Invalid Account Number");

	}

	private static void checkBalance(String code) {
		double retreived_balance = -1;
		String customer_name = "";
		for (Account account : accounts) {
			if (account.getCode().equals(code)) {
				customer_name = account.getName();
				retreived_balance = account.getBalance();
				break;
			}
		}
		if (retreived_balance >= 0) {
			System.out.print("Account Name = " + customer_name);
			System.out.print(" Account Balance  = " + retreived_balance);
		} else
			System.out.println("Invalid Account Number");
	}

	private static void AccountCreation() {
		Scanner sc = new Scanner(System.in);
		Account account = new Account();

		System.out.println("Enter Your Name :");
		String customer_name = sc.nextLine();
		System.out.println("Enter Code : ");
		String code = sc.nextLine();
		account.setName(customer_name);
		account.setCode(code);
		accounts.add(account);

		System.out.println("Your account has been successfully created");
		System.out.println("Your Account Number : " + account.getCode());
		System.out.println("Now you can avail bank services");
	}

}

class Account {

	String name;
	String code;
	double balance;

	public Account() {
		this.balance = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
