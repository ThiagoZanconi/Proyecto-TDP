package gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
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
	private JButton btnEliminarEnemigo;
	
	private JFrame ventanaJuego;
	
	private JPanel panelJuego;
	private JPanel contentPane;
	
	private Juego j;
	private Tienda t;
	private Mapa mapa;
	
	private boolean veredicto;
	
	private int puntaje;
	
	private JLabel mapaImagen;
	private JLabel EnemigoImagen;
	private JLabel labelPuntaje;
	
	private Hilo hilo;
	private GUI gui;
	
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
		gui=this;
		
	}
	
	public void mover() {
		
		int aumentoX=EnemigoImagen.getBounds().x;
		int aumentoY=EnemigoImagen.getBounds().x;
		
		int y=(int) (Math.random() * 2);
		int x=(int) (Math.random() * 2);
		
		switch (y) {
		case 0:
			aumentoY=EnemigoImagen.getBounds().y+15;
			break;
		case 1:
			aumentoY=EnemigoImagen.getBounds().y-15;
		}
		switch (x) {
		case 0:
			aumentoX=EnemigoImagen.getBounds().x+15;
			break;
		case 1:
			aumentoX=EnemigoImagen.getBounds().x-15;		
		}
		
		if(aumentoX>1500 || aumentoX<0)
			aumentoX=0;
		
		if(aumentoY>250)
			aumentoY=249;
		else if(aumentoY<-300)
			aumentoY=-299;
		
		EnemigoImagen.setBounds(aumentoX, aumentoY, EnemigoImagen.getBounds().width, EnemigoImagen.getBounds().height);
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
			
			//Creo boton eliminar enemigo y lo agrego a la ventana
            btnEliminarEnemigo=new JButton("Eliminar Enemigo");
            oyenteEliminarEnemigo oyenteEliminarEnemigo= new oyenteEliminarEnemigo();
            btnEliminarEnemigo.addActionListener(oyenteEliminarEnemigo);
            btnEliminarEnemigo.setBounds(100, 0, 200, 100);
            ventanaJuego.add(btnEliminarEnemigo);
            btnEliminarEnemigo.setVisible(true);

			//Creo el boton comprar guerrero y lo agrego a la ventana
			btnComprarGuerrero=new JButton("Guerrero");
			oyenteComprarGuerrero oyenteComprarGuerrero =new oyenteComprarGuerrero();
			btnComprarGuerrero.addActionListener(oyenteComprarGuerrero);
			btnComprarGuerrero.setBounds(0, 0, 100, 100);
			ventanaJuego.add(btnComprarGuerrero);
			btnComprarGuerrero.setVisible(true);		
			
			//Inicio variables varias
			veredicto=false;
			
			//Creo el label puntaje y lo inicio en 0
			labelPuntaje= new JLabel();
			puntaje= 0;
			labelPuntaje.setText(String.valueOf(puntaje));
			labelPuntaje.setBounds(400,30,40,30);
			labelPuntaje.setBorder(BorderFactory.createLineBorder(Color.black));
			labelPuntaje.setBackground(Color.green);
			labelPuntaje.setOpaque(true);
			ventanaJuego.add(labelPuntaje);
			
			EnemigoImagen=new JLabel();
			EnemigoImagen.setIcon(new ImageIcon("Sprites\\EnemigoCaminando.gif"));
			EnemigoImagen.setBounds(0,0,1920,1080);
			ventanaJuego.add(EnemigoImagen);
						
			//Creo el mapa y lo agrego a la ventana
			mapaImagen=new JLabel();
			mapaImagen.setIcon(new ImageIcon("Sprites\\Mapas\\CmBkGrMtMod.png"));
			//mapaImagen.setIcon(new ImageIcon("Sprites\\Mapas\\CmBkLavaM.png"));
			mapaImagen.setBounds(0,0,1920,1080);
			ventanaJuego.add(mapaImagen);
			ventanaJuego.setVisible(true);
			setVisible(false);
			
			hilo=new Hilo(gui);
			hilo.start();
			
		}
		
	}
	
	class oyenteEliminarEnemigo implements ActionListener{
        public void actionPerformed(ActionEvent e) {

        	EnemigoImagen.setVisible(false);
            puntaje+=100;
            labelPuntaje.setText(String.valueOf(puntaje));

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
				JLabel guerreroImagen=new JLabel();
				guerreroImagen.setIcon(new ImageIcon("Sprites\\GuerreroAtacando.gif"));
				guerreroImagen.setBounds(evento.getX()-65,evento.getY()-550,1000,1000);
				ventanaJuego.add(guerreroImagen);
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
