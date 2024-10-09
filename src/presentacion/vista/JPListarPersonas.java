package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import entidad.PersonasTableModel;
import java.awt.BorderLayout;
import javax.swing.JTable;

public class JPListarPersonas extends JPanel
{
    private static final long serialVersionUID = 1L;
    private PersonasTableModel personasTM;
    private JTable personasJTable;
    private JScrollPane personasJScroll;
    private JPanel northPanel;
    private JPanel eastPanel;
    private JPanel westPanel;
    private JPanel southPanel;

    public JPListarPersonas()
    {
        setLayout(new BorderLayout(0, 0));

        // Paneles norte, este, oeste y sur

        northPanel = new JPanel();
        add(northPanel, BorderLayout.NORTH);

        eastPanel = new JPanel();
        add(eastPanel, BorderLayout.EAST);

        westPanel = new JPanel();
        add(westPanel, BorderLayout.WEST);

        southPanel = new JPanel();
        add(southPanel, BorderLayout.SOUTH);

        // JTable
        
        personasJTable = new JTable();
        personasJScroll = new JScrollPane(personasJTable);
        add(personasJScroll, BorderLayout.CENTER);
    }

    public void setPersonasTableModel(PersonasTableModel personasTM)
    {
        this.personasTM = personasTM;

        if (this.personasTM == null)
        {
            this.personasTM = new PersonasTableModel();
        }

        personasJTable.setModel(this.personasTM);
    }
}
