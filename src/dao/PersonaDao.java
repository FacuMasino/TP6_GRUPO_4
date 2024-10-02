package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import entidad.Persona;

public class PersonaDao
{
	private String host;
	private String user;
	private String pass;
	private String dbName;
	
	public PersonaDao()
	{
		host = "jdbc:mysql://localhost:3306/";
		user = "root";
		pass = "ACAVATUCLAVEDELABASEDEDATOS";
		dbName = "bdPersonas";
	}
	
	public int agregar(Persona persona)
	{
		String query = "INSERT INTO Personas (Dni, Nombre, Apellido) VALUES (?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rows = 0;
		
		try
		{
			conn = DriverManager.getConnection(host + dbName, user, pass);
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, persona.getDni());
			pstmt.setString(2, persona.getNombre());
			pstmt.setString(3, persona.getApellido());
			
			rows = pstmt.executeUpdate();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		
		return rows;
	}
}
