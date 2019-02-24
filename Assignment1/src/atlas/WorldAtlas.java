package atlas;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class WorldAtlas {

	public static void main(String[] args) {
		// For user input
		Scanner userIn = new Scanner(System.in);
		
		// Prints out all options available to the user
		System.out.println("Welcome to the world altas! What do you want to know?");
		System.out.println("-What countries are in the world? (1)");	
		System.out.println("-How can I get to where I want to go? (2)");
		System.out.println("-What countries border a certain country? (3)");
		System.out.println("-Do these two countries border each other? (4)");
		System.out.println("-How many people live here? (5)");
		System.out.println("-What cities are in this country? (6)");
		
		int response = userIn.nextInt();
		userIn.nextLine();
		// Switch case to run different code depending on the user's input
		switch(response) {
		
		// Case 1 - printing out list of countries available
			/* Complete */
		case 1:
			System.out.println("Here are all the countries in the world:");
			JSONArray countries = (JSONArray) FileParser.dataSetter().get("countries");
			for(int i = 0, size = countries.size(); i < size; i++) {
				JSONObject objectInArray = (JSONObject) countries.get(i);
				System.out.println(objectInArray.get("name"));
			}
			
			break;
			
		// Case 2 - the Trip planner	
		case 2:
			System.out.println("Please enter where you are: ");
			String A = userIn.nextLine();
			System.out.println("Please enter where you want to go: ");
			String B = userIn.nextLine();
			System.out.println(A);
			System.out.println(B);
			
			break;
		
		// Case 3 - What countries border a given country
		case 3:
			System.out.println("Please enter the country you wish to verify: ");
			String borderCheck = userIn.nextLine();
			Utility.getCountryBorder(borderCheck);
			
		// Case 4 - Checking if two countries border each other
			/* Complete */
		case 4:
			System.out.println("Enter the first country name: ");
			String c = userIn.nextLine();
			System.out.println("Enter the second country name: ");
			String c2 = userIn.nextLine();
			System.out.println(Utility.borderChecker(c, c2));
		
			break;
			
		// Case 5 - getting population of location (City or Country)
		case 5:
			System.out.println("Where do you want to know the population:");
			//String place = userIn.nextLine();
			
			break;
		// Case 6 - getting cities in country
			/* Complete */
		case 6:
			System.out.println("Enter country name: ");
			String co = userIn.nextLine();
			Country case6 = new Country(co);
			case6.getCities();
			
			break;
			
		// Might be depreciated
		case '\n':
			break;
			
		// Default case	
		default:
			System.out.println("Unknown response.");
			break;
		}
		
		// Finishing program
		System.out.println("Done");
		userIn.close();
		
		
	}

}