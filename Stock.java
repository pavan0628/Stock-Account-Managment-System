package com.bl.opps3;

//Stock.java
//Class representing a single Stock
public class Stock {
 private String name;
 private int numberOfShares;
 private double sharePrice;

 // Constructor to initialize stock details
 public Stock(String name, int numberOfShares, double sharePrice) {
     this.name = name;
     this.numberOfShares = numberOfShares;
     this.sharePrice = sharePrice;
 }

 // Method to calculate the total value of the stock
 public double calculateStockValue() {
     return numberOfShares * sharePrice;
 }

 // Getter methods
 public String getName() {
     return name;
 }

 public int getNumberOfShares() {
     return numberOfShares;
 }

 public double getSharePrice() {
     return sharePrice;
 }
}
