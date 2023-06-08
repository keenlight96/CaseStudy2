package user.finance;

public class FinanceManager extends FinanceStaff{
    public FinanceManager() {
    }

    public FinanceManager(String username, String password) {
        super(username, password);
    }

    public FinanceManager(String id, String name, String phoneNumber, String address, String status, String username, String password) {
        super(id, name, phoneNumber, address, status, username, password);
    }

    @Override
    public void userControlPanel() {

    }
}
