// Fig. 28.32: AddressBookDisplay.java
// A simple address book
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List; 
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

public class AddressBookDisplay extends JFrame
{
   private Person currentEntry;
   private PersonQueries personQueries;
   private List<Person> results;   
   private int numberOfEntries = 0;
   private int currentEntryIndex;

   private JButton browseButton;
   private JLabel emailLabel;
   private JTextField emailTextField;
   private JLabel firstNameLabel;
   private JTextField firstNameTextField;
   private JLabel idLabel;
   private JTextField idTextField;
   private JTextField indexTextField;
   private JLabel lastNameLabel;
   private JTextField lastNameTextField;
   private JTextField maxTextField;
   private JButton nextButton;
   private JLabel ofLabel;
   private JLabel phoneLabel;
   private JTextField phoneTextField;
   private JButton previousButton;
   private JButton queryButton;
   private JLabel queryLabel;
   private JPanel queryPanel;
   private JPanel navigatePanel;
   private JPanel displayPanel;
   private JTextField queryTextField;
   private JButton insertButton;
   
   // modifications:
   private JButton updateButton;
   private JButton deleteButton;
   private JLabel stateLabel;
   private JTextField stateTextField;
   private JLabel queryStateLabel;
   private JPanel queryStatePanel;
   private JTextField queryStateTextField;
   private JButton queryStateButton;
   // end mods
   
