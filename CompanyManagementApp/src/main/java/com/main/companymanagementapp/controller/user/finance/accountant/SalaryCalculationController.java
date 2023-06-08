package com.main.companymanagementapp.controller.user.finance.accountant;

import com.main.companymanagementapp.Main;
import com.main.companymanagementapp.controller.AlertInformation;
import com.main.companymanagementapp.controller.Controller;
import com.main.companymanagementapp.user.Employee;
import com.main.companymanagementapp.user.employer.President;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class SalaryCalculationController implements Initializable {
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
    private TableColumn<Employee,Integer> workdaysColumn;
    @FXML
    private TableColumn<Employee,Long> salaryColumn;

    private ObservableList<Employee> employeeList;
    AlertInformation alert = new AlertInformation();
    President president = (President) Main.userManagement.get(0);

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {
        // Calculate salary
        for (Employee e :
                Main.userManagement) {
            e.setSalary(e.calculateSalary());
        }

        // Show list
        employeeList = FXCollections.observableArrayList(Main.userManagement);
        idColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("id"));
        roleColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("role"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("username"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("phoneNumber"));
        workdaysColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("workDays"));
        salaryColumn.setCellValueFactory(new PropertyValueFactory<Employee, Long>("salary"));
        tableView.setItems(employeeList);
//        addButtonToTable();
    }
    
    public void payAll() {
        long totalPayForSalary = 0;
        for (Employee e :
                Main.userManagement) {
            totalPayForSalary += e.getSalary();
        }
        if (totalPayForSalary <= president.getCompanyFund()) {
            president.setCompanyFund(president.getCompanyFund() - totalPayForSalary);
            alert.show("SUCCESS","All employees happily received their salary","");
            for (Employee e :
                    Main.userManagement) {
                e.setTotalSalary(e.getTotalSalary() + e.getSalary());
                e.setSalary(0);
                e.setWorkDays(0);
            }
        } else {
            alert.show("FAILURE","President said company fund has not enough", "");
        }
    }
    
    private void addButtonToTable() {
        TableColumn<Employee, Void> colBtn = new TableColumn("Pay");

        Callback<TableColumn<Employee, Void>, TableCell<Employee, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Employee, Void> call(final TableColumn<Employee, Void> param) {
                final TableCell<Employee, Void> cell = new TableCell<>() {

                    private final Button btn = new Button("Pay");

                    {
                        btn.setOnAction((ActionEvent event) -> terminate(getTableView().getItems().get(getIndex()).getUsername()));
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

    public void terminate(String username) {
        // Add code here
    }

    public void activate(String username) {
        // Add code here and add button
    }

    public void back(ActionEvent event) {
        Controller.switchScene(event, Controller.ACControlPanelView);
    }

}
