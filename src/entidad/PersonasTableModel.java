package entidad;

import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class PersonasTableModel extends DefaultTableModel
{
    private static final long serialVersionUID = 1L;
    private TreeSet<Persona> tsPersonas;
    private String[] columnas = {"Nombre", "Apellido", "DNI"};

    public PersonasTableModel()
    {
        tsPersonas = new TreeSet<Persona>();
    }

    public void addElement(Persona element)
    {
        tsPersonas.add(element);
        fireTableDataChanged();
    }
    
    public void addAllElements(List<Persona> list)
    {
        for (Persona persona : list)
        {
            tsPersonas.add(persona);
        }
        
        fireTableDataChanged();
    }

    @Override
    public int getRowCount()
    {
        if (tsPersonas == null)
        {
            return 0;
        }
        
        return tsPersonas.size();
    }

    @Override
    public int getColumnCount()
    {
        return columnas.length;
    }

    @Override
    public String getColumnName(int column)
    {
        return columnas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Persona persona = (Persona) tsPersonas.toArray()[rowIndex];

        switch (columnIndex)
        {
            case 0: return persona.getNombre();
            case 1: return persona.getApellido();
            case 2: return persona.getDni();
            default: return null;
        }
    }
}
