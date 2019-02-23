package atlas;

//This file is mostly for experimenting with reading the .json file
//It's largely unnecessary to the code


/*
 * 
 * 			JSONObject obj = new JSONObject(" .... ");
			String pageName = obj.getJSONObject("pageInfo").getString("pageName");
			
			JSONArray arr = obj.getJSONArray("posts");
			for (int i = 0; i < arr.length(); i++)
			{
			    String post_id = arr.getJSONObject(i).getString("post_id");
			    ......
			} 
			
 */

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class TravelGuide {

	
	
	public static void main(String[] args) {
		
		try {
			
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
			
			
			/*
			for(Iterator iterator = borders.keySet().iterator(); iterator.hasNext();) {
			    String key = (String) iterator.next();
			    System.out.println(key + borders.get(key));
			}
			*/
		
			//System.out.println(borderChecker("Ireland", "United Kingdom"));
			//System.out.println(getCountryBorder("Ireland"));


		}
		
		
		catch(Exception e){
			e.printStackTrace();
			
		}
		
	}
	
}
