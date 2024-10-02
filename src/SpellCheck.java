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


        return;
    }

    private TSTNode[] convertDictionaryToTST(String[] dictionary)
    {
        TSTNode root = new TSTNode(false, dictionary[0].charAt(0));


        for (int i = 0; i < dictionary.length; i++)
        {
            String word = dictionary[i];
            for (int j = 0; j < word.length(); j++)
            {
                char charToCompare = word.charAt(j);

                word = word.substring(1);

                // This means the char is the last letter of the word, meaning it is a word
                if (word.equals(String.valueOf(charToCompare)))
                {
                    node.setNextNode(1, new TSTNode(true, charToCompare));
                    break;
                }

                // CharToCompare is the current char we are checking
                // CurrentChar is the char from the node we are checking to see if the charToCompare will pass through.

                if (charToCompare < currentChar)
                {
                    node.setNextNode(0, new TSTNode(false, charToCompare));
                } else if (charToCompare > currentChar)
                {
                    node.setNextNode(2, new TSTNode(false, charToCompare));
                } else
                {
                    node.setNextNode(1, new TSTNode(false, charToCompare));
                }
            }
        }

        return;
    }
}