package main;

import java.awt.List;
import java.util.ArrayList;

import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import presentacion.vista.JFMenuPrincipal;


public class Main {

	public static void main(String[] args)
	{
		
		PersonaDaoImpl personaDao = new PersonaDaoImpl();
		Persona persona = new Persona();
		Persona persona1 = new Persona();
		ArrayList<Persona> listaAux = new ArrayList<>();
		listaAux = personaDao.readAll();
		
		persona.setDni("34294954");
		persona.setNombre("Carlos");
		persona.setApellido("Berligieri");
		
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
		
		//boolean exito = personaDao.agregar(persona);
		
		//boolean exito = personaDao.eliminar(persona);
		
		//voy a sobreescribir esta persona, uso metodo modificar
		/*
		persona.setDni("34294954");
		persona.setNombre("Carloncho");
		persona.setApellido("Perez");
		
		personaDao.modificar(persona);
		*/
		
		JFMenuPrincipal menu = new JFMenuPrincipal();
		menu.setVisible(true);
		boolean exito = true;
		
		if (exito)
		{
			System.out.println("SAPE!");
			for(Persona aux : listaAux)
			{
				System.out.println(aux.toString() + "\n");
			}
			//System.out.println(personaDao.obtenerPersona("321").toString());
			
		}
		else
		{
			System.out.println("ERROR");
		}

	}
}


