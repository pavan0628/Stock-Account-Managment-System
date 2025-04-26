package com.bl.opps3;

//Account.java
public class Account {
 private double balance; // instance variable to store the balance

 // Constructor
 public Account(double initialBalance) {
     if (initialBalance > 0.0) {
         balance = initialBalance;
     } else {
         balance = 0.0;
     }
 }

 // Method to deposit money
 public void credit(double amount) {
     balance += amount;
 }

 // Method to withdraw money safely
 public void debit(double amount) {
     if (amount > balance) {
         System.out.println("Debit amount exceeded account balance.");
     } else {
         balance -= amount;
     }
 }

 // Getter method for balance
 public double getBalance() {
     return balance;
 }
}

