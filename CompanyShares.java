package com.bl.opps3;

import java.io.Serializable;
import java.time.LocalDateTime;

//Class representing shares owned in a particular company
public class CompanyShares implements Serializable {
 private String symbol;           // Stock symbol (e.g., AAPL, GOOG)
 private int shares;             // Number of shares owned
 private LocalDateTime dateTime; // Date and time of last transaction

 // Constructor to create a new CompanyShares object
 public CompanyShares(String symbol, int shares) {
     this.symbol = symbol;
     this.shares = shares;
     this.dateTime = LocalDateTime.now(); // Set current time as transaction time
 }

 public String getSymbol() {
     return symbol;
 }

 public int getShares() {
     return shares;
 }

 // Updates the number of shares and resets the transaction time
 public void setShares(int shares) {
     this.shares = shares;
     this.dateTime = LocalDateTime.now();
 }

 public LocalDateTime getDateTime() {
     return dateTime;
 }

 // String representation of the object for printing reports
 @Override
 public String toString() {
     return "Symbol: " + symbol + ", Shares: " + shares + ", Last Updated: " + dateTime;
 }
}