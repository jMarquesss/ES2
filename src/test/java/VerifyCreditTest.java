import Exceptions.UserAlreadyExists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VerifyCreditTest {


    BikeRentalSystem b = new BikeRentalSystem(1);


    @BeforeEach
    void setUp() throws UserAlreadyExists {
        b.registerUser(0, "testUser", 1);
    }

    @Test
    public void test1() {
        b.addCredit(0, 1);
        assertTrue(b.verifyCredit(0));
    }

    @Test
    public void test2() {
        b.addCredit(1, 1);
        assertFalse(b.verifyCredit(0));
    }

    @Test
    public void test3(){
        b.addCredit(-1,1);
        assertFalse(b.verifyCredit(-1));
    }

    @Test
    public void test4() {
        b.addCredit(0, 0);
        assertFalse(b.verifyCredit(0));
    }
}