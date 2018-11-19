import Exceptions.UserAlreadyExists;
import Models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterUserTest {

    BikeRentalSystem b = new BikeRentalSystem(1);


    @BeforeEach
    void setUp() throws UserAlreadyExists {
        b.registerUser(0, "testUser", 1);
    }

    @Test
    public void test1() throws UserAlreadyExists {
        b.registerUser(1, "testUser0", 1);
        assertEquals(1, b.getUsers().get(1).getIDUser());

    }

    @Test
    public void test2() {
        assertThrows(UserAlreadyExists.class,
                () -> {
                    b.registerUser(0, "testUser", 1);
                });
    }

    @Test
    public void test3() throws UserAlreadyExists {
        b.registerUser(-1, "testUser", 1);
        assertEquals(-1, b.getUsers().get(1).getIDUser());
    }


}