package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JPAltaPersona extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDni;
	private JButton btnAceptar;

	public JPAltaPersona()
	{
		setLayout(null);
		setBounds(100, 100, 450, 300);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(96, 44, 45, 14);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(231, 41, 129, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(96, 94, 45, 14);
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(231, 91, 129, 20);
		add(txtApellido);
		txtApellido.setColumns(10);
		
		lblDni = new JLabel("Dni");
		lblDni.setBounds(96, 148, 45, 14);
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setBounds(231, 145, 129, 20);
		add(txtDni);
		txtDni.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(96, 188, 129, 26);
		add(btnAceptar);
	}

	public JButton getBtnAceptar()
	{
		return btnAceptar;
	}

	public JTextField getTxtNombre()
	{
		return txtNombre;
	}

	public JTextField getTxtApellido()
	{
		return txtApellido;
	}

	public JTextField getTxtDni()
	{
		return txtDni;
	}
}
