package com.ncu.main;

import java.util.*;
import java.io.*;
import com.ncu.login.*;
import com.ncu.validators.*;

public class Main {
    public static void main(String[] args) {

        LoginVerification logincheck = new LoginVerification(); // To match the login credentials with properties file
        NameValidator nv = new NameValidator(); // To Validate Username
        Expense ex = new Expense(); // To read expense when login authenticated
        Menu mn = new Menu(); // For loading menu
        Scanner s = new Scanner(System.in);
        PasswordField pf = new PasswordField(); // for asterisks masking of password
        // Console console = System.console();
        System.out.println("Welcome to Expenese Management System: ");
        int i = 0, j = 1;
        String username, password;
        while (i == 0) {
            s.nextLine();
            System.out.print("Enter username:");
            username = s.nextLine();
            nv.nameValidator(username);
            System.out.print("Enter password:");// password:user
            // password = new String(console.readPassword());
            password = pf.readPassword(); // calling method from PasswordField class for asterisks masking
            System.out.println("Password entered was:" + password); // printing password
            // nv.nameValidator(password);
            if (logincheck.chkpass(username, password)) {
                System.out.println("\nAuthentication Successful\n\nFollowing are your current Expenses:-\n");
                ex.expenseRead();
                mn.mainMenu();
                i++;
            } else {
                System.out.println("Wrong Username or Password!! Press 1 to try again and any other to exit");
                j = s.nextInt();
                if (j == 1) {
                    System.out.println("Authentication Failed try again...");
                } else {
                    break;
                }
            }

        }

    }

}