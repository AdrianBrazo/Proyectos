import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelBajas extends JPanel {
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtEdad;
	private JTextField txtCalle;
	private JTextField txtNumero;
	private JTextField txtCp;
	private JButton btnBaja;
	private BaseDatos bd;
	private ResultSet rs;

	/**
	 * Create the panel.
	 */
	public PanelBajas() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		
		btnBaja = new JButton("Dar de baja");
		panel.add(btnBaja);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Datos personales:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		panel_3.add(lblNewLabel_1);
		
		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
		panel_3.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos:");
		panel_3.add(lblNewLabel_2);
		
		txtApellidos = new JTextField();
		txtApellidos.setEnabled(false);
		panel_3.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Edad:");
		panel_3.add(lblNewLabel_3);
		
		txtEdad = new JTextField();
		txtEdad.setEnabled(false);
		panel_3.add(txtEdad);
		txtEdad.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Direccion:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("Calle:");
		panel_4.add(lblNewLabel_4);
		
		txtCalle = new JTextField();
		txtCalle.setEnabled(false);
		panel_4.add(txtCalle);
		txtCalle.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Numero:");
		panel_4.add(lblNewLabel_5);
		
		txtNumero = new JTextField();
		txtNumero.setEnabled(false);
		panel_4.add(txtNumero);
		txtNumero.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Codigo Postal:");
		panel_4.add(lblNewLabel_6);
		
		txtCp = new JTextField();
		txtCp.setEnabled(false);
		panel_4.add(txtCp);
		txtCp.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Alumnos:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Clave:");
		panel_2.add(lblNewLabel);
		
		JComboBox comboBoxClave = new JComboBox();
		panel_2.add(comboBoxClave);
		
		inicializar();

	}
	
	private void inicializar() {
		bd=new BaseDatos();
		//Cargar los datos de la bd en un rs y mostrar los datos del primer registro
		rs=bd.obtenerAlumnado();
		try {
			if(rs.first()) {
				cargarDatos();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void cargarDatos() {
		//Carga los datos del registro actual en los Jtextfield
		
			try {
				//comboBoxClave.setText(rs.getInt("clave")+"");
				txtNombre.setText(rs.getString("nombre"));
				txtApellidos.setText(rs.getString("apellidos"));
				txtEdad.setText(rs.getString("edad"));
				txtCalle.setText(rs.getString("direccion"));
				txtNumero.setText(rs.getString("numero"));
				txtCp.setText(rs.getString("cp"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

}
