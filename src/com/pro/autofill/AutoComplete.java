package com.pro.autofill;

import com.pro.trie.Trie;

import java.util.*;
import java.util.stream.Collectors;

public class AutoComplete {

    private Trie trie;
    private int size = 5;

    public AutoComplete(){
        this.trie = new Trie();
    }
    public AutoComplete(int size){
        this();
        this.size = size;
    }

    public List<String> suggest(String word){
        Trie tr = trie;
        int charIndex = 0;
        for(char c : word.toCharArray()){
            charIndex = c==' ' ? 26 : c-'a';
            if(tr.trie[charIndex]==null)return Collections.emptyList();
            tr = tr.trie[charIndex];
        }
        Queue<Trie> trieQueue = new PriorityQueue<>((t1,t2)->{
            String w1 = t1.word;
            String w2 = t2.word;
            return t1.frequency==t2.frequency ? w2.compareTo(w1) : t1.frequency-t2.frequency;
        });
        dfs1(trieQueue,tr);
//        dfs(word.toCharArray(),trieQueue,trie,0);
         List<String> resultList = trieQueue.stream().map(t->t.word).collect(Collectors.toList());;
         Collections.reverse(resultList);
         return resultList;
    }
    public void dfs1(Queue<Trie> trieQueue, Trie tr){
        if(tr==null)return;
        if(tr.frequency>0){
            trieQueue.add(tr);
        }
        if(trieQueue.size()>size){
           trieQueue.poll();
        }
        for(int i=0;i<27;i++){
            dfs1(trieQueue,tr.trie[i]);
        }
    }

//    public void dfs(char[] word,Queue<Trie> trieQueue, Trie tr, int index){
//        if(tr==null || trieQueue.size()>size) return;
//        if(index>=word.length){
//            dfs1(trieQueue,tr);
//            return;
//        }
//        Trie t=null;
//        if(word[index]==' '){
//            t = tr.trie[26];
//        }else{
//            t = tr.trie[word[index]-'a'];
//        }
//        dfs(word,trieQueue,t, index+1);
//    }


    public void search(String word){
        if (word.isBlank())return;
        Trie tr = trie;
        int charIndex=0;
        for(char c : word.toCharArray()){
            charIndex = c ==' ' ? 26 : c-'a';
            if(tr.trie[charIndex]==null){
                tr.trie[charIndex] = new Trie();
            }
            tr = tr.trie[charIndex];
        }
        tr.word=word;
        tr.frequency+=1;
    }
}














