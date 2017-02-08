package twentyQuestions;

import java.io.FileNotFoundException;

public class QuestionTester {

	public static void main(String[] args) throws FileNotFoundException 
	{
		Question game = new Question("Human", "Bob", "Fish");
		
		game.solve();
		
		

	}

}
