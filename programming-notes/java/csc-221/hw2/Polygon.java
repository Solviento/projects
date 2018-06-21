import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

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
	public String toString(){
		return "Side length: " + getSide() + " Interior Angle: " +
				getAngle() + " Perimeter: " + getPerimeter() + " Area: "
				+ getArea();
	}
	
	public void draw(Graphics g){
		draw();
		super.paintComponent(g);
		g.setColor(getColor());
		g.fillPolygon(arrx, arry, n);
		g.setColor(Color.black);
		g.drawString(toString(),getX()-radius,getY()+radius); 
	}
	public void draw(){
		
		ArrayList<Integer> x = new ArrayList<Integer>();
		ArrayList<Integer> y = new ArrayList<Integer>();
		
		if (n == 3){
			// do triangle coordinates
			ArrayList<Point> triangle = tri();
			for (Point p: triangle){
				x.add(p.getX());
				y.add(p.getY());
			}
		}
		if (n == 5){
			// do pentagon coordinates
			ArrayList<Point> pentagon = pent();
			for (Point p: pentagon){
				x.add(p.getX());
				y.add(p.getY());
			}
		}
		if (n == 8){
			// do octagon coordinates
			ArrayList<Point> octagon = oct();
			for (Point p: octagon){
				x.add(p.getX());
				y.add(p.getY());
			}
		}
		// convert Integer to primitive ints
		arrx = new int[x.size()];
    	for (int i = 0; i < x.size(); i++){
    		arrx[i] = x.get(i);
    	}
    	arry = new int[y.size()];
    	for (int j = 0; j < y.size(); j++){
    		arry[j] = y.get(j);
    	}
	}
	
	// returns coordinates of an octagon
	public ArrayList<Point> oct(){
		
		double CX, CY;	// C = radius
		side = (int) ((radius*Math.sin(Math.toRadians(45))) / 2);
		
		// area formula of regular octagon
		double a = 2*(1+Math.sqrt(2))*Math.pow(side, 2);
		area = (int) a;
		
		CY = radius * Math.cos(Math.toRadians(45));
		CX = radius * Math.sin(Math.toRadians(45));
		
		int int_CX = (int) CX;
		int int_CY = (int) CY;
		
		Point P1 = new Point(getX(), getY() - radius);
		Point P2 = new Point(getX() + int_CX, getY() - int_CY );
		Point P3 = new Point(getX() + radius, getY());
		Point P4 = new Point(getX() + int_CX, getY() + int_CY);
		Point P5 = new Point(getX(), getY() + radius);
		Point P6 = new Point(getX() - int_CX, getY() + int_CY);
		Point P7 = new Point(getX() - radius, getY());
		Point P8 = new Point(getX() - int_CX, getY() - int_CY);
		
		ArrayList<Point> array = new ArrayList<Point>();
		
		array.add(P1);
		array.add(P2);
		array.add(P3);
		array.add(P4);
		array.add(P5);
		array.add(P6);
		array.add(P7);
		array.add(P8);
		
		return array;
	}
	// returns coordinates of a pentagon	
	public ArrayList<Point> pent(){
		
		double A, AX, AX72, AY, AY72;
		// side length formula for pentagon
		A = 2*radius*Math.sin(Math.PI/n);
		side = (int)A;
		
		// area of pentagon formula
		double a = (Math.pow(side, 2)*n)/(4*Math.tan(Math.toRadians(180/n)));
		area = (int) a;			
		
		// vector components
		AY = A*Math.sin(Math.toRadians(36));
		AY72 = A*Math.sin(Math.toRadians(72));
		
		AX = A*Math.cos(Math.toRadians(36));
		AX72 = A*Math.cos(Math.toRadians(72));
		// cast conversions
		int int_AX = (int) AX;
		int int_AX72 = (int) AX72;
		int int_AY = (int) AY;
		int int_AY72 = (int) AY72;
		
		// coordinate arithmetic
		Point P1 = new Point(getX(), getY() - radius); 						
		Point P2 = new Point(P1.getX()+int_AX, P1.getY() +int_AY);	
		Point P3 = new Point(P2.getX()- int_AX72, P2.getY() + int_AY72);
		Point P5 = new Point(getX() - int_AX, P1.getY() + int_AY);
		Point P4 = new Point(P5.getX() + int_AX72, P3.getY() );
		
		ArrayList<Point> array = new ArrayList<Point>();

		array.add(P1);
		array.add(P2);
		array.add(P3);
		array.add(P4);
		array.add(P5);
		
		return array;
	}
	// returns coordinates of a triangle
	public ArrayList<Point> tri(){
		
		// first use doubles then convert everything to int
		double cnum, cden, C, CX, CY;	// C vector and components
		
		cnum = radius * Math.sin( Math.toRadians(getInscribedAngle()));
		cden = Math.sin( Math.toRadians( getAngle()/2 ));
		
		C = cnum/cden;
		side = (int) C;
		
		// area formula for regular triangle
		double a = (Math.pow(3, .5)/4)*Math.pow(side, 2);
		area = (int) a;

		// vector notation to get coordinates
		CY = C * Math.sin(Math.toRadians(getInscribedAngle()));
		CX = -1 * C * Math.cos(Math.toRadians(getInscribedAngle()));
		
		int int_CX = (int) CX;
		int int_CY = (int) CY;
		
		// coordinate arithmetic
		Point P1 = new Point(getX(), getY() - radius); 						
		Point P2 = new Point(P1.getX()+int_CX, P1.getY()+int_CY);	
		Point P3 = new Point(P2.getX()-(2*int_CX), P2.getY());		
		
		ArrayList<Point> array = new ArrayList<Point>();
		array.add(P1);
		array.add(P2);
		array.add(P3);
		
		return array;
	}
}
