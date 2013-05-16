package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
	
	/**
	 * Meetod, milles luuakse andmebaasiga ühendus läbi jdbc driveri.
	 * @return - null, kui ühendust ei looda.
	 * 
	 * Imbisse ühendumsieks:	
	 * 	String url = "jdbc:postgresql://imbi.ld.ttu.ee:5432/t104348_ladu";
		String userName = "t103770";
		String passWord = "TRiyZCAd";
	 */
	public Connection getConnection(){
		
		String url = "jdbc:postgresql://localhost:5432/R11_ladu";
		String userName = "postgres";
		String passWord = "admin";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, userName, passWord);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
