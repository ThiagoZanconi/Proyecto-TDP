package gui;

import java.awt.EventQueue;
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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
	
	private boolean veredicto;
	
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
		
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		
		//Creo el panel de inicio
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Creo el boton jugar y lo agrego al panel de inicio
		btnJugar=new JButton(new ImageIcon("Sprites\\play.gif"));
		oyenteJugar oyenteJugar=new oyenteJugar();
		btnJugar.addActionListener(oyenteJugar);
		btnJugar.setBounds(850, 1080/2, 220, 168);
		contentPane.add(btnJugar);
		
		
	}
	
	class oyenteJugar implements ActionListener{
		public void actionPerformed(ActionEvent e) {
					
			//Creo la ventana del juego
			ventanaJuego=new JFrame("ventanaJuego");
			ventanaJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ventanaJuego.setExtendedState(MAXIMIZED_BOTH);
			ventanaJuego.addMouseListener(click);
			
			//Creo el panel del juego y le agrego la ventana
			panelJuego=new JPanel();
			panelJuego.setBorder(new EmptyBorder(5, 5, 5, 5));
			ventanaJuego.setContentPane(panelJuego);
			panelJuego.setLayout(null);

			//Creo el boton comprar guerrero y lo agrego a la ventana
			btnComprarGuerrero=new JButton("Guerrero");
			oyenteComprarGuerrero oyenteComprarGuerrero =new oyenteComprarGuerrero();
			btnComprarGuerrero.addActionListener(oyenteComprarGuerrero);
			btnComprarGuerrero.setBounds(0, 0, 100, 100);
			ventanaJuego.add(btnComprarGuerrero);
			btnComprarGuerrero.setVisible(true);		
			
			//Inicio variables varias
			veredicto=false;
			
			JLabel guerreroImagen=new JLabel();
			guerreroImagen.setIcon(new ImageIcon("Sprites\\EnemigoCaminando.gif"));
			guerreroImagen.setBounds(200,0,1920,1080);
			ventanaJuego.add(guerreroImagen);
						
			//Creo el mapa y lo agrego a la ventana
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
			
			veredicto=true;
			
		}
	}
	
	MouseListener click=new MouseListener() {
		@Override
		public void mousePressed(MouseEvent evento) {
			
			if(veredicto) {
				JLabel EnemigoImagen=new JLabel();
				EnemigoImagen.setIcon(new ImageIcon("Sprites\\GuerreroAtacando.gif"));
				EnemigoImagen.setBounds(evento.getX(),evento.getY()-500,1000,1000);
				ventanaJuego.add(EnemigoImagen);
				ventanaJuego.add(mapaImagen);
				veredicto=false;
			}
			
		}
		@Override
		public void mouseReleased(MouseEvent evento) {

		}
		@Override
		public void mouseEntered(MouseEvent evento) {

		}
		@Override
		public void mouseExited(MouseEvent evento) {

		}
		@Override
		public void mouseClicked(MouseEvent evento) {
			
		}
	};
}
