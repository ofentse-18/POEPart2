package com.mycompany.poepart2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    private Login login;

    @BeforeEach
    public void setUp() {
        login = new Login();
        login.setFirstName("Kylian");
        login.setLastName("Mbappe");
        login.setUsername("kyl_1");
        login.setPassword("Ch&&sec99!");
        login.setCellPhoneNumber("+27831234567");
    }

    @Test
    public void testCheckUserNameCorrect() {
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testCheckUserNameIncorrect() {
        assertFalse(login.checkUserName("kyle!!!!!!"));
    }

    @Test
    public void testCheckPasswordComplexitySuccess() {
        assertTrue(login.checkPasswordComplexity("Ch&&sec99!"));
    }

    @Test
    public void testCheckPasswordComplexityFailure() {
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testCheckCellPhoneNumberSuccess() {
        assertTrue(login.checkCellPhoneNumber("+27831234567"));
    }

    @Test
    public void testCheckCellPhoneNumberFailure() {
        assertFalse(login.checkCellPhoneNumber("0831234567"));
    }

    @Test
    public void testLoginSuccessful() {
        assertTrue(login.loginUser("kyl_1", "Ch&&sec99!"));
        assertEquals("Welcome Kylian, Mbappe it is great to see you again.", login.returnLoginStatus(true));
    }

    @Test
    public void testLoginFailed() {
        assertFalse(login.loginUser("wrong_user", "wrong_pass"));
        assertEquals("Username or password incorrect, please try again.", login.returnLoginStatus(false));
    }

    private void assertTrue(boolean checkUserName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertFalse(boolean checkPasswordComplexity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertEquals(String welcome_Kylian_Mbappe_it_is_great_to_see_, String returnLoginStatus) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

