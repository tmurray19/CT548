package atlas;

// This needs to print out population
// Print out bordering countries

//import java.util.Iterator;
import java.util.ArrayList;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
 


public class Country {
	//Country Class
	
	//Initialising variables
	private int population;
	private ArrayList<City> cities = new ArrayList<>();
	private JSONObject jsonCities;

	
	
	// Add a city to the city arrayList
	public void addCity(City c) {
		cities.add(c);
	}
	
	// Returns all cities in arraylist
	public void getCities() {
		for(City c: cities) {
			System.out.println(c.getName());
		}
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
		Utility.dataSetter();
		//Add the countries' cities from json file to arraylist
		
		
		JSONArray country = (JSONArray) jsonCities.get("countries");
		for(Object j: country) {
			//System.out.println(j);
			JSONObject h = (JSONObject) j;
			String r = (String) (h.get("name"));
			JSONArray cities = (JSONArray) h.get("cities");
			//System.out.println(cities);
			
			if(r.equals(name)) {
				for(Object n: cities) {
					JSONObject m = (JSONObject) n;
					String cityName =(String) m.get("name");
					
					City city = new City(cityName);
					addCity(city);
				}
				break;
			}
		}
		
			
	}
	

}
