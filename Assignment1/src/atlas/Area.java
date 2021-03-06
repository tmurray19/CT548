package atlas;
import java.util.ArrayList;



// An attempt at implementing polymorphism into the project
public class Area {
	// Initialising variables
	// Has to be initialised as 0 here, so that values can be added correctly down the hirearchy
	private long population = 0;
	private String name;
	private ArrayList<String> pointsOfInterest = new ArrayList<>();
	
	// Set name
	public void setName(String n) {
		this.name = n;
	}
	
	// returns name
	public String getName() {
		return this.name;
	}
	
	// returns population
	public long getPop() {
		return this.population;
	}
	
	// sets population
	public void setPop(long p) {
		this.population = p;
		
	}
	
	// adds a point of interest to the arraylist
	public void addPOI(String s) {
		pointsOfInterest.add(s);
	}
	
	// prints out all available points of interest in an area
	public void getPOIs() {
		for (String s: pointsOfInterest) {
			System.out.println(s);
		}
	}
	
	
}
