import java.util.ArrayList;
import java.util.Random;
public class TestPuzzleJava {
    
	public static void main(String[] args) {
		PuzzleJava generator = new PuzzleJava();

		// // 10 random numbers test
		// ArrayList<Integer> randomRolls = generator.getTenRolls();
		// System.out.println(randomRolls);

		// // get random letter test
		// char randomLetter = generator.randomLetter();
		// System.out.println(randomLetter);
		
    	// // get random password
		// String generatePassword = generator.generatePassword();
		// System.out.println(generatePassword);

		// get array of random passwords
		int number = 6;
		ArrayList<String> randomPasswords = generator.arrayPassword(number);
		System.out.println(randomPasswords);
	}
}
