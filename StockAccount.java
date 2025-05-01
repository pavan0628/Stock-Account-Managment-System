package com.bl.opps3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

//Class to manage a user's stock portfolio and transactions
public class StockAccount {
 private List<CompanyShares> companySharesList; // List of all company shares owned

 // Constructor: Loads data from a file, or initializes empty list if file not found
 @SuppressWarnings("unchecked")
 public StockAccount(String filename) {
     try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
         companySharesList = (List<CompanyShares>) ois.readObject();
     } catch (Exception e) {
         companySharesList = new ArrayList<>(); // Start fresh if file not found or corrupt
     }
 }

 // Calculates total value of portfolio (assumes fixed price per share: $100)
 public double vaalueOf() {
     double total = 0;
     for (CompanyShares cs : companySharesList) {
         total += cs.getShares() * 100;
     }
     return total;
 }

 // Buys shares for a specific company; adds or updates existing entry
 public void buy(int amount, String symbol) {
     CompanyShares existing = find(symbol);
     if (existing != null) {
         existing.setShares(existing.getShares() + amount);
     } else {
         companySharesList.add(new CompanyShares(symbol, amount));
     }
 }

 // Sells shares if available; validates ownership and quantity
 public void sell(int amount, String symbol) {
     CompanyShares existing = find(symbol);
     if (existing != null) {
         if (existing.getShares() >= amount) {
             existing.setShares(existing.getShares() - amount);
         } else {
             System.out.println("Not enough shares to sell.");
         }
     } else {
         System.out.println("No such stock owned.");
     }
 }

 // Saves the current portfolio to a file
 public void save(String filename) {
     try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
         oos.writeObject(companySharesList);
     } catch (IOException e) {
         System.out.println("Failed to save file.");
     }
 }

 // Prints a detailed report of all shares in the portfolio
 public void printReport() {
     System.out.println("Stock Report:");
     for (CompanyShares cs : companySharesList) {
         System.out.println(cs);
     }
     System.out.printf("Total Portfolio Value: $%.2f%n", vaalueOf());
 }

 // Helper method to find a CompanyShares object by stock symbol
 private CompanyShares find(String symbol) {
     for (CompanyShares cs : companySharesList) {
         if (cs.getSymbol().equalsIgnoreCase(symbol)) {
             return cs;
         }
     }
     return null;
 }
}