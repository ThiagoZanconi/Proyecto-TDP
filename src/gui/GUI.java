package gui;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import juego.Juego;
import juego.Tienda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton btnJugar;
	private JButton btnComprarGuerrero;
	private JFrame ventanaJuego;
	private JPanel panelJuego;
	private JPanel contentPane;
	private Juego j;
	private Tienda t;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				//mover(arg0);
			}
		});
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		j = new Juego(this);
		
		btnJugar=new JButton("Jugar");
		oyenteJugar oyenteJugar=new oyenteJugar();
		btnJugar.addActionListener(oyenteJugar);
		btnJugar.setBounds(222, 10, 100, 23);
		contentPane.add(btnJugar);
		
		
		ventanaJuego=new JFrame();
		ventanaJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaJuego.setExtendedState(MAXIMIZED_BOTH);
		
		panelJuego=new JPanel();
		panelJuego.setBorder(new EmptyBorder(5, 5, 5, 5));
		ventanaJuego.setContentPane(panelJuego);
		panelJuego.setLayout(null);
		
		
		
		btnComprarGuerrero=new JButton("Comprar Guerrero");
		oyenteComprarGuerrero oyenteComprarGuerrero =new oyenteComprarGuerrero();
		btnComprarGuerrero.addActionListener(oyenteComprarGuerrero);
		btnComprarGuerrero.setBounds(300, 800, 150, 23);
		panelJuego.add(btnComprarGuerrero);
				
		
		
		
		
		
		
	}
	
	class oyenteJugar implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ventanaJuego.setVisible(true);
			setVisible(false);
		}
		
	}
	
	class oyenteComprarGuerrero implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			panelJuego.add(t.crearGuerrero());
		}
	}
	
	
}
