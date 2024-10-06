public class TST
{
    private TSTNode root;

    public TST(String firstDictionaryWord)
    {
        root = new TSTNode(false, firstDictionaryWord.charAt(0));
    }


    // First insert call, pass in (root, word, 0)

    public void insert(String word)
    {
        insert(root, word, 0);
    }

    public void insert(TSTNode node, String word, int index)
    {
        // Base case, check if index is word length
        if (index == word.length())
        {
            node.setWord(true);
            return;
        }

        int nextIndex = getNextIndex(node, word, index);

        TSTNode desiredNode = node.getNextNodes()[nextIndex];

        if (desiredNode == null)
        {
            desiredNode = new TSTNode(false, word.charAt(index));
            node.setNextNode(nextIndex, desiredNode);
        }

        if (nextIndex == 1)
        {
            insert(desiredNode, word, index + 1);
        }
        else
        {
            insert(desiredNode, word, index);
        }

        // Also need to check for null nodes, then create new nodes there

        // If go left or right, don't increase index, but if match (going middle), then increment by 1
        // Need to know where in word at (charAt)
        // params(TSTNode, word, index)
    }



    public boolean contains(String word)
    {
        return contains(root, word, 0);
    }


    public boolean contains(TSTNode node, String word, int index)
    {
        if (index == word.length())
        {
            return node.isWord();
        }

        TSTNode desiredNode = node.getNextNodes()[getNextIndex(node, word, index)];

        if (desiredNode == null)
        {
            return false;
        }

        if (getNextIndex(node, word, index) == 1)
        {
            return contains(desiredNode, word, index + 1);
        }
        else
        {
            return contains(desiredNode, word, index);
        }
    }


    private static int getNextIndex(TSTNode node, String word, int index)
    {
        int nextIndex;
        if (word.charAt(index) < node.getCharacter())
        {
            nextIndex = 0;
        }
        else if (word.charAt(index) > node.getCharacter())
        {
            nextIndex = 2;
        }
        else
        {
            nextIndex = 1;
        }
        return nextIndex;
    }
}
