import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class TresEnRaya extends JFrame {

	private JPanel contentPane;
	private JButton btn3;
	private JButton btn2;
	private JButton btn1;
	private JButton btnSalir;
	private JButton btnNuevaPartida;
	private JButton btn9;
	private JButton btn8;
	private JButton btn7;
	private JButton btnColorJ2;
	private JLabel lblJ2;
	private JButton btn6;
	private JButton btn5;
	private JButton btn4;
	private JButton btnColorJ1;
	private JLabel lblJ1;
	private int turno;
	private JButton[] arrayFichas;
	private JButton[] arrayGanador;
	private int numFichas;
	private Timer reloj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TresEnRaya frame = new TresEnRaya();
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
	public TresEnRaya() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 5, 0, 0));

		btn1 = new JButton("");
		contentPane.add(btn1);

		btn2 = new JButton("");
		contentPane.add(btn2);

		btn3 = new JButton("");
		contentPane.add(btn3);

		lblJ1 = new JLabel("Jugador 1");
		lblJ1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblJ1);

		btnColorJ1 = new JButton("");
		btnColorJ1.setBackground(new Color(255, 0, 0));
		contentPane.add(btnColorJ1);

		btn4 = new JButton("");
		contentPane.add(btn4);

		btn5 = new JButton("");
		contentPane.add(btn5);

		btn6 = new JButton("");
		contentPane.add(btn6);

		lblJ2 = new JLabel("Jugador 2");
		lblJ2.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblJ2);

		btnColorJ2 = new JButton("");
		btnColorJ2.setBackground(new Color(0, 0, 255));
		contentPane.add(btnColorJ2);

		btn7 = new JButton("");
		contentPane.add(btn7);

		btn8 = new JButton("");
		contentPane.add(btn8);

		btn9 = new JButton("");
		contentPane.add(btn9);

		btnNuevaPartida = new JButton("Nueva Partida");
		contentPane.add(btnNuevaPartida);

		btnSalir = new JButton("Salir");
		contentPane.add(btnSalir);

		inicializar();
		registrarEventos();
	}// Fin del constructor

	private void registrarEventos() {
		for (JButton btn:arrayFichas) {
			btn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// Poner la ficha pulsada del color del jugador que tiene el turno 
					if(turno==1) {
						btn.setBackground(btnColorJ1.getBackground());
					} else {
						btn.setBackground(btnColorJ2.getBackground());
					}
					btn.setEnabled(false);
					// Deshabilitarla

					// poner ficha
					numFichas++;
					// comprobar tres en raya --> Funcion
					if(numFichas>4) {
						if(tresEnraya()) {
							estadoBotones(false);
							btnNuevaPartida.setEnabled(true);
							numFichas=0;
							reloj.start();
							if (turno==1) {
								JOptionPane.showMessageDialog(TresEnRaya.this, "El ganador es: "+lblJ1.getText());
							}else{
								JOptionPane.showMessageDialog(TresEnRaya.this, "El ganador es: "+lblJ2.getText());
							}
							return;
						}
					}
					// Comprobar tablas
					if(numFichas==9) {
						JOptionPane.showMessageDialog(TresEnRaya.this, "Tablas.");
						btnNuevaPartida.setEnabled(true);
						numFichas=0;
					}
					// Cambiar turno // turno=(turno % 2)+1;
					if(turno==1) {
						turno=2;
					}else {
						turno=1;
					}
					resaltarJugada();
				}
			});
			reloj=new Timer(500, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(turno==1) {
						if(arrayGanador[0].getBackground().equals(btnColorJ1.getBackground())) {
							for (int i = 0; i < arrayGanador.length; i++) {
								arrayGanador[i].setBackground(btnSalir.getBackground());
							}
						}else {
							for (int i = 0; i < arrayGanador.length; i++) {
								arrayGanador[i].setBackground(btnColorJ1.getBackground());
							}
						}
					}
					if(turno==2) {
						if(arrayGanador[0].getBackground().equals(btnColorJ2.getBackground())) {
							for (int i = 0; i < arrayGanador.length; i++) {
								arrayGanador[i].setBackground(btnSalir.getBackground());
							}
						}else {
							for (int i = 0; i < arrayGanador.length; i++) {
								arrayGanador[i].setBackground(btnColorJ2.getBackground());
							}
						}
					}

				}
			});
		}
		btnColorJ1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Color color;
				color=JColorChooser.showDialog(TresEnRaya.this, "Elige color", btnColorJ1.getBackground());
				if(color!=null) {
					btnColorJ1.setBackground(color);
					resaltarJugada();
				}
			}
		});
		
		btnColorJ2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Color color;
				color=JColorChooser.showDialog(TresEnRaya.this, "Elige color", btnColorJ2.getBackground());
				if(color!=null) {
					btnColorJ2.setBackground(color);
					resaltarJugada();
				}
				
			}
		});

		btnSalir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Pide confirmacion para dar por finalizado el programa
				if(JOptionPane.showConfirmDialog(TresEnRaya.this, "¿Seguro que quieres salir?", "Aviso", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
					System.exit(1);
				}	
			}
		});
		btnNuevaPartida.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String j1, j2;
				
				// Pedir nombre jugador 1	
				j1=JOptionPane.showInputDialog(TresEnRaya.this, "Introduce nombre del Jugador 1: ", "Jugador 1");
				if(j1==null || j1.isEmpty()) {
					j1="Jugador 1";
				}
				lblJ1.setText(j1);
				// Pedir nombre jugador 2 y controlar que no coincida con el j1.
				do {
					j2=JOptionPane.showInputDialog(TresEnRaya.this, "Introduce nombre del Jugador 2: ", "Jugador 2");
					if(j2==null || j2.isEmpty()) {
						j2="Jugador 2";
					}
				}while (j1.equalsIgnoreCase(j2));
				lblJ2.setText(j2);
				
				reloj.stop();
				// Deshabilitar nuevaPartida y habilitar fichas
				btnNuevaPartida.setEnabled(false);
				estadoBotones(true);
			}
		});

	}

	protected boolean tresEnraya() {		
		// Tres en raya em horizontal
		for(int i=0;i<3;i++) {
			if(arrayFichas[i*3].getBackground().equals(arrayFichas[i*3+1].getBackground()) && 
					arrayFichas[i*3+1].getBackground().equals(arrayFichas[i*3+2].getBackground()) && 
					!arrayFichas[i*3].getBackground().equals(btnSalir.getBackground())) {
				arrayGanador[0]=arrayFichas[i*3];
				arrayGanador[1]=arrayFichas[i*3+1];
				arrayGanador[2]=arrayFichas[i*3+2];
				return true;
			}
		}
		// Tres en raya en vertical
		for(int i=0;i<3;i++) {
			if(arrayFichas[i].getBackground().equals(arrayFichas[i+3].getBackground()) && 
					arrayFichas[i].getBackground().equals(arrayFichas[i+6].getBackground()) && 
					!arrayFichas[i].getBackground().equals(btnSalir.getBackground())) {
				arrayGanador[0]=arrayFichas[i];
				arrayGanador[1]=arrayFichas[i+3];
				arrayGanador[2]=arrayFichas[i+6];
				return true;
			}
		}
		// Tres en raya en diagonal
		if(arrayFichas[0].getBackground().equals(arrayFichas[4].getBackground()) && 
				arrayFichas[0].getBackground().equals(arrayFichas[8].getBackground()) && 
				!arrayFichas[0].getBackground().equals(btnSalir.getBackground())) {
			arrayGanador[0]=arrayFichas[0];
			arrayGanador[1]=arrayFichas[4];
			arrayGanador[2]=arrayFichas[8];
			return true;
		}
		if(arrayFichas[2].getBackground().equals(arrayFichas[4].getBackground()) && 
				arrayFichas[2].getBackground().equals(arrayFichas[6].getBackground()) && 
				!arrayFichas[2].getBackground().equals(btnSalir.getBackground())) {
			arrayGanador[0]=arrayFichas[2];
			arrayGanador[1]=arrayFichas[4];
			arrayGanador[2]=arrayFichas[6];
			return true;
		}
		return false;
	}

	public void inicializar() {
		Random r=new Random();
		// Mete los 9 botones en el array
		arrayGanador=new JButton[3];
		arrayFichas=new JButton[9];
		arrayFichas[0]=btn1;
		arrayFichas[1]=btn2;
		arrayFichas[2]=btn3;
		arrayFichas[3]=btn4;
		arrayFichas[4]=btn5;
		arrayFichas[5]=btn6;
		arrayFichas[6]=btn7;
		arrayFichas[7]=btn8;
		arrayFichas[8]=btn9;

		numFichas=0;

		// Los 9 botones deshabilitados ==> Funcion habilitar/deshabilitar
		estadoBotones(false);

		// Nueva partida: deshabilitado
		btnNuevaPartida.setEnabled(true);

		turno=r.nextInt(2)+1;
		// Resaltar jugador con turno y quitar el resalte del otro
		resaltarJugada();
	}

	private void resaltarJugada() {
		if(turno==1) {
			//lblJ1.setBackground(Color.GREEN);
			//lblJ2.setBackground(Color.WHITE);
			lblJ1.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 12));
			lblJ1.setForeground(btnColorJ1.getBackground());
			lblJ2.setFont(new Font("Arial", Font.PLAIN, 12));
			lblJ2.setForeground(Color.BLACK);
		} else {
			//lblJ2.setBackground(Color.GREEN);
			//lblJ1.setBackground(Color.WHITE);
			lblJ2.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 12));
			lblJ2.setForeground(btnColorJ2.getBackground());
			lblJ1.setFont(new Font("Arial", Font.PLAIN, 12));
			lblJ1.setForeground(Color.BLACK);
		}

	}

	private void estadoBotones(boolean estado) {
		for (int i = 0; i < arrayFichas.length; i++) {
			arrayFichas[i].setEnabled(estado);
			if(estado==true) {
				arrayFichas[i].setBackground(btnSalir.getBackground());
			}
		}

	}

}
