package com.company;

public class Main {

    public static void main(String[] args) {
        try {
            TopWordsHandler topWordsHandler = new TopWordsHandler(args);
            System.out.println(topWordsHandler.getTopWords());
        } catch (Exception er) {
            System.out.println(er.getMessage());
        }
    }
}
