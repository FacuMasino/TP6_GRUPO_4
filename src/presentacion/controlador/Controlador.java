package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entidad.PersonasListModel;
import presentacion.vista.JFPrincipal;
import presentacion.vista.JPAltaPersona;
import presentacion.vista.JPBajaPersona;
import presentacion.vista.JPModificarPersona;

public class Controlador {
	
	private JFPrincipal jfPrincipal;
	private JPAltaPersona jpAltaPersona;
	private JPBajaPersona jpBajaPersona;
	private JPModificarPersona jpModificarPersona;
	private PersonasListModel personasLM;
	
	public Controlador(JFPrincipal vista){
		
		// Panel Principal
		this.jfPrincipal = vista;
		
		// Subpaneles
		this.jpAltaPersona = new JPAltaPersona();
		this.jpBajaPersona = new JPBajaPersona();
		this.jpModificarPersona = new JPModificarPersona();
	
		// List model de personas para las listas
		this.personasLM = new PersonasListModel();
		
		// Configuración de eventos
		
		// Panel Alta
		this.jfPrincipal.getMnuItemAgregar().addActionListener
		(a->evtClickMenu_Agregar(a));
		
		// Panel Baja
		this.jfPrincipal.getMnuItemEliminar().addActionListener
		(a->evtClickMenu_Baja(a));
	
		// Panel Modificar
		this.jfPrincipal.getMnuItemModificar().addActionListener
		(a->evtClickMenu_Modificar(a));
	}
	
	private void evtClickMenu_Agregar(ActionEvent a) {
		this.jfPrincipal.getContentPane().removeAll();
		this.jfPrincipal.getContentPane().add(jpAltaPersona);
		this.jfPrincipal.getContentPane().repaint();
		this.jfPrincipal.getContentPane().revalidate();	
	}
	
	private void evtClickMenu_Baja(ActionEvent a) {
		this.jfPrincipal.getContentPane().removeAll();
		jpBajaPersona.setPersonasListModel(personasLM);
		this.jfPrincipal.getContentPane().add(jpBajaPersona);
		this.jfPrincipal.getContentPane().repaint();
		this.jfPrincipal.getContentPane().revalidate();	
	}
	
	private void evtClickMenu_Modificar(ActionEvent a) {
		this.jfPrincipal.getContentPane().removeAll();
		jpModificarPersona.setPersonasListModel(personasLM);
		this.jfPrincipal.getContentPane().add(jpModificarPersona);
		this.jfPrincipal.getContentPane().repaint();
		this.jfPrincipal.getContentPane().revalidate();	
	}
	
	public void inicializar() {
		this.jfPrincipal.setVisible(true);
	}

}
