package main;

import java.awt.List;
import java.util.ArrayList;

import daoImpl.PersonaDaoImpl;
import entidad.Persona;


public class Main {

	public static void main(String[] args)
	{
		
		PersonaDaoImpl personaDao = new PersonaDaoImpl();
		Persona persona = new Persona();
		Persona persona1 = new Persona();
		/*
		persona.setDni("34294954");
		persona.setNombre("Carlos");
		persona.setApellido("Berligieri");
		*/
		/*
		persona.setDni("123");
		persona.setNombre("Tomas");
		persona.setApellido("Masto");
		*/
		/*
		persona1.setDni("321");
		persona1.setNombre("Simone");
		persona1.setApellido("De Beauvoir");
		*/
		
		//boolean exito = personaDao.agregar(persona1);
		
		//boolean exito = personaDao.eliminar(persona);
		
		boolean exito = true;
		ArrayList<Persona> listaAux = new ArrayList<>();
		listaAux = personaDao.readAll();
		if (exito)
		{
			System.out.println("SAPE!");
			for(Persona aux : listaAux)
			{
				System.out.println(aux.toString() + "\n");
			}
			
		}
		else
		{
			System.out.println("ERROR");
		}

	}
}


