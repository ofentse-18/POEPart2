package com.mycompany.poepart2;

import com.mycompany.poepart2.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
public class MessageTest {
    
    private Message message;

    @BeforeEach
    public void setUp() {
        message = new Message();
        Message.resetTotalMessagesSent();
    }

    @Test
    public void testMessageLengthSuccess() {
        String testMessage = "Hi Mike, can you join us for dinner tonight?";
        String expected = "Message ready to send.";
        String actual = message.checkMessageLength(testMessage);
        assertEquals(expected, actual);
    }

    @Test
    public void testMessageLengthFailure() {
        StringBuilder longMsg = new StringBuilder();
        for (int i = 0; i < 260; i++) {
            longMsg.append("x");
        }
        String actual = message.checkMessageLength(longMsg.toString());
        assertEquals("Message exceeds 250 characters by 10; please reduce the size.", actual);
    }

    @Test
    public void testRecipientNumberSuccess() {
        String validNumber = "+27718693002";
        String expected = "Cell phone number successfully captured.";
        String actual = message.checkRecipientCell(validNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void testRecipientNumberFailure() {
        String invalidNumber = "08575975889";
        String expected = "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        String actual = message.checkRecipientCell(invalidNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void testMessageHashCorrect() {
        String fakeMessageId = "0012345678";
        int messageNumber = 0;
        String messageText = "Hi Mike, can you join us for dinner tonight?";

        String expectedHash = "00:0:HITONIGHT";
        String actualHash = message.createMessageHash(fakeMessageId, messageNumber, messageText);
        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testMessageIdCreated() {
        assertTrue(message.checkMessageId());
        assertNotNull(message.getMessageId());
        assertEquals("Message ID generated: " + message.getMessageId(), message.getMessageIdNotification());
    }

    @Test
    public void testUserSelectedSendMessage() {
        String result = message.SentMessage(1);
        assertEquals("Message successfully sent.", result);
        assertEquals(1, message.returnTotalMessagess());
    }

    @Test
    public void testUserSelectedDisregardMessage() {
        String result = message.SentMessage(2);
        assertEquals("Press 0 to delete the message.", result);
    }

    @Test
    public void testUserSelectedStoreMessage() {
        String result = message.SentMessage(3);
        assertEquals("Message successfully stored.", result);
    }

    private void assertEquals(String expected, String actual) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertNotNull(String messageId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertEquals(int i, int returnTotalMessagess) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertTrue(Boolean checkMessageId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
    

