package atlas;

public class City {
	
	//Variable Initialisation
	private int population;
	private String name;
	
	public void populationSetter(int pop) {
		this.population = pop;
	}
	
	public int populationGetter() {
		return this.population;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getName() {
		return this.name;
	}
	
	public City(String s) {
		this.name = s;
	}
	
	
}
