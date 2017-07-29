import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.nio.file.Paths; 
import java.util.*;

public class HistogramLetters extends JFrame{
	
	private static Scanner input;
	static int randomInt = 1;
	private static double letterCount;
	private static HashMap<String, Double> map = new HashMap<>();
	
	public HistogramLetters(){
		// header
		super("Finding n frequent letters");
		// set up borderlayout as layout manager type
		setLayout(new BorderLayout());
		// create panel for NORTH section
		JPanel northPanel = new JPanel();
		// input text field
		JTextField input = new JTextField();
		// submit button component
		JButton getNButton = new JButton("Click");
		// set text spacing
		input.setColumns(5);						
		// add label before text field
		northPanel.add(new JLabel("Enter n:"));
		// now add text field after label
		northPanel.add(input);
		// listens for input from user through text field
		getNButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				// expected user input is int (from 1 to 25)
				int n = Integer.parseInt(input.getText());
			    displayShape d = pieChartMaker(250,250, n);
			    add(d, BorderLayout.CENTER);
			    setSize(525, 650);
			}
		});		
		// add button after text field
		northPanel.add(getNButton);
		// set up panel for SOUTH section
		JPanel southPanel = new JPanel();
		JButton closeButton = new JButton("Close");
		// shutdown listener
		closeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				// if Close button is pressed, exit out of window
				System.exit(DISPOSE_ON_CLOSE);
			}
		});
		southPanel.add(closeButton);
	    // add all panels to JFrame
		add(northPanel, BorderLayout.NORTH);
		//add(d, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		// set size of JFrame
		setSize(500, 500);
		setVisible(true);
	}

	// center x, y
	private static displayShape pieChartMaker(int x, int y, int n){
		displayShape drawPanel = new displayShape();
	    // generate respective probabilities for each letter
		map = generateProbabilities(map);
		// sort hashmap by values
		map = sortByValue(map);
		// convert keys and values of hashmap to arraylist (top 3 are located foremost)
		ArrayList<String> sortedLetters = new ArrayList<String>(map.keySet());
		ArrayList<Double> sortedP		= new ArrayList<Double>(map.values());
		// calculation of remaining probablity for other letters
		int loop = 0;								// loop counter
		double sumProbability = 0;					// keeps counter of probabilities
		int angleIncrementations = 0;				// used to remember where the angle offset is
		int arcAngle;								// used to create arc based on where the offset is
		while (loop < n){
			sumProbability += (sortedP.get(loop));	
			// arc angle = 360 * probability
			arcAngle = (int) Math.round(360 * sortedP.get(loop));
			String s = sortedLetters.get(loop) + ", " + String.format("%.4f", sortedP.get(loop));
			drawPanel.add(new PieChart(x, y, randomColor(), 300, angleIncrementations, arcAngle, s));
			// remembers where we last left off from previous arc fill
			angleIncrementations += arcAngle;
			if (loop == (n-1)){
				// all other letters probability
				double remainingP = 1 - sumProbability;
				arcAngle = (int) Math.round(360 * remainingP);
				String r = "All other letters, \n" + String.format("%.4f", remainingP);
				drawPanel.add(new PieChart(x, y, randomColor(), 300, angleIncrementations, arcAngle, r));
				loop++;
			}
			// keep iterating until no more n to analyze
			loop++;
		}
		return drawPanel;
	}
	// sort a hashmap by value
	private static HashMap<String, Double> sortByValue(Map<String, Double> unsortMap) {
        // Convert Map to List of Map
        List<Map.Entry<String, Double>> list =
                new LinkedList<Map.Entry<String, Double>>(unsortMap.entrySet());
        // Sort list with Collections.sort(), provide a custom Comparator
        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
            public int compare(Map.Entry<String, Double> o2,
                               Map.Entry<String, Double> o1) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        // Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        HashMap<String, Double> sortedMap = new LinkedHashMap<String, Double>();
        for (Map.Entry<String, Double> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }        
        return sortedMap;
    }
	// generate probabilities for each letter inside hashmap
	public static HashMap<String, Double> generateProbabilities(HashMap<String, Double> hm){
		
		// find total number of letters in the text file
		for (Map.Entry<String, Double> entry : hm.entrySet()){
			double val = entry.getValue();
			letterCount += val;
		}
		// find frequency of each letter in the text file
		for (Map.Entry<String, Double> entry: hm.entrySet()){
			String key = entry.getKey();
			double val = entry.getValue();
			double freq = val/letterCount;
			
			map.put(key, freq);
		}
		return hm;
	}
	// open a text file
	public static void openFile(){
		try{
			// hardcoded filepath
			input = new Scanner(Paths.get("Emma.txt"));
		}
		catch(IOException ioException){
			System.err.println("Error opening file. Terminating.");
			System.exit(1);
		}
	}
	// parse through a text file character by character
	public static void readRecords(){
		try{
			// process input text character by character
			input.useDelimiter("");
			while(input.hasNext()){
				// process character into hashmap
				freqCharacter(input.next());
			}
		}
		catch(NoSuchElementException elementException){
			System.err.println("File improperly formed. Terminating.");
		}
		catch (IllegalStateException stateException) {
			System.err.println("Error reading from file. Terminating."); 
		}
	}
	// closes a file stream
	public static void closeFile(){
		input.close();
	}
	// increments counter for each letter in the global hashmap 
	public static void freqCharacter(String c){
		if (c.equals("A") || c.equals("a")){
			double count = map.containsKey("a") ? map.get("a") : 0;
			map.put("a", count+1);
		}
		if (c.equals("B") || c.equals("b")){
			double count = map.containsKey("b") ? map.get("b") : 0;
			map.put("b", count+1);
		}
		if (c.equals("C") || c.equals("c")){
			double count = map.containsKey("c") ? map.get("c") : 0;
			map.put("c", count+1);
		}
		if (c.equals("D") || c.equals("d")){
			double count = map.containsKey("d") ? map.get("d") : 0;
			map.put("d", count+1);
		}
		if (c.equals("E") || c.equals("e")){
			double count = map.containsKey("e") ? map.get("e") : 0;
			map.put("e", count+1);
		}
		if (c.equals("F") || c.equals("f")){
			double count = map.containsKey("f") ? map.get("f") : 0;
			map.put("f", count+1);
		}
		if (c.equals("G") || c.equals("g")){
			double count = map.containsKey("g") ? map.get("g") : 0;
			map.put("g", count+1);
		}
		if (c.equals("H") || c.equals("h")){
			double count = map.containsKey("h") ? map.get("h") : 0;
			map.put("h", count+1);
		}
		if (c.equals("I") || c.equals("i")){
			double count = map.containsKey("i") ? map.get("i") : 0;
			map.put("i", count+1);
		}
		if (c.equals("J") || c.equals("j")){
			double count = map.containsKey("j") ? map.get("j") : 0;
			map.put("j", count+1);
		}
		if (c.equals("K") || c.equals("k")){
			double count = map.containsKey("k") ? map.get("k") : 0;
			map.put("k", count+1);
		}
		if (c.equals("L") || c.equals("l")){
			double count = map.containsKey("l") ? map.get("l") : 0;
			map.put("l", count+1);
		}
		if (c.equals("M") || c.equals("m")){
			double count = map.containsKey("m") ? map.get("m") : 0;
			map.put("m", count+1);
		}
		if (c.equals("N") || c.equals("n")){
			double count = map.containsKey("n") ? map.get("n") : 0;
			map.put("n", count+1);
		}
		if (c.equals("O") || c.equals("o")){
			double count = map.containsKey("o") ? map.get("o") : 0;
			map.put("o", count+1);
		}
		if (c.equals("P") || c.equals("p")){
			double count = map.containsKey("p") ? map.get("p") : 0;
			map.put("p", count+1);
		}
		if (c.equals("Q") || c.equals("q")){
			double count = map.containsKey("q") ? map.get("q") : 0;
			map.put("q", count+1);
		}
		if (c.equals("R") || c.equals("r")){
			double count = map.containsKey("r") ? map.get("r") : 0;
			map.put("r", count+1);
		}
		if (c.equals("S") || c.equals("s")){
			double count = map.containsKey("s") ? map.get("s") : 0;
			map.put("s", count+1);
		}
		if (c.equals("T") || c.equals("t")){
			double count = map.containsKey("t") ? map.get("t") : 0;
			map.put("t", count+1);
		}
		if (c.equals("U") || c.equals("u")){
			double count = map.containsKey("u") ? map.get("u") : 0;
			map.put("u", count+1);
		}
		if (c.equals("V") || c.equals("v")){
			double count = map.containsKey("v") ? map.get("v") : 0;
			map.put("v", count+1);
		}
		if (c.equals("W") || c.equals("w")){
			double count = map.containsKey("w") ? map.get("w") : 0;
			map.put("w", count+1);
		}
		if (c.equals("X") || c.equals("x")){
			double count = map.containsKey("x") ? map.get("x") : 0;
			map.put("x", count+1);
		}
		if (c.equals("Y") || c.equals("y")){
			double count = map.containsKey("y") ? map.get("y") : 0;
			map.put("y", count+1);
		}
		if (c.equals("Z") || c.equals("z")){
			double count = map.containsKey("z") ? map.get("z") : 0;
			map.put("z", count+1);
		}
	}
	// returns a random color
	public static Color randomColor(){
		
		if (randomInt%10 == 1){
			randomInt++;
			return Color.orange;
		}
		if (randomInt%10 == 2){
			randomInt++;
			return Color.gray;
		}
		if (randomInt%10 == 3){
			randomInt++;
			return Color.green;
		}
		if (randomInt%10 == 4){
			randomInt++;
			return Color.blue;
		}
		if (randomInt%10 == 5){
			randomInt++;
			return Color.magenta;
		}
		if (randomInt%10 == 6){
			randomInt++;
			return Color.white;
		}
		if (randomInt%10 == 7){
			randomInt++;
			return Color.cyan;
		}
		if (randomInt%10 == 8){
			randomInt++;
			return Color.black;
		}
		if (randomInt%10 == 9){
			randomInt++;
			return Color.yellow;
		}
		else{
			randomInt++;
			return Color.white;
		}
	}
	public static void main(String... args){
		// I/O operations
		openFile();
		readRecords();
		closeFile();	
		// create pie chart with user input
		HistogramLetters app = new HistogramLetters();
		app.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
