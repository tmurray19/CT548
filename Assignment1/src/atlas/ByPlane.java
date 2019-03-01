package atlas;

public class ByPlane implements StrategyPlanner{

	@Override
	public void fromTo(Country conA, City cityA, Country conB, City cityB) {
		// TODO Auto-generated method stub
		System.out.println("Move from " + cityA.getName() + ", " + conA.getName() + " to " + cityB.getName() + ", " + conB.getName() + " by Plane");
	}

}
