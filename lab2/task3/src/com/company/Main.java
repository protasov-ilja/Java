package com.company;

public class Main {
    private static final String HELP_INFO = "Please enter the <available characters> and <password length> in range [1 .. max value]";

    public static void main(String[] args) {
        try {
            PasswordGenerator passwordGenerator = new PasswordGenerator(args);
            System.out.println(passwordGenerator.generateNewPassword());
        } catch (Exception er) {
            System.out.println(er.getMessage());
//            System.out.println(HELP_INFO);
        }
    }
}
