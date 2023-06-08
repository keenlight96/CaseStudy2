package com.main.companymanagementapp.product;

import java.io.Serializable;

public class Product implements Serializable {
    private String id;
    private String name;
    private String uom; // unit of measurement
    private int quantity = 0;
    private long buyPrice = 0;
    private long sellPrice = 0;
    private String origin;
    private String description;
    private long totalBuyPrice = 0;
    private long totalSellPrice = 0;

    private final double FACTOR = 1.7;

    public Product() {
    }

    public Product(String id, String name, String uom, int quantity, long buyPrice, String origin, String description) {
        this.id = id;
        this.name = name;
        this.uom = uom;
        this.quantity = quantity;
        this.buyPrice = buyPrice;
        this.sellPrice = (long) (this.buyPrice * FACTOR);
        this.origin = origin;
        this.description = description;
        totalBuyPrice = this.buyPrice * this.quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        getTotalBuyPrice();
        getTotalSellPrice();
    }

    public long getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(long buyPrice) {
        this.buyPrice = buyPrice;
        sellPrice = (long) (this.buyPrice * FACTOR);
        getTotalBuyPrice();
        getTotalSellPrice();
    }

    public long getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(long sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getTotalBuyPrice() {
        return totalBuyPrice = buyPrice * quantity;
    }

    public void setTotalBuyPrice(long totalBuyPrice) {
        this.totalBuyPrice = totalBuyPrice;
    }

    public long getTotalSellPrice() {
        return totalSellPrice = sellPrice * quantity;
    }

    public void setTotalSellPrice(long totalSellPrice) {
        this.totalSellPrice = totalSellPrice;
    }
}
