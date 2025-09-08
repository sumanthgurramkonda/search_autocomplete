import com.pro.autofill.AutoComplete;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AutoComplete autoComplete = new AutoComplete(3);

        autoComplete.search("leetcode");
        autoComplete.search("leet");
        autoComplete.search("leetcode program");

        autoComplete.search("google");
        autoComplete.search("go");
        autoComplete.search("google play");
        autoComplete.search("google");
        autoComplete.search("googler");
        autoComplete.search("googler");
        autoComplete.search("googler");

//        List<String> suggestionList = autoComplete.suggest("leetcode ");
//        for (String word : suggestionList){
//            System.out.println(word);
//        }
        autoComplete.search("leetcoder");
        List<String> suggestionList = autoComplete.suggest("google");
        for (String word : suggestionList){
            System.out.println(word);
        }
    }
}