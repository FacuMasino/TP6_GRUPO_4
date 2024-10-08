package presentacion.vista;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.BorderLayout;
import entidad.Persona;
import entidad.PersonasListModel;
import javax.swing.SwingConstants;

public class JPBajaPersona extends JPanel {
	

	private static final long serialVersionUID = 1L;
	private JPanel panelIzquierdo;
	private JPanel panelDerecho;
	private JPanel panelCentral;
	private PersonasListModel personasLM; 
	private JList<Persona> personasLst;
	private JLabel eliminarLbl; 
	private JButton btnEliminar;

	
	public JPBajaPersona() {
		
		setLayout(new GridLayout(1, 1, 0, 0));
		
		panelIzquierdo = new JPanel();
		add(panelIzquierdo);
		panelIzquierdo.setLayout(new BorderLayout(0, 0));
		
		panelCentral = new JPanel();
		add(panelCentral);
		panelCentral.setLayout(new BorderLayout(0, 0));
		
		btnEliminar = new JButton("Eliminar");
		panelCentral.add(btnEliminar, BorderLayout.SOUTH);
		
		eliminarLbl = new JLabel("Eliminar usuarios");
		eliminarLbl.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentral.add(eliminarLbl, BorderLayout.NORTH);
		
		JList<Persona> list = new JList<Persona>();
		panelCentral.add(list, BorderLayout.CENTER);
		
		panelDerecho = new JPanel();
		add(panelDerecho);
		
	}
	
	public void setPersonasLM(PersonasListModel personasLM)
	{
		
		this.personasLM = personasLM;
		
		if (this.personasLM == null)
		{
			this.personasLM = new PersonasListModel();
		}

		personasLst.setModel(this.personasLM);
	}
	

}
