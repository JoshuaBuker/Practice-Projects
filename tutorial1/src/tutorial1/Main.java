package tutorial1;

//Imports
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
		System.out.println("Hello World!");
		
	//These are primitive Data Types - Not Changeable
		// Integer is a number without a decimal point
		int hello_world = 5;
		// Double is a number with a decimal point
		double num2 = 5.0;
		// Boolean is a true or false value
		boolean isOn = true;
		// Character is any character. Made with either unicode or ''. Can only be 1 character within quotes
		char c = '9';
		char d = 'h';
	// These are not primitive Data Types - Changeable	
		// String is literally anything and will print as words
		String str = "Hello World";
		
		//sets variable to the value of another variable
		int tim = hello_world;
		
		//Declaring Variable without giving it a value
		int num1;
		//Gives value
		num1 = 6;
		
	//Basic Operations
		// Multiply *
		// Divide /
		// Add +
		// Subtract -
		// Remainder %   This symbol is called Modulus
		int x = 5;
		int y = -7;
		int z = 56;
		int sum = x + y + z;
		
	//Type casting - Converting one data type to another
		//Currently this will return an int because both x and y are integers
		double u = x / y;
		//To solve this, you would use type casting like so. 
		double q = x / (double)y;
		//You can do it to both, but with dividing in java, only one needs to be a double.
		
	//Scanners - AKA User Input
	//first you need to import scanner at the very top of the file.
		Scanner sc = new Scanner(System.in);
		String scanned = sc.next();
		int scanned_num = sc.nextInt();
		boolean scanned_boolean = sc.nextBoolean();
		double scanned_double = sc.nextDouble();
		
		System.out.println(scanned);
		System.out.println(scanned_num);
		System.out.println(scanned_boolean);
		System.out.println(scanned_double);
		
	//Instead of having different sc objects, convert everything to a string
		int converted = Integer.parseInt(scanned);
		
	//Comparison Operators
		
		}
	

}
