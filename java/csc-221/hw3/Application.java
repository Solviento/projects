import java.awt.Color;
import java.util.Random;
import javax.swing.JFrame;

public class Application{

	public static void main(String[] args) {

		int width = 500;
		int height = 500;
		
		JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(width, height);
        
        // x, y coordinates
        int midx = width/2;
        int midy = height/2;
        
        displayShape display = new displayShape();

        for (int i = 0; i < 3; i++){
        	Shape o = new Oval(midx, midy, randomColor(), (int) (height/(i*Math.sqrt(2))), (int)(height/(i*1.5)));
        	Shape r = o.getBoundingBox();
        	
        	display.add(r);
        	display.add(o);
        }
        
        frame.add(display);		// displays shapes on JFrame
	}
	public static Color randomColor(){
		Random rand = new Random();
		int  n = rand.nextInt(50) + 1;
		// sets color without transparency
		switch(n){
		case 2: return Color.orange;
		case 3: return Color.yellow;
		case 4: return Color.cyan; 
		case 5: return (Color.gray); 
		case 6: return (Color.green); 
		case 7: return (Color.blue); 
		case 8: return (Color.orange); 
		case 9: return (Color.white); 
		default: return (Color.white);
		}
	}

}

/*

Shape o = new Oval(midx, midy, Color.green, (int) height-100, (int) (height/2.5));
Shape o2 = new Oval(midx, midy, Color.orange, (int)((height-100)/Math.sqrt(2)), (int)(height/3.5));
Shape o3 = new Oval(midx, midy, Color.white, (int) ((height+50)/(2*Math.sqrt(2))), (int)(height/5));

Shape oR = o.getBoundingBox();
Shape o2R = o2.getBoundingBox();
Shape o3R = o3.getBoundingBox();

oR.setColor(Color.blue);
o2R.setColor(Color.yellow);
o3R.setColor(Color.magenta);


display.add(oR);
display.add(o);

display.add(o2R);
display.add(o2);

display.add(o3R);
display.add(o3); */