package com.turntabl;

public class Future extends Product {

    private String contractCode;
    private String exchange;
    private int month;
    private int year;

    public Future(String productId, String contractCode, String exchange, int month, int year) {
        super(productId);
        this.contractCode = contractCode;
        this.exchange = exchange;
        this.month = month;
        this.year = year;
    }

    @Override
    public double getCurrentPrice(ProductPricingService priceService) {
        return priceService.price(exchange, contractCode, month, year);
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
