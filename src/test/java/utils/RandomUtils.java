package utils;

import java.security.SecureRandom;
import java.util.Random;

public class RandomUtils {
    private static final String CAPITAL_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String SMALL_LETTERS = CAPITAL_LETTERS.toLowerCase();
    private static final String NUMERALS = "0123456789";
    private static final String CYRILLIC_CHARACTERS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static final Random RANDOM = new SecureRandom();

    //Random username and domain Generation
    public static String generateRandomString(int length) {
        StringBuilder randomString = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = generateRandomNumber(SMALL_LETTERS.length());
            randomString.append(SMALL_LETTERS.charAt(index));
        }
        return randomString.toString();
    }

    //creating randomNumber as suggested
    public static int generateRandomNumber(int maxValue) {
        return RANDOM.nextInt(maxValue);
    }

    //Random Password Generation
    public static String generateRandomPassword(String email, int length) {
        StringBuilder password = new StringBuilder();
        password.append(CAPITAL_LETTERS.charAt(generateRandomNumber(CAPITAL_LETTERS.length())));
        password.append(NUMERALS.charAt(generateRandomNumber(NUMERALS.length())));
        password.append(email.charAt(generateRandomNumber(email.length())));
        password.append(CYRILLIC_CHARACTERS.charAt(generateRandomNumber(CYRILLIC_CHARACTERS.length())));
        while (password.length() < length) {
            password.append(SMALL_LETTERS.charAt(generateRandomNumber(SMALL_LETTERS.length())));
        }
        return password.toString();
    }
}
