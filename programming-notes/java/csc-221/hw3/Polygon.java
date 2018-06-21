import java.awt.Color;
import java.awt.Graphics;

public class Polygon extends Shape{

	private int n;				// polygon's number of sides
	private int radius;			// we inscribe polygon in circle w radius
	private int side;			// side length of polygon
	private int area;			// area determined by spefic formulas
	private int[] arrx;			// arrays for x, y coordinates
	private int[] arry;
	
	// Polygon contains extra 'n' parameter
	public Polygon(int x, int y, Color c, int rad, int n) {
		super(x, y, c);
		this.n = n;
		radius = rad;
	}
	// accessor methods
	public int getArea(){
		return area;
	}
	public int getPerimeter(){
		return side*n;
	}
	public int getAngle(){
		// formula for interior angle of regular polygon
		return (180 - (360/n));
	}
	public int getInscribedAngle(){
		// formula for inscribed angle
		return (360/n);
	}
	public int getSide(){
		return side;
	}
	@Override
	public String toString(){
		return "Side length: " + getSide() + " Interior Angle: " +
				getAngle() + " Perimeter: " + getPerimeter() + " Area: "
				+ getArea();
	}
	// paints shape on drawing panel after computing coordinates
	public void draw(Graphics g){
		
		draw();
		super.paintComponent(g);
		g.setColor(getColor());
		g.fillPolygon(arrx, arry, n);
		g.setColor(Color.black);
		g.drawString(toString(),getX()-radius,getY()+radius); 
	}
	// computes shape characteristics + coordinates
	public void draw(){
		
		arrx = new int[n];
		arry = new int[n];
			
		if (n == 3){
			// do triangle calculations
			tri();
		}
		if (n == 5){
			// do pentagon calculations
			pent();
		}
		if (n == 8){
			// do octagon calculations
			oct();
		}
		// x and y coordinate computation
		for (int i = 0; i < n; i++){
			int x = (int) (getX() + (Math.sin(2 * Math.PI * i / n) * radius));
			int y = (int) (getY() + (Math.cos(2 * Math.PI * i / n) * radius));
			//polygon.addPoint(x, y);
			arrx[i] = x;
			arry[i] = y;
		}
	}	
	// computes octagon calculations
	public void oct(){
		
		side = (int) ((radius*Math.sin(Math.toRadians(45))) / 2);
		// area formula of regular octagon
		double a = 2*(1+Math.sqrt(2))*Math.pow(side, 2);
		area = (int) a;
	}
	// computes pentagon calculations
	public void pent(){
		
		double A;
		// side length formula for pentagon
		A = 2*radius*Math.sin(Math.PI/n);
		side = (int)A;
		
		// area of pentagon formula
		double a = (Math.pow(side, 2)*n)/(4*Math.tan(Math.toRadians(180/n)));
		area = (int) a;			
	}
	// computes triangle calculations
	public void tri(){
		
		// first use doubles then convert everything to int
		double cnum, cden, C;	// C vector and components
		
		cnum = radius * Math.sin( Math.toRadians(getInscribedAngle()));
		cden = Math.sin( Math.toRadians( getAngle()/2 ));
		
		C = cnum/cden;
		side = (int) C;
		
		// area formula for regular triangle
		double a = (Math.pow(3, .5)/4)*Math.pow(side, 2);
		area = (int) a;
	}
	@Override
	// normally used for regular polygons inscribed by a circle
	public Rectangle getBoundingBox() {
		Rectangle r = new Rectangle(getX(), getY(), getColor(), radius, radius);
		return r;
	}	
}
