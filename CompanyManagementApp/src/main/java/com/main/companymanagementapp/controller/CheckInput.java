package com.main.companymanagementapp.controller;

import com.main.companymanagementapp.customer.Customer;
import com.main.companymanagementapp.product.Product;
import com.main.companymanagementapp.user.Employee;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckInput {
    static Scanner scanner = new Scanner(System.in);
    static Pattern pattern;
    static Matcher matcher;
    public static final String NAME_PATTERN = "^([A-ZzàáãạảăắằẳẵặâấầẩẫậèéẹẻẽêềếểễệđìíĩỉịòóõọỏôốồổỗộơớờởỡợùúũụủưứừửữựỳỵỷỹýÀÁÃẠẢĂẮẰẲẴẶÂẤẦẨẪẬÈÉẸẺẼÊỀẾỂỄỆĐÌÍĨỈỊÒÓÕỌỎÔỐỒỔỖỘƠỚỜỞỠỢÙÚŨỤỦƯỨỪỬỮỰỲỴỶỸÝ][a-zzàáãạảăắằẳẵặâấầẩẫậèéẹẻẽêềếểễệđìíĩỉịòóõọỏôốồổỗộơớờởỡợùúũụủưứừửữựỳỵỷỹýÀÁÃẠẢĂẮẰẲẴẶÂẤẦẨẪẬÈÉẸẺẼÊỀẾỂỄỆĐÌÍĨỈỊÒÓÕỌỎÔỐỒỔỖỘƠỚỜỞỠỢÙÚŨỤỦƯỨỪỬỮỰỲỴỶỸÝ]* )*[A-ZzàáãạảăắằẳẵặâấầẩẫậèéẹẻẽêềếểễệđìíĩỉịòóõọỏôốồổỗộơớờởỡợùúũụủưứừửữựỳỵỷỹýÀÁÃẠẢĂẮẰẲẴẶÂẤẦẨẪẬÈÉẸẺẼÊỀẾỂỄỆĐÌÍĨỈỊÒÓÕỌỎÔỐỒỔỖỘƠỚỜỞỠỢÙÚŨỤỦƯỨỪỬỮỰỲỴỶỸÝ][a-zzàáãạảăắằẳẵặâấầẩẫậèéẹẻẽêềếểễệđìíĩỉịòóõọỏôốồổỗộơớờởỡợùúũụủưứừửữựỳỵỷỹýÀÁÃẠẢĂẮẰẲẴẶÂẤẦẨẪẬÈÉẸẺẼÊỀẾỂỄỆĐÌÍĨỈỊÒÓÕỌỎÔỐỒỔỖỘƠỚỜỞỠỢÙÚŨỤỦƯỨỪỬỮỰỲỴỶỸÝ]*$";
    public static final String PHONE_NUMBER_PATTERN = "^0[1-9][0-9]{8}$";
    public static final String EMAIL_PATTERN = "^\\w.*@([a-zA-Z]+\\.)+[a-zA-Z]+$";

    // Input String
    public static boolean isValidString(String input, String regex) {
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(input);
        if (matcher.matches())
            return true;
        else
            return false;
    }

    // Input Integer
    public static boolean isValidInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
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
            }
        }
    }

    // Input Long
    public static boolean isValidLong(String input) {
        try {
            Long.parseLong(input);
            return true;
        } catch (Exception e) {
            return false;
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
            }
        }
    }

    // Input username
    public static boolean isValidUsername(String username, List<Employee>... lists) {
        try {
            for (List<Employee> list :
                    lists) {
                for (Employee e :
                        list) {
                    if (e.getUsername().equals(username)) {
                        return false;
                    }
                }
            }
        } catch (Exception e) {
        }
        return true;
    }

    public static boolean isValidEmail(String email, List<Employee>... lists) {
        try {
            for (List<Employee> list :
                    lists) {
                for (Employee e :
                        list) {
                    if (e.getEmail().equals(email)) {
                        return false;
                    }
                }
            }
        } catch (Exception e) {
        }
        return true;
    }

    public static boolean isValidPhoneNumber(String phoneNumber, List<Employee>... lists) {
        try {
            for (List<Employee> list :
                    lists) {
                for (Employee e :
                        list) {
                    if (e.getPhoneNumber().equals(phoneNumber)) {
                        return false;
                    }
                }
            }
        } catch (Exception e) {
        }
        return true;
    }


    public static boolean isValidPhoneNumber(String phoneNumber, List<Customer> list) {
        try {
            for (Customer e :
                    list) {
                if (e.getPhoneNumber().equals(phoneNumber)) {
                    return false;
                }
            }
        } catch (Exception e) {
        }
        return true;
    }

    public static boolean isValidId(String id, List<Product> list) {
        try {
            for (Product e :
                    list) {
                if (e.getId().equals(id))
                    return false;
            }
        } catch (Exception e) {
        }
        return true;
    }
}
