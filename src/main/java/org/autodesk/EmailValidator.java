package org.autodesk;

import static org.autodesk.Constants.EMAIL_REGEX;

public class EmailValidator {

        public static boolean isValidEmail(String email) {
            if (email == null || email.isEmpty()) {
                return false;
            }
            return email.matches(EMAIL_REGEX);
        }

        public static void main(String[] args) {
            EmailGenerator emailGenerator = new EmailGenerator();

                System.out.println(emailGenerator.generateValidEmail() + " is valid: " + isValidEmail(emailGenerator.generateValidEmail()));
                System.out.println(emailGenerator.generateEmailWithInvalidPrefix() + " is valid: " + isValidEmail(emailGenerator.generateEmailWithInvalidPrefix()));
                System.out.println(emailGenerator.generateEmailWithInvalidCharacters() + " is valid: " + isValidEmail(emailGenerator.generateEmailWithInvalidCharacters()));
                System.out.println(emailGenerator.generateEmailWithInvalidDomain() + " is valid: " + isValidEmail(emailGenerator.generateEmailWithInvalidDomain()));

        }
        }
