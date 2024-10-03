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
        addDictionaryToTST(dictionary);


        return new String[3];
    }

    private void addDictionaryToTST(String[] dictionary)
    {
        TST TSTTree = new TST(dictionary[0]);

        for (String word : dictionary)
        {
            TSTTree.insert(word);
        }
    }

}