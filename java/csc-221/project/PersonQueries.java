// Fig. 28.31: PersonQueries.java
// PreparedStatements used by the Address Book application
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class PersonQueries 
{
   private static final String URL = "jdbc:derby:addressbook";
   private static final String USERNAME = "deitel";
   private static final String PASSWORD = "deitel";

   private Connection connection; // manages connection
   private PreparedStatement selectAllPeople; 
   private PreparedStatement selectPeopleByLastName; 
   private PreparedStatement insertNewPerson; 
   
   // modifications
   private PreparedStatement deletePerson;
   private PreparedStatement updatePerson;
   private PreparedStatement selectPeopleByState;
   //private PreparedStatement insertStateColumn;
    
   // constructor
   public PersonQueries()
   {
      try 
      {
         connection = 
            DriverManager.getConnection(URL, USERNAME, PASSWORD);
         
         /* modification (used to add State as an attribute to the database)
         //insertStateColumn = connection.prepareStatement(
          * "ALTER TABLE Addresses ADD state VARCHAR(20)");
         //insertStateColumn.executeUpdate();
         // end mod */
               
         // create query that selects all entries in the AddressBook
         selectAllPeople = 
            connection.prepareStatement("SELECT * FROM Addresses");
         
         // create query that selects entries with a specific last name
         selectPeopleByLastName = connection.prepareStatement(
            "SELECT * FROM Addresses WHERE LastName = ?");
         
         // create insert that adds a new entry into the database
         insertNewPerson = connection.prepareStatement(
            "INSERT INTO Addresses " +
            "(FirstName, LastName, Email, PhoneNumber, state) " + 
            "VALUES (?, ?, ?, ?, ?)");
         
         // deletes an entry
         deletePerson = connection.prepareStatement(
            "DELETE FROM Addresses WHERE AddressID = ?");
         
         // updates current entry
         updatePerson = connection.prepareStatement(
        	"UPDATE Addresses SET FirstName = ?, LastName = ?, Email = ?, "
        	+ "PhoneNumber = ?, state = ? " +
        	"WHERE AddressID = ?");
         
         // create query to search database by state
         selectPeopleByState = connection.prepareStatement(
        	"SELECT * FROM Addresses WHERE state = ?");
        	
      }
      catch (SQLException sqlException)
      {
         sqlException.printStackTrace();
         System.exit(1);
      }
   } // end PersonQueries constructor
   
   // select all of the addresses in the database
   public List< Person > getAllPeople()
   {
      List< Person > results = null;
      ResultSet resultSet = null;
      
      try 
      {
         // executeQuery returns ResultSet containing matching entries
         resultSet = selectAllPeople.executeQuery(); 
         results = new ArrayList< Person >();
         
         while (resultSet.next())
         {
            results.add(new Person(
               resultSet.getInt("addressID"),
               resultSet.getString("firstName"),
               resultSet.getString("lastName"),
               resultSet.getString("email"),
               resultSet.getString("phoneNumber"),
               // modifications
               resultSet.getString("state")));
         } 
      } 
      catch (SQLException sqlException)
      {
         sqlException.printStackTrace();         
      } 
      finally
      {
         try 
         {
            resultSet.close();
         } 
         catch (SQLException sqlException)
         {
            sqlException.printStackTrace();         
            close();
         }
      }
      
      return results;
   } 

   // select person by last name   
   public List<Person> getPeopleByLastName(String name)
   {
      List< Person > results = null;
      ResultSet resultSet = null;

      try 
      {
         selectPeopleByLastName.setString(1, name); // specify last name

         // executeQuery returns ResultSet containing matching entries
         resultSet = selectPeopleByLastName.executeQuery(); 

         results = new ArrayList<Person>();

         while (resultSet.next())
         {
            results.add(new Person(resultSet.getInt("addressID"),
               resultSet.getString("firstName"),
               resultSet.getString("lastName"),
               resultSet.getString("email"),
               resultSet.getString("phoneNumber"),
               // modifications
               resultSet.getString("state")));
               // end mods
         } 
      } 
      catch (SQLException sqlException)
      {
         sqlException.printStackTrace();
      } 
      finally
      {
         try 
         {
            resultSet.close();
         }
         catch (SQLException sqlException)
         {
            sqlException.printStackTrace();         
            close();
         }
      } 
      
      return results;
   } 
   
   public List<Person> getPeopleByState(String stat)
   {
	   List< Person > results = null;
	   ResultSet resultSet = null;

	   try 
	   {
		   selectPeopleByState.setString(1, stat); // specify last name

	       // executeQuery returns ResultSet containing matching entries
	       resultSet = selectPeopleByState.executeQuery(); 
	       results = new ArrayList<Person>();

	       while (resultSet.next())
	       {
	    	   results.add(new Person(resultSet.getInt("addressID"),
	           resultSet.getString("firstName"),
	           resultSet.getString("lastName"),
	           resultSet.getString("email"),
	           resultSet.getString("phoneNumber"),
	           // modifications
	           resultSet.getString("state")));
	           // end mods
	       } 
	   } 
	   catch (SQLException sqlException)
	   {
		   sqlException.printStackTrace();
	   } 
	   finally
	   {
		   try 
	       {
			   resultSet.close();
	       }
	       catch (SQLException sqlException)
	       {
	    	   sqlException.printStackTrace();         
	           close();
	       }
	   } 
	   
	   return results;	   
	   
   }
   
   // add an entry
   public int addPerson(
      String fname, String lname, String email, String num, String stat)
   {
      int result = 0;
      
      // set parameters, then execute insertNewPerson
      try 
      {
         insertNewPerson.setString(1, fname);
         insertNewPerson.setString(2, lname);
         insertNewPerson.setString(3, email);
         insertNewPerson.setString(4, num);
         // modifications
         insertNewPerson.setString(5, stat);
         // end mods

         // insert the new entry; returns # of rows updated
         result = insertNewPerson.executeUpdate(); 
      }
      catch (SQLException sqlException)
      {
         sqlException.printStackTrace();
         close();
      } 
      
      return result;
   } 
   
   // delete an entry   
   public int deletePerson(int ID)
   {
	   int result = 0;
	   
	   try
	   {
		   // set parameters then execute query deletePerson
		   deletePerson.setInt(1, ID);
		   
		   // delete entry, should return 1 as only one row updated
		   result = deletePerson.executeUpdate();
	   }
	   catch (SQLException sqlException)
	   {
		   sqlException.printStackTrace();
		   close();
	   }
	   
	   return result;
   }
   
   // update an entry
   public int updatePerson(
	String fname, String lname, String email, String num, String stat, int ID)
   {
	   int result = 0;
	   
	   try
	   {
		   updatePerson.setString(1, fname);
	   	   updatePerson.setString(2, lname);
	   	   updatePerson.setString(3, email);
	   	   updatePerson.setString(4, num);
	   	   updatePerson.setString(5, stat);
	   	   updatePerson.setInt(6, ID);
	   	   
	   	   result = updatePerson.executeUpdate();
	   }
	   catch (SQLException sqlException)
	   {
		   sqlException.printStackTrace();
	       close();
	   } 
	   	   
	   return result;
   }
   
   // close the database connection
   public void close()
   {
      try 
      {
         connection.close();
      } 
      catch (SQLException sqlException)
      {
         sqlException.printStackTrace();
      } 
   } 
} // end class PersonQueries
 