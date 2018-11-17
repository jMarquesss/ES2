import Exceptions.UserAlreadyExists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BikeSharingTest {
    BikeRentalSystem b = new BikeRentalSystem(1);

    @BeforeEach
    public void init() throws UserAlreadyExists{
        b.registerUser(0, "testUser", 1);
    }


    @Test
    public void registerUserTestInvalid(){
       assertThrows(UserAlreadyExists.class,
               () -> {
                   b.registerUser(0, "testUser", 1);
               });
   }


    @Test
    public void registerUserTestValid()  throws UserAlreadyExists {
        b.registerUser(1, "testUser0", 1);
        assertEquals(b.getUsers().get(1).getIDUser(), 1);

    }

    @Test
    public void addCreditTest(){
        b.addCredit(0, 1);
        assertEquals(b.getUsers().get(0).getCredit(), 1);
    }


    /*
    Não acontece nada quando falha
     */
    @Test
    public void addCreditTestInvalidUser() {
        b.addCredit(1, 1);
        assertEquals(b.getUsers().get(0).getCredit(), 1);
    }

    /*
    Não acontece nada quando a ammount e invalida
     */
    @Test
    public void addCreditTestInvalidAmmount() {
        b.addCredit(0, -1);
        assertEquals(b.getUsers().get(0).getCredit(), -1);
    }

    @Test
    public void verifyCreditTestValid() {
        b.addCredit(0, 1);
        assertTrue(b.verifyCredit(0));
    }

    @Test
    public void verifyCreditTestInvalidUser() {
        b.addCredit(1, 1);
        assertFalse(b.verifyCredit(0));
    }

    @Test
    public void verifyCreditTestInvalidCredit() {
        b.addCredit(0, 0);
        assertFalse(b.verifyCredit(0));
    }

}