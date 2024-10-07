package main;

import daoImpl.PersonaDaoImpl;
import entidad.Persona;


public class Main {

	public static void main(String[] args)
	{
		
		PersonaDaoImpl personaDao = new PersonaDaoImpl();
		Persona persona = new Persona();
		
		/*
		persona.setDni("34294954");
		persona.setNombre("Carlos");
		persona.setApellido("Berligieri");
		*/
		persona.setDni("123");
		persona.setNombre("Tomas");
		persona.setApellido("Masto");
		
		
		
		//boolean exito = personaDao.agregar(persona);
		boolean exito = personaDao.eliminar(persona);
		
		if (exito)
		{
			System.out.println("SAPE!");
		}
		else
		{
			System.out.println("ERROR");
		}

	}
}


