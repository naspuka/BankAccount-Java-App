import java.util.Scanner;

public class App {
	
	public static void main(String[] args) {
		BankAcc obj1  = new BankAcc("XYZ", "BA0001");
		obj1.showMenu();
	}

}

class BankAcc {
	int balance;
	int previousTransaction;
	String customerName;
	String customerId;

        BankAcc(String cname, String cid){
                customerName = cname;
                customerId = cid;
        }
	
	void deposit(int amount) {
		if(amount != 0) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	
	void withdraw(int amount) {
		if(amount != 0) {
			balance = balance - amount;
			previousTransaction = -amount;
		}
	}
	
	void getPreviousTransaction() {
		if (previousTransaction > 0) {
			System.out.println("Deposited: " + previousTransaction);
		}
		else if(previousTransaction < 0) {
			System.out.println("Withdrawn: " + Math.abs(previousTransaction));
		}
		else {
			System.out.println("No transaction Occurred");
		}
	}
	
	void showMenu() {
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome " + customerName);
		System.out.println("Your ID is " + customerId);
		System.out.println("\n");
		System.out.println("A. Check Balance.");
		System.out.println("B. Deposit.");
		System.out.println("C. Withdraw.");
		System.out.println("D. Previous Transaction.");
		System.out.println("E. Exit");
		
		do {
			System.out.println("=================================================");
			System.out.println("Enter an Option: ");
			System.out.println("=================================================");
			option = scanner.next().charAt(0);
			System.out.println('\n');
			
			switch(option) {
			case 'A':
				System.out.println("--------------------------------");
				System.out.println("Balance = "+ balance);
				System.out.println("--------------------------------");
				System.out.println('\n');
				break;
			case 'B':
				System.out.println("--------------------------------");
				System.out.println("Enter amount to Deposit: ");
				System.out.println("--------------------------------");
				int amount = scanner.nextInt();
				deposit(amount);
				System.out.println('\n');
				break;
			case 'C':
				System.out.println("--------------------------------");
				System.out.println("Enter an Amount to Withdraw: ");
				System.out.println("--------------------------------");
				int amount1 = scanner.nextInt();
				withdraw(amount1);
				System.out.println('\n');
				break;
			case 'D':
				System.out.println("--------------------------------");
				getPreviousTransaction();
				System.out.println("--------------------------------");
				System.out.println('\n');
				break;
			case 'E':
				System.out.println("******************************");
				break;
			default:
				System.out.println("Invalid option !!. Please Enter Again: ");
				break;
			}
		}while(option != 'E');
		System.out.print("Thank you for using our services");
	}
}
