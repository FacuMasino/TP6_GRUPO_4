package main;

import java.util.ArrayList;

import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.PersonaNegocio;
import negocioImpl.PersonaNegocioImpl;
import presentacion.controlador.Controlador;
import presentacion.vista.JFPrincipal;


public class Main {

	public static void main(String[] args)
	{
		JFPrincipal vista = new JFPrincipal();
		PersonaNegocio negocio = new PersonaNegocioImpl();
		Controlador controlador = new Controlador(vista, negocio);
		controlador.inicializar();
		
		// Pruebas
		PersonaDaoImpl personaDao = new PersonaDaoImpl();
		ArrayList<Persona> listaAux = new ArrayList<>();
		listaAux = personaDao.readAll();
		
		for(Persona aux : listaAux)
		{
			System.out.println(aux.toString() + "\n");
		}
		System.out.println("\n\nBuscaste a la persona con DNI 123456789:\n");
		System.out.println(personaDao.obtenerPersona("123456789").toString());

	}
}


