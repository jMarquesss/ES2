import Exceptions.UserAlreadyExists;
import Exceptions.UserDoesNotExists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class returnBikeTest {

    BikeRentalSystem b = new BikeRentalSystem(1);


    @BeforeEach
    void setUp() throws UserAlreadyExists {
        b.registerUser(0, "testUser", 1);
    }

    @Test
    public void test1() throws UserDoesNotExists {
        b.addBicycle(1, 1, 1);
        b.addCredit(0, 1);
        b.getBicycle(1,0,0);
        float help=b.getUsers().get(0).getCredit();
        assertFalse(b.returnBicycle(10,0,0)==help);
    }

    @Test
    public void test2() throws UserDoesNotExists {
        b.addBicycle(1, 1, 1);
        b.addCredit(0, 1);
        b.getBicycle(1,0,0);
        assertEquals(-1, b.returnBicycle(1,1,0));
    }

    @Test
    public void test3() throws UserDoesNotExists {
        b.addBicycle(1, 1, 1);
        b.addCredit(0, 1);
        b.getBicycle(1, 0, 0);
        assertEquals(-1, b.returnBicycle(1,-1,0));
    }


    @Test
    public void test4() throws UserDoesNotExists {
        b.addBicycle(1, 1, 1);
        b.addCredit(0, 1);
        b.getBicycle(1, 0, 0);
        assertEquals(-1, b.returnBicycle(0,0,0));
    }


    @Test
    public void test5() throws UserDoesNotExists {
        b.addBicycle(1, 1, 1);
        b.addCredit(0, 1);
        b.getBicycle(1, 0, 0);
        assertEquals(-1, b.returnBicycle(2,0,0));
    }


    @Test
    public void test6() throws UserDoesNotExists {
        b.addBicycle(1, 1, 1);
        b.addCredit(0, 1);
        b.getBicycle(1, 0, 0);
        assertEquals(-1, b.returnBicycle(1,0,-1));
    }

    @Test
    public void test7() throws UserDoesNotExists {
        b.addBicycle(1, 1, 1);
        b.addCredit(0, 1);
        b.getBicycle(1, 0, 0);
        assertEquals(1, b.returnBicycle(1,0,1));
    }

    @Test
    public void test8() throws UserDoesNotExists {
        b.addBicycle(1, 1, 1);
        b.addCredit(0, 1);
        b.getBicycle(1, 0, 0);
        b.getBikes().get(0).setInUSe(false);
        assertEquals(-1, b.returnBicycle(1,0,1));
    }

    @Test
    public void test9() throws UserDoesNotExists {
        b.addBicycle(1, 1, 1);
        b.addBicycle(2,2,2);
        b.addCredit(0, 1);
        b.getBicycle(2,0,0);
        assertEquals(-1, b.returnBicycle(1,0,1));
    }
}