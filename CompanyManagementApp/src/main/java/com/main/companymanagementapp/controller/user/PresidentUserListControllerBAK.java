package com.main.companymanagementapp.controller.user;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PresidentUserListControllerBAK implements Initializable {
    @FXML
    private Pagination pagination;
    @FXML
    private TableView<Sample> table = createTable();
    @FXML
    private List<Sample> data = createData();
    static int rowsPerPage = 15;

    private TableView<Sample> createTable() {
        TableView<Sample> table = new TableView<>();
        TableColumn<Sample, Integer> idColumn = new TableColumn<>("Id");
        idColumn.setCellValueFactory(param -> param.getValue().id);
        idColumn.setPrefWidth(100);

        TableColumn<Sample, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(param -> param.getValue().foo);
        nameColumn.setPrefWidth(70);

        table.getColumns().addAll(idColumn, nameColumn);
        return table;
    }

    private List<Sample> createData() {
        List<Sample> data = new ArrayList<>(30);
        for (int i = 1; i <= 30; i++) {
            data.add(new Sample(i, "foo " + i, "name " + i));
        }
        return data;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pagination.setPageFactory(this::createPage);
    }

    private Node createPage(int pageIndex) {
        int fromIndex = pageIndex * rowsPerPage;
        int toIndex = Math.min(fromIndex + rowsPerPage, data.size());
        table.setItems(FXCollections.observableArrayList(data.subList(fromIndex, toIndex)));
        return table;
    }

    public static class Sample {
        private ObservableValue<Integer> id;
        private SimpleStringProperty foo;
        private SimpleStringProperty bar;

        public Sample(int id, String foo, String bar) {
            this.id = new SimpleObjectProperty<>(id);
            this.foo = new SimpleStringProperty(foo);
            this.bar = new SimpleStringProperty(bar);
        }
    }


}

