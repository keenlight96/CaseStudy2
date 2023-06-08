package com.main.companymanagementapp;

import com.main.companymanagementapp.controller.Controller;
import com.main.companymanagementapp.data.Loader;
import com.main.companymanagementapp.data.Saver;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(Controller.loginView));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("MANAGEMENT");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop(){
        Saver.saveIdData();
        Saver.saveUserData();
        Saver.saveProductWarehouseData();
        Saver.saveProductStoreData();
        Saver.saveCustomerData();
        Saver.saveReceiptData();
    }

    public static void main(String[] args) {
        Loader.loadIdData();
        Loader.loadUserData();
        Loader.loadProductWarehouseData();
        Loader.loadProductStoreData();
        Loader.loadCustomerData();
        Loader.loadReceiptData();
        launch();
    }
}