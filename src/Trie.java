public class Trie
{
    private TrieNode root;

    public Trie(String firstDictionaryWord)
    {
        root = new TrieNode(false, firstDictionaryWord.charAt(0));
    }


    // First insert call, pass in (root, word, 0)

    public void insert(String word)
    {
        insert(root, word, 0);
    }

    public void insert(TrieNode node, String word, int index)
    {
        // Base case, check if index is word length
        if (index == word.length() - 1)
        {
            node.setWord(true);
            return;
        }


        int nextIndex = getNextIndex(word, index);

        TrieNode desiredNode = node.getNextNodes()[nextIndex];

        if (desiredNode == null)
        {
            desiredNode = new TrieNode(false, word.charAt(index));
            node.setNextNode(nextIndex, desiredNode);
        }

        insert(desiredNode, word, index + 1);
    }



    public boolean contains(String word)
    {
        return contains(root, word, 0);
    }


    public boolean contains(TrieNode node, String word, int index)
    {
        if (index == word.length() - 1)
        {
//            System.out.println(word + "AAAAAAA");
            return node.isWord();
        }

        TrieNode desiredNode = node.getNextNodes()[getNextIndex(word, index)];

        if (desiredNode == null)
        {
            return false;
        }

        return contains(desiredNode, word, index + 1);
    }


    private static int getNextIndex(String word, int index)
    {
        return word.charAt(index) - ' ';
    }
}
