module com.main.companymanagementapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.main.companymanagementapp to javafx.fxml;
    exports com.main.companymanagementapp;
}