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
import juego.Tienda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class GUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private String aliadoComprado;
	
	private JButton btnJugar;
	private JButton btnComprarGuerrero;
	private JButton btnMusica;
	private JButton enemigos[];
	
	private Clip musica;
	
	private JFrame ventanaJuego;
	
	private JPanel panelJuego;
	private JPanel contentPane;
	private JPanel cuadrilla;
	
	private Juego j;
	private Tienda t;
	
	private boolean veredicto,reproduciendo;
	
	private int puntaje;
	private int posicionArregloEnemigos;
	
	private JLabel mapaImagen;
	private JLabel labelPuntaje;
	private JLabel labelCoordenadas;
	private JLabel arregloEnemigos[];
	private JLabel arregloAliados[][];
	
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
		t=t.getTienda();
		j=j.getJuego(t,this);
		
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, 1200, 800);
		
		//Creo el panel de inicio
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Creo el boton jugar y lo agrego al panel de inicio
		btnJugar=new JButton(new ImageIcon("Sprites\\play.gif"));
		oyenteJugar oyenteJugar=new oyenteJugar();
		btnJugar.addActionListener(oyenteJugar);
		btnJugar.setBounds(this.getWidth()/2,this.getHeight()/2, 220, 168);
		contentPane.add(btnJugar);
		gui=this;
		
	}
	
	public void mover() {
		
		int aumentoX=arregloEnemigos[posicionArregloEnemigos].getX()+15;
		
		arregloEnemigos[posicionArregloEnemigos].setBounds(aumentoX,arregloEnemigos[posicionArregloEnemigos].getY(), arregloEnemigos[posicionArregloEnemigos].getBounds().width, arregloEnemigos[posicionArregloEnemigos].getBounds().height);
	
		if(aumentoX>1100) {

			arregloEnemigos[posicionArregloEnemigos].setVisible(false);;
			
			for(int i=0;i<6;i++) {
				enemigos[i].setVisible(true);	
			}
			
		}
		
	}
	
	class oyenteJugar implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			aliadoComprado="";
			posicionArregloEnemigos=0;
			arregloAliados=(JLabel[][]) new JLabel[6][10]; 
			
			//Creo la ventana del juego
			ventanaJuego=new JFrame("ventanaJuego");
			ventanaJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ventanaJuego.setBounds(0, 0, 1200, 800);
			ventanaJuego.addMouseListener(click);
			
			//Creo el panel del juego y le agrego la ventana
			panelJuego=new JPanel();
			panelJuego.setBorder(new EmptyBorder(5, 5, 5, 5));
			ventanaJuego.setContentPane(panelJuego);
			panelJuego.setLayout(null);

            iniciarBotonEnemigos();
            arregloEnemigos=(JLabel[]) new JLabel[100];
            
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
				
			
			
			//Crea la cuadrilla
			cuadrilla=new JPanel();
			cuadrilla.setLayout(new GridLayout(6,10));
			llenarCuadrilla();
			cuadrilla.setBounds(20,200,1150,560);
			cuadrilla.setOpaque(false);
			ventanaJuego.add(cuadrilla);
			cuadrilla.setVisible(false);
			
			//Creo el mapa y lo agrego a la ventana
			mapaImagen=new JLabel();
			mapaImagen.setIcon(new ImageIcon("Sprites\\Mapas\\CmBkGrMtMod.png"));
			//mapaImagen.setIcon(new ImageIcon("Sprites\\Mapas\\CmBkLavaM.png"));
			mapaImagen.setBounds(0, 0, 1200, 800);
			ventanaJuego.add(mapaImagen);
			ventanaJuego.setVisible(true);
			setVisible(false);
			
			
			
			hilo=new Hilo(gui);
			
			
		}
		
	}
	
	class oyenteBotonEnemigos implements ActionListener{
		public void actionPerformed(ActionEvent evento) {
			
			JButton boton=(JButton) evento.getSource();
			
			JLabel EnemigoImagen=new JLabel();
			EnemigoImagen.setIcon(new ImageIcon("Sprites\\EnemigoCaminando.gif"));
			EnemigoImagen.setBounds(20,boton.getY()-80,100,100);
			ventanaJuego.add(EnemigoImagen);
			ventanaJuego.add(mapaImagen);
			arregloEnemigos[posicionArregloEnemigos]=EnemigoImagen;
			
			hilo.start();
			
			for(int i=0;i<6;i++) {
				enemigos[i].setVisible(false);
			}
		}
	}
	
	private void iniciarBotonEnemigos() {
		
		enemigos=new JButton[6];
		int y=240;
		oyenteBotonEnemigos oyenteEnemigos=new oyenteBotonEnemigos();
		
		for(int i=0;i<6;i++) {
			enemigos[i]=new JButton();
			enemigos[i].setBounds(20, y, 20, 20);
			enemigos[i].setText(".");
			enemigos[i].addActionListener(oyenteEnemigos);
			ventanaJuego.add(enemigos[i]);
			y+=93;
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
	
	class oyenteComprarGuerrero implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			veredicto=true;
			aliadoComprado="Guerrero";
			cuadrilla.setVisible(true);
			
		}
	}
	
	private int[] traducirCoordenadas(int x, int y) {
		int[] arregloDevolver=new int[4];
		//[0] = x en la matriz
		//[1] = coordenadas x para el pj
		//[2] = y en la matriz
		//[3] = coordenadas y para el pj
		
		if(y>233 && y<325) {
			arregloDevolver[2]=1;
			arregloDevolver[3]=279;
		}else if(y>=325 && y<420) {
			arregloDevolver[2]=2;
			arregloDevolver[3]=372;
		}else if(y>=420 && y<511) {
			arregloDevolver[2]=3;
			arregloDevolver[3]=465;
		}else if(y>=511 && y<603) {
			arregloDevolver[2]=4;
			arregloDevolver[3]=557;
		}else if(y>=601 && y<697) {
			arregloDevolver[2]=5;
			arregloDevolver[3]=649;
		}else if(y>=697 && y<790) {
			arregloDevolver[2]=6;
			arregloDevolver[3]=743;
		}else {
			arregloDevolver[2]=0;
			arregloDevolver[3]=0;
		}
		if(x>=28 && x<142) {
			arregloDevolver[0]=1;
			arregloDevolver[1]=85;
		}else if(x>=142 && x<255) {
			arregloDevolver[0]=2;
			arregloDevolver[1]=198;
		}else if(x>=255 && x<372) {
			arregloDevolver[0]=3;
			arregloDevolver[1]=313;
		}else if(x>=372 && x<486) {
			arregloDevolver[0]=4;
			arregloDevolver[1]=429;
		}else if(x>=486 && x<602) {
			arregloDevolver[0]=5;
			arregloDevolver[1]=544;
		}else if(x>=602 && x<716) {
			arregloDevolver[0]=6;
			arregloDevolver[1]=659;
		}else if(x>=716 && x<832) {
			arregloDevolver[0]=7;
			arregloDevolver[1]=774;
		}else if(x>=832 && x<946) {
			arregloDevolver[0]=8;
			arregloDevolver[1]=889;
		}else if(x>=946 && x<1062) {
			arregloDevolver[0]=9;
			arregloDevolver[1]=1004;
		}else if(x>=1062 && x<1177) {
			arregloDevolver[0]=10;
			arregloDevolver[1]=1119;
		}else {
			arregloDevolver[0]=0;
			arregloDevolver[1]=0;
		}
		return arregloDevolver;
	}
	
	private void generarGuerrero(int x, int y) {
		int[] arregloAuxiliar=traducirCoordenadas(x,y);
		
		if(arregloAuxiliar[3]!=0 && arregloAuxiliar[0]!=0) {
			JLabel guerreroImagen=new JLabel();
			arregloAliados[arregloAuxiliar[2]][arregloAuxiliar[0]]=guerreroImagen;
			guerreroImagen.setIcon(new ImageIcon("Sprites\\GuerreroAtacando.gif"));
			guerreroImagen.setBounds(arregloAuxiliar[1]-65,arregloAuxiliar[3]-550,1000,1000);
			ventanaJuego.add(guerreroImagen);
			ventanaJuego.add(mapaImagen);
		}
		
		cuadrilla.setVisible(false);
		
		veredicto=false;
	}
	
	MouseListener click=new MouseListener() {
		@Override
		public void mousePressed(MouseEvent evento) {
			labelCoordenadas.setText("X: "+evento.getX()+" Y: "+evento.getY());
			
			if(veredicto) {
				switch (aliadoComprado) {
					case "Guerrero":
						generarGuerrero(evento.getX(), evento.getY());
				}
				
				
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
