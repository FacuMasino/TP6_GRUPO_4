package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.IPersonaDao;
import entidad.Persona;

public class PersonaDaoImpl implements IPersonaDao
{
	private String insertQry;
	private String modifyQry;
	private String deleteQry;
	private String readAllQry;
	private String obtenerQry;
	private String selectDniQry;
	
	public PersonaDaoImpl()
	{
		insertQry = "INSERT INTO Personas (Dni, Nombre, Apellido) VALUES (?, ?, ?)";
		modifyQry = "UPDATE Personas SET Nombre = ? , Apellido = ? WHERE Dni = ?";
		deleteQry = "DELETE from Personas WHERE Dni = ?";
		readAllQry = "SELECT * FROM Personas";
		obtenerQry = "SELECT * FROM Personas WHERE Dni = ?";
		selectDniQry = "SELECT * FROM Personas Where Dni = ?";
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
			pstmt.setString(2, persona.getNombre(). toUpperCase());
			pstmt.setString(3, persona.getApellido(). toUpperCase());
			
			rows = pstmt.executeUpdate();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
		
		return (rows > 0);
	}

	@Override
	public boolean eliminar(Persona persona)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rows = 0;
		
		try
		{
			Conexion conexion = new Conexion();
			conn = conexion.getSQLConexion();
			pstmt = conn.prepareStatement(deleteQry);
			
			pstmt.setString(1, persona.getDni());
			
			rows = pstmt.executeUpdate();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		
		return (rows > 0);
	}

	@Override
	public boolean modificar(Persona persona)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rows = 0;
		
		try
		{
			Conexion conexion = new Conexion();
			conn = conexion.getSQLConexion();
			pstmt = conn.prepareStatement(modifyQry);
			
			pstmt.setString(1, persona.getNombre().toUpperCase());
			pstmt.setString(2, persona.getApellido().toUpperCase());
			pstmt.setString(3, persona.getDni());
			
			rows = pstmt.executeUpdate();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		
		return (rows > 0);
	}

	@Override
	public ArrayList<Persona> readAll()
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		ResultSet resultSet;
		ArrayList<Persona> personas = new ArrayList<Persona>();

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
	
	@Override
	public Persona obtenerPersona(String dni)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		ResultSet resultSet;
		Persona persona = new Persona();
		
		try 
		{
			Conexion conexion = new Conexion();
			conn = conexion.getSQLConexion();
			pstmt = conn.prepareStatement(obtenerQry);
			pstmt.setString(1, dni);
			resultSet = pstmt.executeQuery();
			
			resultSet.next();
			
			persona = getPersona(resultSet);
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return persona;
	}
	
	private Persona getPersona(ResultSet resultSet) throws SQLException
	{
		String dni = resultSet.getString("Dni");
		String nombre = resultSet.getString("Nombre");
		String apellido = resultSet.getString("Apellido");
		return new Persona(dni, nombre, apellido);
	}

	@Override
	public boolean dniDisponible(String dni) 
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		ArrayList<Persona> personas = new ArrayList<Persona>();
		
		try
		{
			Conexion conexion = new Conexion();
			conn = conexion.getSQLConexion();
			pstmt = conn.prepareStatement(selectDniQry);
			
			pstmt.setString(1,dni);
			
			resultSet = pstmt.executeQuery();
			
			while(resultSet.next())
			{
				personas.add(getPersona(resultSet));
			}
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			
		}
		
		if(personas.isEmpty())
		{
			return true;
		}
		return false;
	}
}
