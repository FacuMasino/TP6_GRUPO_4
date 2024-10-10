package negocioImpl;

import java.util.List;
import dao.IPersonaDao;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.IPersonaNegocio;

public class PersonaNegocioImpl implements IPersonaNegocio
{	
	IPersonaDao personaDao = new PersonaDaoImpl();

	@Override
	public boolean agregar(Persona persona)
	{
		boolean estado=false;
		//String Dni = persona.getDni();
		
			if(persona.getNombre().trim().length()>0 && persona.getApellido().trim().length()>0 && persona.getDni().trim().length()>0 )
			{
				estado=personaDao.agregar(persona);
			}

		return estado;
	}

	@Override
	public boolean eliminar(Persona persona_a_eliminar)
	{
		boolean estado=false;

		if (persona_a_eliminar.getDni().length() > 0)
		{
			estado=personaDao.eliminar(persona_a_eliminar);
		}

		return estado;
	}

	@Override
	public boolean modificar(Persona persona)
	{
		boolean estado=false;

		if(persona.getNombre().trim().length()>0 && persona.getApellido().trim().length()>0 && persona.getDni().trim().length()>0)
		{
			estado=personaDao.modificar(persona);
		}

		return estado;
	}

	@Override
	public Persona obtenerPersona(String dni)
	{
		return personaDao.obtenerPersona(dni);
	}

	@Override
	public List<Persona> readAll()
	{	
		return personaDao.readAll();
	}

	@Override
	public boolean dniDisponible(Persona persona)
	{
		
		return personaDao.dniDisponible(persona.getDni());
	}
	
	public boolean contieneTextoElDni (String dni) throws NoNumericoExcepcion 
	{
		Boolean auxTexto = false;
		
		for (int x =0; x < dni.length(); x ++) 
		{
			if (dni.charAt(x) < 48 || dni.charAt(x)> 57)
				{
					auxTexto= true; 
				}
		}
		
		if (auxTexto == true) 
		{
			NoNumericoExcepcion exc1 = new NoNumericoExcepcion();
			throw exc1;
		}
		
		if (auxTexto)
		{
			return true;
		}
		
		else
		{
			return false; 
		}
	
	}
	
	
}
