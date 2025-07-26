import java.util.*;

public class FindtheMostRepeatedwords {

    public static List<String> getmostRepeatedWords(String text) {
        // Step 1: Normalize and split
        String[] words = text.toLowerCase().split("\\s+");

        //Step 2: Count word frequencies
        HashMap<String , Integer> wordCount = new HashMap<>();
        for (String word:words){
            word = word.replaceAll("[^a-zA-Z0-9]","");
            if(word.isEmpty()) continue;

            wordCount.put(word, wordCount.getOrDefault(word,0)+1);

        }
        // Step 3: Find max frequency
        int maxFreq = Collections.max(wordCount.values());

        // Step 4: Collect all words with max frequency
        List<String> mostRepeated = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue()==maxFreq) {
                mostRepeated.add(entry.getKey());
            }
        }
         return mostRepeated;
    }


    public static void main(String[] args){
        String text = "Hello world! Hello again, world. Hello there";
        List<String> mostRepeated = getmostRepeatedWords(text);
        System.out.println("Most repeated words: " + mostRepeated);

    }
}
