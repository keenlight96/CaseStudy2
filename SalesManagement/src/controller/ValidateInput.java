package controller;

import user.Employee;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateInput {
    static Scanner scanner = new Scanner(System.in);
    static Pattern pattern;
    static Matcher matcher;

    // Input String
    public static String inputString(String input, String regex) {
        String text;
        while (true) {
            try {
                System.out.print("Input " + input + ": ");
                text = scanner.nextLine();
                pattern = Pattern.compile(regex);
                matcher = pattern.matcher(text);
                if (matcher.matches())
                    return text;
                else
                    System.out.println("Wrong input format");
            } catch (InputMismatchException e) {
                System.out.println("Wrong input format");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Input Integer
    public static int inputInteger(String input) {
        while (true) {
            try {
                System.out.print("Input " + input + ": ");
                return Integer.parseInt(scanner.nextLine());
            } catch (InputMismatchException e) {
                System.out.println("Wrong input format");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static int inputInteger(String input, int min, int max) {
        while (true) {
            try {
                System.out.print("Input " + input + ": ");
                int number = Integer.parseInt(scanner.nextLine());
                if (number >= min && number <= max)
                    return number;
                else
                    System.out.println("Out of range (Min: " + min + ", Max: " + max + ")");
            } catch (InputMismatchException e) {
                System.out.println("Wrong input format");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Input Double
    public static double inputDouble(String input) {
        while (true) {
            try {
                System.out.print("Input " + input + ": ");
                return Double.parseDouble(scanner.nextLine());
            } catch (InputMismatchException e) {
                System.out.println("Wrong input format");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Input username
    public static String inputUsername(List<Employee>... lists) {
        while (true) {
            String username = inputString("username", "^\\w.{4,15}$");
            boolean check = true;
            for (List<Employee> list :
                    lists) {
                for (Employee e :
                        list) {
                    if (e.getUsername().equals(username)){
                        check = false;
                        break;
                    }
                }
                if (!check)
                    break;
            }
            if (check)
                return username;
        }
    }
}
