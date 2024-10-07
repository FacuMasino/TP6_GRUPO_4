package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PersonaDao;
import entidad.Persona;

public class PersonaDaoImpl implements PersonaDao 
{
	private String insertQry;
	private String modifyQry;
	private String deleteQry;
	private String readAllQry;
	
	public PersonaDaoImpl()
	{
		insertQry = "INSERT INTO Personas (Dni, Nombre, Apellido) VALUES (?, ?, ?)";
		modifyQry = "ACA VA LA QUERY PARA MODIFICAR";
		deleteQry = "DELETE from Personas WHERE Dni = ?";
		readAllQry = "SELECT * FROM Personas";
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

	@Override
	public boolean eliminar(Persona persona_a_eliminar)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rows = 0;
		
		try
		{
			Conexion conexion = new Conexion();
			conn = conexion.getSQLConexion();
			pstmt = conn.prepareStatement(deleteQry);
			
			pstmt.setString(1,persona_a_eliminar.getDni());
			
			rows = pstmt.executeUpdate();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		
		return (rows > 0);
	}

	@Override
	public boolean modificar(Persona persona) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Persona> readAll() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		ResultSet resultSet;
		ArrayList<Persona> personas = new ArrayList<Persona>();
		///////////////////////
		//ACA
		///////////////////////
		try 
		{
			Conexion conexion = new Conexion();
			conn = conexion.getSQLConexion();
			pstmt = conn.prepareStatement(readAllQry);
			resultSet = pstmt.executeQuery();
			while(resultSet.next())
			{
				personas.add(getPersona(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return personas;
	}
	
	
	private Persona getPersona(ResultSet resultSet) throws SQLException
	{
		String dni = resultSet.getString("Dni");
		String nombre = resultSet.getString("Nombre");
		String apellido = resultSet.getString("Apellido");
		return new Persona(dni, nombre, apellido);
	}
}
