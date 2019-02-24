package atlas;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


// Decided to define a utility class to handle and hold various functions
// I felt these functions could be fit into the Country class
// But I think it makes more sense to have a static class that just references these function
public class Utility {
	
	private static JSONObject jsonCities;

	
	// Retrieve and define the jsonCities JSONObject
	public static void dataSetter() {
		try {
			//Sets jsonCities to the JSONObject called in the FileParser class
			jsonCities = FileParser.dataSetter();
	
		}
		//This exception is to stop misreading files
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//Returns the array of countries bordering a given country
	public static JSONArray getCountryBorder(String country) {
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
	public static Boolean borderChecker(String country1, String country2) {
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
	
	
}
