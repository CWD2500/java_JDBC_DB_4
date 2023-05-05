package DataBases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;

public class Closeded {

	public static void main(String[] args) throws SQLException {

		// Closeded
		ResultSet result = null;
		try (
			
				Connection con = DBInfo.connectDB();
				Statement state = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
	
				
				
				) {
			
			state.executeUpdate("DROP TABLE IF EXISTS personals");
			String sql = "CREATE TABLE personals ("
					+ "preosnID int  , firstName varchar(255),"+
					"lastName varchar(255) ,address Text";
			state.executeUpdate(sql);
			System.out.println("Don Created ..!");
			
			state.setMaxRows(3);
			result = state
			.executeQuery("SELECT `employeeID`, `firstName` ,`lastName` FROM `employee`");
			while (result.next())

			{
//				NumberFormat nF = NumberFormat.getCurrencyInstance();
//				Double  d = result.getDouble("salart");
//				String salary = nF.format(d);

//				System.out.println("jobs :" + result.getInt("jobID")+" "+"-> " 
//			+ result.getString("jobTitle") 
//			+ " !  Description ?" + result.getString("jobDescription") +
//			" "  );	
			}

			System.out.println("-----------------");
			result.absolute(1);

			System.out.println("get row  1 :" + result.getNString("firstName"));
			result.first();
			System.out.println("First Name  :" + result.getNString("firstName"));
			result.last();
			System.out.println("Last Name :" + result.getNString("lastName"));
//			result.beforeFirst();
//			System.out.println("beforeFirst :" + result.getString("firstName"));
			result.getRow();
			System.out.println("get row   :" + result.getInt("employeeID"));
			// result.last();
			// System.out.println(result.getRow());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			result.close();
		}

	}

}
