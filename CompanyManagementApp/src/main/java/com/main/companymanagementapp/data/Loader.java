package com.main.companymanagementapp.data;

import com.main.companymanagementapp.Main;
import com.main.companymanagementapp.customer.Customer;
import com.main.companymanagementapp.product.Product;
import com.main.companymanagementapp.receipt.Receipt;
import com.main.companymanagementapp.user.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Loader {
    public static File userDataFile = new File("src/main/java/com/main/companymanagementapp/data/userData.txt");
    public static File userPendingDataFile = new File("src/main/java/com/main/companymanagementapp/data/userPendingData.txt");
    public static File userRoleFile = new File("src/main/java/com/main/companymanagementapp/data/userRole.txt");
    public static File idData = new File("src/main/java/com/main/companymanagementapp/data/idData.txt");
    public static File productWarehouseData = new File("src/main/java/com/main/companymanagementapp/data/productWarehouseData.txt");
    public static File productStoreData = new File("src/main/java/com/main/companymanagementapp/data/productStoreData.txt");
    public static File customerData = new File("src/main/java/com/main/companymanagementapp/data/customerData.txt");
    public static File receiptData = new File("src/main/java/com/main/companymanagementapp/data/receiptData.txt");

    public static List<Employee> loadUserData(File file) {
        List<Employee> list = new ArrayList<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            list = (List<Employee>) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static String[] getRoleList() {
        List<String> roleList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(userRoleFile))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                roleList.add(line);
            }
            String[] list = new String[roleList.size()];
            for (int i = 0; i < list.length; i++) {
                list[i] = roleList.get(i);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String[0];
    }

    public static void loadIdData() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(idData))) {
            Main.idData = (Map<String, Integer>) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            Main.idData = new HashMap<>();
        }
    }

    public static void loadUserData() {
        try (ObjectInputStream objectInputStream1 = new ObjectInputStream(new FileInputStream(userDataFile));
             ObjectInputStream objectInputStream2 = new ObjectInputStream(new FileInputStream(userPendingDataFile))) {
            Main.userManagement = (List<Employee>) objectInputStream1.readObject();
            Main.pendingManagement = (List<Employee>) objectInputStream2.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            Main.userManagement = new ArrayList<>();
            Main.pendingManagement = new ArrayList<>();
        }
    }

    public static void loadProductWarehouseData() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(productWarehouseData))) {
            Main.productWarehouseManagement = (List<Product>) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            Main.productWarehouseManagement = new ArrayList<>();
        }
    }

    public static void loadProductStoreData() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(productStoreData))) {
            Main.productStoreManagement = (List<Product>) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            Main.productStoreManagement = new ArrayList<>();
        }
    }

    public static void loadCustomerData() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(customerData))) {
            Main.customerManagement = (List<Customer>) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            Main.customerManagement = new ArrayList<>();
        }
    }

    public static void loadReceiptData() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(receiptData))) {
            Main.receiptManagement = (List<Receipt>) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            Main.receiptManagement = new ArrayList<>();
        }
    }
}
