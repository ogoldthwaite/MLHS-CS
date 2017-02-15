package substitutionCipher;

public class FrequencyNode implements Comparable<FrequencyNode>
{
	    public final char letter;
	    public final int frequency;

	    public FrequencyNode(char letter, int frequency)
	    {
	        this.letter = letter;
	        this.frequency = frequency;
	    }
	    
	    public int compareTo(FrequencyNode other)
	    {
	        return frequency - other.frequency;
	    }
	}
