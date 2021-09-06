package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Datebase {
	Connection conn=null;
	
	public Connection getconn()
	{
		String url = "jdbc:mysql://140.119.19.73:9306/MG11?useUnicode=true&characterEncoding=utf8";
		String username = "MG11";
		String password = "Lczhnp";
		try {
			conn =(Connection) DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return conn;
	}

}
