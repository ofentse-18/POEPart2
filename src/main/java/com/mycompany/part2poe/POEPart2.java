/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.part2poe;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Main application driver for Part 2(incorporating Part 1 Auth and Part 2 QuickChat) 
 */
public class POEPart2 {

    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       Login user = new Login();
       
       //----------------------------------------------------
       //PART 1: USER REGISTRATION
       //----------------------------------------------------
       
       System.out.println("=== USER REGISTRATION ===");
        System.out.print("Enter First Name: ");
        user.setFirstName(scanner.nextLine());

        System.out.print("Enter Last Name: ");
        user.setLastName(scanner.nextLine());

        // Username loop
        while (true) {
            System.out.print("Enter Username: ");
            String username = scanner.nextLine();
            user.setUsername(username);
            if (user.checkUserName()) {
                System.out.println("Username successfully captured.");
                break;
            } else {
                System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
            }
        }

        // Password loop
        while (true) {
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();
            user.setPassword(password);
            if (user.checkPasswordComplexity()) {
                System.out.println("Password successfully captured.");
                break;
            } else {
                System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
            }
        }

        // Cell phone loop
        while (true) {
            System.out.print("Enter Cell Phone Number: ");
            String cell = scanner.nextLine();
            user.setCellPhoneNumber(cell);
            if (user.checkCellPhoneNumber()) {
                System.out.println("Cell phone number successfully captured.");
                break;
            } else {
                System.out.println("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.");
            }
        }

        System.out.println(user.registerUser());

        // ---------------------------------------------------------
        // PART 1: USER LOGIN
        // ---------------------------------------------------------
        System.out.println("\n=== USER LOGIN ===");
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.print("Enter Username: ");
            String loginUser = scanner.nextLine();

            System.out.print("Enter Password: ");
            String loginPass = scanner.nextLine();

            loggedIn = user.loginUser(loginUser, loginPass);
            System.out.println(user.returnLoginStatus(loggedIn));
        }
        
        //-----------------------------------------------------------------
        //PART 2 : QUICKCHAT (Only accessible after successful login)
        //-----------------------------------------------------------------
         System.out.println("\nWelcome to QuickChat. ");
         
         Array
    }
}
