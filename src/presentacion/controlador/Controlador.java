package presentacion.controlador;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;

import entidad.Persona;
import entidad.PersonasListModel;
import entidad.PersonasTableModel;
import negocio.IPersonaNegocio;
import negocioImpl.DNINoDisponibleExcepcion;
import negocioImpl.NoCaracterExcepcion;
import negocioImpl.NoNumericoExcepcion;
import presentacion.vista.JFPrincipal;
import presentacion.vista.JPAltaPersona;
import presentacion.vista.JPBajaPersona;
import presentacion.vista.JPListarPersonas;
import presentacion.vista.JPModificarPersona;

public class Controlador
{
	private JFPrincipal jfPrincipal;
	private JPAltaPersona jpAltaPersona;
	private JPBajaPersona jpBajaPersona;
	private JPListarPersonas jpListarPersonas;
	private JPModificarPersona jpModificarPersona;
	private PersonasListModel personasLM;
	private PersonasTableModel personasTM;
	private IPersonaNegocio personaNegocio;
	private JOptionPane message;
	
	public Controlador(JFPrincipal vista, IPersonaNegocio negocio)
	{
		// Panel Principal
		this.jfPrincipal = vista;
		
		// Subpaneles
		this.jpAltaPersona = new JPAltaPersona();
		this.jpBajaPersona = new JPBajaPersona();
		this.jpModificarPersona = new JPModificarPersona();
		this.jpListarPersonas = new JPListarPersonas();
		this.personaNegocio = negocio;
	
		// Models
		this.personasLM = new PersonasListModel();
		this.personasTM = new PersonasTableModel();
		
		// Configuración de eventos Menu
		
		// Panel Alta
		this.jfPrincipal.getMnuItemAgregar().addActionListener
		(a->evtClickMenu_Agregar(a));
		
		// Panel Baja
		this.jfPrincipal.getMnuItemEliminar().addActionListener
		(a->evtClickMenu_Baja(a));
		
	
		// Panel Modificar
		this.jfPrincipal.getMnuItemModificar().addActionListener
		(a->evtClickMenu_Modificar(a));
		
		// Panel Listar
		this.jfPrincipal.getMnuItemListar().addActionListener
		(a->evtClickMenu_Listar(a));
		
		// Configuración de eventos JPAltaPersona
		
		this.jpAltaPersona.getBtnAceptar().addActionListener
		(a -> agregarPersona(a));
		
		this.jpAltaPersona.getTxtDni().addKeyListener
		(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				evtKeyTyped_SoloDigitos(e);
			}
		});
		
		this.jpAltaPersona.getTxtApellido().addKeyListener
		(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				evtKeyTyped_SoloLetras(e);
			}
		});
		
		this.jpAltaPersona.getTxtNombre().addKeyListener
		(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				evtKeyTyped_SoloLetras(e);
			}
		});
		
		// Configuración de eventos JPModificarPersona
		
		// Seleccion de persona
		this.jpModificarPersona.getJlPersonas().addListSelectionListener
		(a->evtJListValueChanged_Modificar(a));
		// Modificar persona
		this.jpModificarPersona.getBtnModificar().addActionListener
		(a->evtClickBtn_Modificar(a));
		
		
		// Configuración de eventos JPBajaPersona
		
		// Seleccion de persona
		this.jpBajaPersona.getJlPersonas().addListSelectionListener
		(a->evtJListValueChanged_Eliminar(a));                    
		//Eliminar persona 
		this.jpBajaPersona.getBtnEliminar().addActionListener
		(a->evtClickBtn_Eliminar(a));
		
	}
	
	private void agregarPersona(ActionEvent a)
	{ 
		Persona persona = new Persona();
		persona.setApellido(this.jpAltaPersona.getTxtApellido().getText());
		persona.setNombre(this.jpAltaPersona.getTxtNombre().getText());
		persona.setDni(this.jpAltaPersona.getTxtDni().getText());
		
		String Dni = jpAltaPersona.getTxtDni().getText();
		
		if(hayCamposVacios(persona)) return;
		
		// Si se pudo agregar la persona, se debe actualizar el ListModel
		// y limpiar campos
		try
		{
			if(this.personaNegocio.agregar(persona))
			{
				actualizarPersonasLM();
				this.jpAltaPersona.getTxtApellido().setText("");
				this.jpAltaPersona.getTxtNombre().setText("");
				this.jpAltaPersona.getTxtDni().setText("");
				
				JOptionPane.showMessageDialog(null, "¡Persona agregada exitosamente!", "Todo OK!", JOptionPane.INFORMATION_MESSAGE,null);
			}
		}
		catch (NoCaracterExcepcion | NoNumericoExcepcion e)
		{
			jfPrincipal.mostrarMensaje(e.getMessage(),JOptionPane.ERROR_MESSAGE);
		}
		catch (DNINoDisponibleExcepcion e) {
			jfPrincipal.mostrarMensaje(e.getMessage(), JOptionPane.WARNING_MESSAGE);
		}
		catch (Exception e) {
			e.printStackTrace();
			jfPrincipal.mostrarMensaje("Ocurrio un error inesperado al agregar la persona", JOptionPane.ERROR_MESSAGE);
		}
		
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
		if(personasLM.getSize() == 0) personasLM.addElements(personaNegocio.readAll());
		jpBajaPersona.setPersonasListModel(personasLM);
		this.jfPrincipal.getContentPane().add(jpBajaPersona);
		this.jfPrincipal.getContentPane().repaint();
		this.jfPrincipal.getContentPane().revalidate();		
		
	}
	
	private void evtClickMenu_Modificar(ActionEvent a)
	{
		this.jfPrincipal.getContentPane().removeAll();
		if(personasLM.getSize() == 0) personasLM.addElements(personaNegocio.readAll());
		jpModificarPersona.setPersonasListModel(personasLM);
		this.jfPrincipal.getContentPane().add(jpModificarPersona);
		this.jfPrincipal.getContentPane().repaint();
		this.jfPrincipal.getContentPane().revalidate();	
	}

	private void evtClickMenu_Listar(ActionEvent a)
	{
		this.jfPrincipal.getContentPane().removeAll();
		personasTM.addAllElements(personaNegocio.readAll());
		jpListarPersonas.setPersonasTableModel(personasTM);
		this.jfPrincipal.getContentPane().add(jpListarPersonas);
		this.jfPrincipal.getContentPane().repaint();
		this.jfPrincipal.getContentPane().revalidate();	
	}
	
	public void evtJListValueChanged_Modificar(ListSelectionEvent e)
	{
		// Si aún no suelta el botón del mouse, salir del evento
		// porque el valor seleccionado puede cambiar
		if(e.getValueIsAdjusting()) return;
		
		Persona auxPersona = this.jpModificarPersona.getJlPersonas().getSelectedValue();
		this.jpModificarPersona.getBtnModificar().setEnabled(true);
		this.jpModificarPersona.getTxtNombre().setText(auxPersona.getNombre());
		this.jpModificarPersona.getTxtApellido().setText(auxPersona.getApellido());
		this.jpModificarPersona.getTxtDNI().setText(auxPersona.getDni());
	}

	public void evtClickBtn_Modificar(ActionEvent a)
	{
		Persona personaSeleccionada = this.jpModificarPersona.getJlPersonas().getSelectedValue(); 
		Persona personaModificada = new Persona();
		personaModificada.setDni(personaSeleccionada.getDni());
		personaModificada.setNombre(this.jpModificarPersona.getTxtNombre().getText());
		personaModificada.setApellido(this.jpModificarPersona.getTxtApellido().getText());
		
		if(personaModificada.getNombre().isEmpty() || personaModificada.getNombre().isEmpty())
		{
			jpModificarPersona.mostrarMensaje("Debe completar todos los campos");
			return;
		}
		
		if(!personaNegocio.modificar(personaModificada))
		{
			jpModificarPersona.mostrarMensaje("Ocurrió un problema, no se pudo modificar la persona");
			return;
		}
		
		actualizarPersonasLM();
		
		JOptionPane.showMessageDialog(null, "Persona modificada exitosamente!", "Todo OK!", JOptionPane.INFORMATION_MESSAGE,null);
		
		jpModificarPersona.limpiarCampos();
		
	}
	
	public void evtJListValueChanged_Eliminar(ListSelectionEvent e)
	{
		// Si aún no suelta el botón del mouse, salir del evento
		// porque el valor seleccionado puede cambiar
		if(e.getValueIsAdjusting()) return;
		
		Persona auxPersona = this.jpBajaPersona.getJlPersonas().getSelectedValue();
		this.jpBajaPersona.getBtnEliminar().setEnabled(true);
	
	}
	
	public void evtClickBtn_Eliminar(ActionEvent a)
	{
		
		Persona personaSeleccionada = this.jpBajaPersona.getJlPersonas().getSelectedValue(); 
		
	
		if(personaNegocio.eliminar(personaSeleccionada))
		{
			jpBajaPersona.mostrarMensaje("Persona eliminada exitosamente");
			actualizarPersonasLM();
			
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Error al eliminar persona.." ,"Error", JOptionPane.ERROR_MESSAGE);
		}
		
		if (personasLM.getSize() == 0)
		{
			JOptionPane.showMessageDialog(null, "No hay más personas en la lista" ,"Error", JOptionPane.ERROR_MESSAGE);
		}
		
	
	}
	
	private void evtKeyTyped_SoloDigitos(KeyEvent e)
	{
		char caracter = e.getKeyChar();
		if (((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE)
		&& (caracter != '.') ) 
		{
			e.consume();
		}
	}
	
	private void evtKeyTyped_SoloLetras(KeyEvent e) {
	    char caracter = e.getKeyChar();
	    if (!Character.isLetter(caracter) && 
	        caracter != KeyEvent.VK_BACK_SPACE) {
	        e.consume();
	    }
	}
		
	private void actualizarPersonasLM()
	{
		personasLM.clear();
		personasLM.addElements(personaNegocio.readAll());
	}
	
	public void inicializar()
	{
		this.jfPrincipal.setVisible(true);
	}
	
	public boolean hayCamposVacios (Persona persona) 
	{
		int ContadorVacios = 0;
		
		if (this.jpAltaPersona.getTxtNombre().getText().equals("")) 
		{ 
			ContadorVacios= ContadorVacios+1;
		}
		
		if ( this.jpAltaPersona.getTxtDni().getText().equals(""))
		{ 
			ContadorVacios= ContadorVacios+1;
		}
		
		if (this.jpAltaPersona.getTxtApellido().getText().equals(""))
		{ 
			ContadorVacios= ContadorVacios+1;
		}
		
		if(ContadorVacios == 0) return false;
		 
		if (ContadorVacios == 1)
		{
			JOptionPane.showMessageDialog(null, "¡Ingrese el campo faltante!", "Error",JOptionPane.ERROR_MESSAGE);
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "¡Ingrese los campos faltantes!", "Error",JOptionPane.ERROR_MESSAGE); 
		}
		
		return true;
		
	}
	
}
