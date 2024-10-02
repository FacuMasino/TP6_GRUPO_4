package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import dao.PersonaDao;
import entidad.Persona;

public class PersonaDaoImpl implements PersonaDao 
{
	String insertQry;
	
	public PersonaDaoImpl()
	{
		insertQry = "INSERT INTO Personas (Dni, Nombre, Apellido) VALUES (?, ?, ?)";
	}
	
	@Override
	public boolean agregar(Persona persona)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rows = 0;
		
		try
		{
			Conexion conexion = new Conexion();
			conn = conexion.getSQLConexion();
			pstmt = conn.prepareStatement(insertQry);
			
			pstmt.setString(1, persona.getDni());
			pstmt.setString(2, persona.getNombre());
			pstmt.setString(3, persona.getApellido());
			
			rows = pstmt.executeUpdate();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		
		return (rows > 0);
	}
}
