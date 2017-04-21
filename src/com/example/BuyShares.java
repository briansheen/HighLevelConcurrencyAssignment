package com.example;

import java.util.concurrent.Callable;

/**
 * Created by bsheen on 4/19/17.
 */
public class BuyShares implements Callable<String> {

    private TraderService traderService;
    private String traderName;
    private String stockName;
    private int numShares;
    private int sharePrice;

    public BuyShares(TraderService traderService, String traderName, String stockName, int numShares, int sharePrice) {
        this.traderService = traderService;
        this.traderName = traderName;
        this.stockName = stockName;
        this.numShares = numShares;
        this.sharePrice = sharePrice;
    }

    @Override
    public String call() throws Exception {
        System.out.println("B");
        try {
            Trade trade = traderService.buyShares(traderName, stockName, numShares, sharePrice);
            //System.out.println(trade);
        } catch (SharesException e) {
            return e.getMessage();
        }
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            //do nothing
        }
        return "Bought " + numShares + " of stock " + stockName + " at price " + sharePrice + " by tra!der " + traderName;
    }

}
