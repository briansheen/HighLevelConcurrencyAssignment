package com.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bsheen on 4/19/17.
 */
public class TraderServiceImpl implements TraderService {

    private Map<String, Stock> stocks = new HashMap<>();
    private List<Trade> trades = new ArrayList<>();

    @Override
    public synchronized void addShares(String stockName, int numShares, int price) {
        if (!stocks.containsKey(stockName)) {
            stocks.put(stockName, new Stock(stockName, price, numShares));
        } else {
            int newShares;
            newShares = stocks.get(stockName).getNumShares() + numShares;
            stocks.put(stockName, new Stock(stockName, price, newShares));
        }
    }

    @Override
    public synchronized Stock getStock(String stockName) {
        return stocks.get(stockName);
    }

    @Override
    public synchronized Trade buyShares(String traderName, String stockName, int numShares, int price) throws SharesException {
        int newShares;
        Trade addTrade = null;
        Stock stock = stocks.get(stockName);
        if (stock != null) {
            if (stock.getNumShares() >= numShares) {
                newShares = stock.getNumShares() - numShares;
                stocks.put(stockName, new Stock(stockName, price, newShares));
                addTrade = new Trade(stockName, price, numShares, traderName, LocalDateTime.now());
                trades.add(addTrade);
            } else {
                throw new SharesException("Not Enough Shares To Buy.");
            }
        } else {
            throw new SharesException("Stock Cannot Be Found.");
        }
        return addTrade;
    }

    @Override
    public void clearStocks() {
        stocks.clear();
    }

    @Override
    public List<Trade> getTrades() {
        return trades;
    }

    @Override
    public String toString() {
        return "TraderServiceImpl{" +
                "stocks=" + stocks +
                '}';
    }
}
