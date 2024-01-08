import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final  UserService userService = new UserService();

    public Menu() throws SQLException {
    }

    public void publicMenu() throws SQLException {
        System.out.println("****** WELCOME ******");
        System.out.println("1-SIGN UP");
        System.out.println("2-SIGN IN");
        System.out.println("3-EXIT");
        System.out.println("Choose your number: ");

        int number = scanner.nextInt();
        scanner.nextLine();

        switch (number){
            case 1 -> signup();
            case 2 -> signIn();
            case 3 -> System.out.println("exit");
        }
    }

    private void signIn() throws SQLException {
        userService.signIn();
    }

    public void signup() throws SQLException {
        userService.signup();
    }
}
