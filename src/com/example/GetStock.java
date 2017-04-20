package com.example;

import java.util.concurrent.Callable;

/**
 * Created by bsheen on 4/19/17.
 */
public class GetStock implements Callable<String> {
    private TraderService traderService;
    private String stockName;

    public GetStock(TraderService traderService, String stockName) {
        this.traderService = traderService;
        this.stockName = stockName;
    }

    @Override
    public String call() throws Exception {
        System.out.println("G");
        Stock stock = traderService.getStock(stockName);
        //System.out.println(stock);
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            //do nothing
        }
        return "Getting stock " + stockName + ": " + stock;
    }

}
