package com.jwd.service;

import com.jwd.data.Dictionary;
import com.jwd.data.PairOfWords;

import java.io.Closeable;
import java.io.IOException;
import java.util.Scanner;

public class DictionaryConsoleApplication {

    private Dictionary dictionary;
    private final Scanner scanner = new Scanner(System.in);
    public static final String WELCOME_MESSAGE = "\n-------Dictionary-------\n" +
            "1 - enter new translation\n" +
            "2 - display all words\n" +
            "3 - the number of words in the dictionary\n" +
            "4 - find a translation\n" +
            "5 - quiz\n" +
            "0 - exit";
    public static final int EXIT = 0, ENTER = 1, DISPLAY_ALL = 2, COUNT_ALL = 3, FIND = 4, QUIZ = 5, RESTART_VALUE = 999;
    public static final String DELIMITER = "\n==============================================\n";

    private Closeable[] closeables;

    public DictionaryConsoleApplication(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.closeables = new Closeable[]{scanner};
    }

    public void start() {
        processMenu();
        cleanUpCloseables();
    }

    private void processMenu() {
        boolean isRunning = true;
        while (isRunning) {
            printConsole(WELCOME_MESSAGE);
            printConsole(DELIMITER);
            int consoleChoice = getConsoleChoice();
            switch (consoleChoice) {
                case EXIT:
                    isRunning = false;
                    printConsole("App closes.");
                    break;
                case ENTER:
                    enter();
                    break;
                case DISPLAY_ALL:
                    display();
                    break;
                case COUNT_ALL:
                    countAllWords();
                    break;
                case FIND:
                    find();
                    break;
                case QUIZ:
//                    quiz();
                    break;
                default:
                    printConsole("Invalid choice. Restarting app." + DELIMITER);
            }
        }
    }

    private void enter() {
        printConsole("Enter english word");
        String first = scanner.next();
        printConsole("Enter russian word");
        String second = scanner.next();
        PairOfWords pair = new PairOfWords(first, second);
        dictionary.getSetOfPairs().add(pair);
        printConsole("Result is " + dictionary.getSetOfPairs().toString() + "." + DELIMITER);

    }

    private void display() {
        printConsole("All words in dictionary:");
        for (PairOfWords pair : dictionary.getSetOfPairs()) {
            printConsole(pair.toString());
        }
    }

    private void countAllWords() {
        printConsole("There are " + dictionary.getSetOfPairs().size() + " words in dictionary");
    }

    public void find() {
        boolean isFound = false;
        printConsole("Enter the word you want to search for: ");
        String wordToFind = scanner.next();
        for (PairOfWords pair : dictionary.getSetOfPairs()) {
            if (pair.getEnWord().equals(wordToFind) || pair.getRuWord().equals(wordToFind)) {
                printConsole(pair.toString());
                isFound = true;
            }
        }
        if (!isFound)
            printConsole("There is no such word in the dictionary");
    }


    private int getConsoleChoice() {
        int choice;
        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
        } else {
            cleanScannerNextEnteredValue();
            choice = RESTART_VALUE;
        }
        return choice;
    }

    private void cleanScannerNextEnteredValue() {
        final String next = scanner.next();
        printConsole("Entered next=[" + next + "].");
    }

    private void printConsole(final String message) {
        System.out.println(message);
    }

    private void printCaughtException(Exception e) {
        printConsole("Exception: Parameters passed to Calculator is invalid. Exception message is " + e.getMessage());
    }

    private void cleanUpCloseables() {
        for (final Closeable closeable : closeables) {
            try {
                closeable.close();
                System.out.println("Resource is closed, " + closeable.getClass());

            } catch (final IOException e) {
                System.out.println("Something went wrong during closing " + closeable.getClass());
                e.printStackTrace();
            }
        }
    }
}
