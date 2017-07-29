
public interface ShapePositionInterface extends PositionInterface, ShapeInterface{
	
	// returns bounding rectangle of a shape
	public Rectangle getBoundingBox();
	// returns boolean of whether two shapes overlap
	public boolean doOverlap(Shape A, Shape B);
}
