package user;

import lombok.Getter;

import lombok.RequiredArgsConstructor;
import org.example.annotation.PasswordValidation;

@Getter
@RequiredArgsConstructor
public class User {

    @PasswordValidation(minLength = 10, requireDigit = true, requireSpecialChar = true)
    private final String password;
}

