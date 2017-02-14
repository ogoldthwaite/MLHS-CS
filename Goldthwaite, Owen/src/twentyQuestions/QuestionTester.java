package twentyQuestions;

import java.io.FileNotFoundException;

public class QuestionTester {

	public static void main(String[] args) throws FileNotFoundException 
	{
		//Question game = new Question("Alive", "Fish", "Computer");
		Question game = new Question();
		game.solve();
	}

}
