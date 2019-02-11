package com.denis.interview.algorithms.interviewcake.applestocks;

/**
 * Suppose we could access yesterday's stock prices as an array, where:
 * <p>
 * The indices are the time in minutes past trade opening time, which was 9:30am local time.
 * The values are the price in dollars of Apple stock at that time.
 * So if the stock cost $500 at 10:30am, stockPricesYesterday[60] = 500.
 * <p>
 * Write an efficient method that takes stockPricesYesterday and returns the best profit I could have made from 1 purchase and 1 sale of 1 Apple stock yesterday.
 * <p>
 * For example:
 * <p>
 * int[] stockPricesYesterday = new int[] {10, 7, 5, 8, 11, 9};
 * <p>
 * getMaxProfit(stockPricesYesterday);
 * returns 6 (buying for $5 and selling for $11)
 */
public class AppleStocks {

    private static int getMaxProfitFirstApproach(int[] stocks) {

        if (stocks.length < 2) {
            throw new IllegalArgumentException("Getting a profit requires at least 2 prices");
        }

        var min = stocks[0];
        var profit = 0;

        for (var i = 1; i < stocks.length; i++) {

            if (profit == 0) {
                profit = stocks[1] - stocks[0];
            }

            if (profit <= 0) {
                if ((stocks[i] - min) > profit) {
                    profit = stocks[i] - min;
                }
            }

            if (stocks[i] < min) {
                min = stocks[i];
            }

            if (stocks[i] > min) {
                if ((stocks[i] - min) > profit) {
                    profit = stocks[i] - min;
                }
            }
        }
        return profit;
    }

    private static int getMaxProfitSecondApproach(int[] stockPricesYesterday) {

        if (stockPricesYesterday.length < 2) {
            throw new IllegalArgumentException("Getting a profit requires at least 2 prices");
        }

        // we'll greedily update minPrice and maxProfit, so we initialize
        // them to the first price and the first possible profit
        var minPrice = stockPricesYesterday[0];
        var maxProfit = stockPricesYesterday[1] - stockPricesYesterday[0];

        // start at the second (index 1) time
        // we can't sell at the first time, since we must buy first,
        // and we can't buy and sell at the same time!
        // if we started at index 0, we'd try to buy *and* sell at time 0.
        // this would give a profit of 0, which is a problem if our
        // maxProfit is supposed to be *negative*--we'd return 0.
        for (var i = 1; i < stockPricesYesterday.length; i++) {
            var currentPrice = stockPricesYesterday[i];

            // see what our profit would be if we bought at the
            // min price and sold at the current price
            var potentialProfit = currentPrice - minPrice;

            // update maxProfit if we can do better
            maxProfit = Math.max(maxProfit, potentialProfit);

            // update minPrice so it's always
            // the lowest price we've seen so far
            minPrice = Math.min(minPrice, currentPrice);
        }
        return maxProfit;
    }


    public static void main(String[] args) {

        var stockPricesYesterday = new int[]{10, 7, 5, 8, 11, 9};
        var stockPricesYesterday2 = new int[]{10, 8, 5, 4, 2, 1};

        System.out.println(getMaxProfitFirstApproach(stockPricesYesterday));
        System.out.println(getMaxProfitFirstApproach(stockPricesYesterday));

        System.out.println(getMaxProfitFirstApproach(stockPricesYesterday2));
        System.out.println(getMaxProfitFirstApproach(stockPricesYesterday2));

    }
}
