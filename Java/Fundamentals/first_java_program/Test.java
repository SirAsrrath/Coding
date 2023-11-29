import java.util.Random;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args){
        // System.out.println("My name is Coding Dojo");
        // System.out.println("I am 28 years old");
        // System.out.println("My hometown is Greenville, SC");
    ArrayList<Integer> tenRolls = new ArrayList<Integer>();
    Random randMachine = new Random();
    

        for (int i = 0; i < 10; i++)
    {
        int upperbound = 21;
        int int_random = randMachine.nextInt(upperbound);
        tenRolls.add(int_random);
        
        
    }
    System.out.println(tenRolls);
    }
}