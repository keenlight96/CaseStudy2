package com.main.companymanagementapp.receipt;

import com.main.companymanagementapp.Main;
import com.main.companymanagementapp.customer.Customer;
import com.main.companymanagementapp.product.Product;

import java.io.Serializable;
import java.util.List;

public class Receipt implements Serializable {
    private int id;
    private Customer customer;
    private List<Product> products;
    private String description;
    private long totalPrice;

    public Receipt() {
        if (Main.receiptManagement.size() == 0) {
            id = 1;
        } else {
            id = Main.receiptManagement.get(Main.receiptManagement.size() - 1).getId() + 1;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }
}
