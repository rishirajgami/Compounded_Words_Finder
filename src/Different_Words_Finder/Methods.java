package Different_Words_Finder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Methods {
	
	// Method to process the file and identify compounded words
   
	protected static void process_selected_File(String inputFile) {
		 // Start measuring time
        long startTime = System.nanoTime();
        
        // Read words from the file into a Set for fast lookup
        Set<String> wordSet = readWordsFromFile(inputFile);

        // Variables to keep track of the longest and second longest compounded words
        String longestCompoundedWord = "";
        String secondLongestCompoundedWord = "";

        // Iterate through all words to find compounded words
        for (String word : wordSet) {
            if (isCompoundedWord(wordSet, word)) {
                // Update the longest and second longest compounded words
                if (word.length() > longestCompoundedWord.length()) {
                    secondLongestCompoundedWord = longestCompoundedWord;
                    longestCompoundedWord = word;
                } else if (word.length() > secondLongestCompoundedWord.length()) {
                    secondLongestCompoundedWord = word;
                }
            }
        }

        // End time measurement
        long endTime = System.nanoTime();
        long duration = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

        // Output the results
        System.out.println("Processing file: " + inputFile);
        System.out.println("Longest compounded word: " + longestCompoundedWord);
        System.out.println("Second longest compounded word: " + secondLongestCompoundedWord);
        System.out.println("Time taken to process the file " + inputFile + ": " + duration + " milliseconds");
        System.out.println();
    }

    // Method to read words from the file into a Set
    private static Set<String> readWordsFromFile(String fileName) {
        Set<String> wordSet = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                wordSet.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordSet;
    }

    // Method to check if a word is a compounded word
    private static boolean isCompoundedWord(Set<String> wordSet, String word) {
        // If the word is shorter than 2 characters, it can't be compounded
        if (word.length() <= 1) return false;

        // Try to break down the word into smaller words that are in the word set
        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);

            // Check if both prefix and suffix are in the word set
            if (wordSet.contains(prefix) && wordSet.contains(suffix) && !prefix.equals(word) && !suffix.equals(word)) {
                return true; // Found a valid compounded word
            }
        }
        return true;
    }


}
