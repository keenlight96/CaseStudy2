package com.main.companymanagementapp.controller;

import com.main.companymanagementapp.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {
    // Login - Register - Settings
    public static String loginView = "login/login-view.fxml";
    public static String registerView = "login/register-view.fxml";
    public static String settingsView = "user/userInformation-view.fxml";

    // President
    public static String presidentControlPanelView = "user/president/president-ControlPanel-view.fxml";
    public static String presidentUserListView = "user/president/president-UserList-view.fxml";
    public static String presidentPendingListView = "user/president/president-PendingList-view.fxml";
    public static String presidentCompanyFundView = "user/president/president-CompanyFund-view.fxml";

    // Logistics
    public static String LMControlPanelView = "user/logistics/manager/LM-ControlPanel-view.fxml";
    public static String LEControlPanelView = "user/logistics/employee/LE-ControlPanel-view.fxml";
    public static String LMLEListView = "user/logistics/manager/LM-LEList-view.fxml";
    public static String productWarehouseView = "user/logistics/productWarehouseList-view.fxml";
    public static String LMAddProductTypeView = "user/logistics/manager/LM-AddProductType-view.fxml";
    public static String importProductView = "user/logistics/importProduct-view.fxml";
    public static String moveProductView = "user/logistics/employee/moveProduct-view.fxml";

    // Sales
    public static String SMControlPanelView = "user/sales/manager/SM-ControlPanel-view.fxml";
    public static String SPControlPanelView = "user/sales/employee/SP-ControlPanel-view.fxml";
    public static String SMSPListView = "user/sales/manager/SM-SPList-view.fxml";
    public static String productStoreView = "user/sales/productStoreList-view.fxml";
    public static String customersListView = "user/sales/customerList-view.fxml";
    public static String allReceiptsListView = "user/sales/manager/allReceiptsList-view.fxml";
    public static String createCustomerView = "user/sales/createCustomer-view.fxml";
    public static String createReceiptView = "user/sales/createReceipt-view.fxml";

    // Accountant
    public static String ACControlPanelView = "user/finance/AC-ControlPanel-view.fxml";
    public static String ACSalaryView = "user/finance/AC-Salary-view.fxml";


    public static void switchScene(ActionEvent event, String url) {
        try {
            Parent root = FXMLLoader.load(HelloApplication.class.getResource(url));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
