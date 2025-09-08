package com.pro.trie;

public class Trie {
    private final int ALPHABET_COUNT = 27;
    public Trie[] trie;
    public int frequency;
    public String word;

    public Trie(){
        this.trie = new Trie[ALPHABET_COUNT];
        this.frequency = 0;
        this.word="";
    }

}
