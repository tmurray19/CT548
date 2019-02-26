package atlas;

// This needs to print out population
// Print out bordering countries

//import java.util.Iterator;
import java.util.ArrayList;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
 


public class Country extends Area{
	//Country Class
	
	//Initialising variables
	private ArrayList<City> cities = new ArrayList<>();
	
	// Add a city to the city arrayList
	public void addCity(City c) {
		cities.add(c);
	}
	
	// Returns all cities in arraylist
	public void getCities() {
		for(City c: this.cities) {
			System.out.println(c.getName());
		}
	}
	
	// Returns total population of country, based on cities
	@Override
	public long getPop() {
		long r = 0;
		for(City c: cities) {
			r += (c.getPop());
		}
		return r;
	}
	
	
	
	// Constructor 
	public Country(String name) {
		//Initialise Data
		setName(name);
		//Add the countries' cities from json file to arraylist
		
		// Adding cities to arraylist
		
		// A rather dirty solution, but my knowledge with JSON is limited
		// Please cut me a little slack, I'm learning as I'm coding here
		
		JSONArray country = (JSONArray) FileParser.dataSetter().get("countries");
		for(Object j: country) {
			// Cast j as a JSONObject
			JSONObject h = (JSONObject) j;
			// Get the name of the country h
			String r = (String) (h.get("name"));
			// Get the cities of the country h
			JSONArray cities = (JSONArray) h.get("cities");
			//System.out.println(cities);
			
			// If the country found is the one being init, then add cities to arraylist
			if(r.equals(name)) {
				for(Object n: cities) {
					// Casting n as a JSONObject
					JSONObject m = (JSONObject) n;
					// Getting the name of the city for city creation
					String cityName =(String) m.get("name");
					// Creating city 
					City city = new City(cityName);
					// Adding it to list
					addCity(city);
				}
				break;
			}
			
		}
		
			
	}
	

}
