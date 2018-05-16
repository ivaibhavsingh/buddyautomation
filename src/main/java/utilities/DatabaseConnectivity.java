package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectivity {


	public static Connection makeConn() throws ClassNotFoundException {
	    Connection con = null;
	    try {
	      Class.forName("com.mysql.jdbc.Driver");
	      con = DriverManager.getConnection("jdbc:mysql://52.66.5.239:3306/bidnwin","root","admin");
	      System.out.println("DB CONN");
	    } catch (SQLException e) {
	      System.err.println("Error While Creating Connection to db" + e);
	    }
	    return con;
	  }

	public static void deleteBid() throws SQLException, ClassNotFoundException {

	    Connection con1 = null;
	    con1=makeConn();
	    java.sql.Statement stmt = con1.createStatement();
	    int rs =stmt.executeUpdate("delete from BidingTransactions where userId = 63");
	    System.out.println(rs);
	    System.out.println("Bids for your user have been deleted");
	    con1.close();
	    
     }
}