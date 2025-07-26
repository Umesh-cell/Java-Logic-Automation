import java.awt.*;
import java.util.HashMap;
import java.util.Locale;

public class CountOfwordsString {

    public static HashMap<String, Integer> countWords(String text) {
        String[] words = text.toLowerCase().split("\\s+");

        HashMap<String, Integer> wordCount = new HashMap<>();

        for(String word :words) {
            word = word.replaceAll("[^a-zA-Z0-9]", "");

            if (word.isEmpty()) continue;
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        return wordCount;
    }

    public static void main(String[] args){
        String text = "Hello world! Hello again, world.";

        HashMap<String, Integer> result = countWords(text);

        for (String word: result.keySet()) {
            System.out.println(word + ": " + result.get(word));
        }
    }
}
