package gui;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import juego.Juego;
import juego.Mapa;
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
	private Mapa mapa;
	
	private JLabel mapaImagen;

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
		
		t = t.getTienda();
		mapa=new Mapa();
		j = j.getJuego(t, this, mapa);
		
		
		btnJugar=new JButton(new ImageIcon("Sprites\\play.gif"));
		oyenteJugar oyenteJugar=new oyenteJugar();
		btnJugar.addActionListener(oyenteJugar);
		btnJugar.setBounds(850, 1080/2, 220, 168);
		contentPane.add(btnJugar);
		
		
		ventanaJuego=new JFrame("ventanaJuego");
		ventanaJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaJuego.setExtendedState(MAXIMIZED_BOTH);
		
		panelJuego=new JPanel();
		panelJuego.setBorder(new EmptyBorder(5, 5, 5, 5));
		ventanaJuego.setContentPane(panelJuego);
		panelJuego.setLayout(null);
		
		
		//contentPane.setVisible(true);
		
		
		
		btnComprarGuerrero=new JButton("Comprar Guerrero");
		oyenteComprarGuerrero oyenteComprarGuerrero =new oyenteComprarGuerrero();
		btnComprarGuerrero.addActionListener(oyenteComprarGuerrero);
		btnComprarGuerrero.setBounds(300, 100, 150, 23);
		
		panelJuego.add(btnComprarGuerrero);
		btnComprarGuerrero.setVisible(false);		
		
		
		
		
		
		
	}
	
	class oyenteJugar implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			
			JLabel guerreroImagen=new JLabel();
			guerreroImagen.setIcon(new ImageIcon("Sprites\\GuerreroAtacando.gif"));
			guerreroImagen.setBounds(1500,0,1920,1080);
			ventanaJuego.add(guerreroImagen);
			
			JLabel EnemigoImagen=new JLabel();
			EnemigoImagen.setIcon(new ImageIcon("Sprites\\EnemigoCaminando.gif"));
			//EnemigoImagen.setBounds(150,8,1920,1080);
			EnemigoImagen.setBounds(1420,8,1920,1080); //cagandose a palos
			ventanaJuego.add(EnemigoImagen);
						
			mapaImagen=new JLabel();
			mapaImagen.setIcon(new ImageIcon("Sprites\\Mapas\\CmBkGrMtMod.png"));
			//mapaImagen.setIcon(new ImageIcon("Sprites\\Mapas\\CmBkLavaM.png"));
			
			mapaImagen.setBounds(0,0,1920,1080);
			ventanaJuego.add(mapaImagen);
			ventanaJuego.setVisible(true);
			setVisible(false);
		}
		
	}
	
	class oyenteComprarGuerrero implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			ImageIcon guerreroImagen=new ImageIcon("Sprites\\Guerrero.png");
			JLabel guerreroImage=new JLabel();
			guerreroImage.setIcon(new ImageIcon("Sprites\\Guerrero.png"));
			guerreroImage.setBounds(0, 0, 1920, 1080);
			ventanaJuego.add(guerreroImage);
			ventanaJuego.setVisible(true);
		}
	}
	
	
}
