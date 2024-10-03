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
        TST TSTTree = new TST(dictionary[0]);

        addDictionaryToTST(dictionary, TSTTree);


        return getMisspelledWords(text, TSTTree);
    }

    private void addDictionaryToTST(String[] dictionary, TST tree)
    {
        for (String word : dictionary)
        {
            tree.insert(word);
        }
    }

    private String[] getMisspelledWords(String[] text, TST tree)
    {
        ArrayList<String> arList = new ArrayList<>();

        for (String word : text)
        {
            if (!tree.contains(word))
            {
                arList.add(word);
            }
        }

        String[] ar = new String[arList.size()];

        for (int i = 0; i < arList.size(); i++)
        {
            ar[i] = arList.get(i);
        }

        return ar;
    }
}