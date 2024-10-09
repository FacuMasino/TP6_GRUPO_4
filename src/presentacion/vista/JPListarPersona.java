package presentacion.vista;

import javax.swing.JList;
import javax.swing.JPanel;
import entidad.Persona;
import entidad.PersonasListModel;
import java.awt.BorderLayout;
import java.awt.Font;

public class JPListarPersona extends JPanel
{
	private static final long serialVersionUID = 1L;
	private PersonasListModel personasLM;
	private JList<Persona> jlPersonas;
	private JPanel northPanel;
	private JPanel eastPanel;
	private JPanel westPanel;
	private JPanel southPanel;

	public JPListarPersona()
	{
		setLayout(new BorderLayout(0, 0));
		
		northPanel = new JPanel();
		add(northPanel, BorderLayout.NORTH);
		
		eastPanel = new JPanel();
		add(eastPanel, BorderLayout.EAST);
		
		westPanel = new JPanel();
		add(westPanel, BorderLayout.WEST);
		
		southPanel = new JPanel();
		add(southPanel, BorderLayout.SOUTH);
		
		jlPersonas = new JList<Persona>();
		add(jlPersonas, BorderLayout.CENTER);
		jlPersonas.setFont(new Font("Tahoma", Font.BOLD, 11));
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
}
