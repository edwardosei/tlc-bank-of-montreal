package com.turntabl;

public class Future extends Product {

    private final String contractCode;
    private final String exchange;
    private final int month;
    private final int year;

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
}
