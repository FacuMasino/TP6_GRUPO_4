package main;

import java.awt.List;
import java.util.ArrayList;

import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import presentacion.controlador.Controlador;
import presentacion.vista.JFPrincipal;


public class Main {

	public static void main(String[] args)
	{
		JFPrincipal vista = new JFPrincipal();
		Controlador controlador = new Controlador(vista);
		controlador.inicializar();
		
		// Pruebas
		PersonaDaoImpl personaDao = new PersonaDaoImpl();
		ArrayList<Persona> listaAux = new ArrayList<>();
		listaAux = personaDao.readAll();
		
		for(Persona aux : listaAux)
		{
			System.out.println(aux.toString() + "\n");
		}
		//System.out.println(personaDao.obtenerPersona("321").toString());

	}
}


