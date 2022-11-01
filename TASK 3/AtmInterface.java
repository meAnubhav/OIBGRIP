// Task 3: ATM Interface

import java.util.Scanner;

class BankAcc{
	String name, username, password, accNo;
	float balance = 100000f;
	int transactions;
	String transHistory = "";

	public void register(){
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter your name: ");
		this.name= sc.nextLine();
		System.out.print("\nEnter your username: ");
		this.username= sc.nextLine();
		System.out.print("\nEnter your password: ");
		this.password= sc.nextLine();
		System.out.print("\nEnter your Acc No: ");
		this.accNo= sc.nextLine();
		System.out.print("\nRegistration completed! Login to proceed..");
	}
	
	public boolean Login() {
		boolean isLogin = false;
		Scanner sc = new Scanner(System.in);
		while (!isLogin){
			System.out.print("\nEnter your Username: ");
			String Username = sc.nextLine();
			if (Username.equals(username)) {
				while (!isLogin){
					System.out.print("\nEnter your password: ");
					String Password = sc.nextLine();
					if (Password.equals(password)) {
						System.out.print("\nLogin successful!");
						isLogin = true;
					}
					else {
						System.out.println("\nIncorrect Password");
					}
				}
			}
			else {
				System.out.println("\nUsername not found!");
			}
		}
		return isLogin;
    }

	public void withdraw() {
		System.out.print("\nEnter amount to withdraw: ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		try {
			if (balance >= amount) {
				transactions++;
				balance -= amount;
				System.out.println("\nWithdraw Successfully");
				String str = amount + " Rs Withdrawed\n";
				transHistory = transHistory.concat(str);
			}
			else {
				System.out.println("\nInsufficient Balance");
			}
		}
		catch (Exception e) {
		}
	}

	public void deposit() {
		System.out.print("\nEnter amount to deposit: ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		
		try{
			if (amount <= 100000f){
				transactions++;
				balance += amount;
				System.out.println("\nSuccesfully Deposited");
				String str = amount + " Rs deposited\n";
				transHistory = transHistory.concat(str);
			}
			else {
				System.out.println("\nSorry! Limit is 100000.00");
			}
		}
		catch (Exception e) {
		}
	}

	public void transfer() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Receipent's Name: ");
		String receipent = sc.nextLine();
		System.out.print("\nEnter amount to transfer: ");
		float amount = sc.nextFloat();

		try {
			if (balance >= amount) {
				if (amount <= 50000f) {
					transactions++;
					balance -= amount;
					System.out.println("\nSuccessfully Transfered to "+receipent);
					String str = amount + " Rs transfered to "+receipent+"\n";
					transHistory = transHistory.concat(str);
				}
				else {
					System.out.println("\nSorry! Limit is 50000.00");
				}
			}
			else {
				System.out.println("\nInsufficient Balance");
			}
		}
		catch (Exception e){
		}
	}

	public void checkBalance() {
		System.out.println("\n"+ balance + " Ra");
	}

	public void transHistory() {
		if (transactions == 0){
			System.out.println("\nEmpty");
		}
		else {
			System.out.println("\n" + transHistory);
		}
	}
}

public class AtmInterface {
	public static int takeIntegerInput(int limit){
		int input = 0;
		boolean flag = false;
		
		while (!flag) {
			try {
				Scanner sc = new Scanner(System.in);
				input = sc.nextInt();
				flag = true;

		if (flag && input > limit || input < 1) {
			System.out.println("Choose the no. between 1 to "+limit);
			flag = false;
		}
	  }
          catch (Exception e) {
		}
	};
	return input;
    }

public static void main(String[] args) {
	System.out.println("\n---Welcome to ABC Bank ATM---");
	System.out.println("1.Register \n2.Exit");
	System.out.println("Enter your choice");
	int choice = takeIntegerInput(2);

	if (choice == 1) {
		BankAcc b = new BankAcc();
		b.register();
		while(true) {
			System.out.println("\n1.Login \n2.Exit");
			System.out.print("Enter your Choice: ");
			int ch = takeIntegerInput(2); 
			if (ch==1) {
				if (b.Login()) {
					System.out.println("\n---Welcome Again! " +b.name+ "---\n");
					boolean isFinished = false;
					while (!isFinished) {
						System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
						System.out.println("\nEnter your choice: ");
						int c = takeIntegerInput(6);
						switch(c) {
							case 1:
							b.withdraw();
							break;
							case 2:
							b.deposit();
							break;
							case 3:
							b.transfer();
							break;
							case 4:
							b.checkBalance();
							break;
							case 5:
							b.transHistory();
							break;
							case 6:
							isFinished = true;
							break;
						}
					}
				}
			}
			else {
				System.exit(0);
			}
		}
	}
	else {
		System.exit(0);
        }
    }
}