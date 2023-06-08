import management.UserManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserManagement management = new UserManagement();
        management.mainControlPanel();
    }
}
