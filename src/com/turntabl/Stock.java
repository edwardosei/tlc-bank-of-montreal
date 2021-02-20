package com.turntabl;

public class Stock extends Product {

    private String ticker;
    private String exchange;

    public Stock(String productId, String ticker, String exchange) {
        super(productId);
        this.ticker = ticker;
        this.exchange = exchange;
    }

    @Override
    public double getCurrentPrice(ProductPricingService priceService) {
        return priceService.price(exchange, ticker);
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }
}
