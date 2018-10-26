package com.company;

public class Main {
    private static final String HELP_INFO = "please input <input file name> <number of top words>";

    public static void main(String[] args) {
        try {
            TopWordsHandler topWordsHandler = new TopWordsHandler(args);
            topWordsHandler.showTopWords();
        } catch (Exception er) {
            System.out.println(HELP_INFO);
        }
    }
}
