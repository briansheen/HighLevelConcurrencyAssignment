package com.example;

import java.util.List;

/**
 * Created by bsheen on 4/19/17.
 */
public class GetTrades implements Runnable{
    private TraderService traderService;

    public GetTrades(TraderService traderService) {
        this.traderService = traderService;
    }

    @Override
    public void run() {
        List<Trade> testTrade = null;
        while(testTrade==null){
            testTrade = traderService.getTrades();
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                // do nothing
            }
        }
        System.out.println(testTrade);
    }
}
