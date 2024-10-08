package presentacion.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidad.Persona;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.SpringLayout;
import net.miginfocom.swing.MigLayout;

public class JFPrincipal extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnPersona;
	private JMenuItem mnuItemAgregar;
	private JMenuItem mnuItemModificar;
	private JMenuItem mnuItemEliminar;
	private JMenuItem mnuItemListar;
	private JPAltaPersona altaPersona;
	private JPBajaPersona bajaPersona;
	
	private static DefaultListModel<Persona> defaultListModel;

	public JFPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Programa");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(new BorderLayout());
		
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

	public JMenuItem getMnuItemAgregar() {
		return mnuItemAgregar;
	}

	public JMenuItem getMnuItemModificar() {
		return mnuItemModificar;
	}

	public JMenuItem getMnuItemEliminar() {
		return mnuItemEliminar;
	}

	public JMenuItem getMnuItemListar() {
		return mnuItemListar;
	}
	
}
