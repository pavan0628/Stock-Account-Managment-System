package com.bl.opps3;

import java.util.ArrayList;
import java.util.List;

// Class representing a portfolio of stocks
public class StockPortfolio {
    private List<Stock> stocks;

    // Constructor to initialize the list of stocks
    public StockPortfolio() {
        stocks = new ArrayList<>();
    }

    // Method to add a stock to the portfolio
    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    // Method to print the stock report
    public void printReport() {
        double totalValue = 0;
        System.out.println("\nStock Report:");
        System.out.println("--------------------------------");
        for (Stock stock : stocks) {
            double stockValue = stock.calculateStockValue();
            System.out.println("Stock Name: " + stock.getName());
            System.out.println("Number of Shares: " + stock.getNumberOfShares());
            System.out.println("Share Price: $" + stock.getSharePrice());
            System.out.println("Total Value: $" + stockValue);
            System.out.println();
            totalValue += stockValue;
        }
        System.out.println("--------------------------------");
        System.out.println("Total Portfolio Value: $" + totalValue);
    }
}
