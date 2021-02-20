package com.turntabl;

import java.time.LocalDate;

public class Trade {
    private Product product;
    private int quantity;
    private LocalDate date;

    public Trade(Product product, int quantity, LocalDate date) {
        this.product = product;
        this.quantity = quantity;
        this.date = date;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
