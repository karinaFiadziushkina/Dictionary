package com.company.data;

import java.util.TreeSet;

public class Dictionary {

    private TreeSet<PairOfWords> setOfPairs;

    public Dictionary(TreeSet<PairOfWords> treeSet){
        this.setOfPairs = treeSet;
    }

    public TreeSet<PairOfWords> getSetOfPairs() {
        return setOfPairs;
    }

    public void setSetOfPairs(TreeSet<PairOfWords> setOfPairs) {
        this.setOfPairs = setOfPairs;
    }

}
