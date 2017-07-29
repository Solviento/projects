
public interface PositionInterface{	
	// returns the point (x, y)
	public int[] getPoint();
	
	// moves point (x, y) to point (x + ∆x, y + ∆y)
	public void moveTo(int x, int y);
	
	// returns distance from point (x, y) to a point
	public int distanceTo(int x, int y);
}