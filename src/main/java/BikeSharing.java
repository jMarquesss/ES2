import Exceptions.UserAlreadyExists;

public class BikeSharing{
    public static void main (String[] args) throws UserAlreadyExists {
        BikeRentalSystem b = new BikeRentalSystem(1);
        b.registerUser(1,"testUser", 1);
        b.registerUser(2,"testUser2",2);
        System.out.println("yolo");
    }
}
