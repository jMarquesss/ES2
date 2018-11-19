import Exceptions.UserAlreadyExists;
import Exceptions.UserDoesNotExists;
import Models.Bike;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class getBicycleTest {

    BikeRentalSystem b = new BikeRentalSystem(1);


    @BeforeEach
    void setUp() throws UserAlreadyExists {
        b.registerUser(0, "testUser", 1);
    }

    @Test
    public void test1() throws UserDoesNotExists {
        b.addBicycle(1, 1, 1);
        b.addCredit(0, 1);
        b.getBicycle(1, 0, 0);
        assertTrue(b.getUsers().get(0).getBike().isInUSe());
        assertFalse(b.getBikes().contains(new Bike(1)));
    }

    @Test
    public void test2() {
        b.addBicycle(1, 1, 1);
        b.addCredit(0, 1);
        assertThrows(UserDoesNotExists.class,
                () -> {
                    b.getBicycle(1, 1, 0);
                });
    }

    @Test
    public void test3() {
        b.addBicycle(1, 1, 1);
        b.addCredit(0, 1);
        assertThrows(UserDoesNotExists.class,
                () -> {
                    b.getBicycle(1, -1, 0);
                });
    }

    @Test
    public void test4() throws UserDoesNotExists {
        b.addBicycle(1, 1, 1);
        b.addCredit(0, 1);
        assertEquals(-1, b.getBicycle(0, 0, 0));
    }

    @Test
    public void test5() throws UserDoesNotExists {
        b.addBicycle(1, 1, 1);
        b.addCredit(0, 1);
        assertEquals(-1, b.getBicycle(2, 0, 0));
    }

    @Test
    public void test6() throws UserDoesNotExists {
        b.addBicycle(1, 1, 1);
        assertEquals(-1, b.getBicycle(1, 0, 0));
    }


    @Test
    public void test7() throws UserDoesNotExists {
        b.addBicycle(1, 1, 1);
        b.addCredit(0, 2);
        b.getBicycle(1, 0, 0);
        assertTrue(b.getUsers().get(0).getBike().isInUSe());
        assertFalse(b.getBikes().contains(new Bike(1)));
    }

    @Test
    public void test8() throws UserDoesNotExists {
        b.addBicycle(1, 1, 1);
        b.addCredit(0, 1);
        assertEquals(-1, b.getBicycle(1, 0, -1));
    }

    @Test
    public void test9() throws UserDoesNotExists {
        b.addBicycle(1, 1, 1);
        b.addCredit(0, 1);
        b.getBicycle(1, 0, 1);
        assertTrue(b.getUsers().get(0).getBike().isInUSe());
        assertFalse(b.getBikes().contains(new Bike(1)));

    }

    @Test
    public void test10() throws UserDoesNotExists {
        b.addCredit(0, 1);
        assertEquals(-1, b.getBicycle(1, 0, 0));
    }

    @Test
    public void test11() throws UserDoesNotExists {
        b.addBicycle(1, 1, 1);
        b.addCredit(0, 1);
        b.getBicycle(1, 0, 0);
        b.addBicycle(2, 2, 2);
        assertEquals(-1, b.getBicycle(2, 0, 0));
    }
}