package com.mycompany.registration_and_login1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LoginTest {

    Login login = new Login();

    // 🔹 Username Tests
    @Test
    void testUsernameValid() {
        assertTrue(login.checkUserName("Sbu_1")); // valid
    }

    @Test
    void testUsernameTooLong() {
        assertFalse(login.checkUserName("Sbu_123")); // >5 characters
    }

    @Test
    void testUsernameNoUnderscore() {
        assertFalse(login.checkUserName("Sbu12")); // no "_"
    }

    // 🔹 Password Tests
    @Test
    void testPasswordValid() {
        assertTrue(login.checkPasswordComplexity("Abcdef1!")); // valid
    }

    @Test
    void testPasswordTooShort() {
        assertFalse(login.checkPasswordComplexity("Ab1!")); // <8 characters
    }

    @Test
    void testPasswordNoCapital() {
        assertFalse(login.checkPasswordComplexity("abcdef1!")); // no uppercase
    }

    @Test
    void testPasswordNoNumber() {
        assertFalse(login.checkPasswordComplexity("Abcdefg!")); // no number
    }

    @Test
    void testPasswordNoSpecialChar() {
        assertFalse(login.checkPasswordComplexity("Abcdefg1")); // no special char
    }

    // 🔹 Phone Number Tests
    @Test
    void testPhoneValid() {
        assertTrue(login.checkCellPhoneNumber("+27728478453")); // valid SA format
    }

    @Test
    void testPhoneMissingPlus() {
        assertFalse(login.checkCellPhoneNumber("27728478453")); // no "+"
    }

    @Test
    void testPhoneInvalidCharacters() {
        assertFalse(login.checkCellPhoneNumber("+27abc123")); // letters not allowed
    }

    // 🔹 Register User Tests
    @Test
    void testRegisterSuccess() {
        String result = login.registerUser("Sbu_1", "Abcdef1!");
        assertTrue(result.contains("registered successfully"));
    }

    @Test
    void testRegisterInvalidUsername() {
        String result = login.registerUser("Sbu12", "Abcdef1!");
        assertTrue(result.contains("username is incorrectly formatted"));
    }

    @Test
    void testRegisterInvalidPassword() {
        String result = login.registerUser("Sbu_1", "abc");
        assertTrue(result.contains("password does not meet"));
    }

    // 🔹 Login Tests
    @Test
    void testLoginSuccess() {
        assertTrue(login.loginUser("Sbu_1", "Sbu_1", "Abcdef1!", "Abcdef1!"));
    }

    @Test
    void testLoginFail() {
        assertFalse(login.loginUser("Sbu_1", "Sbu_2", "Abcdef1!", "wrongPass"));
    }

    // 🔹 Return Login Status Tests
    @Test
    void testReturnLoginSuccessMessage() {
        String result = login.returnLoginStatus("Sbu_1", "Sbu_1", "Abcdef1!", "Abcdef1!");
        assertEquals("A successful login", result);
    }

    @Test
    void testReturnLoginFailMessage() {
        String result = login.returnLoginStatus("wrong", "Sbu_1", "wrong", "Abcdef1!");
        assertEquals("A failed login", result);
    }
}