import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava {
    
    Random randMachine = new Random();

    // print 10 random numbers on an array

    public ArrayList<Integer> getTenRolls(){
        ArrayList<Integer> randomRolls = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++){  // arraylist number generator and iteration
            int upperbound = 21;
            int int_random = randMachine.nextInt(upperbound);
            randomRolls.add(int_random);
        }
        return randomRolls;
    }

    // print one random letter of the alphabet
    public char randomLetter(){
        
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray(); //creating an array containing all letters of the alphabet
        int upperbound = 27;
        int int_random = randMachine.nextInt(upperbound);
        return alphabet[int_random];
    }

    // generate password using previous method, with at least 8 characters

    public String generatePassword(){
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray(); //creating an array containing all letters of the alphabet
        int upperbound = 27;
        ArrayList<Integer> letterValue = new ArrayList<Integer>();
        ArrayList<String> password = new ArrayList<String>();
        for (int i =0; i<8 ; i++){
            int int_random = randMachine.nextInt(upperbound - 1);
            letterValue.add(int_random);//adding numerical values to a separate string
            password.add(Character.toString(alphabet[int_random]));//translating those numerical values into letters

        }
        // creating a password with all the random letters
        String randomPassword = (password.get(0) +password.get(1) + password.get(2) + password.get(3) + password.get(4) + password.get(5) + password.get(6) + password.get(7) );
        return randomPassword;
    }

    public ArrayList<String> arrayPassword(Integer number){
        ArrayList<String> passArray = new ArrayList<String>();
        for(int i = 0; i < number; i++){
            passArray.add(generatePassword());
        } 
        return passArray;
    }
}
