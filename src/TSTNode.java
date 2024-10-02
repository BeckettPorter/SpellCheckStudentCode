public class TSTNode
{
    private boolean isWord;
    private TSTNode[] nextNodes = new TSTNode[3];
    private char character;


    public TSTNode(boolean isWord, char c)
    {
        this.isWord = isWord;
        this.character = c;
    }

    public boolean isWord()
    {
        return isWord;
    }

    public void setWord(boolean word)
    {
        isWord = word;
    }

    public TSTNode[] getNextNodes()
    {
        return nextNodes;
    }

    public void setNextNode(int index, TSTNode nodeToAdd)
    {
        this.nextNodes[index] = nodeToAdd;
    }
}
