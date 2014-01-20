import java.sql.*;
import java.util.ArrayList;


public class DatabaseConnect {
	private ArrayList<String> recipeNamesBreakfast = new ArrayList<String>();
	private ArrayList<String> recipeNamesLunch = new ArrayList<String>();
	private ArrayList<String> recipeNamesDinner = new ArrayList<String>();
	
	public DatabaseConnect() {

	
	try{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/food","root","");
		
		//create statement object for sending SQL statements to the database
		Statement sqlState = con.createStatement();
		
		String selectBreakfast = "SELECT Name FROM breakfast";
		String selectLunch = "SELECT Name FROM lunch";
		String selectDinner = "SELECT Name FROM dinner";
		
		//contains all results of query
		ResultSet rowsBreakfast = sqlState.executeQuery(selectBreakfast);
		
		while(rowsBreakfast.next()) {
			recipeNamesBreakfast.add(rowsBreakfast.getString("Name"));//create array of meal objects
		}
		rowsBreakfast.close();
		
		ResultSet rowsLunch = sqlState.executeQuery(selectLunch);
		while(rowsLunch.next()) {
			recipeNamesLunch.add(rowsLunch.getString("Name"));
		}
		rowsLunch.close();
		
		ResultSet rowsDinner = sqlState.executeQuery(selectDinner);
		while(rowsDinner.next()) {
			recipeNamesDinner.add(rowsDinner.getString("Name"));
		}
		rowsDinner.close();
	
	}
	catch(SQLException e){
		System.out.println("SQLException: " + e.getMessage());
	}
	catch(ClassNotFoundException ex){
		ex.printStackTrace();
	}
} //End of Constructor
	
//Methods
public ArrayList<String> breakfastArrayItems(){
				return recipeNamesBreakfast;
}

public ArrayList<String> lunchArrayItems(){
				return recipeNamesLunch;
}

public ArrayList<String> dinnerArrayItems(){
				return recipeNamesDinner;
}
/*
 
class Recipe {





}
 			
 			
 			
 			
 			
 			
 */
	
	
	
}//End of Code