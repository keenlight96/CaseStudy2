package user.logistics;

import user.Employee;

public abstract class LogisticsStaff extends Employee {
    public LogisticsStaff() {
    }

    public LogisticsStaff(String username, String password) {
        super(username, password);
    }

    public LogisticsStaff(String id, String name, String phoneNumber, String address, String status, String username, String password) {
        super(id, name, phoneNumber, address, status, username, password);
    }
}
