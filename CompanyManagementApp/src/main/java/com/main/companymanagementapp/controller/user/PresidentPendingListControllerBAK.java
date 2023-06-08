package com.main.companymanagementapp.controller.user;

import com.main.companymanagementapp.Main;
import com.main.companymanagementapp.controller.Controller;
import com.main.companymanagementapp.user.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;


public class PresidentPendingListControllerBAK implements Initializable {
    @FXML
    private TableView<Employee> tableView;
    @FXML
    private TableColumn<Employee, String> roleColumn;
    @FXML
    private TableColumn<Employee, String> usernameColumn;
    @FXML
    private TableColumn<Employee,String> nameColumn;
    @FXML
    private TableColumn<Employee,String> phoneNumberColumn;
    @FXML
    private TableColumn<Employee,String> addressColumn;

    // Approve
    @FXML
    private TextField usernameToApprove;

    private ObservableList<Employee> employeeList;

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {
        employeeList = FXCollections.observableArrayList(Main.pendingManagement);
        roleColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("role"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("username"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("phoneNumber"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("address"));
        tableView.setItems(employeeList);
    }

    public void approve() {
        for (Employee e :
                Main.pendingManagement) {
            if (e.getUsername().equals(usernameToApprove.getText())) {
                Main.userManagement.add(e);
                Main.pendingManagement.remove(e);
                usernameToApprove.setText("");
                employeeList.removeAll();
                employeeList = FXCollections.observableArrayList(Main.pendingManagement);
                tableView.setItems(employeeList);
                return;
            }
        }
        usernameToApprove.setText("");
    }

    public void back(ActionEvent event) {
        Controller.switchScene(event, Controller.presidentControlPanelView);
    }

}

