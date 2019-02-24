package atlas;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


/*

//Read in as object
Object obj = parser.parse(new FileReader("src/cities.json"));

//Cast as JSONObject
JSONObject jsonCities = (JSONObject) obj;

//Get borders of countries
JSONObject borders = (JSONObject) jsonCities.get("bordering");

//Get countries data
JSONArray countries = (JSONArray) jsonCities.get("countries");

//Reading all data from countries
for(int i = 0, size = countries.size(); i < size; i++) {
	JSONObject objectInArray = (JSONObject) countries.get(i);
	System.out.println(objectInArray);
	//Capital Code
	Object C = objectInArray.get("capital");
	System.out.println(C);
	//Name
	Object N = objectInArray.get("name");
	System.out.println(N);
	
	
	Long ID = (Long) objectInArray.get("id");
	System.out.println(borders.get(Long.toString(ID)));
	JSONArray countryBorder = (JSONArray) borders.get(Long.toString(ID)); 
}

*/

public class FileParser {
	// Initialising variables
	private static JSONParser parser = new JSONParser();

	public static JSONObject dataSetter() {
		try {
			//Read json file as object
			Object obj = parser.parse(new FileReader("src/cities.json"));

			//Cast as JSONObject
			JSONObject jsonCities = (JSONObject) obj;
			
			return jsonCities;
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
}
