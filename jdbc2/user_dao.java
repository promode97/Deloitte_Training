package jdbc2;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class user_dao  {
	
	Connection con = null;

	public user_dao()
	{
		
	}
	
	public void listUsers()
	{
		DBConnector dbcon = new DBConnector("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
		con = dbcon.getConnection();
		String sql = "select u.name,u.user_name,u.email,u.mobile_number,r.role_name\r\n" + 
				"from users u,roles r\r\n" + 
				"where u.role_id=r.role_id";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery(sql);
			while(rs.next())
			{
				System.out.println(rs.getString(1)+":"+rs.getString(2)+":"+rs.getString(3)+":"+rs.getString(4)+":"+rs.getString(5));
			}
		}catch (SQLException e) {
				System.out.println(e);
			}
		
	
	}
	
	public static void main(String [] args)
	{
		user_dao udao = new user_dao();
		udao.listUsers();
	}
}
