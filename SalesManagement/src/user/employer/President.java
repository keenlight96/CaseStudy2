package user.employer;

import controller.ValidateInput;
import data.Loader;
import data.Saver;
import user.Employee;

import java.util.List;

public class President extends Employee {
    List<Employee> userManagement = Loader.loadUserData(Loader.userDataFile);
    List<Employee> pendingManagement = Loader.loadUserData(Loader.userPendingDataFile);

    public President() {
    }

    public President(String username, String password) {
        super(username, password);
    }

    public President(String id, String name, String phoneNumber, String address, String status, String username, String password) {
        super("PR001", name, phoneNumber, address, status, username, password);
    }

    @Override
    public void userControlPanel() {
        userManagement = Loader.loadUserData(Loader.userDataFile);
        pendingManagement = Loader.loadUserData(Loader.userPendingDataFile);
        int choice;
        while (true) {
            System.out.println("1. Show list employees");
            System.out.println("2. Show list pending account");
            choice = ValidateInput.inputInteger("choice", 0,2);
            switch (choice) {
                case 1:
                    for (Employee e :
                            userManagement) {
                        System.out.println(e);
                    }
                    break;
                case 2:
                    for (Employee e :
                            pendingManagement) {
                        System.out.println(e);
                    }
                    approveAccount();
                    break;
                case 0:
                    return;
            }
        }
    }

    public void approveAccount() {
        int choice;
        boolean check;
        while (true) {
            check = false;
            choice = ValidateInput.inputInteger("id to approve");
            if (choice == 0)
                return;
            for (Employee e :
                    pendingManagement) {
                if (Integer.parseInt(e.getId()) == choice) {
                    check = true;
                    userManagement.add(e);
                    pendingManagement.remove(e);
                    Saver.saveUserData(userManagement,Saver.userDataFile);
                    Saver.saveUserData(pendingManagement,Saver.userPendingDataFile);
                    break;
                }
            }
            if (check)
                System.out.println("User has been approved");
            else
                System.out.println("ID not found");
        }
    }
}
