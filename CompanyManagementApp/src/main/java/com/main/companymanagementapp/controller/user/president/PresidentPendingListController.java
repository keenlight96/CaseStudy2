package com.main.companymanagementapp.controller.user.president;

import com.main.companymanagementapp.Main;
import com.main.companymanagementapp.controller.Controller;
import com.main.companymanagementapp.user.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;


public class PresidentPendingListController implements Initializable {
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
    @FXML
    private TableColumn<Employee,String> statusColumn;

    private ObservableList<Employee> employeeList;

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {
        employeeList = FXCollections.observableArrayList(Main.pendingManagement);
        roleColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("role"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("username"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("phoneNumber"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("address"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("status"));
        tableView.setItems(employeeList);
        addButtonToTable();
    }
    private void addButtonToTable() {
        TableColumn<Employee, Void> colBtn = new TableColumn("Approve");

        Callback<TableColumn<Employee, Void>, TableCell<Employee, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Employee, Void> call(final TableColumn<Employee, Void> param) {
                final TableCell<Employee, Void> cell = new TableCell<>() {

                    private final Button btn = new Button("Approve");

                    {
                        btn.setOnAction((ActionEvent event) -> approve(getTableView().getItems().get(getIndex()).getUsername()));
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);

        tableView.getColumns().add(colBtn);

    }

    public void approve(String username) {
        for (Employee e :
                Main.pendingManagement) {
            if (e.getUsername().equals(username)) {
                e.setId();
                e.setStatus("Active");
                Main.userManagement.add(e);
                Main.pendingManagement.remove(e);
                employeeList.removeAll();
                employeeList = FXCollections.observableArrayList(Main.pendingManagement);
                tableView.setItems(employeeList);
                return;
            }
        }
    }

    public void back(ActionEvent event) {
        Controller.switchScene(event, Controller.presidentControlPanelView);
    }

}

