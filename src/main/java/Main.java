import user.PasswordValidator;
import user.User;

import java.util.List;
import java.util.stream.IntStream;

public class Main {
    static void main() {
        List<String> passwords = List.of(
                "abc1!",
                "zaqqaz123dsa",
                "zaq!1qaZdsa");

        IntStream.range(0, passwords.size()).forEach(i -> {
            User user = new User(passwords.get(i));
            boolean valid = PasswordValidator.validate(user);
            System.out.println("password = " + user.getPassword()
                    + " -> " + (valid ? "valid" : "invalid"));
        });
    }
}
