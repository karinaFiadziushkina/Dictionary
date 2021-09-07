package com.jwd.data;

import java.util.Objects;

public class PairOfWords implements Comparable<PairOfWords> {

    private String enWord;
    private String ruWord;

    public PairOfWords() {
    }

    public PairOfWords(String first, String second) {
        if (isEnglish(first)) {
            this.enWord = first;
            this.ruWord = second;
        } else {
            this.enWord = second;
            this.ruWord = first;
        }
    }

    public void setPair(String first, String second) {
        if (isEnglish(first)) {
            this.enWord = first;
            this.ruWord = second;
        } else {
            this.enWord = second;
            this.ruWord = first;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PairOfWords that = (PairOfWords) o;
        return Objects.equals(enWord, that.enWord);
    }

    @Override
    public String toString() {
        return enWord + " - " + ruWord;
    }

    @Override
    public int compareTo(PairOfWords pair) {
        return this.enWord.compareTo(pair.getEnWord());
    }

    public boolean isEnglish(String str) {
        boolean isEnglish = true;
        for (char c : str.toCharArray()) {
            if (Character.UnicodeBlock.of(c) != Character.UnicodeBlock.BASIC_LATIN) {
                isEnglish = false;
                break;
            }
        }
        return isEnglish;
    }

    public String getEnWord() {
        return enWord;
    }

    public void setEnWord(String enWord) {
        this.enWord = enWord;
    }

    public String getRuWord() {
        return ruWord;
    }

    public void setRuWord(String ruWord) {
        this.ruWord = ruWord;
    }


}
