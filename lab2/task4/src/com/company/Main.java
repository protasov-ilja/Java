package com.company;

public class Main {
    private final static int SPACES_BETWEEN_COLUMNS = 25;
    public static void main(String[] args) {
        System.out.printf("%-11s%-" + SPACES_BETWEEN_COLUMNS + "s%-" + SPACES_BETWEEN_COLUMNS + "s%-5s%n", "Type", "Min", "Max", "Size");
        System.out.printf("%-11s%-" + SPACES_BETWEEN_COLUMNS + "d%-" + SPACES_BETWEEN_COLUMNS + "d%-5d%n", "Integer", Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.BYTES);
        System.out.printf("%-11s%-" + SPACES_BETWEEN_COLUMNS + "d%-" + SPACES_BETWEEN_COLUMNS + "d%-5d%n", "Long", Long.MIN_VALUE, Long.MAX_VALUE, Long.BYTES);
        System.out.printf("%-11s%-" + SPACES_BETWEEN_COLUMNS + "d%-" + SPACES_BETWEEN_COLUMNS + "d%-5d%n", "Short", Short.MIN_VALUE, Short.MAX_VALUE, Short.BYTES);
        System.out.printf("%-11s%-" + SPACES_BETWEEN_COLUMNS + "d%-" + SPACES_BETWEEN_COLUMNS + "d%-5d%n", "Byte", Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.BYTES);
        System.out.printf("%-11s%-" + SPACES_BETWEEN_COLUMNS + "s%-" + SPACES_BETWEEN_COLUMNS + "s%-5d%n", "Double", Double.toString(Double.MIN_VALUE), Double.toString(Double.MAX_VALUE), Double.BYTES);
        System.out.printf("%-11s%-" + SPACES_BETWEEN_COLUMNS + "s%-" + SPACES_BETWEEN_COLUMNS + "s%-5d%n", "Float", Float.toString(Float.MIN_VALUE), Float.toString(Float.MAX_VALUE), Float.BYTES);
        System.out.printf("%-11s%-" + SPACES_BETWEEN_COLUMNS + "d%-" + SPACES_BETWEEN_COLUMNS + "d%-5d%n", "Character", (int)Character.MIN_VALUE, (int)Character.MAX_VALUE, Character.BYTES);
    }
}
