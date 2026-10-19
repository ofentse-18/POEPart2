/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poepart2;

import com.mycompany.poepart2.Message;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Main application driver for Part 2(incorporating Part 1 Auth and Part 2 QuickChat) 
 */
public class POEPart2 {

    private static Object Interger;

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
         
         ArrayList<Message> messageList = new ArrayList<>();
         boolean isRunning = true;
         
         //while loop for application running and quitting
         while(isRunning){
             System.out.println("\nPlease choose an option from the menu: ");
             System.out.println("1) Send Messages");
             System.out.println("2) Show recently sent messages");
             System.out.println("3) Quit");
             System.out.println("Enter choice (1-3): ");
             
             String menuChoice = scanner.nextLine().trim();
             
             switch(menuChoice){
                 case "1":
                     //User defines number of messages to enter
                     System.out.println("\nHow many messages would you like to enter?");
                     int numMessages = 0;
                     try{
                         numMessages = Integer.parseInt(scanner.nextLine().trim());
                     }catch (NumberFormatException e){
                         System.out.println("Invalid numeric input. Returning to menu.");
                         break;
                     }
                     
                      // For loop to enter the assigned number of messages
                    for (int i = 0; i < numMessages; i++) {
                        System.out.println("\n--- Entering Message " + (i + 1) + " of " + numMessages + " ---");

                        Message msg = new Message();
                        // Message number created using loop counter
                        msg.setMessageNumber(i);

                        // Recipient cell number input loop
                        while (true) {
                            System.out.print("Enter Recipient Cell Number: ");
                            String recipient = scanner.nextLine().trim();
                            String validation = msg.checkRecipientCell(recipient);
                            System.out.println(validation);
                            if (validation.contains("successfully captured")) {
                                msg.setRecipientCell(recipient);
                                break;
                            }
                        }

                         // Message text input & length validation (<= 250)
                        while (true) {
                            System.out.print("Enter Message text: ");
                            String text = scanner.nextLine();
                            String lengthStatus = msg.checkMessageLength(text);
                            System.out.println(lengthStatus);
                            if (lengthStatus.equals("Message ready to send.")) {
                                msg.setMessageText(text);
                                break;
                            }
                        }
                        
                         int action = 1;
                        try {
                            action = Integer.parseInt(scanner.nextLine().trim());
                        } catch (NumberFormatException ignored) {}

                        String actionResult = msg.SentMessage(action);
                        System.out.println(actionResult);

                        if (action == 2) {
                            System.out.print("Confirm (press 0 to delete the message): ");
                            String deleteConfirm = scanner.nextLine().trim();
                            if (deleteConfirm.equals("0")) {
                                System.out.println("Message disregarded.");
                            }
                        }

                        // Output message details in strict rubric order:
                        // Message ID, Message Hash, Recipient, Message
                        System.out.println("\n--- Message Details ---");
                        System.out.println(msg.printMessages());

                        messageList.add(msg);
                    }

                    // Total number of messages accumulated
                    System.out.println("\nTotal messages sent so far: " + Message.getTotalMessagesSent());
                    break;

                case "2":
                    System.out.println("Coming Soon.");
                    break;

                case "3":
                    System.out.println("Exiting QuickChat. Goodbye!");
                    isRunning = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please select 1, 2, or 3.");
            }
        }

        scanner.close();
                     
             }
         }
    

