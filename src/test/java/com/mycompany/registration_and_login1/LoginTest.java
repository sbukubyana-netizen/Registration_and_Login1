import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.mycompany.registration_and_login1.Login;

public class LoginTest {

    @Test
    void testUsernameLogic() {
        Login login = new Login();

        assertTrue(login.checkUserName("Sbu_1")); // contains underscore
        
        assertFalse(login.checkUserName("abc")); // does not contain underscore therefore returning as false
    }
}