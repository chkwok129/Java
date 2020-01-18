import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
//Edit by Chit Hang Kwok
//This program is to conect the database to the java program
	public static Connection pmartConnection() {
		// TODO Auto-generated constructor stub
		Connection con = null;
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
		}
		return con;
	}

}
