package com.main.companymanagementapp.data;

import com.main.companymanagementapp.Main;
import com.main.companymanagementapp.user.Employee;

import java.io.*;
import java.util.List;

public class Saver {
    public static File userDataFile = new File("src/main/java/com/main/companymanagementapp/data/userData.txt");
    public static File userPendingDataFile = new File("src/main/java/com/main/companymanagementapp/data/userPendingData.txt");
    public static File idData = new File("src/main/java/com/main/companymanagementapp/data/idData.txt");
    public static File productWarehouseData = new File("src/main/java/com/main/companymanagementapp/data/productWarehouseData.txt");
    public static File productStoreData = new File("src/main/java/com/main/companymanagementapp/data/productStoreData.txt");
    public static File customerData = new File("src/main/java/com/main/companymanagementapp/data/customerData.txt");
    public static File receiptData = new File("src/main/java/com/main/companymanagementapp/data/receiptData.txt");

    public static void saveUserData(List<Employee> list, File file) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveIdData() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(idData))) {
            objectOutputStream.writeObject(Main.idData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveUserData() {
        try (ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(new FileOutputStream(userDataFile));
             ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(userPendingDataFile))) {
            objectOutputStream1.writeObject(Main.userManagement);
            objectOutputStream2.writeObject(Main.pendingManagement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveProductWarehouseData() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(productWarehouseData))) {
            objectOutputStream.writeObject(Main.productWarehouseManagement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveProductStoreData() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(productStoreData))) {
            objectOutputStream.writeObject(Main.productStoreManagement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveCustomerData() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(customerData))) {
            objectOutputStream.writeObject(Main.customerManagement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveReceiptData() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(receiptData))) {
            objectOutputStream.writeObject(Main.receiptManagement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
