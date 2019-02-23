package atlas;

// This needs to print out population
// Print out bordering countries

import java.io.FileReader;
//import java.util.Iterator;
import java.util.ArrayList;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
 


public class Country {
	//Country Class
	
	//Initialising variables
	private int population;
	private static JSONParser parser = new JSONParser();
	private ArrayList<City> cities = new ArrayList<>();
	private JSONObject jsonCities;
	
	
	// Retrieve and define the jsonCities JSONObject
	public void dataSetter() {
		try {
			//Read json file as object
			Object obj = parser.parse(new FileReader("src/cities.json"));

			//Cast as JSONObject
			JSONObject jsonCities = (JSONObject) obj;
			
			this.jsonCities = jsonCities;
		}
		
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
	
	public Boolean borderChecker(String country1, String country2) {
		if(getCountryBorder(country1).contains(country2)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// Add a city to the city arrayList
	public void addCity(City c) {
		cities.add(c);
	}
	
	// Constructor 
	public Country(String name) {
		//Initialise Data
		dataSetter();
		//Add the countries' cities from json file to arraylist

			

	}
	

}
