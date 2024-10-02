package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion 
{
	private static Connection conn;
	
	private String host;
	private String user;
	private String pass;
	private String dbName;
	
	public Conexion()
	{
		host = "jdbc:mysql://localhost:3306/";
		user = "root";
		pass = "ACAVATUCLAVEDELABASEDEDATOS";
		dbName = "bdPersonas";
	}
	
	public Connection getSQLConexion()   
	{
		try
		{
			if(conn == null || conn.isClosed())
			{
				conn = DriverManager.getConnection(host + dbName, user, pass);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void cerrar()
	{
		try 
		{
			conn.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
