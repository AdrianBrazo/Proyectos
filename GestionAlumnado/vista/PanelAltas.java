import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JCheckBox;
import java.awt.FlowLayout;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class PanelAltas extends JPanel {
	private JTextField txtClave;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtEdad;
	private JTextField txtCalle;
	private JTextField txtNumero;
	private JTextField txtCp;
	private JButton btnLimpiar;
	private JButton btnAlta;
	private EventosAlta eventosAlta;
	private BaseDatos bd;
	private ResultSet rs;

	/**
	 * Create the panel.
	 */
	public PanelAltas() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos Personales:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(panel);
		panel.setLayout(new GridLayout(4, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Clave:");
		panel.add(lblNewLabel);
		
		txtClave = new JTextField();
		panel.add(txtClave);
		txtClave.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		panel.add(lblNewLabel_1);
		
		txtNombre = new JTextField();
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos:");
		panel.add(lblNewLabel_2);
		
		txtApellidos = new JTextField();
		panel.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Edad:");
		panel.add(lblNewLabel_3);
		
		txtEdad = new JTextField();
		panel.add(txtEdad);
		txtEdad.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_1.setBorder(new TitledBorder(null, "Direccion:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_1);
		panel_1.setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("Calle:");
		panel_1.add(lblNewLabel_4);
		
		txtCalle = new JTextField();
		panel_1.add(txtCalle);
		txtCalle.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Numero:");
		panel_1.add(lblNewLabel_5);
		
		txtNumero = new JTextField();
		panel_1.add(txtNumero);
		txtNumero.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Codigo Postal:");
		panel_1.add(lblNewLabel_6);
		
		txtCp = new JTextField();
		panel_1.add(txtCp);
		txtCp.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setAlignmentY(Component.TOP_ALIGNMENT);
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		add(panel_2);
		
		btnLimpiar = new JButton("Limpiar");
		panel_2.add(btnLimpiar);
		
		btnAlta = new JButton("Dar de alta");
		panel_2.add(btnAlta);
		
		eventosAlta = new EventosAlta(this);
		
		inicializar();

	}

	public JButton getBtnAlta() {
		return btnAlta;
	}

	public void setBtnAlta(JButton btnAlta) {
		this.btnAlta = btnAlta;
	}

	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}

	public void setBtnLimpiar(JButton btnLimpiar) {
		this.btnLimpiar = btnLimpiar;
	}

	public JTextField getTxtClave() {
		return txtClave;
	}

	public void setTxtClave(JTextField txtClave) {
		this.txtClave = txtClave;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtApellidos() {
		return txtApellidos;
	}

	public void setTxtApellidos(JTextField txtApellidos) {
		this.txtApellidos = txtApellidos;
	}

	public JTextField getTxtEdad() {
		return txtEdad;
	}

	public void setTxtEdad(JTextField txtEdad) {
		this.txtEdad = txtEdad;
	}

	public JTextField getTxtCalle() {
		return txtCalle;
	}

	public void setTxtCalle(JTextField txtCalle) {
		this.txtCalle = txtCalle;
	}

	public JTextField getTxtNumero() {
		return txtNumero;
	}

	public void setTxtNumero(JTextField txtNumero) {
		this.txtNumero = txtNumero;
	}

	public JTextField getTxtCp() {
		return txtCp;
	}

	public void setTxtCp(JTextField txtCp) {
		this.txtCp = txtCp;
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
				txtClave.setText(rs.getInt("clave")+"");
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




