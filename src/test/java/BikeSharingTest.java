import Exceptions.UserAlreadyExists;
import Models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BikeSharingTest {
    BikeRentalSystem b = new BikeRentalSystem(1);

    @BeforeEach
    public void init() throws UserAlreadyExists{
        b.registerUser(1,"testUser", 1);
    }
    @Test
    public void verifyCreditTest() throws UserAlreadyExists {
        b.addCredit(1,5);
        assertTrue(b.verifyCredit(1));
    }

    @Test
    public void registerUserTestInvalid(){
       assertThrows(UserAlreadyExists.class,
                ()->{b.registerUser(1,"testUser", 1);});
   }


    @Test
    public void registerUserTestValid()  throws UserAlreadyExists {
        b.registerUser(0,"testUser0", 1);
        assertTrue(b.getUsers().contains(new User(0,"testUser0", 1)));

    }

    @Test

    public void addCreditTest(){

    }



}