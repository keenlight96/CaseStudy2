package com.main.companymanagementapp.product;

public class ProductBuilder {
    Product product;

    public ProductBuilder() {
        product = new Product();
    }

    public ProductBuilder addId(String id) {
        product.setId(id);
        return this;
    }

    public ProductBuilder addName(String name) {
        product.setName(name);
        return this;
    }

    public ProductBuilder addUom(String uom) {
        product.setUom(uom);
        return this;
    }

    public ProductBuilder addQuantity(int quantity) {
        product.setQuantity(quantity);
        return this;
    }

    public ProductBuilder addBuyPrice(long buyPrice) {
        product.setBuyPrice(buyPrice);
        return this;
    }

    public ProductBuilder addSellPrice(long sellPrice) {
        product.setSellPrice(sellPrice);
        return this;
    }

    public ProductBuilder addOrigin(String origin) {
        product.setOrigin(origin);
        return this;
    }

    public ProductBuilder addDescription(String description) {
        product.setDescription(description);
        return this;
    }

    public Product build(){
        return product;
    }
}
