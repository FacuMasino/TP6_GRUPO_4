package main;

import dao.PersonaDao;
import entidad.Persona;

public class main
{
	public static void main(String[] args)
	{
		PersonaDao personaDao = new PersonaDao();
		Persona persona = new Persona();
		
		persona.setDni("34294954");
		persona.setNombre("Carlos");
		persona.setApellido("Berligieri");
		
		int rows = personaDao.agregar(persona);
		
		if (0 < rows)
		{
			System.out.println("SAPE!");
		}
		else
		{
			System.out.println("ERROR");
		}
	}
}