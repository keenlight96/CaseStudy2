package com.main.companymanagementapp;

import com.main.companymanagementapp.customer.Customer;
import com.main.companymanagementapp.data.Loader;
import com.main.companymanagementapp.data.Saver;
import com.main.companymanagementapp.product.Product;
import com.main.companymanagementapp.receipt.Receipt;
import com.main.companymanagementapp.user.Employee;
import javafx.event.ActionEvent;

import java.util.*;

public class Main {
    public static Employee user = new Employee() {
        @Override
        public void userControlPanel(ActionEvent event) {
        }

        @Override
        public long calculateSalary() {
            return 0;
        }
    };
    public static List<Employee> userManagement = new ArrayList<>();
    public static List<Employee> pendingManagement = new ArrayList<>();
    public static Map<String,Integer> idData = new HashMap<>();
    public static List<Product> productWarehouseManagement = new ArrayList<>();
    public static List<Product> productStoreManagement = new ArrayList<>();
    public static List<Customer> customerManagement = new ArrayList<>();
    public static List<Receipt> receiptManagement = new ArrayList<>();

}
