import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	//Prints to console so user knows what to do
		System.out.println("Input Your Age: ");
	//creates scanner object and varibles to store strings in.
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
	//converts the string varible to an Integer
		int age = Integer.parseInt(s);
		
	// Creates conditions for various ages
		if (age >= 18) {
		// Scanner used within this condition
			System.out.println("You are an Adult");
			System.out.println("As Adults, lets discuss favorite food. What is yours?: ");
			String food = sc.nextLine();
		// Nested IF statement
			if (food.equals("Ramen")) {
				System.out.println("SAMEEEE!!!!");
			} else {
				System.out.println("Not my favorite but I respect your choice.");
			}
		} else if (age >= 13) {
			System.out.println("You are a teenager");
		} else {
			System.out.println("You are not a teenager, let alone an adult");
		}
		
		

	}

}
