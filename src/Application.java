import users.UserController;
import view.UI;

import java.util.Locale;

public class Application {
    private static final UserController userController = new UserController();
    public static void main(String[] args){
        System.out.println("_".repeat(32));
        System.out.println("\n| Social media data management |\n".toUpperCase(Locale.ROOT));
        while (true){
            switch (UI.homePage()){
                case 1->{
                    System.out.println("-".repeat(90));
                    userController.getAllUsers();
                }
                case 2->{
                    System.out.println("-".repeat(90));
                    userController.deleteUserByUUID();
                }
                default -> System.out.println("Try again, you have inserted with wrong option.");
            }
        }
    }
}
