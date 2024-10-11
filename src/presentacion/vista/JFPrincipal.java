package presentacion.vista;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class JFPrincipal extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnPersona;
	private JMenuItem mnuItemAgregar;
	private JMenuItem mnuItemModificar;
	private JMenuItem mnuItemEliminar;
	private JMenuItem mnuItemListar;

	public JFPrincipal()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Programa");
		setBounds(100, 100, 450, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnPersona = new JMenu("Persona");
		menuBar.add(mnPersona);
		
		mnuItemAgregar = new JMenuItem("Agregar");
		mnPersona.add(mnuItemAgregar);
		
		mnuItemModificar = new JMenuItem("Modificar");
		mnPersona.add(mnuItemModificar);
		
		mnuItemEliminar = new JMenuItem("Eliminar");
		mnPersona.add(mnuItemEliminar);
		
		mnuItemListar = new JMenuItem("Listar");
		mnPersona.add(mnuItemListar);
	}

	public JMenuItem getMnuItemAgregar()
	{
		return mnuItemAgregar;
	}

	public JMenuItem getMnuItemModificar()
	{
		return mnuItemModificar;
	}

	public JMenuItem getMnuItemEliminar()
	{
		return mnuItemEliminar;
	}

	public JMenuItem getMnuItemListar()
	{
		return mnuItemListar;
	}
	
	public void mostrarMensaje(String msg, int jOptionType) {
		JOptionPane.showMessageDialog(null, msg, "Mensaje", jOptionType,null);
	}
}
