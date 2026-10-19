package com.mycompany.poepart2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Message class representing an individual chat message in QuickChat.
 * Handles data encapsulation, validation rules, hash generation, and JSON storage.
 */
public class Message {
    
    private String messageId;
    private int messageNumber;
    private String recipientCell;
    private String messageText;
    private String messageHash;
    private String status;
    
    private static int totalMessagesSent = 0;
    
    public Message(){
        this.messageId = generateMessageId();
        this.messageNumber = 0;
        this.recipientCell = "";
        this.messageText = "";
        this.messageHash = "";
        this.status = "";
    }

    public Message(int messageNumber, String recipientCell, String messageText){
        this.messageId = generateMessageId();
        this.messageNumber = messageNumber;
        this.recipientCell = recipientCell;
        this.messageText = messageText;
        this.messageHash = createMessageHash();
        this.status = "";
    }
    
    public static String generateMessageId(){
        Random random = new Random();
        StringBuilder sb = new StringBuilder ();
        for(int i=0; i<10; i++){
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
    
    public Boolean checkMessageId(){
        return this.messageId !=null && this.messageId.length() <= 10;
    }
    
    public Boolean checkMessageId(String id){
        return id !=null && id.length() <=10;
    }
    
    public String getMessageIdNotification() {
        return "Message ID generated: " + this.messageId;
    }

    public String checkRecipientCell() {
        return checkRecipientCell(this.recipientCell);
    }

    public String checkRecipientCell(String cellNumber) {
        if (cellNumber == null || cellNumber.trim().isEmpty()) {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
        String trimmed = cellNumber.trim();
        if (trimmed.startsWith("+") && trimmed.length() >= 10 && trimmed.length() <= 13) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }

    public String checkMessageLength() {
        return checkMessageLength(this.messageText);
    }

    public String checkMessageLength(String text) {
        if (text == null || text.length() <= 250) {
            return "Message ready to send.";
        } else {
            int excess = text.length() - 250;
            return "Message exceeds 250 characters by " + excess + "; please reduce the size.";
        }
    }

    public String createMessageHash() {
        return createMessageHash(this.messageId, this.messageNumber, this.messageText);
    }

    public String createMessageHash(String id, int number, String text) {
        String firstTwoDigits = "00";
        if (id != null && id.length() >= 2) {
            firstTwoDigits = id.substring(0, 2);
        }

        String cleanText = (text == null) ? "" : text.replaceAll("[^a-zA-Z0-9\\s]", " ").trim();
        String[] words = cleanText.split("\\s+");

        String firstWord = "";
        String lastWord = "";

        if (words.length > 0 && !words[0].isEmpty()) {
            firstWord = words[0].toUpperCase();
            lastWord = words[words.length - 1].toUpperCase();
        }

        return firstTwoDigits + ":" + number + ":" + firstWord + lastWord;
    }

    public String SentMessage(int choice) {
        switch (choice) {
            case 1:
                this.status = "Sent";
                totalMessagesSent++;
                return "Message successfully sent.";
            case 2:
                this.status = "Disregarded";
                return "Press 0 to delete the message.";
            case 3:
                this.status = "Stored";
                storeMessage();
                return "Message successfully stored.";
            default:
                return "Invalid option selected.";
        }
    }

    public String sentMessage(int choice) {
        return SentMessage(choice);
    }

    public String printMessages() {
        return "Message ID: " + this.messageId + "\n"
             + "Message Hash: " + this.messageHash + "\n"
             + "Recipient: " + this.recipientCell + "\n"
             + "Message: " + this.messageText;
    }

    public int returnTotalMessagess() {
        return totalMessagesSent;
    }

    public int returnTotalMessages() {
        return totalMessagesSent;
    }

    public static int getTotalMessagesSent() {
        return totalMessagesSent;
    }

    public static void resetTotalMessagesSent() {
        totalMessagesSent = 0;
    }

    
    //storeMessage()
    //-------CODE ATTRIBUTION-------------
    //JSON 
     public void storeMessage() {
        String jsonRecord = "{\n"
                + "  \"messageId\": \"" + sanitizeJson(this.messageId) + "\",\n"
                + "  \"messageNumber\": " + this.messageNumber + ",\n"
                + "  \"recipientCell\": \"" + sanitizeJson(this.recipientCell) + "\",\n"
                + "  \"messageText\": \"" + sanitizeJson(this.messageText) + "\",\n"
                + "  \"messageHash\": \"" + sanitizeJson(this.messageHash) + "\",\n"
                + "  \"status\": \"" + sanitizeJson(this.status) + "\"\n"
                + "}\n";

        try (FileWriter writer = new FileWriter("stored_messages.json", true)) {
            writer.write(jsonRecord);
        } catch (IOException e) {
            System.err.println("Error storing message to JSON: " + e.getMessage());
        }
    }

    private String sanitizeJson(String value) {
        if (value == null) return "";
        return value.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    public String getMessageId() { return messageId; }
    public void setMessageId(String messageId) {
        this.messageId = messageId;
        this.messageHash = createMessageHash();
    }
    public int getMessageNumber() { return messageNumber; }
    public void setMessageNumber(int messageNumber) {
        this.messageNumber = messageNumber;
        this.messageHash = createMessageHash();
    }
    public String getRecipientCell() { return recipientCell; }
    public void setRecipientCell(String recipientCell) { this.recipientCell = recipientCell; }
    public String getMessageText() { return messageText; }
    public void setMessageText(String messageText) {
        this.messageText = messageText;
        this.messageHash = createMessageHash();
    }
    public String getMessageHash() { return messageHash; }
    public String getStatus() { return status; }
}
    
    
    
    
    
    
    
   

    

