package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Main {

    static ArrayList<String> stockNames = new ArrayList<>();
    static ArrayList<String> traderNames = new ArrayList<>();
    static Random random = new Random();

    static {
        stockNames.add("ABC");
        stockNames.add("IBM");
        stockNames.add("TIY");
        traderNames.add("Steve");
        traderNames.add("Abby");
        traderNames.add("Joe");
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TraderService traderService = new TraderServiceImpl();
        List<Callable> callables = new ArrayList<>();
        List<Future> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 100; ++i) {
            AddShares addShares = new AddShares(traderService, stockNames.get(random.nextInt(3)), random.nextInt(40) + 1, random.nextInt(80));
            BuyShares buyShares = new BuyShares(traderService, traderNames.get(random.nextInt(3)), stockNames.get(random.nextInt(3)), random.nextInt(40)+1, random.nextInt(80));
            GetStock getStock = new GetStock(traderService, stockNames.get(random.nextInt(3)));

            callables.add(addShares);
            callables.add(buyShares);
            callables.add(getStock);
        }

        for (Callable callable : callables) {
            Future future = executorService.submit(callable);
            futures.add(future);
        }

        for (Future future : futures) {
            System.out.println(future.get());
        }

        executorService.shutdown();

        System.out.println(traderService.getTrades());


    }


}
