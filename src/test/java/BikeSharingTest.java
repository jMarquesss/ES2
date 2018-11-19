import Exceptions.UserAlreadyExists;
import Exceptions.UserDoesNotExists;
import Models.Bike;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class BikeSharingTest {
    BikeRentalSystem b = new BikeRentalSystem(1);
    Bike bici = new Bike(1);

    @BeforeEach
    public void setUp() throws UserAlreadyExists{
        b.registerUser(0, "testUser", 1);
    }

    //Test 1- getBicycle
    @Test
    public void getBicycleTestValid() throws UserDoesNotExists {
        b.addBicycle(1, 1, 1);
        b.addCredit(0, 1);
        b.getBicycle(1, 0, 0);
        assertTrue(b.getUsers().get(0).getBike().isInUSe());
        assertFalse(b.getBikes().contains(new Bike(1)));
    }

    //Test 2- getBicycle
    @Test
    public void getBicycleTestInvalidUser() {
        b.addBicycle(1, 1, 1);
        b.addCredit(0, 1);
        assertThrows(UserDoesNotExists.class,
                () -> {
                    b.getBicycle(1, 1, 0);
                });
    }


    //Test 3- getBicycle
    @Test
    public void getBicycleTestInvalidDeposit() throws UserDoesNotExists {
        b.addBicycle(1, 1, 1);
        b.addCredit(0, 1);
        assertEquals(-1, b.getBicycle(0, 0, 0));
    }

    //Test 4- getBicycle
    @Test
    public void getBicycleTestInvalidCredit() throws UserDoesNotExists {
        b.addBicycle(1, 1, 1);
        assertEquals(-1, b.getBicycle(1, 0, 0));
    }

    //Test 5- getBicycle
    @Test
    public void getBicycleTestNoAvailableBikes() throws UserDoesNotExists {
        b.addCredit(0, 1);
        assertEquals(-1, b.getBicycle(1, 0, 0));
    }

    //Test 6- getBicycle
    @Test
    public void getBicycleTestInvalidUserHasRental() throws UserDoesNotExists {
        b.addBicycle(1, 1, 1);
        b.addCredit(0, 1);
        b.getBicycle(1, 0, 0);
        b.addBicycle(2, 2, 2);
        assertEquals(-1, b.getBicycle(2, 0, 0));
    }

    //Test 7- getBicycle
    @Test
    public void getBicycleTestInvalidStartTime() throws UserDoesNotExists {
        b.addBicycle(1, 1, 1);
        b.addCredit(0, 1);
        assertEquals(-1, b.getBicycle(1, 0, -1));
    }

    //Test 1- returnBicycle
    @Test
    public void returnBicycleTestValid() throws UserDoesNotExists {
        b.addBicycle(1, 1, 1);
        b.addCredit(0, 1);
        b.getBicycle(1,0,0);
        float help=b.getUsers().get(0).getCredit();
        assertFalse(b.returnBicycle(10,0,1)==help);
    }

    //Test 2- returnBicycle
    @Test
    public void returnBicycleTestInvalidUser() throws UserDoesNotExists {
        b.addBicycle(1, 1, 1);
        b.addCredit(0, 1);
        b.getBicycle(1,0,0);
        assertEquals(-1, b.returnBicycle(1,1,1));
    }

    //Test 3- returnBicycle
    @Test
    public void returnBicycleTestInvalidDeposit() throws UserDoesNotExists {
        b.addBicycle(1, 1, 1);
        b.addCredit(0, 1);
        b.getBicycle(1, 0, 0);
        assertEquals(-1, b.returnBicycle(0,1,1));
    }

    //Test 4- returnBicycle
    @Test
    public void returnBicycleTestInvalidEndTime() throws UserDoesNotExists {
        b.addBicycle(1, 1, 1);
        b.addCredit(0, 1);
        b.getBicycle(1, 0, 0);
        assertEquals(-1, b.returnBicycle(0,1,-1));
    }

    //Test 5- returnBicycle
    @Test
    public void returnBicycleTestInvalidBikeId() throws UserDoesNotExists {
        b.addBicycle(1, 1, 1);
        b.addCredit(0, 1);
        b.getBicycle(1, 0, 0);
        b.getBikes().get(0).setInUSe(false);
        assertEquals(-1, b.returnBicycle(0,1,1));
    }

    /*Test 6- returnBicycle
        Needs help
    */
    @Test
    public void returnBicycleTestInvalidNoAvailableSpots() throws UserDoesNotExists {
        b.addBicycle(1, 1, 1);
        b.addCredit(0, 1);
        b.getBicycle(1, 0, 0);

        //assertEquals(-1, b.returnBicycle(0,1,1));
    }

    //Test 1- bicycleRentalFee
    @Test
    public void bicycleRentalFeeTestInvalidRentalProgram(){
        assertEquals(0, b.bicycleRentalFee(0,0,1,0));
    }

    //Test 2- bicycleRentalFee
    @Test
    public void bicycleRentalFeeTestValidRentalProgram1(){
        assertEquals((1-0)*b.getRentalFee(), b.bicycleRentalFee(1,0,1,0));
    }

    //Test 3- bicycleRentalFee
    @Test
    public void bicycleRentalFeeTestInvalidRentalProgram2(){
        assertEquals(0, b.bicycleRentalFee(2,0,1,0));
    }

    //Test 4- bicycleRentalFee
    @Test
    public void bicycleRentalFeeTestValidRentalProgram2a(){
        assertEquals((1-0)*b.getRentalFee(), b.bicycleRentalFee(2,0,1,1));
    }

    //Test 5- bicycleRentalFee
    @Test
    public void bicycleRentalFeeTestValidRentalProgram2b(){
        assertEquals(b.getRentalFee()*10+((11-0)-10)*b.getRentalFee()/2, b.bicycleRentalFee(2,0,11,1));
    }

    //Test 6- bicycleRentalFee
    @Test
    public void bicycleRentalFeeTestInvalidNRentals(){
        assertEquals(0, b.bicycleRentalFee(2,0,1,0));
    }

    //Test 7- bicycleRentalFee
    @Test
    public void bicycleRentalFeeTestInvalidStartAndEndTime(){
        assertEquals(0, b.bicycleRentalFee(2,1,0,0));
    }

    //Test 8- bicycleRentalFee
    @Test
    public void bicycleRentalFeeTestInvalidRentalProgram3(){
        assertEquals(0, b.bicycleRentalFee(3,0,1,0));
    }

    //Test 1- verifyCredit
    @Test
    public void verifyCreditTestValid() {
        b.addCredit(0, 1);
        assertTrue(b.verifyCredit(0));
    }

    //Teste 2- verifyCredit
    @Test
    public void verifyCreditTestInvalidUser() {
        b.addCredit(1, 1);
        assertFalse(b.verifyCredit(0));
    }

    //Test 3- verifyCredit
    @Test
    public void verifyCreditTestInvalidCredit() {
        b.addCredit(0, 0);
        assertFalse(b.verifyCredit(0));
    }

    //Test 1- addCreddit
    @Test
    public void addCreditTestValid() {
        b.addCredit(0, 1);
        assertEquals(1, b.getUsers().get(0).getCredit());
    }

    /*
    Test 2- addCreddit
    Não acontece nada quando falha
     */
    @Test
    public void addCreditTestInvalidUser() {
        b.addCredit(1, 1);
        assertFalse(1== b.getUsers().get(0).getCredit());
    }

    /*
    Test 3- addCreddit
    Não acontece nada quando a ammount e invalida
     */
    @Test
    public void addCreditTestInvalidAmmount() {
        b.addCredit(0, -1);
        assertFalse(-1 == b.getUsers().get(0).getCredit());
    }

    //Test 1- registerUser
    @Test
    public void registerUserTestValid() throws UserAlreadyExists {
        b.registerUser(1, "testUser0", 1);
        assertEquals(1, b.getUsers().get(1).getIDUser());

    }

    //Test 2- registerUser
    @Test
    public void registerUserTestInvalid() {
        assertThrows(UserAlreadyExists.class,
                () -> {
                    b.registerUser(0, "testUser", 1);
                });
    }

    //Test 3- registerUser
    @Test
    public void registerUserInvalidNegative() throws UserAlreadyExists {
        b.registerUser(-1, "testUser", 1);
        assertEquals(-1, b.getUsers().get(1).getIDUser());
    }


}