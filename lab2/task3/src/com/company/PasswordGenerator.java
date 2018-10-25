package com.company;

import java.util.Random;

public class PasswordGenerator {
    private final static int NUMBER_OF_ARGUMENTS = 2;

    private String availableCharacters;
    private int lengthOfPassword;

    public PasswordGenerator(String[] arguments) {
        checkNumberOfArguments(arguments.length);
        int length = Integer.parseInt(arguments[0]);
        checkPasswordLength(length);
        checkPasswordAvailableCharacters(arguments[1]);
        lengthOfPassword = length;
        availableCharacters = arguments[1];
    }

    private void checkNumberOfArguments(int number) {
        if (number != NUMBER_OF_ARGUMENTS) {
            throw new IllegalArgumentException("Wrong arguments");
        }
    }

    private void checkPasswordLength(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Wrong arguments");
        }
    }

    private void checkPasswordAvailableCharacters(String symbols) {
        if (symbols.isEmpty()) {
            throw new IllegalArgumentException("Wrong arguments");
        }
    }

    public String generateNewPassword() {
        String password = "";
        Random random = new Random(System.currentTimeMillis());
        for(int i = 0; i < lengthOfPassword; ++i) {
            password += availableCharacters.charAt(random.nextInt(availableCharacters.length()));
        }

        return password;
    }
}
