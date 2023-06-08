package com.main.companymanagementapp.receipt;

import com.main.companymanagementapp.customer.Customer;
import com.main.companymanagementapp.product.Product;

import java.util.List;

public class ReceiptBuilder {
    Receipt receipt;

    public ReceiptBuilder() {
        receipt = new Receipt();
    }
    public ReceiptBuilder addCustomer(Customer customer){
        receipt.setCustomer(customer);
        return this;
    }

    public ReceiptBuilder addProducts(List<Product> list){
        receipt.setProducts(list);
        return this;
    }

    public ReceiptBuilder addDescription(String description) {
        receipt.setDescription(description);
        return this;
    }

    public ReceiptBuilder addTotalPrice(long totalPrice) {
        receipt.setTotalPrice(totalPrice);
        return this;
    }

    public Receipt build(){
        return receipt;
    }
}
