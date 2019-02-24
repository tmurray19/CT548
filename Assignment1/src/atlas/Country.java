package atlas;

// This needs to print out population
// Print out bordering countries

//import java.util.Iterator;
import java.util.ArrayList;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
 


public class Country {
	//Country Class
	
	//Initialising variables
	private int population;
	private ArrayList<City> cities = new ArrayList<>();
	private JSONObject jsonCities;
	
	
	// Retrieve and define the jsonCities JSONObject
	public void dataSetter() {
		try {
			//Sets jsonCities to the JSONObject called in the FileParser class
			this.jsonCities = FileParser.dataSetter();
	
		}
		//This exception is to stop misreading files
		catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	
	//Returns the array of countries bordering a given country
	public JSONArray getCountryBorder(String country) {
		try {
			//Get borders of countries
			JSONObject borders = (JSONObject) jsonCities.get("bordering");

			//Get countries info
			//JSONArray countries = (JSONArray) jsonCities.get("countries");
			JSONArray countryBorder = (JSONArray) borders.get(country);
			return countryBorder;

		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//Checks if two given countries share a border
	public Boolean borderChecker(String country1, String country2) {
		// If the list of a given country contains the other given country
		if(getCountryBorder(country1).contains(country2)) {
			//returns true
			return true;
		}
		//otherwise returns false
		else {
			return false;
		}
	}
	
	// Add a city to the city arrayList
	public void addCity(City c) {
		cities.add(c);
	}
	
	// Returns total population of country, based on cities
	public int getPop() {
		for(City c: cities) {
			this.population += c.populationGetter();
		}
		return this.population;
	}
	
	
	// Constructor 
	public Country(String name) {
		//Initialise Data
		dataSetter();
		//Add the countries' cities from json file to arraylist
		//for(city C in jsonCities.cities){
		//	cities.add(c);
			
	}
	

}
