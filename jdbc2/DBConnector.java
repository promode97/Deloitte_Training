package jdbc2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	
	private String url;
	private String pass;
	private String user;
	
	public DBConnector(){}
	public DBConnector(String url, String pass, String user) {
		super();
		this.url = url;
		this.pass = pass;
		this.user = user;
	}
	
	public Connection getConnection()
	{
		Connection con=null;
		try{
			con=DriverManager.getConnection(url, user, pass);
			System.out.println("connection successful");
		}
		catch(SQLException e)
		{
			System.out.println("connection failed" +e);
		}
		return con;			
	}
	
	public static void main(String[] args)
	{
		DBConnector dbcon= new DBConnector("jdbc:oracle;thin;@localhost:1521:orc1","hr","hr");
		Connection con=dbcon.getConnection();
		System.out.println(con);
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "DBConnector [url=" + url + ", pass=" + pass + ", user=" + user + "]";
	}
	
	

}



