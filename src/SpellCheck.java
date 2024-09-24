import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Spell Check
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Beckett Porter
 * Completed on:
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
        Map<String, Boolean> stringIntMap = new Hashtable<>();
        Map<String, Boolean> misspelledWords = new Hashtable<>();

        for (String word : dictionary)
        {
            stringIntMap.put(word, false);
        }

        for (int i = 0; i < text.length; i++)
        {
            if (!stringIntMap.containsKey(text[i]) && !misspelledWords.get(text[i]))
            {
                misspelledWords.put(text[i], true);
            }
        }


        String[] ar = new String[misspelledWords.size()];

        int index = 0;
        for (String s : misspelledWords.keySet())
        {
            ar[index] = s;
            index++;
        }

        return ar;

        // Made hashmap of all dictionary words
        // Check if word is in dictionary
    }
}