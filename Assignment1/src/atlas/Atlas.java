package atlas;
import java.util.Scanner;


public class Atlas {

	public static void main(String[] args) {
		Scanner userIn = new Scanner(System.in);
		
		System.out.println("Welcome to the world altas! What do you want to know?");
		System.out.println("-What countries are in the world? (1)");	
		System.out.println("-How can I get to where I want to go? (2)");
		System.out.println("-What countries border a certain country? (3)");
		System.out.println("-Do these two countries border each other? (4)");
		System.out.println("-How many people live here? (5)");
		System.out.println("-What cities are in this country? (6)");
		
		int response = userIn.nextInt();
		switch(response) {
		case 1:
			System.out.println("Here are all the countries in the world:");
			
			
		default:
			System.out.println("Unknown response.");
		}
		
		
		
	}

}
