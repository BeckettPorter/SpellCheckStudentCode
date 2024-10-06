public class TrieNode
{
    // Instance variables
    private boolean isWord;
    private TrieNode[] nextNodes = new TrieNode[255];
    private char character;

    // Constructor that sets if it is a word or not and sets the character.
    public TrieNode(boolean isWord, char c)
    {
        this.isWord = isWord;
        this.character = c;
    }

    // Getters and Setters
    public boolean isWord()
    {
        return isWord;
    }

    public void setWord(boolean word)
    {
        isWord = word;
    }

    public TrieNode[] getNextNodes()
    {
        return nextNodes;
    }

    public void setNextNode(int index, TrieNode nodeToAdd)
    {
        this.nextNodes[index] = nodeToAdd;
    }

    public char getCharacter()
    {
        return character;
    }

    public void setCharacter(char character)
    {
        this.character = character;
    }
}