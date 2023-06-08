package com.main.companymanagementapp.controller.user.president;

import com.main.companymanagementapp.Main;
import com.main.companymanagementapp.controller.Controller;
import com.main.companymanagementapp.user.Employee;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class PresidentUserListController implements Initializable {
    NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
    @FXML
    private TableView<Employee> tableView;
    @FXML
    private TableColumn<Employee, String> idColumn;
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
    private TableColumn<Employee,String> totalSalaryColumn;
    @FXML
    private TableColumn<Employee,String> statusColumn;

    private ObservableList<Employee> employeeList;

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {
        employeeList = FXCollections.observableArrayList(Main.userManagement);
        idColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("id"));
        roleColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("role"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("username"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("phoneNumber"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("address"));
        totalSalaryColumn.setCellValueFactory(cellData ->{
            Long totalSalary = cellData.getValue().getTotalSalary();
            if (totalSalary != 0) {
                return new SimpleStringProperty(numberFormat.format(totalSalary));
            }
            return new SimpleStringProperty("");
        });
        statusColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("status"));
        tableView.setItems(employeeList);
        if (Main.user.getRole().equals("President")){
            addButtonToTable();
        }
    }
    private void addButtonToTable() {
        TableColumn<Employee, Void> colBtn = new TableColumn("Terminate");

        Callback<TableColumn<Employee, Void>, TableCell<Employee, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Employee, Void> call(final TableColumn<Employee, Void> param) {
                final TableCell<Employee, Void> cell = new TableCell<>() {

                    private final Button btn = new Button("Terminate");

                    {
                        btn.setOnAction((ActionEvent event) -> terminate(getTableView().getItems().get(getIndex())));
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

    public void terminate(Employee employee) {
        Main.userManagement.remove(employee);
        employeeList.clear();
        employeeList.addAll(Main.userManagement);
        tableView.refresh();
    }

    public void activate(String username) {
        // Add code here and add button
    }

    public void back(ActionEvent event) {
        Controller.switchScene(event, Controller.presidentControlPanelView);
    }

}
