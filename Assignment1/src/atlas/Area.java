package atlas;

//import org.json.simple.JSONObject;

// An attempt at implementing polymorphism into the project
public class Area {
	private long population = 0;
	private String name;

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
	
	// += to allow for multiple pop additions
	public void setPop(long p) {
		this.population = p;
		
	}
}
