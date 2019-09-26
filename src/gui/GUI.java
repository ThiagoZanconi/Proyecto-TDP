package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
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
import java.io.File;
import java.io.IOException;

public class GUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JButton btnJugar;
	private JButton btnComprarGuerrero;
	private JButton btnEliminarEnemigo;
	private JButton btnMusica;
	
	private Clip musica;
	
	private JFrame ventanaJuego;
	
	private JPanel panelJuego;
	private JPanel contentPane;
	private JPanel cuadrilla;
	
	private Juego j;
	private Tienda t;
	private Mapa mapa;
	
	private boolean veredicto,reproduciendo;
	
	private int puntaje;
	
	private JLabel mapaImagen;
	private JLabel EnemigoImagen;
	private JLabel labelPuntaje;
	private JLabel labelCoordenadas;
	
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

		
		int x=(int) (Math.random() * 2);
		int y=(int) (Math.random() * 2);
		
		int aumentoY=EnemigoImagen.getBounds().y;
		int aumentoX=EnemigoImagen.getBounds().x;
		
		switch(x) {
		case 0:
			aumentoX+=15;
			break;
		case 1:
			aumentoX-=15;
		}
		switch(y) {
		case 0:
			aumentoY+=15;
			break;
		case 1:
			aumentoY-=15;
		}
		
		if(aumentoY<-300) {
			aumentoY=-299;
		}
		if(aumentoX>1500 || aumentoX<0)
			aumentoX=0;
		EnemigoImagen.setBounds(aumentoX,aumentoY, EnemigoImagen.getBounds().width, EnemigoImagen.getBounds().height);
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

			//Creo el boton para reproducir musica
            btnMusica=new JButton("Musica");
			oyenteBotonMusica oyenteMusica =new oyenteBotonMusica();
			btnMusica.addActionListener(oyenteMusica);
			btnMusica.setBounds(1000, 0, 100, 100);
			ventanaJuego.add(btnMusica);
			btnMusica.setVisible(true);	
			reproduciendo=false;
			
			//Le relaciono el archivo .wav a la variable musica
			try {
				musica = crearClip("C:\\Users\\Matias\\Documents\\GitHub\\Proyecto-TDP\\Canciones\\cancion1.wav");
			} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
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
			
			labelCoordenadas=new JLabel();
			labelCoordenadas.setText("");
			labelCoordenadas.setBounds(500, 30, 100, 30);
			labelCoordenadas.setBorder(BorderFactory.createLineBorder(Color.black));
			labelCoordenadas.setBackground(Color.green);
			labelCoordenadas.setOpaque(true);
			ventanaJuego.add(labelCoordenadas);
			
			
			EnemigoImagen=new JLabel();
			EnemigoImagen.setIcon(new ImageIcon("Sprites\\EnemigoCaminando.gif"));
			EnemigoImagen.setBounds(0,0,1920,1080);
			ventanaJuego.add(EnemigoImagen);
					
			cuadrilla=new JPanel();
			cuadrilla.setLayout(new GridLayout(6,10));
			llenarCuadrilla();
			cuadrilla.setBounds(20,200,1890,700);
			cuadrilla.setOpaque(false);
			ventanaJuego.add(cuadrilla);
			cuadrilla.setVisible(false);
			
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
	
	private Clip crearClip(String str) throws LineUnavailableException,UnsupportedAudioFileException,IOException{
		
		Clip clip;
		AudioInputStream inputStream;
		clip = AudioSystem.getClip();
		inputStream = AudioSystem.getAudioInputStream(new File(str));
		clip.open (inputStream);
		return clip;
		
	}
	
	class oyenteBotonMusica implements ActionListener{
		public void actionPerformed(ActionEvent evento) {
			
			if(!reproduciendo) {
				musica.start();
				reproduciendo = true;
			}else {
				musica.stop();
				reproduciendo = false;
			}
			
		}
	}
	
	private void llenarCuadrilla() {
		for(int i=0;i<60;i++) {
			JLabel labelAuxiliar=new JLabel();
			labelAuxiliar.setBorder(BorderFactory.createLineBorder(Color.black));
			cuadrilla.add(labelAuxiliar);
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
			cuadrilla.setVisible(true);
			
		}
	}
	
	MouseListener click=new MouseListener() {
		@Override
		public void mousePressed(MouseEvent evento) {
			labelCoordenadas.setText("X: "+evento.getX()+" Y: "+evento.getY());
			
			if(veredicto) {
				JLabel guerreroImagen=new JLabel();
				guerreroImagen.setIcon(new ImageIcon("Sprites\\GuerreroAtacando.gif"));
				guerreroImagen.setBounds(evento.getX()-65,evento.getY()-550,1000,1000);
				ventanaJuego.add(guerreroImagen);
				ventanaJuego.add(mapaImagen);
				
				cuadrilla.setVisible(false);
				
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