   // constructor
   public AddressBookDisplay()
   {
      super("Address Book"); 
      
      // establish database connection and set up Statements
      personQueries = new PersonQueries(); 
      
      // create GUI
      navigatePanel = new JPanel();
      previousButton = new JButton();
      indexTextField = new JTextField(2);
      ofLabel = new JLabel();
      maxTextField = new JTextField(2);
      nextButton = new JButton();
      displayPanel = new JPanel();
      idLabel = new JLabel();
      idTextField = new JTextField(10);
      firstNameLabel = new JLabel();
      firstNameTextField = new JTextField(10);
      lastNameLabel = new JLabel();
      lastNameTextField = new JTextField(10);
      emailLabel = new JLabel();
      emailTextField = new JTextField(10);
      phoneLabel = new JLabel();
      phoneTextField = new JTextField(10);
      queryPanel = new JPanel();
      queryLabel = new JLabel();
      queryTextField = new JTextField(10);
      queryButton = new JButton();
      browseButton = new JButton();
      insertButton = new JButton();
      
      // modifications:
      updateButton = new JButton();
      deleteButton = new JButton();
      stateLabel = new JLabel();
      stateTextField = new JTextField(10);
      queryStatePanel = new JPanel();
      queryStateTextField = new JTextField(10);
      queryStateButton = new JButton();
      queryStateLabel = new JLabel();
      // end mods

      setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
      // modification
      setSize(400, 450);
      // end mod
      setResizable(false);

      navigatePanel.setLayout(
         new BoxLayout(navigatePanel, BoxLayout.X_AXIS));

      previousButton.setText("Previous");
      previousButton.setEnabled(false);
      previousButton.addActionListener(
         new ActionListener()
         {
            public void actionPerformed(ActionEvent evt)
            {
               previousButtonActionPerformed(evt);
            }
         }
      ); // end call to addActionListener

      navigatePanel.add(previousButton);
      navigatePanel.add(Box.createHorizontalStrut(10));

      indexTextField.setHorizontalAlignment(
         JTextField.CENTER);
      indexTextField.addActionListener(
         new ActionListener()
         {
            public void actionPerformed(ActionEvent evt)
            {
               indexTextFieldActionPerformed(evt);
            } 
         }
      ); // end call to addActionListener

      navigatePanel.add(indexTextField);
      navigatePanel.add(Box.createHorizontalStrut(10));

      ofLabel.setText("of");
      navigatePanel.add(ofLabel);
      navigatePanel.add(Box.createHorizontalStrut(10));

      maxTextField.setHorizontalAlignment(
         JTextField.CENTER);
      maxTextField.setEditable(false);
      navigatePanel.add(maxTextField);
      navigatePanel.add(Box.createHorizontalStrut(10));

      nextButton.setText("Next");
      nextButton.setEnabled(false);
      nextButton.addActionListener(
         new ActionListener()
         {
            public void actionPerformed(ActionEvent evt)
            {
               nextButtonActionPerformed(evt);
            }
         }
      ); // end call to addActionListener

      navigatePanel.add(nextButton);
      add(navigatePanel);

      displayPanel.setLayout(new GridLayout(6, 2, 4, 4));

      idLabel.setText("Address ID:");
      displayPanel.add(idLabel);

      idTextField.setEditable(false);
      displayPanel.add(idTextField);

      firstNameLabel.setText("First Name:");
      displayPanel.add(firstNameLabel);
      displayPanel.add(firstNameTextField);

      lastNameLabel.setText("Last Name:");
      displayPanel.add(lastNameLabel);
      displayPanel.add(lastNameTextField);

      emailLabel.setText("Email:");
      displayPanel.add(emailLabel);
      displayPanel.add(emailTextField);

      phoneLabel.setText("Phone Number:");
      displayPanel.add(phoneLabel);
      displayPanel.add(phoneTextField);
      //add(displayPanel);
      
      // modifications:
      stateLabel.setText("State:");
      displayPanel.add(stateLabel);
      displayPanel.add(stateTextField);
      add(displayPanel);
      // end mods
      
      // gui component to search db by last name
      
      queryPanel.setLayout(
         new BoxLayout(queryPanel, BoxLayout.X_AXIS));

      queryPanel.setBorder(BorderFactory.createTitledBorder(
         "Find an entry by last name"));
      queryLabel.setText("Last Name:");
      queryPanel.add(Box.createHorizontalStrut(5));
      queryPanel.add(queryLabel);
      queryPanel.add(Box.createHorizontalStrut(10));
      queryPanel.add(queryTextField);
      queryPanel.add(Box.createHorizontalStrut(10));

      queryButton.setText("Find");
      queryButton.addActionListener(
         new ActionListener()
         {
            public void actionPerformed(ActionEvent evt)
            {
               queryButtonActionPerformed(evt);
            } 
         }
      ); // end call to addActionListener

      queryPanel.add(queryButton);
      queryPanel.add(Box.createHorizontalStrut(5));
      add(queryPanel);
      
      // gui component to search db by state
      queryStatePanel.setLayout(
    	new BoxLayout(queryStatePanel, BoxLayout.X_AXIS));
      
      queryStatePanel.setBorder(BorderFactory.createTitledBorder(
    	"Find an entry by state"));
      queryStateLabel.setText("State:");
      queryStatePanel.add(Box.createHorizontalStrut(5));
      queryStatePanel.add(queryStateLabel);
      queryStatePanel.add(Box.createHorizontalStrut(10));
      queryStatePanel.add(queryStateTextField);
      queryStatePanel.add(Box.createHorizontalStrut(10));
      
      queryStateButton.setText("Find");
      queryStateButton.addActionListener(
    	new ActionListener()
    	{
    		public void actionPerformed(ActionEvent evt)
    		{
    			queryStateButtonActionPerformed(evt);
    		}
    	}
      );
      
      queryStatePanel.add(queryStateButton);
      queryStatePanel.add(Box.createHorizontalStrut(5));
      add(queryStatePanel);
      

      browseButton.setText("Browse All Entries");
      browseButton.addActionListener(
         new ActionListener()
         {
            public void actionPerformed(ActionEvent evt)
            {
               browseButtonActionPerformed(evt);
            } 
         } 
      ); // end call to addActionListener

      add(browseButton);

      insertButton.setText("Insert New Entry");
      insertButton.addActionListener(
         new ActionListener()
         {
            public void actionPerformed(ActionEvent evt)
            {
               insertButtonActionPerformed(evt);
            } 
         } 
      ); // end call to addActionListener

	  add(insertButton);
	   
	  // modifications
	  
	  // insert update button
	  updateButton.setText("Update Entry");
	  updateButton.addActionListener(
		new ActionListener()
	    {
			public void actionPerformed(ActionEvent evt)
	    	{
				updateButtonActionPerformed(evt);
	    	}
	    }
	   );
	  add(updateButton);
	  
	  // insert delete button
	  deleteButton.setText("Delete Current Entry");
	  deleteButton.addActionListener(

		new ActionListener()
	     {
	       public void actionPerformed(ActionEvent evt)
	    	 {
	    		 deleteButtonActionPerformed(evt);
	    	 }
	     }
      );
	  add(deleteButton);
	  
	  // end mods

      addWindowListener(
         new WindowAdapter() 
         {  
            public void windowClosing(WindowEvent evt)
            {
               personQueries.close(); // close database connection
               System.exit(0);
            } 
         } 
      ); // end call to addWindowListener
	
      setVisible(true);
   } // end constructor

