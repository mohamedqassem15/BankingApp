// package bank;
import java.util.Scanner;
// Mohamed
class BankDetails {
  private String accno;
  private String name;
  private String acc_type;
  private long balance;
  Scanner sc = new Scanner(System.in);
  
  //below is a method to open a new account
  
  public void openAccount() {
	System.out.print("Enter Account Number: ");
	accno = sc.next();
	System.out.print("Enter Account Type: ");
	acc_type = sc.next();
	System.out.print("Enter Name: ");
	name = sc.next();
	System.out.print("Enter Balance: ");
	balance = sc.nextLong();
  }
  
  //below is a method to display account details
  
  public void showAccount() {
	System.out.println("Name of account holder: " + name);
	System.out.println("Account Number: " + accno);
	System.out.println("Account Type: " + acc_type);
	System.out.println("Balance: " + balance);
  }
  
  //below is a method to deposit money
  
  public void deposit() {
	long amt;
	System.out.println("Enter the amount you want to deposit: ");
	amt = sc.nextLong();
	balance = balance + amt;
  }
  
  //below is a method to withdraw money
  
  public void withdrawl() {
	long amt;
	System.out.println("Enter the amount you want to withdraw: ");
	amt = sc.nextLong();
	if(balance >= amt) {
	   balance = balance - amt;
	   System.out.println("Balance after withdrawl: " + balance);
	} else {
	   System.out.println("Your balance is less than " + amt + "\tTransaction failed...!!");
	}
  }
  
  //below is a method to search an account number
  
  public boolean search(String ac_no) {
	  if(accno.equals(ac_no)) {
		  showAccount();
		  return(true);
	  }
	  
	  return(false);
  }
  
}

public class BankingApp {

	public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
      // below verifies login information
      System.out.print("Enter Username: ");
      String username = sc.nextLine();
      System.out.print("Enter Password: ");
      String password = sc.nextLine();



	  //below creates initial accounts
      if(username.equals("admin") && (password.equals("123"))) {
        System.out.print("How many number of customers do you want to input? ");
        int n = sc.nextInt();
        BankDetails C[] = new BankDetails[n];
        for (int i = 0;i < C.length; i++) {
            C[i] = new BankDetails();
            C[i].openAccount();
        }
      
      
      //loop runs until number 5 is not pressed to exit
      
      int ch;
      do {
    	  System.out.println("\n ***Group 3 Banking System Application***");
    	  System.out.println("1. Dispaly all account details \n 2. Search by Account number\n 3. Deposit the amount \n 4. Withdraw the amount \n 5. Exit ");
    	  System.out.println("Enter your choice: ");
    	  ch = sc.nextInt();
    	  switch (ch) {
    	  case 1:
    		  for (int i = 0;i < C.length; i++) {
    			  C[i].showAccount();
    		  }
    		  break;
    	  case 2:
    		  System.out.print("Enter account number you want to search: ");
    		  String ac_no = sc.next();
    		  boolean found = false;
    		  for (int i = 0; i < C.length; i++) {
    			  found = C[i].search(ac_no);
    			  if (found) {
    				  break;
    			  }
    		  }
    		  if (!found) {
    			 System.out.println("Search failed! Account doesn't exist..!!");
    		  }
    		  break;
    	  case 3: 
    		  System.out.print("Enter Account Number: ");
    		  ac_no = sc.next();
    		  found = false;
    		  for (int i = 0; i < C.length; i++) {
    			  found = C[i].search(ac_no);
    			  if (found) {
    				  C[i].deposit();
    				  break;
    			  }
    		  }
    		  if (!found) {
    			  System.out.println("Search failed! Account doesn't exist..!!");
    		  }
    		  break;
    	  case 4: 
    		  System.out.print("Enter Account Number: ");
    		  ac_no = sc.next();
    		  found = false;
    		  for (int i = 0; i < C.length; i++) {
    		  found = C[i].search(ac_no);
    		  if (found) {
    			  C[i].withdrawl();
    			  break;
    		  }
    		}
    		if (!found) {
    			 System.out.println("Search failed! Account doesn't exist..!!");
    		}
    		break;
    	  case 5: 
    		  System.out.println("See you soon...");
    		  break;
    	}
      }
      while (ch != 5);
	}
    else {
        System.out.println("The password or username you have entered is incorrect. Try again. ");
        main(null);
    }
 }
   
}
