package com.turntabl;

public class Stock extends Product {

    private final String ticker;
    private final String exchange;

    public Stock(String productId, String ticker, String exchange) {
        super(productId);
        this.ticker = ticker;
        this.exchange = exchange;
    }

    @Override
    public double getCurrentPrice(ProductPricingService priceService) {
        return priceService.price(exchange, ticker);
    }
}
