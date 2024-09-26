import java.lang.reflect.Array;
import java.util.*;

/**
 * Spell Check
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Beckett Porter
 * Completed on: 9/26/24
 * */

public class SpellCheck {


    /**
     * checkWords finds all words in text that are not present in dictionary
     *
     * @param text The list of all words in the text.
     * @param dictionary The list of all accepted words.
     * @return String[] of all misspelled words in the order they appear in text. No duplicates.
     */
    public String[] checkWords(String[] text, String[] dictionary)
    {
        // Use a helper method I made to get a LinkedHashList of all the misspelled words.
        LinkedHashSet<String> misspelledWords = getMisspelledWords(text, dictionary);

        // Make a new string array with the length of the number of misspelled words.
        String[] ar = new String[misspelledWords.size()];

        // Had to use an enhanced for loop here because LinkedHashSets don't have a .get(int index) method so I have
        // to do this to get the word at a given index. I don't really know why they don't have a method for this
        // because it seems like using an enhanced for loop would be doing basically the same thing...
        int index = 0;
        for (String s : misspelledWords)
        {
            ar[index] = s;
            index++;
        }

        // Return the new String[] array
        return ar;
    }

    // Method that returns a LinkedHashList of all the misspelled words in a given text with a given dictionary.
    private static LinkedHashSet<String> getMisspelledWords(String[] text, String[] dictionary)
    {
        // Make a hash set of all the dictionary words for O(1) lookup times. It doesn't need to be a LinkedHashSet
        // (this would be an ordered hash set) because the order doesn't matter when finding if it contains a word.
        HashSet<String> dictionaryHashSet = new HashSet<>(Arrays.asList(dictionary));

        // Use a linked hash set because it doesn't allow duplicate entries but is also ordered since we have to
        // return the list of the misspelled words in order.
        LinkedHashSet<String> misspelledWords = new LinkedHashSet<>();

        // Go through each word in the text
        for (String word : text)
        {
            // If the word is not found in the dictionary
            if (!dictionaryHashSet.contains(word))
            {
                // Then add to the misspelled words
                misspelledWords.add(word);
            }
        }
        return misspelledWords;
    }
}