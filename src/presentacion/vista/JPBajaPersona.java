package presentacion.vista;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import entidad.Persona;
import entidad.PersonasListModel;
import javax.swing.SwingConstants;

public class JPBajaPersona extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JPanel panelIzquierdo;
	private JPanel panelDerecho;
	private JPanel panelCentral;
	private PersonasListModel personasLM; 
	private JList<Persona> jlPersonas;
	private JLabel eliminarLbl; 
	private JButton btnEliminar;
	
	public JPBajaPersona()
	{	
		setLayout(new GridLayout(1, 1, 0, 0));
		
		panelIzquierdo = new JPanel();
		add(panelIzquierdo);
		panelIzquierdo.setLayout(new BorderLayout(0, 0));
		
		panelCentral = new JPanel();
		add(panelCentral);
		panelCentral.setLayout(new BorderLayout(0, 0));
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		panelCentral.add(btnEliminar, BorderLayout.SOUTH);
		
		eliminarLbl = new JLabel("Eliminar usuarios");
		eliminarLbl.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentral.add(eliminarLbl, BorderLayout.NORTH);
		
		jlPersonas = new JList<Persona>();
		panelCentral.add(jlPersonas, BorderLayout.CENTER);
		
		panelDerecho = new JPanel();
		add(panelDerecho);
	}
	
	public void setPersonasListModel(PersonasListModel personasLM)
	{
		this.personasLM = personasLM;
		
		if (this.personasLM == null)
		{
			this.personasLM = new PersonasListModel();
		}

		jlPersonas.setModel(this.personasLM);
	}
	
	public void limpiarCampos()
	{
			btnEliminar.setEnabled(false);
	}
	
	public JButton getBtnEliminar() {
		return btnEliminar;
	}
	
	public JList<Persona> getJlPersonas() {
		return jlPersonas;
	}
	
	public void mostrarMensaje(String msg)
	{
		JOptionPane.showMessageDialog(null, msg);
	}
}
