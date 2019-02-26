package atlas;
import java.util.Scanner;

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
		
		// Ask for user input
		int response = userIn.nextInt();
		userIn.nextLine();
		
		// Switch case to run different code depending on the user's input
		switch(response) {
		
		// Case 1 - printing out list of countries available
			/* Complete */
		case 1:
			System.out.println("Here are all the countries in the world:");
			Utility.getCountries();
			break;
			
		// Case 2 - the Trip planner	
		// It may be best to ask for country, then city.
		case 2:
			System.out.println("Please enter the country you are in: ");
			String countryInA = userIn.nextLine();
			Country countryA = new Country(countryInA);
			
			System.out.println("Please enter the city you are in: ");
			String cityInA = userIn.nextLine();
			City cityA = new City(cityInA);
			
			System.out.println("Please enter the country you want to go: ");
			String countryInB = userIn.nextLine();
			Country countryB = new Country(countryInB);
			
			System.out.println("Please enter the city you want to go to: ");
			String cityInB = userIn.nextLine();
			City cityB = new City(cityInB);

			
			break;
		
		// Case 3 - What countries border a given country
			/* Complete */
		case 3:
			System.out.println("Please enter the country you wish to verify: ");
			String borderCheck = userIn.nextLine();
			
			// Prints out list in neater manor
			for(Object s: Utility.getCountryBorder(borderCheck)) {
				System.out.println(s);
			}
			
			break;
			
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
			/* Complete */
		case 5:
			System.out.println("Would you like to know the City(0) or Country(1) population?");
			int i = userIn.nextInt();
			userIn.nextLine();
			System.out.println("Please enter the place you wish to know the population of: ");
			String name = userIn.nextLine();
			
			// City case
			if(i == 0) {
				City city = new City(name);
				System.out.println("Population of " + name + " is " + city.getPop());
			}
			// Country case
			if(i == 1) {
				Country country = new Country(name);
				System.out.println("Population of " + name + " is " + country.getPop());
			}
			
			break;
		// Case 6 - getting cities in country
			/* Complete */
		case 6:
			System.out.println("Enter country name: ");
			String co = userIn.nextLine();
			Country case6 = new Country(co);
			case6.getCities();
			
			break;
			
		// Might be depreciated, but to stop any new line issues 
		case '\n':
			break;
			
		// Default case	
		default:
			System.out.println("Unknown response.");
			break;
		}//end switch
		
		// Finishing program
		System.out.println("Done");
		userIn.close();
		
		
	}

}