   // handles call when previousButton is clicked
   private void previousButtonActionPerformed(ActionEvent evt)
   {
      currentEntryIndex--;
      
      if (currentEntryIndex < 0)
         currentEntryIndex = numberOfEntries - 1;
      
      indexTextField.setText("" + (currentEntryIndex + 1));
      indexTextFieldActionPerformed(evt);  
   } 

   // handles call when nextButton is clicked
   private void nextButtonActionPerformed(ActionEvent evt) 
   {
      currentEntryIndex++;
      
      if (currentEntryIndex >= numberOfEntries)
         currentEntryIndex = 0;
      
      indexTextField.setText("" + (currentEntryIndex + 1));
      indexTextFieldActionPerformed(evt);
   }

   // handles call when queryButton is clicked (find entry by last name)
   private void queryButtonActionPerformed(ActionEvent evt)
   {
	   if(queryTextField.getText().length() == 0)
	   {
		   JOptionPane.showMessageDialog(this, "Missing term",
		            "Missing term", JOptionPane.PLAIN_MESSAGE);
	   }
	   
	   else
	   {
		  results = 
         personQueries.getPeopleByLastName(queryTextField.getText());
      numberOfEntries = results.size();
      
      if (numberOfEntries != 0)
      {
         currentEntryIndex = 0;
         currentEntry = results.get(currentEntryIndex);
         idTextField.setText("" + currentEntry.getAddressID());
         firstNameTextField.setText(currentEntry.getFirstName());
         lastNameTextField.setText(currentEntry.getLastName());
         emailTextField.setText(currentEntry.getEmail());
         phoneTextField.setText(currentEntry.getPhoneNumber());
         // modification
         stateTextField.setText(currentEntry.getState());
         // end mod
         maxTextField.setText("" + numberOfEntries);
         indexTextField.setText("" + (currentEntryIndex + 1));
         nextButton.setEnabled(true);
         previousButton.setEnabled(true);
      } 
      else
         browseButtonActionPerformed(evt); 
	   }
      
   } 
   
   // handles call when query StateButton is clicked
   private void queryStateButtonActionPerformed(ActionEvent evt)
   {
	   if (queryStateTextField.getText().length() == 0)
	   {
		   JOptionPane.showMessageDialog(this, "Missing term",
		            "Missing term", JOptionPane.PLAIN_MESSAGE);
	   }
	   else
	   {
		   results = 
			personQueries.getPeopleByState(queryStateTextField.getText());
			      numberOfEntries = results.size();
			if (numberOfEntries != 0)
			      {
			         currentEntryIndex = 0;
			         currentEntry = results.get(currentEntryIndex);
			         idTextField.setText("" + currentEntry.getAddressID());
			         firstNameTextField.setText(currentEntry.getFirstName());
			         lastNameTextField.setText(currentEntry.getLastName());
			         emailTextField.setText(currentEntry.getEmail());
			         phoneTextField.setText(currentEntry.getPhoneNumber());
			         // modification
			         stateTextField.setText(currentEntry.getState());
			         // end mod
			         maxTextField.setText("" + numberOfEntries);
			         indexTextField.setText("" + (currentEntryIndex + 1));
			         nextButton.setEnabled(true);
			         previousButton.setEnabled(true);
			      } 
			      else
			         browseButtonActionPerformed(evt);       
			              
	   }
   } 

   // handles call when a new value is entered in indexTextField (indexed entry)
   private void indexTextFieldActionPerformed(ActionEvent evt)
   {
      currentEntryIndex = 
         (Integer.parseInt(indexTextField.getText()) - 1);
      
      if (numberOfEntries != 0 && currentEntryIndex < numberOfEntries)
      {
         currentEntry = results.get(currentEntryIndex);
         idTextField.setText("" + currentEntry.getAddressID());
         firstNameTextField.setText(currentEntry.getFirstName());
         lastNameTextField.setText(currentEntry.getLastName());
         emailTextField.setText(currentEntry.getEmail());
         phoneTextField.setText(currentEntry.getPhoneNumber());
         // modification
         stateTextField.setText(currentEntry.getState());
         // end mod
         maxTextField.setText("" + numberOfEntries);
         indexTextField.setText("" + (currentEntryIndex + 1));
      } 
    }

