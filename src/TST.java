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
        int desiredIndex;

        // Base case, check if index is word length
        if (index == word.length() - 1)
        {
            node.setWord(true);
            return;
        }


        if (word.charAt(index) < node.getCharacter())
        {
            desiredIndex = 0;
        }
        else if (word.charAt(index) > node.getCharacter())
        {
            desiredIndex = 2;
        }
        else
        {
            desiredIndex = 1;
        }

        TSTNode desiredNode = node.getNextNodes()[desiredIndex];

        if (desiredNode == null)
        {
            insert(new TSTNode(false, word.charAt(index)), word, index + 1);
            return;
        }

        if (desiredIndex == 1)
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
        return false;
    }
}
