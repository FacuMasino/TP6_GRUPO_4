package presentacion.controlador;

import java.awt.event.ActionEvent;
import entidad.Persona;
import entidad.PersonasListModel;
import negocio.PersonaNegocio;
import presentacion.vista.JFPrincipal;
import presentacion.vista.JPAltaPersona;
import presentacion.vista.JPBajaPersona;
import presentacion.vista.JPListarPersona;
import presentacion.vista.JPModificarPersona;

public class Controlador
{
	private JFPrincipal jfPrincipal;
	private JPAltaPersona jpAltaPersona;
	private JPBajaPersona jpBajaPersona;
	private JPListarPersona jpListarPersona;
	private JPModificarPersona jpModificarPersona;
	private PersonasListModel personasLM;
	private PersonaNegocio personaNegocio;
	
	public Controlador(JFPrincipal vista, PersonaNegocio negocio)
	{
		// Panel Principal
		this.jfPrincipal = vista;
		
		// Subpaneles
		this.jpAltaPersona = new JPAltaPersona();
		this.jpBajaPersona = new JPBajaPersona();
		this.jpModificarPersona = new JPModificarPersona();
		this.jpListarPersona = new JPListarPersona();
		this.personaNegocio = negocio;
	
		// List model de personas para las listas
		this.personasLM = new PersonasListModel();
		
		// Configuración de eventos
		
		// Panel Alta
		this.jfPrincipal.getMnuItemAgregar().addActionListener
		(a->evtClickMenu_Agregar(a));
		
		this.jpAltaPersona.getBtnAceptar().addActionListener(a -> agregarPersona(a));
		
		// Panel Baja
		this.jfPrincipal.getMnuItemEliminar().addActionListener
		(a->evtClickMenu_Baja(a));
	
		// Panel Modificar
		this.jfPrincipal.getMnuItemModificar().addActionListener
		(a->evtClickMenu_Modificar(a));
		
		// Panel Listar
		this.jfPrincipal.getMnuItemListar().addActionListener
		(a->evtClickMenu_Listar(a));
	}
	
	private void agregarPersona(ActionEvent a)
	{
		Persona persona = new Persona();
		persona.setApellido(this.jpAltaPersona.getTxtApellido().getText());
		persona.setNombre(this.jpAltaPersona.getTxtNombre().getText());
		persona.setDni(this.jpAltaPersona.getTxtDni().getText());
		this.personaNegocio.agregar(persona);
		this.jpAltaPersona.getTxtApellido().setText("");
		this.jpAltaPersona.getTxtNombre().setText("");
		this.jpAltaPersona.getTxtDni().setText("");
	}
	
	private void evtClickMenu_Agregar(ActionEvent a)
	{
		this.jfPrincipal.getContentPane().removeAll();
		this.jfPrincipal.getContentPane().add(jpAltaPersona);
		this.jfPrincipal.getContentPane().repaint();
		this.jfPrincipal.getContentPane().revalidate();	
	}
	
	private void evtClickMenu_Baja(ActionEvent a)
	{
		this.jfPrincipal.getContentPane().removeAll();
		jpBajaPersona.setPersonasListModel(personasLM);
		this.jfPrincipal.getContentPane().add(jpBajaPersona);
		this.jfPrincipal.getContentPane().repaint();
		this.jfPrincipal.getContentPane().revalidate();	
	}
	
	private void evtClickMenu_Modificar(ActionEvent a)
	{
		this.jfPrincipal.getContentPane().removeAll();
		jpModificarPersona.setPersonasListModel(personasLM);
		this.jfPrincipal.getContentPane().add(jpModificarPersona);
		this.jfPrincipal.getContentPane().repaint();
		this.jfPrincipal.getContentPane().revalidate();	
	}

	private void evtClickMenu_Listar(ActionEvent a)
	{
		this.jfPrincipal.getContentPane().removeAll();
		jpListarPersona.setPersonasListModel(personasLM);
		this.jfPrincipal.getContentPane().add(jpListarPersona);
		this.jfPrincipal.getContentPane().repaint();
		this.jfPrincipal.getContentPane().revalidate();	
	}	

	public void inicializar()
	{
		this.jfPrincipal.setVisible(true);
	}
}
