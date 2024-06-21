package org.autodesk;


import java.util.Random;

import static org.autodesk.Constants.INVALID_DOMAIN;
import static org.autodesk.Constants.VALID_DOMAIN;

public class EmailGenerator {

    private static final Random random = new Random();

    public String generateValidEmail() {
        String prefix = generateValidPrefix();
        return prefix + VALID_DOMAIN;
    }

    private static String generateValidPrefix() {
        StringBuilder prefix = new StringBuilder();
        int length = random.nextInt(11) + 5;
        prefix.append(generateRandomLetter());

        for (int i = 1; i < length; i++) {
            prefix.append(generateRandomValidCharacter());
        }

        return prefix.toString();
    }

    private static String generateInvalidPrefix() {
        StringBuilder prefix = new StringBuilder();
        int length = random.nextInt(11) + 5;

        prefix.append(generateRandomInvalidStartCharacter());

        for (int i = 1; i < length; i++) {
            prefix.append(generateRandomValidCharacter());
        }

        return prefix.toString();
    }

    public String generateEmailWithInvalidPrefix() {
        String prefix = generateInvalidPrefix();
        return prefix + VALID_DOMAIN;
    }

    public String generateEmailWithInvalidCharacters() {
        StringBuilder prefix = new StringBuilder();
        int length = random.nextInt(11) + 5;

        prefix.append(generateRandomLetter());

        for (int i = 1; i < length; i++) {
            if (random.nextInt(10) > 7) {
                prefix.append(generateRandomInvalidCharacter());
            } else {
                prefix.append(generateRandomValidCharacter());
            }
        }

        return prefix.toString() + VALID_DOMAIN;
    }

    public String generateEmailWithInvalidDomain() {
        String prefix = generateValidPrefix();
        return prefix + INVALID_DOMAIN;
    }

    private static char generateRandomLetter() {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        return letters.charAt(random.nextInt(letters.length()));
    }

    private static char generateRandomValidCharacter() {
        String validChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789._-";
        return validChars.charAt(random.nextInt(validChars.length()));
    }

    private static char generateRandomInvalidStartCharacter() {
        String invalidStartChars = "0123456789._-";
        return invalidStartChars.charAt(random.nextInt(invalidStartChars.length()));
    }

    private static char generateRandomInvalidCharacter() {
        String invalidChars = "!#$%^&*()+=[]{}|;:'\",<>?/\\`~";
        return invalidChars.charAt(random.nextInt(invalidChars.length()));
    }
}