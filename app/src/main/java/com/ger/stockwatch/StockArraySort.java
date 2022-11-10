package com.ger.stockwatch;

import java.util.Comparator;
//Class that implements Comparator sorting efficiency
public class StockArraySort implements Comparator<Stock> {
    @Override
    public int compare(Stock stock, Stock t1) {
        return stock.getSymbol().compareTo(t1.getSymbol());
    }
}
