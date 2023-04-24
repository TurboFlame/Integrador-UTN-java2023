import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	
	
	
	
	
	public static ResultSet getResultSet(String tabla) throws SQLException {
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","2440");
	Statement stmt=con.createStatement();
	ResultSet rs=stmt.executeQuery("SELECT * FROM " + tabla);
	return rs;	
	}

	
	
	public static void closeConnection(Connection con) throws SQLException{
	if (con!=null) {
	con.close();
	}
	
	
}
	
	

}
