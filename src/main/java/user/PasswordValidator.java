package user;

import org.example.annotation.PasswordValidation;

import java.lang.reflect.Field;

public class PasswordValidator {

    public static boolean validate(Object obj) {
        if (obj == null) {
            return false;
        }
        boolean foundAnnotatedField = false;
        for(Field field : obj.getClass().getDeclaredFields()){
            if (field.isAnnotationPresent(PasswordValidation.class)) {
                foundAnnotatedField = true;
                if (!meetsRules(field, obj)) {
                    return false;
                }
            }
        }
        return foundAnnotatedField;
    }

    private static boolean meetsRules(Field field, Object obj) {
        try {
            field.setAccessible(true);
            Object value = field.get(obj);
            if (!(value instanceof String password)) {
                return false;
            }

            PasswordValidation rules = field.getAnnotation(PasswordValidation.class);
            if (password.length() < rules.minLength()) {
                return false;
            }
            if (rules.requireDigit() && !containsDigit(password)) {
                return false;
            }
            if (rules.requireSpecialChar() && !containsSpecialChar(password)) {
                return false;
            }
            return true;
        } catch (ReflectiveOperationException e) {
            return false;
        }

    }

    public static boolean containsDigit(String text) {
        return text.chars().anyMatch(Character::isDigit);
    }

    public static boolean containsSpecialChar(String text) {
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (!Character.isLetterOrDigit(ch) && !Character.isWhitespace(ch)) {
                return true;
            }
        }
        return false;
    }
}
