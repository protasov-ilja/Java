package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.HashMap;
import java.util.Iterator;

public class TopWordsHandler {
    private final static int NUMBER_OF_ARGUMENTS = 2;

    private int _amountOfTopWords;
    private ArrayList<LinkedHashSet<String>> _listOfWords;
    private HashMap<String, Integer> _wordsCounts;

    public TopWordsHandler(String[] args) {
        try (FileReader inputFile = new FileReader(args[0])) {
            setCountOfWordsFromString(args[1]);
            checkNumberOfArguments(args.length);
            _wordsCounts = new HashMap<>();
            _listOfWords = new ArrayList<>();
            FindTopWords(inputFile);
        } catch (Exception er) {
            System.out.println(er.getMessage());
        }
    }

    private void checkNumberOfArguments(int number) throws IllegalArgumentException {
        if (number != NUMBER_OF_ARGUMENTS) {
            throw new IllegalArgumentException("number of arguments must be " + NUMBER_OF_ARGUMENTS);
        }
    }

    private void setCountOfWordsFromString(String wordsNumber) throws IllegalArgumentException {
        int number = Integer.parseInt(wordsNumber);
        if (number <= 0) {
            throw new IllegalArgumentException("count of top words must be more than 0");
        }

        _amountOfTopWords = number;
    }

    private void FindTopWords(FileReader inputFile) throws IOException {
		    int ch;
		    String word = "";
		    while((ch = inputFile.read()) != -1) {
		        if (Character.isLetter(ch)) {
		            word += (char)ch;
		        } else if (!word.equals("")) {
		            int newCount = setWordsCounts(word);
		            setWordInList(word, newCount);
		            word = "";
		        }
		    }

		    if (!word.equals("")) {
		        int newCount = setWordsCounts(word);
		        setWordInList(word, newCount);
		    }
    }

    private int setWordsCounts(String word) {
        int count = 0;
        if (_wordsCounts.containsKey(word)) {
	        count = _wordsCounts.get(word) + 1;
	        _wordsCounts.replace(word, count);
        } else {
	        _wordsCounts.put(word, count);
        }

        return count;
    }

    private void setWordInList(String word, int value) {
        if (_listOfWords.isEmpty()) {
	        addNewSetInList(word);
        } else if (value >= _listOfWords.size()) {
	        _listOfWords.get(value - 1).remove(word);
	        addNewSetInList(word);
        } else if (value == 0) {
            _listOfWords.get(value).add(word);
        } else {
            _listOfWords.get(value - 1).remove(word);
            _listOfWords.get(value).add(word);
        }
    }

    private void addNewSetInList(String word) {
	    LinkedHashSet<String> newSet = new LinkedHashSet<>();
	    newSet.add(word);
	    _listOfWords.add(newSet);
    }

    public void showTopWords() {
        int topWordsCounter = 0;
        for (int i = _listOfWords.size() - 1; i >= 0; --i) {
		        Iterator<String> iterator = _listOfWords.get(i).iterator();
		        while (iterator.hasNext() && (topWordsCounter < _amountOfTopWords)) {
			          System.out.println(iterator.next() + " " + String.valueOf(i + 1));
			          topWordsCounter++;

			          if (topWordsCounter ==_amountOfTopWords) {
			              return;
			          }
		        }
        }
    }
}
