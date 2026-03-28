package com.mycompany.registration_and_login1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LoginTest {

    @Test
    void testUsernameLength() {
        assertTrue("Sbu123".length() >= 5);
        assertFalse("abc".length() >= 5);
    }
}
