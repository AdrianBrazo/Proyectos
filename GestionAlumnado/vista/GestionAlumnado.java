import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;

public class GestionAlumnado extends JFrame {

	private JPanel contentPane;
	private PanelAltas panelAltas;
	private PanelBajas panelBajas;
	private Modificaciones modificaciones;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionAlumnado frame = new GestionAlumnado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GestionAlumnado() {
		setTitle("Gestion de Alumnos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		panelAltas = new PanelAltas();
		tabbedPane.add("Altas", panelAltas);
		panelBajas = new PanelBajas();
		tabbedPane.add("Bajas", panelBajas);
		modificaciones = new Modificaciones();
		tabbedPane.add("Modificaciones", modificaciones);
	}

}
