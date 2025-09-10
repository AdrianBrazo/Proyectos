import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class Modificaciones extends JPanel {
	private JButton btnModificar;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtEdad;
	private JTextField txtCalle;
	private JTextField txtNumero;
	private JTextField txtCp;

	/**
	 * Create the panel.
	 */
	public Modificaciones() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Alumnos:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Clave:");
		panel.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos personales:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		panel_3.add(lblNewLabel_1);
		
		txtNombre = new JTextField();
		panel_3.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos:");
		panel_3.add(lblNewLabel_2);
		
		txtApellidos = new JTextField();
		panel_3.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Edad:");
		panel_3.add(lblNewLabel_3);
		
		txtEdad = new JTextField();
		panel_3.add(txtEdad);
		txtEdad.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Direccion:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(panel_4);
		panel_4.setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("Calle:");
		panel_4.add(lblNewLabel_4);
		
		txtCalle = new JTextField();
		panel_4.add(txtCalle);
		txtCalle.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Numero");
		panel_4.add(lblNewLabel_5);
		
		txtNumero = new JTextField();
		panel_4.add(txtNumero);
		txtNumero.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Codigo Postal:");
		panel_4.add(lblNewLabel_6);
		
		txtCp = new JTextField();
		panel_4.add(txtCp);
		txtCp.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.SOUTH);
		
		btnModificar = new JButton("Modificar");
		panel_2.add(btnModificar);

	}

}
