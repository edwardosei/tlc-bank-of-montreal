package com.turntabl;

public class Product extends ProductAction implements ProductPricingService {
    private String productID;
    private String exchange;
    private int month;
    private int year;
    private String contractCode, ticker;
    private double currentPrice;
    private boolean isRegistered = false;

    public static final double PRICE_OF_STOCKS = 50.0;
    public static final double PRICE_OF_FUTURES = 60.0;

    public Product(String productID) {
        this.productID = productID;
    }

    public Product(String productID, double currentPrice) {
        this.productID = productID;
        this.currentPrice = currentPrice;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    @Override
    public double price(String exchange, String ticker) {
        this.exchange = exchange;
        this.ticker = ticker;
        this.currentPrice = PRICE_OF_STOCKS;
        return currentPrice;
    }

    @Override
    public double price(String exchange, String contractCode, int month, int year) {
        this.exchange = exchange;
        this.contractCode = contractCode;
        this.month = month;
        this.year = year;
        this.currentPrice = PRICE_OF_FUTURES;
        return currentPrice;
    }

    public String getProductID() {
        return productID;
    }
}
