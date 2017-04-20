package com.example;

/**
 * Created by bsheen on 4/19/17.
 */
public class Stock {
    private final String stockName;
    private final int pricePerShare;
    private final int numShares;

    public Stock(String stockName, int pricePerShare, int numShares) {
        this.stockName = stockName;
        this.pricePerShare = pricePerShare;
        this.numShares = numShares;
    }

    public String getStockName() {
        return stockName;
    }

    public int getPricePerShare() {
        return pricePerShare;
    }

    public int getNumShares() {
        return numShares;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockName='" + stockName + '\'' +
                ", pricePerShare=" + pricePerShare +
                ", numShares=" + numShares +
                '}';
    }
}
