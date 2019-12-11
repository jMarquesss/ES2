import Exceptions.UserAlreadyExists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BicycleRentalFeeTest {


    BikeRentalSystem b = new BikeRentalSystem(1);


    @BeforeEach
    void setUp() throws UserAlreadyExists {
        b.registerUser(0, "testUser", 1);
    }

    @Test
    public void test1() {
        assertEquals(0, b.bicycleRentalFee(0, 0, 1, 0));
    }

    @Test
    public void test2() {
        assertEquals((1 - 0) * b.getRentalFee(), b.bicycleRentalFee(1, 0, 1, 0));
    }

    @Test
    public void test3() {
        assertEquals(0, b.bicycleRentalFee(2, 0, 1, 0));
    }

    @Test
    public void test4() {
        assertEquals((1 - 0) * b.getRentalFee(), b.bicycleRentalFee(2, 0, 1, 1));
    }

    @Test
    public void test5() {
        assertEquals(b.getRentalFee() * 10 + ((11 - 0) - 10) * b.getRentalFee() / 2, b.bicycleRentalFee(2, 0, 11, 1));
    }

    @Test
    public void test6() {
        assertEquals(0, b.bicycleRentalFee(2, 0, 1, 0));
    }

    @Test
    public void test7() {
        assertEquals(0, b.bicycleRentalFee(2, 1, 0, 0));
    }

    @Test
    public void test8() {
        assertEquals(0, b.bicycleRentalFee(3, 0, 1, 0));
    }

}