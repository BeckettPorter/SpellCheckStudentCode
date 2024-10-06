public class Trie
{
    private TrieNode root;

    // Constructor that sets the root to have the first character of the first word in the dictionary.
    public Trie(String firstDictionaryWord)
    {
        root = new TrieNode(false, firstDictionaryWord.charAt(0));
    }

    // Method that allows me to call insert with just a word
    public void insert(String word)
    {
        insert(root, word, 0);
    }

    // Actual insert method that recursively inserts a word into a Trie
    public void insert(TrieNode node, String word, int index)
    {
        // Base case, check if index is word length, if so, set it to be a word and return.
        if (index == word.length())
        {
            node.setWord(true);
            return;
        }

        // Get the "nextIndex" or the desired index we want to go to next
        int nextIndex = getNextIndex(word, index);

        // Then get the child node at that desired index
        TrieNode desiredNode = node.getNextNodes()[nextIndex];

        // If we don't have a node yet at the desired next node location, since we are inserting, make a node there
        // and set it as a child of the current node to link it.
        if (desiredNode == null)
        {
            desiredNode = new TrieNode(false, word.charAt(index));
            node.setNextNode(nextIndex, desiredNode);
        }

        // Call insert again and increment the index by 1.
        insert(desiredNode, word, index + 1);
    }


    // Contains method that just calls the actual contains method with properly setup vars.
    public boolean contains(String word)
    {
        return contains(root, word, 0);
    }

    // Actual contains method that recursively finds if the Trie contains a word.
    public boolean contains(TrieNode node, String word, int index)
    {
        // Base case to see if we have reached the end of the word, then return if it is a word or not.
        if (index == word.length())
        {
            return node.isWord();
        }

        // Get the "desiredNode" which is the target next node
        TrieNode desiredNode = node.getNextNodes()[getNextIndex(word, index)];

        // If this next node doesn't exist, the word isn't in the Trie, thus not in the dictionary, and is misspelled.
        if (desiredNode == null)
        {
            return false;
        }

        // Return contains with the index incremented.
        return contains(desiredNode, word, index + 1);
    }

    // Gets the next index given a word and an index, this index is just the char value of the word.charAt(index).
    private static int getNextIndex(String word, int index)
    {
        return word.charAt(index);
    }
}
