package com.main.companymanagementapp.customer;

public class CustomerBuilder {
    Customer customer;

    public CustomerBuilder() {
        customer = new Customer();
    }

    public CustomerBuilder addName(String name) {
        customer.setName(name);
        return this;
    }

    public CustomerBuilder addPhoneNumber(String phoneNumber) {
        customer.setPhoneNumber(phoneNumber);
        return this;
    }

    public CustomerBuilder addAddress(String address) {
        customer.setAddress(address);
        return this;
    }

    public Customer build() {
        return customer;
    }
}
