package presentacion.vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import entidad.Persona;
import entidad.PersonasListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class JPModificarPersona extends JPanel
{
	private static final long serialVersionUID = 1L;
	private PersonasListModel personasLM;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
	private JList<Persona> jlPersonas;
	private JPanel JPMain;
	private JPanel JPFields;
	private JLabel lblinfo;
	private JButton btnModificar;
	
	public JPModificarPersona()
	{
		setLayout(new BorderLayout(0, 0));
		
		JPMain = new JPanel();
		add(JPMain);
		
		jlPersonas = new JList<Persona>();
		
		jlPersonas.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JPFields = new JPanel();
		
		lblinfo = new JLabel("Seleccione la persona que desea modificar");
		lblinfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		GroupLayout gl_JPMain = new GroupLayout(JPMain);

		gl_JPMain.setHorizontalGroup(
			gl_JPMain.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_JPMain.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_JPMain.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_JPMain.createSequentialGroup()
							.addComponent(lblinfo)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_JPMain.createSequentialGroup()
							.addGroup(gl_JPMain.createParallelGroup(Alignment.TRAILING)
								.addComponent(JPFields, GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
								.addComponent(jlPersonas, GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE))
							.addGap(30))))
		);

		gl_JPMain.setVerticalGroup(
			gl_JPMain.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_JPMain.createSequentialGroup()
					.addGap(15)
					.addComponent(lblinfo)
					.addGap(5)
					.addComponent(jlPersonas, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(JPFields, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(30))
		);

		JPFields.setLayout(new GridLayout(0, 4, 6, 0));
		
		txtNombre = new JTextField();
		JPFields.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		JPFields.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDNI = new JTextField();
		txtDNI.setEditable(false);
		JPFields.add(txtDNI);
		txtDNI.setColumns(10);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setEnabled(false);
		JPFields.add(btnModificar);
		JPMain.setLayout(gl_JPMain);
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
	
	public void mostrarMensaje(String msg)
	{
		JOptionPane.showMessageDialog(null, msg);
	}
	
	public void limpiarCampos()
	{
		txtNombre.setText("");
		txtApellido.setText("");
		txtDNI.setText("");
		btnModificar.setEnabled(false);
	}

	public JList<Persona> getJlPersonas() {
		return jlPersonas;
	}
	
	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public JTextField getTxtDNI() {
		return txtDNI;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}
	
}
