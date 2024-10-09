package entidad;

import java.util.TreeSet;
import javax.swing.DefaultListModel;

public class PersonasListModel extends DefaultListModel<Persona>
{
	private static final long serialVersionUID = 1L;
	private TreeSet<Persona> tsPersonas;
	
	public PersonasListModel()
	{
		tsPersonas = new TreeSet<Persona>();
	}
	
	public void addElement(Persona element)
	{
		tsPersonas.add(element);
	}

	@Override
	public Persona getElementAt(int index)
	{
		return (Persona)tsPersonas.toArray()[index];
	}

	@Override
	public int getSize()
	{
		return tsPersonas.size();
	}
}
