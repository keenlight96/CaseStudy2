package user.finance;

import user.Employee;

public abstract class FinanceStaff extends Employee {
    public FinanceStaff() {
    }

    public FinanceStaff(String username, String password) {
        super(username, password);
    }

    public FinanceStaff(String id, String name, String phoneNumber, String address, String status, String username, String password) {
        super(id, name, phoneNumber, address, status, username, password);
    }
}
