package com.turntabl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductAction implements MontrealTradedProducts {

    public List<Product> getListOfRegisteredProducts() {
        return listOfRegisteredProducts;
    }

    public List<Trade> getListOfProductsTraded() {
        return listOfProductsTraded;
    }

    private final List<Product> listOfRegisteredProducts = new ArrayList<Product>();
    private final List<Trade> listOfProductsTraded = new ArrayList<Trade>();
    private final ProductPricingService pricingService;

    public ProductAction(ProductPricingService pricingService) {
        this.pricingService = pricingService;
    }

    private boolean isProductRegisteredAlready(Product product) {

        for(Product item : this.listOfRegisteredProducts) {
            if (item.getProductId().equals(product.getProductId())) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void addNewProduct(Product product) throws ProductAlreadyRegisteredException {
        if (isProductRegisteredAlready(product)) {
            throw new ProductAlreadyRegisteredException("Product ID is registered already.");
        }
        else {
            this.listOfRegisteredProducts.add(product);
        }
    }

    @Override
    public void trade(Product product, int quantity) {
        if (isProductRegisteredAlready(product)) {
            Trade trade = new Trade(product,quantity, LocalDate.now());
            this.listOfProductsTraded.add(trade);
        }
        else {
            System.out.println("Please register product in order to trade!");
        }

    }

    @Override
    public int totalTradeQuantityForDay() {
        return this.listOfProductsTraded.stream().filter(trade -> LocalDate.now().equals(trade.getDate()))
                                .mapToInt(trade -> trade.getQuantity()).sum();
    }

    @Override
    public double totalValueOfDaysTradedProducts() {

        return this.listOfProductsTraded.stream().filter(trade -> LocalDate.now().equals(trade.getDate()))
                                .mapToDouble(trade -> trade.getQuantity() * trade.getProduct().getCurrentPrice(this.pricingService)).sum();
    }
}