   // handles call when browseButton is clicked (browse all entries)
   private void browseButtonActionPerformed(ActionEvent evt)
   {
      try
      {
         results = personQueries.getAllPeople();
         numberOfEntries = results.size();
      
         if (numberOfEntries != 0)
         {
            currentEntryIndex = 0;
            currentEntry = results.get(currentEntryIndex);
            idTextField.setText("" + currentEntry.getAddressID());
            firstNameTextField.setText(currentEntry.getFirstName());
            lastNameTextField.setText(currentEntry.getLastName());
            emailTextField.setText(currentEntry.getEmail());
            phoneTextField.setText(currentEntry.getPhoneNumber());
            // modification
            stateTextField.setText(currentEntry.getState());
            // end mod
            maxTextField.setText("" + numberOfEntries);
            indexTextField.setText("" + (currentEntryIndex + 1));
            nextButton.setEnabled(true);
            previousButton.setEnabled(true);
         } 
      } 
      catch (Exception e)
      {
         e.printStackTrace();
      } 
   } 

   // handles call when insertButton is clicked (add new entry)
   private void insertButtonActionPerformed(ActionEvent evt) 
   {
	  if (firstNameTextField.getText().length() == 0 ||
			  lastNameTextField.getText().length() == 0 ||
			  emailTextField.getText().length() == 0 ||
			  phoneTextField.getText().length() == 0||
			  stateTextField.getText().length() == 0)
	  {
		  JOptionPane.showMessageDialog(this, "Missing field(s)",
		            "Missing field(s)", JOptionPane.PLAIN_MESSAGE);
	  }
	  else
	  {
	      int result = personQueries.addPerson(firstNameTextField.getText(),
	    	         lastNameTextField.getText(), emailTextField.getText(),
	    	         phoneTextField.getText(), 
	    	         // modification
	    	         stateTextField.getText());
	    	      	 // end mod
	    	      
	    	      if (result == 1)
	    	         JOptionPane.showMessageDialog(this, "Person added!",
	    	            "Person added", JOptionPane.PLAIN_MESSAGE);
	    	      else
	    	         JOptionPane.showMessageDialog(this, "Person not added!",
	    	            "Error", JOptionPane.PLAIN_MESSAGE);
	    	          
	    	      browseButtonActionPerformed(evt);
	  }
   }
   
   // modifications
   
   // handles call when deleteButton is clicked
   private void deleteButtonActionPerformed(ActionEvent evt)
   {
	   
	   try
	   {
		   int result = personQueries.deletePerson(currentEntry.getAddressID());
		   
		   //System.out.println(result);
		   // currently returns > 1 results if multiple entries with same name
		   if (result == 1)
		   {
			   JOptionPane.showMessageDialog(this, "Person deleted!",
					   "Person deleted", JOptionPane.PLAIN_MESSAGE);
		   }
		   else
		   {
			   JOptionPane.showMessageDialog(this, "Person not deleted!",
					  "Error", JOptionPane.PLAIN_MESSAGE);
		   }
		   
		   browseButtonActionPerformed(evt);
	   }
	   catch(NullPointerException e)
	   {
		   //System.out.println("Empty entry");
		   JOptionPane.showMessageDialog(this, "Empty entry!",
					 "Empty entry", JOptionPane.PLAIN_MESSAGE);
	   }
   }
   
   // handles call when updateButton is clicked
   private void updateButtonActionPerformed(ActionEvent evt)
   {
	   try
	   {
		   int result = personQueries.updatePerson(firstNameTextField.getText(),
			         lastNameTextField.getText(), emailTextField.getText(),
			         phoneTextField.getText(), stateTextField.getText(),
			         // using address ID, we condition our UPDATE query
				     currentEntry.getAddressID());
		   // currently returns > 1 results if multiple entries with same name
		   if (result == 1)
		   {
			   JOptionPane.showMessageDialog(this, "Person updated!",
				 "Person updated", JOptionPane.PLAIN_MESSAGE);
		   }
		   else
		   {
			   JOptionPane.showMessageDialog(this, "Person not updated!",
			     "Error", JOptionPane.PLAIN_MESSAGE);
		   }
		   browseButtonActionPerformed(evt);
	   }
	   catch(NullPointerException e)
	   {
		   JOptionPane.showMessageDialog(this, "Not valid entry!",
					 "Empty entry", JOptionPane.PLAIN_MESSAGE);
	   }
   }
   
   // end modifications
   
   // main method
   public static void main(String args[])
   {
      new AddressBookDisplay();
   } 
} // end class AddressBookDisplay


 