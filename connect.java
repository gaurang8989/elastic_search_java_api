import java.sql.*;

class connect
{
	public static void main(String []args)
	{
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
	    try
		{
			String username="root";
			String password="1234";
			String url = "jdbc:mysql://localhost:3306/net";
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("connection establishede");
			
			/*stmt = conn.createStatement();
			stmt.execute("create table emp(name varchar(30));");
			conn.close();*/
		}
		catch(Exception e)
		{
			System.err.println("cannot connect to the database server");
		}
		finally
		{
			if(conn != null)
			{
			try{
				conn.close();
				System.out.println("database connection terminated");
			}
			catch(Exception e){
			}	
		}			
	  }
		
}
	
}