package user.sales;

import user.Employee;

import java.io.Serializable;

public abstract class SalesStaff extends Employee implements Serializable {
    public SalesStaff() {
    }

    public SalesStaff(String username, String password) {
        super(username, password);
    }

    public SalesStaff(String id, String name, String phoneNumber, String address, String status, String username, String password) {
        super(id, name, phoneNumber, address, status, username, password);
    }

}
