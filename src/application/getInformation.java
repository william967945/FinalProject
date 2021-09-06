package application;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class getInformation {
	Datebase datebase=new Datebase();
	Connection conn=null;
	ResultSet re=null;
	Statement stat=null;
	boolean flag=true;
	
public boolean Login(String username ,String password)
{
	try {
		conn= datebase.getconn();
		stat=conn.createStatement();
		re=stat.executeQuery("SELECT * FROM Account WHERE Username='"+username+"'AND Password='"+password+"'");
	if(re.next())
	{flag=true;}
	else
	{flag=false;}
		
	}
	catch(SQLException sqle)
	{
		System.out.print(sqle);
	}
	return flag;
}
public boolean signUp(String username ,String password,String gender)
{
	try {
		conn=datebase.getconn();
		stat=conn.createStatement();
		String query=("INSERT INTO Account(Username,Password,Gender) VALUES(?,?,?)");
		PreparedStatement ps=conn.prepareStatement(query);
		ps.setString(1, username);
		ps.setString(2, password);
		ps.setString(3, gender);
		int row =ps.executeUpdate();
		if(row>0)
		{flag=true;}
		else
		{flag=false;}
		
	}
	catch(SQLException sqle)
	{
		System.out.print(sqle);
	}
	return flag;
	}


}


