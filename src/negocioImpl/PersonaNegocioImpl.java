package negocioImpl;

import java.util.List;
import dao.PersonaDao;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.PersonaNegocio;

public class PersonaNegocioImpl implements PersonaNegocio
{	
	PersonaDao personaDao = new PersonaDaoImpl();

	@Override
	public boolean agregar(Persona persona)
	{
		boolean estado=false;
		
		if(persona.getNombre().trim().length()>0 && persona.getApellido().trim().length()>0 && persona.getDni().trim().length()>0)
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
}
