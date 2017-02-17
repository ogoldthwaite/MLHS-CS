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

	public double compareTo(MapNode other)  //Doesnt work with a double?
    {
        return frequency - other.frequency;
    }
	
	public String toString()
	{
		return letter + " = " + frequency;
	}
	
}
