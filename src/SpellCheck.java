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
        // Set this to true to set it to useTST instead of tries
        boolean useTSTMethod = false;

        LinkedHashSet<String> misspelledWords = new LinkedHashSet<>();
        TST tst = new TST(dictionary[0]);
        Trie trie = new Trie(dictionary[0]);


        // Add every word in the dictionary to the TST or trie.
        for (String word : dictionary)
        {
            // Check to either use Tries or TSTs
            if (useTSTMethod)
            {
                tst.insert(word);
            }
            else
            {
                trie.insert(word);
            }
        }

        // If the tst doesn't contain the word from the text, add it to misspelled words.
        for (String word : text)
        {
            // Another check to see if using Tries or TSTs
            if (useTSTMethod)
            {
                if (!tst.contains(word))
                {
                    misspelledWords.add(word);
                }
            }
            else
            {
                if (!trie.contains(word))
                {
                    misspelledWords.add(word);
                }
            }
        }

        // Change the LinkedHashSet to an array of strings to return it.
        return misspelledWords.toArray(new String[misspelledWords.size()]);
    }
}