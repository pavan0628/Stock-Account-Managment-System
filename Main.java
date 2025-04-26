package com.bl.opps3;

import java.util.Scanner;

//Main class to run the Stock Account Management Program
public class Main {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     StockPortfolio portfolio = new StockPortfolio();

     // Asking the user for number of stocks to be entered
     System.out.print("Enter the number of stocks: ");
     int n = scanner.nextInt();

     // Loop to read stock details from the user
     for (int i = 0; i < n; i++) {
         System.out.println("\nEnter details for Stock " + (i + 1) + ":");
         System.out.print("Stock Name: ");
         String name = scanner.next();
         System.out.print("Number of Shares: ");
         int numberOfShares = scanner.nextInt();
         System.out.print("Share Price: ");
         double sharePrice = scanner.nextDouble();

         // Creating a Stock object and adding it to the portfolio
         Stock stock = new Stock(name, numberOfShares, sharePrice);
         portfolio.addStock(stock);
     }

     // Printing the stock report
     portfolio.printReport();
     scanner.close();
 }
}