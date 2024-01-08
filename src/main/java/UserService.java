import java.sql.SQLException;
import java.util.Scanner;

public class UserService {
    private final Scanner scanner = new Scanner(System.in);
    private final UserRepository userRepository = new UserRepository();

    public UserService() throws SQLException {
    }

    public void signup() throws SQLException {

        System.out.println("Please enter your firstname:  ");
        String firstname = scanner.nextLine();

        System.out.println("Please enter your lastname:  ");
        String lastname = scanner.nextLine();

        System.out.println("Please enter your username:  ");
        String username = scanner.nextLine();

        System.out.println("Please enter your password:  ");
        String password = scanner.nextLine();

        User user = new User(firstname, lastname, username, password);
        int result = userRepository.registerUser(user);
        if (result == 1)
            System.out.println(firstname + " successfully register :)");
        else
            System.out.println("somethings is wrong :(");
    }
}
