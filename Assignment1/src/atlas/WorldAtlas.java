package atlas;
import java.util.Scanner;
import java.util.ArrayList;


// The main file, to showcase all the possibilities of the project
// Implemented through a CLI (Command Line Interface)
public class WorldAtlas {

	public static void main(String[] args) {
		try {
			// For user input
			Scanner userIn = new Scanner(System.in);
			boolean finished = false;
			// Repeatedly asks for user input if they want to query multiple questions
			while(!(finished)) {
				// Prints out all options available to the user
				System.out.println("Welcome to the world altas! What do you want to know?");
				System.out.println("-What countries are in the world? (1)");	
				System.out.println("-How can I get to where I want to go? (2)");
				System.out.println("-What countries border a certain country? (3)");
				System.out.println("-Do these two countries border each other? (4)");
				System.out.println("-How many people live here? (5)");
				System.out.println("-What cities are in this country? (6)");
				System.out.println("-What's the capital of this country? (7)");
				System.out.println("-What are the Points of Interest here? (8)");
				
				
				
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
						/* Only prints out one travel plan
						 * 
						 * It is possible for another plan to be implemented
						 * Record the movements in an array of some sort
						 * Run through the while loop a second time
						 * Compare the movement with the array
						 * 
						 * Might be smarter just to record if a flight had taken place
						 * Then run the code ignoring any possibility of that flight
						 *  */
						
					case 2:
						// Asks for both city and country
						// I was getting into the mindset of there possibly being multiple same city names
						// Its not an issue currently, but could be upon expansion
						System.out.println("Please enter the city you are in: ");
						String cityInA = userIn.nextLine();
						City cityA = new City(cityInA);
						
						System.out.println("Please enter the country you are in: ");
						String countryInA = userIn.nextLine();
						Country countryA = new Country(countryInA);			
						
						System.out.println("Please enter the city you want to go to: ");
						String cityInB = userIn.nextLine();
						City cityB = new City(cityInB);
						
						System.out.println("Please enter the country you want to go: ");
						String countryInB = userIn.nextLine();
						Country countryB = new Country(countryInB);
						
						
						// Add a checker for if you've reached the destination
						boolean destinationReached = false;
						City destinationCity = cityB;
						Country destinationCountry = countryB;
						
						
						// While that destination is not reached
						while(!destinationReached) {
							cityB = destinationCity;
							countryB = destinationCountry;
							// If your cities name and the country's name is the same, then your destination is reached
							if(cityA.getName().equals(destinationCity.getName())) {
								// Set the destination as reached and break the case, as it's no longer needed
								System.out.println("Destination Reached.");
								break;
							}
							// This the case that you're in a capital needing to go to another country
							else {

								// Fixing the case where two countries are bordering a common country
								// and you are in a non-capital city, traveling to a non-capital city 
								// It is faster to take a train through this bordering country
								// This code makes that clause possible
								if(!(Utility.commonBorders(countryA, destinationCountry).isEmpty())) {
									// Gets that common country, and intialises it as a Country
									ArrayList<String> r = (Utility.commonBorders(countryA, destinationCountry));
									String k = r.get(0);
									Country connecterCounty = new Country(k);
									ArrayList<City> cities = connecterCounty.giveArray();
									// This gets a (hopefully) non-capital city in the connector
									// (otherwise the program would default to flight)
									City connecterCity = cities.get(1);
									
									TravelContext t = new TravelContext(new ByTrain());
									t.travelTo(countryA, cityA, connecterCounty, connecterCity);
									countryA = connecterCounty;
									cityA = connecterCity;
									
								}
								
								
								if(Utility.flyFrom(cityA, cityB)) {
									TravelContext t = new TravelContext(new ByPlane());
									t.travelTo(countryA, cityA, countryB, cityB);
									
									// Update the country you are in as the one you moved to
									countryA = countryB;
									cityA = cityB;
									
									if(Utility.areWeThereYet(cityA, destinationCity)) {
										break;
									}
			
			
								}
								// This is the case that you can travel between the cities by bus
								if(Utility.busFrom(countryA, cityA, countryB, cityB)){
									TravelContext t = new TravelContext(new ByBus());
									t.travelTo(countryA, cityA, countryB, cityB);
									
									
									// Update the country you are in as the one you moved to
									countryA = countryB;
									cityA = cityB;
									
									if(Utility.areWeThereYet(cityA, destinationCity)) {
										break;
									}
			
								}
								
								
								if(Utility.trainFrom(countryA, cityA, countryB, cityB)) {
									TravelContext t = new TravelContext(new ByTrain());
									t.travelTo(countryA, cityA, countryB, cityB);
									
									countryA = countryB;
									cityA = cityB;
									
									
									if(Utility.areWeThereYet(cityA, destinationCity)) {
										break;
									}
			
								}
								
								
								// In some cases, the loop can have you ending up in the captial
								// This results in a multi stage journey
								// where you move into the capital any stage after the first
								// e.g Galway, Ireland -> Paris, France
								// This clause is just a catch all for if thats the case
								if(!(cityA.getName().equals(countryA.getCapital().getName()))){	
									TravelContext t = new TravelContext(new ByBus());
									t.travelTo(countryA, cityA, countryA, countryA.getCapital());
									
									
									// Update the country you are in as the one you moved to
									cityA = countryA.getCapital();
								}

								// If nothing else works, it should be because you are currently in the capital, with no
								// way to get to city without flying
								// This fixes that issue and runs through the code again
								else{
										TravelContext t = new TravelContext(new ByPlane());
										t.travelTo(countryA, cityA, destinationCountry, destinationCountry.getCapital());
										
										cityA = destinationCountry.getCapital();
										countryA = destinationCountry;
								}
							}
						}
					
						
						break;
						
					
					// Case 3 - What countries border a given country
						/* Complete */
					case 3:
						System.out.println("Please enter the country you wish to verify: ");
						String countryName = userIn.nextLine();
						Country borderCheck = new Country(countryName);
						// Prints out list in neater manor
						for(Object s: Utility.getCountryBorder(borderCheck)) {
							System.out.println(s);
						}
						
						break;
						
					// Case 4 - Checking if two countries border each other
						/* Complete */
					case 4:
						System.out.println("Enter the first country name: ");
						String cIn = userIn.nextLine();
						Country c = new Country(cIn);
						System.out.println("Enter the second country name: ");
						String c2In = userIn.nextLine();
						Country c2 = new Country(c2In);
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
							System.out.println("Population of " + name + " is " + city.getPop() + ".");
						}
						// Country case
						if(i == 1) {
							Country country = new Country(name);
							System.out.println("Population of " + name + " is " + country.getPop() + ".");
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
					
					// Case 7 - getting capital of country
						/* Complete */
					case 7:
						System.out.println("What country do you want to know the capital of?: ");
						Country countryCap = new Country(userIn.nextLine());
						System.out.println("The capital of " + countryCap.getName() + " is " + countryCap.getCapital().getName() + ".");
						
					// Case 8 - getting the Points of Interest of a City (can be extended to other Area based classes)
						/* Complete */
					case 8:	
						System.out.println("What City do you want to know the Points of Interest of?: ");
						City points = new City(userIn.nextLine());
						System.out.println("Here are all the known Points of Interest: ");
						points.getPOIs();
						
						
					// Might be depreciated, but to stop any new line issues 
					case '\n':
						break;
						
					// Default case	
					default:
						System.out.println("Unknown response.");
						break;
					}//end switch
					
				// Asking user if they wish to continue
				System.out.println("Is there anything else we can help you out with (Y/N): ");
				String l = userIn.nextLine();
				if(l.equals("N") || l.equals("n")) {
					finished = true;
				}
			}
			
			System.out.println("Done");
			userIn.close();
		}
		// Catches incorrect inputs from user
		catch(NullPointerException e) {
			System.out.println("Something has gone wrong. This is likely because the place you entered does not exist in our database. Please try again.");
			e.printStackTrace();
		}
		// Catches any unknown error that may occurs
		catch(Exception e) {
			System.out.println("An error has occured. Please try again.");
			e.printStackTrace();
		}
		
	}

}
