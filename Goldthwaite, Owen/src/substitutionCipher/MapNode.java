package substitutionCipher;

public class MapNode implements Comparable<MapNode>
{
	public final String letter;
    public final double frequency;

    public MapNode(String letter, double frequency)
    {
        this.letter = letter;
        this.frequency = frequency;
    }

	public int compareTo(MapNode other)  //Doesnt work with a double?
    {
        if (frequency > other.frequency)
        	return -1;
        else if(frequency < other.frequency)
        	return 1;
        else
        	return 0;
    }
	
	public String toString()
	{
		return letter + " = " + frequency;
	}
	
}
