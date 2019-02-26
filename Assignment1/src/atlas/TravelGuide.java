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


public class TravelGuide {

	
	
	public static void main(String[] args) {
		City c = new City("Galway");
		System.out.println(c.getName());
		System.out.println(c.getCapital());
		
		
	}
	
}