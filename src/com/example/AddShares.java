package com.example;


import java.util.concurrent.Callable;

/**
 * Created by bsheen on 4/19/17.
 */
public class AddShares implements Callable<String> {

    private TraderService traderService;
    private String stockName;
    private int numShares;
    private int stockPrice;

    public AddShares(TraderService traderService, String stockName, int numShares, int stockPrice) {
        this.traderService = traderService;
        this.stockName = stockName;
        this.numShares = numShares;
        this.stockPrice = stockPrice;
    }

    @Override
    public String call() throws Exception {
        System.out.println("A");
        traderService.addShares(stockName, numShares, stockPrice);
        //System.out.println("after add " + traderService);
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            //do nothing
        }
        return "Added " + numShares + " shares at " + stockPrice + " price for stock " + stockName;
    }

}
