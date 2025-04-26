package com.bl.opps3;

//AccountTest.java
import java.util.Scanner;

public class AccountTest {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

     // Create an Account object with initial balance
     System.out.print("Enter initial balance: ");
     double initialBalance = scanner.nextDouble();
     Account myAccount = new Account(initialBalance);

     // Display initial balance
     System.out.println("Initial balance: $" + myAccount.getBalance());

     // Try to debit from account
     System.out.print("Enter amount to debit: ");
     double debitAmount = scanner.nextDouble();
     myAccount.debit(debitAmount);

     // Display balance after debit attempt
     System.out.println("Balance after debit: $" + myAccount.getBalance());

     scanner.close();
 }
}

