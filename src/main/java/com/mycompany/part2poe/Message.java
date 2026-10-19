package com.mycompany.part2poe;

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
    
    
    
    
    
    
    
   

    private String createMessageHash() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
