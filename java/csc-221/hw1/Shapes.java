import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Shapes extends JPanel{
	
	public int height, width;
	public int zx_global, zy_global;
	
	public Shapes(int h, int w){
		height = h;
		width = w;
	}
	
	public void paintComponent(Graphics g){
		
		int color = 2;							// sets initial color choice
		super.paintComponent(g);				// performs actual drawing
		
		for (int i = 2; i < 6; i++){
			if (height < width){
				// generate pentagon coordinates
				int[] arrx = pentx(height/(i));
				int[] arry = penty(height/(i));
				// set randomcolor
				randomColor(g, color);
				// draw circle
				g.fillOval(zx_global, zy_global, 2*(height/i), 2*(height/i));
				color++;
				randomColor(g, color);
				// draw draw pentagon
				g.fillPolygon(arrx, arry, 5);
				color++;
			}
			else{
				int[] arrx = pentx(width/(i));
				int[] arry = penty(width/(i));
				randomColor(g, color);
				g.fillOval(zx_global, zy_global, 2*(width/i), 2*(width/i));
				color++;
				randomColor(g, color);
				g.fillPolygon(arrx, arry, 5);
				color++;
			}
		}
	}
	public void randomColor(Graphics g, int c){
		
		// sets color without transparency
		switch(c){
		case 2: g.setColor(Color.red); break;
		case 3: g.setColor(Color.yellow); break;
		case 4: g.setColor(Color.cyan); break;
		case 5: g.setColor(Color.gray); break;
		case 6: g.setColor(Color.green); break;
		case 7: g.setColor(Color.blue); break;
		case 8: g.setColor(Color.orange); break;
		case 9: g.setColor(Color.white); break;
		default: g.setColor(Color.white);
		}
	}
	// returns y coods of a pentagon given some int input
	public int[] penty(int in){
		int midpanel_y, radius, a_y, z_y, y1, y2, y3, y4, y5;
		// get y coordinate
		midpanel_y = height/2;
		radius = in;			
		// get z_y coordinate
		z_y = midpanel_y - radius;
		zy_global = z_y;
		// pentagon math to get side length and x, y components	
		Double A = 2*radius*Math.sin(Math.PI/5);
		Double A_Y = A*Math.sin(Math.toRadians(36));
		Double A_Y72 = A*Math.sin(Math.toRadians(72));
		
		a_y = A_Y.intValue();
		
		int a_y72 = A_Y72.intValue();
		// obtain coordinates
		y1 = z_y;
		y2 = y1 + a_y;
		y3 = y2 + a_y72;
		y5 = y1 + a_y;	
		y4 = y5 + a_y72;
		
		int [] arry = { y1, y2, y3, y4, y5};
		return arry;
	}
	// returns x coordinates of a pentagon given some int length
	public int[] pentx(int in){
		int midpanel_x, radius, a_x, z_x, x1, x2, x3, x4, x5;
		
		midpanel_x = width/2;
		radius = in;
		
		z_x = midpanel_x - radius;
		zx_global = z_x;
				
		Double A = 2*radius*Math.sin(Math.PI/5);
		Double A_X = A*Math.cos(Math.toRadians(36));
		Double A_X72 = A*Math.cos(Math.toRadians(72));
		
		a_x = A_X.intValue();
		
		int a_x72 = A_X72.intValue();
		
		x1 = z_x + radius;
		x2 = x1 + a_x;
		x3 = x2 - a_x72;
		x5 = x1 - a_x;
		x4 = x5 + a_x72;
		
		int [] arrx = { x1, x2, x3, x4, x5};
		return arrx;
	}
}


