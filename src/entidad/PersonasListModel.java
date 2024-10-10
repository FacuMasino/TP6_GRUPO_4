package entidad;

import java.util.List;
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
		
		// Se le avisa al modelo que la lista cambió y se le pasa
		// entre que posiciones está el elemento
		int posicionAnterior = tsPersonas.headSet(element).size() - 1;
		fireContentsChanged(tsPersonas, posicionAnterior, posicionAnterior+1);
	}
	
	public void addElements(List<Persona> personas)
	{
		for (Persona persona : personas)
        {
            tsPersonas.add(persona);
        }
		
		// Se le avisa al modelo que la lista cambió por completo
		fireContentsChanged(tsPersonas, 0, tsPersonas.size());
	}
	
	@Override
	public void clear() {
		tsPersonas.clear();
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
