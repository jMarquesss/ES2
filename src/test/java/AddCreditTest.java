import Exceptions.UserAlreadyExists;
import Models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddCreditTest {


    BikeRentalSystem b = new BikeRentalSystem(1);


    @BeforeEach
    void setUp() throws UserAlreadyExists {
        b.registerUser(0, "testUser", 1);
    }

    @Test
    public void test1() {
        b.addCredit(0, 1);
        assertEquals(1, b.getUsers().get(0).getCredit());
    }

    @Test
    public void test2() {
        b.addCredit(1, 1);
        assertFalse(b.getUsers().contains(new User(1,"testUser",1)));
    }

    @Test
    public void test3() {
        b.addCredit(-1, 1);
        assertFalse(b.getUsers().contains(new User(-1,"testUser",1)));
    }
    @Test
    public void test4() {
        b.addCredit(0, -1);
        assertFalse(-1 == b.getUsers().get(0).getCredit());
    }
}