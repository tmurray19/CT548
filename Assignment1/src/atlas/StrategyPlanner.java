package atlas;

public interface StrategyPlanner {
	//This file is to allow for the 'Strategy' design pattern
	//Interface which allows algorithm selection at runtime
	//In this case, instead of an algorithm, it chooses travel type
	
	/*
	This should allow users to choose whether they travel by
		Plane
		Bus
		Train
	To get where they want to go.
	
	*/
	
	public void fromTo(Country conA, City cityA, Country conB, City cityB);

}