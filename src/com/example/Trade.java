package com.example;

import java.time.LocalDateTime;

/**
 * Created by bsheen on 4/19/17.
 */
public class Trade extends Stock {
    private final String tradeName;
    private final LocalDateTime dateTime;

    public Trade(String stockName, int pricePerShare, int numShares, String tradeName, LocalDateTime dateTime) {
        super(stockName, pricePerShare, numShares);
        this.tradeName = tradeName;
        this.dateTime = dateTime;
    }

    public String getTradeName() {
        return tradeName;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "tradeName='" + tradeName + '\'' +
                ", dateTime=" + dateTime + " " + super.toString() +
                '}';
    }
}
