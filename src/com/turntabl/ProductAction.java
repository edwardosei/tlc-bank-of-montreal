package com.turntabl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductAction implements MontrealTradedProducts {

    private final List<Product> listOfRegisteredProducts = new ArrayList<Product>();
    private final Map<Product,Integer> listOfProductsTraded = new HashMap<Product,Integer>();

    public List<Product> getListOfRegisteredProducts() {
        return listOfRegisteredProducts;
    }

    public Map<Product, Integer> getListOfProductsTraded() {
        return listOfProductsTraded;
    }

    private boolean isProductRegisteredAlready(Product product) {

        for(Product item : this.listOfRegisteredProducts) {
            if (item.getProductID() == product.getProductID()) {
                product.setRegistered(true);
                return true;
            }
        }

        return false;
    }

    @Override
    public void addNewProduct(Product product) throws ProductAlreadyRegisteredException {
        if (isProductRegisteredAlready(product)  == true) {
            throw new ProductAlreadyRegisteredException("Product ID is registered already.");
        }
        else {
            product.setRegistered(true);
            this.listOfRegisteredProducts.add(product);
        }
    }

    @Override
    public void trade(Product product, int quantity) {
        if (isProductRegisteredAlready(product)  == true) {
            this.listOfProductsTraded.put(product, quantity);
        }
        else {
            System.out.println("Please register product in order to trade!");
        }

    }

    @Override
    public int totalTradeQuantityForDay() {
        int sumOfQuantity = this.listOfProductsTraded.values().stream().mapToInt(value -> value).sum();
        return sumOfQuantity;
    }

    @Override
    public double totalValueOfDaysTradedProducts() {
        double totalValue = 0;

        for (Map.Entry<Product, Integer> entry : this.listOfProductsTraded.entrySet()) {
            Product product = entry.getKey();
            Integer quantity = entry.getValue();
            totalValue += product.getCurrentPrice() * quantity;
        }

        return totalValue;
    }
}
