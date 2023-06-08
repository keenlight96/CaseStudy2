package user.finance;

public class FinanceEmployee extends FinanceStaff {
    public FinanceEmployee() {
    }

    public FinanceEmployee(String username, String password) {
        super(username, password);
    }

    public FinanceEmployee(String id, String name, String phoneNumber, String address, String status, String username, String password) {
        super(id, name, phoneNumber, address, status, username, password);
    }

    @Override
    public void userControlPanel() {

    }
}
