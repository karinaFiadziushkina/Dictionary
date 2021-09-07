package com.jwd;

import com.jwd.data.Dictionary;
import com.jwd.data.PairOfWords;
import com.jwd.service.DictionaryConsoleApplication;

import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        TreeSet<PairOfWords> setOfPairs = new TreeSet<>();
        Dictionary dictionary = new Dictionary(setOfPairs);
        setOfPairs.add(new PairOfWords("word", "слово"));
        setOfPairs.add(new PairOfWords("cat", "кошка"));
        setOfPairs.add(new PairOfWords("actually", "на самом деле"));
        DictionaryConsoleApplication app = new DictionaryConsoleApplication(dictionary);
        app.start();

    }
}
