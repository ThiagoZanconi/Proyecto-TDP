package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import aliados.Ballesta;
import aliados.Escudero;
import aliados.Guerrero;
import aliados.MagoDeFuego;
import aliados.MagoDeHielo;
import enemigos.Curador;
import enemigos.Invocador;
import enemigos.Normal;
import enemigos.Rango;
import enemigos.Rapido;
import enemigos.Tanque;
import juego.Elementos;
import juego.Juego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private String aliadoComprado;
	
	private JButton btnJugar;
	
	
	private JButton btnComprarGuerrero;
	private JButton btnComprarBallesta;
	private JButton btnComprarMagoDeHielo;
	private JButton btnComprarMagoDeFuego;
	private JButton btnComprarEscudero;
	
	private JFrame ventanaNivelUno;
	private JPanel panelNivelUno;
	//hay que añadir nivel dos
	
	private JFrame ventanaElegirNivel;
	private JPanel panelElegirNivel;
	
	private JPanel contentPane;
	private JLabel menuImagen;
	private JLabel menuLluvia;
		
	private JPanel cuadrilla;
	
	
	private boolean veredicto;
	
	private int puntaje;
	private JLabel mapaImagen;
	private JLabel labelPuntaje;
	private JLabel labelCoordenadas;
	
	private Hilo hilo;
	private GUI gui;
	private Elementos elementos;
	private Juego juego;
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
		elementos=elementos.getElementos();
		
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(300, 100, 1200, 770);
		
		//Creo el panel de inicio
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//Creo el boton jugar y lo agrego al panel de inicio
		btnJugar=new JButton(new ImageIcon("Sprites\\button_elegir-nivel.png"));
		oyenteJugar oyenteJugar=new oyenteJugar();
		btnJugar.addActionListener(oyenteJugar);
		btnJugar.setFocusPainted(false);
		btnJugar.setBounds(100, 290, 170, 53);
		contentPane.add(btnJugar);
		
		//Creo el boton opciones y lo agrego al panel de inicio
		JButton btnOpciones;
		btnOpciones=new JButton(new ImageIcon("Sprites\\button_opciones.png"));
		//oyenteOpciones oyenteOpciones=new oyenteOpciones();
		//btnOpciones.addActionListener(oyenteOpciones);
		btnOpciones.setFocusPainted(false);
		btnOpciones.setBounds(100, 370, 170, 53);
		contentPane.add(btnOpciones);
		
		//Creo el boton creditos y lo agrego al panel de inicio
		JButton btnCreditos;
		btnCreditos=new JButton(new ImageIcon("Sprites\\button_creditos.png"));
		oyenteCreditos oyenteCreditos=new oyenteCreditos();
		btnCreditos.addActionListener(oyenteCreditos);
		btnCreditos.setFocusPainted(false);
		btnCreditos.setBounds(100, 450, 170, 53);
		contentPane.add(btnCreditos);
				
		//Creo el boton salir y lo agrego al panel de inicio
		JButton btnSalir;
		btnSalir=new JButton(new ImageIcon("Sprites\\button_salir.png"));
		oyenteSalir oyenteSalir=new oyenteSalir();
		btnSalir.addActionListener(oyenteSalir);
		btnSalir.setFocusPainted(false);
		btnSalir.setBounds(100, 530, 170, 53);
		contentPane.add(btnSalir);
		
		//Label del panel
		JLabel panel=new JLabel();
		panel.setIcon(new ImageIcon("Sprites\\panel-removebg-preview.png"));
		panel.setBounds(50, 250, 300, 400);
		contentPane.add(panel);
		
		//Lluvia
		///**
		menuLluvia=new JLabel();
		menuLluvia.setIcon(new ImageIcon("Sprites\\rain.gif"));
		menuLluvia.setBounds(0, -130, 1400, 1000);
		contentPane.add(menuLluvia);
		//**/
		
		
				
		//Label del titulo
		JLabel titulo=new JLabel();
		titulo.setIcon(new ImageIcon("Sprites\\titulotest3.png"));
		titulo.setBounds(300, -25, 690, 200);
		contentPane.add(titulo);
				
		
		//Imagen del menu
		menuImagen=new JLabel();
		menuImagen.setIcon(new ImageIcon("Sprites\\menu1.png"));
		menuImagen.setBounds(0, 0, 1200, 800);
		contentPane.add(menuImagen);
				
		
		gui=this;
		juego=juego.getJuego(this);
	}
	
	class oyenteSalir implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	class oyenteNivelUno implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			aliadoComprado="";
			
			ventanaElegirNivel.setVisible(false);
			
			//Creo la ventana del Nivel Uno
			ventanaNivelUno=new JFrame("ventanaJuego");
			ventanaNivelUno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ventanaNivelUno.setBounds(0, 0, 1200, 1000);
			ventanaNivelUno.addMouseListener(click);
			
			//Creo el panel del Nivel Uno y le agrego la ventana
			panelNivelUno=new JPanel();
			panelNivelUno.setBorder(new EmptyBorder(5, 5, 5, 5));
			ventanaNivelUno.setContentPane(panelNivelUno);
			panelNivelUno.setLayout(null);
           
			
			//Creo el boton comprar guerrero y lo agrego a la ventana
			btnComprarGuerrero=new JButton("Guerrero");
			oyenteComprarGuerrero oyenteComprarGuerrero =new oyenteComprarGuerrero();
			btnComprarGuerrero.addActionListener(oyenteComprarGuerrero);
			btnComprarGuerrero.setBounds(0, 800, 100, 100);
			ventanaNivelUno.add(btnComprarGuerrero);
			btnComprarGuerrero.setVisible(true);
			
			//Creo el boton comprar Ballesta y lo agrego a la ventana
			btnComprarBallesta=new JButton("Ballesta");
			oyenteComprarBallesta oyenteComprarBallesta =new oyenteComprarBallesta();
			btnComprarBallesta.addActionListener(oyenteComprarBallesta);
			btnComprarBallesta.setBounds(100, 800, 100, 100);
			ventanaNivelUno.add(btnComprarBallesta);
			btnComprarBallesta.setVisible(true);
			
			//Creo el boton comprar Mago de Hielo y lo agrego a la ventana
			btnComprarMagoDeHielo=new JButton("Mago de Hielo");
			oyenteComprarMagoDeHielo oyenteComprarMagoDeHielo =new oyenteComprarMagoDeHielo();
			btnComprarMagoDeHielo.addActionListener(oyenteComprarMagoDeHielo);
			btnComprarMagoDeHielo.setBounds(200, 800, 100, 100);
			ventanaNivelUno.add(btnComprarMagoDeHielo);
			btnComprarMagoDeHielo.setVisible(true);
			
			//Creo el boton comprar Mago de Fuego y lo agrego a la ventana
			btnComprarMagoDeFuego=new JButton("Mago de Fuego");
			oyenteComprarMagoDeFuego oyenteComprarMagoDeFuego =new oyenteComprarMagoDeFuego();
			btnComprarMagoDeFuego.addActionListener(oyenteComprarMagoDeFuego);
			btnComprarMagoDeFuego.setBounds(300, 800, 100, 100);
			ventanaNivelUno.add(btnComprarMagoDeFuego);
			btnComprarMagoDeFuego.setVisible(true);
			
			//Creo el boton comprar Escudero y lo agrego a la ventana
			btnComprarEscudero=new JButton("Escudero");
			oyenteComprarEscudero oyenteComprarEscudero =new oyenteComprarEscudero();
			btnComprarEscudero.addActionListener(oyenteComprarEscudero);
			btnComprarEscudero.setBounds(400, 800, 100, 100);
			ventanaNivelUno.add(btnComprarEscudero);
			btnComprarEscudero.setVisible(true);
			
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
			ventanaNivelUno.add(labelPuntaje);
			
			labelCoordenadas=new JLabel();
			labelCoordenadas.setText("");
			labelCoordenadas.setBounds(500, 30, 100, 30);
			labelCoordenadas.setBorder(BorderFactory.createLineBorder(Color.black));
			labelCoordenadas.setBackground(Color.green);
			labelCoordenadas.setOpaque(true);
			ventanaNivelUno.add(labelCoordenadas);
				
			//Crea la cuadrilla
			cuadrilla=new JPanel();
			cuadrilla.setLayout(new GridLayout(6,10));
			llenarCuadrilla();
			cuadrilla.setBounds(20,200,1150,560);
			cuadrilla.setOpaque(false);
			ventanaNivelUno.add(cuadrilla);
			cuadrilla.setVisible(false);
			
			//Creo el mapa y lo agrego a la ventana
			mapaImagen=new JLabel();
			mapaImagen.setIcon(new ImageIcon("Sprites\\Mapas\\CmBkGrMtMod.png"));
			mapaImagen.setBounds(0, 0, 1200, 800);
			//ventanaNivelUno.add(mapaImagen);
			ventanaNivelUno.setVisible(true);
			setVisible(false);
			
			hilo=new Hilo(gui,juego);
			hilo.start();
			
			
			Normal normal=new Normal(100,-155);
			elementos.añadirElemento(normal);
			normal.getGrafico().setBounds(100,-155,1000,1000);
			ventanaNivelUno.add(normal.getGrafico());
			
			Rapido rapido=new Rapido(100,-70);
			elementos.añadirElemento(rapido);
			rapido.getGrafico().setBounds(100,-70,1000,1000);
			ventanaNivelUno.add(rapido.getGrafico());
			
			Tanque tanque=new Tanque(100,20);
			elementos.añadirElemento(tanque);
			tanque.getGrafico().setBounds(100,20,1000,1000);
			ventanaNivelUno.add(tanque.getGrafico());
			
			Rango rango=new Rango(100,200);
			elementos.añadirElemento(rango);
			rango.getGrafico().setBounds(100,200,1000,1000);
			ventanaNivelUno.add(rango.getGrafico());
			
			Curador curador=new Curador(100,-260);
			elementos.añadirElemento(curador);
			curador.getGrafico().setBounds(100,-260,1000,1000);
			ventanaNivelUno.add(curador.getGrafico());
			
			Invocador invocador=new Invocador(300,-260);
			elementos.añadirElemento(invocador);
			invocador.getGrafico().setBounds(300,-260,1000,1000);
			ventanaNivelUno.add(invocador.getGrafico());
			
			
			//ventanaNivelUno.add(mapaImagen);	
		}
		
	}
	
	class oyenteNivelDos implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			aliadoComprado="";
		
			ventanaElegirNivel.setVisible(false);
						
			//Creo la ventana del juego
			ventanaNivelUno=new JFrame("ventanaJuego");
			ventanaNivelUno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ventanaNivelUno.setBounds(0, 0, 1200, 1000);
			ventanaNivelUno.setLayout(new BorderLayout());
			ventanaNivelUno.addMouseListener(click);
			
			//Creo el panel del juego y le agrego la ventana
			panelNivelUno=new JPanel();
			panelNivelUno.setBorder(new EmptyBorder(5, 5, 5, 5));
			ventanaNivelUno.setContentPane(panelNivelUno);
			panelNivelUno.setLayout(null);
           
			
			//Creo el boton comprar guerrero y lo agrego a la ventana
			btnComprarGuerrero=new JButton("Guerrero");
			oyenteComprarGuerrero oyenteComprarGuerrero =new oyenteComprarGuerrero();
			btnComprarGuerrero.addActionListener(oyenteComprarGuerrero);
			btnComprarGuerrero.setBounds(0, 800, 100, 100);
			ventanaNivelUno.add(btnComprarGuerrero);
			btnComprarGuerrero.setVisible(true);
			
			//Creo el boton comprar Ballesta y lo agrego a la ventana
			btnComprarBallesta=new JButton("Ballesta");
			oyenteComprarBallesta oyenteComprarBallesta =new oyenteComprarBallesta();
			btnComprarBallesta.addActionListener(oyenteComprarBallesta);
			btnComprarBallesta.setBounds(100, 800, 100, 100);
			ventanaNivelUno.add(btnComprarBallesta);
			btnComprarBallesta.setVisible(true);
			
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
			ventanaNivelUno.add(labelPuntaje);
			
			labelCoordenadas=new JLabel();
			labelCoordenadas.setText("");
			labelCoordenadas.setBounds(500, 30, 100, 30);
			labelCoordenadas.setBorder(BorderFactory.createLineBorder(Color.black));
			labelCoordenadas.setBackground(Color.green);
			labelCoordenadas.setOpaque(true);
			ventanaNivelUno.add(labelCoordenadas);
				
			//Crea la cuadrilla
			cuadrilla=new JPanel();
			cuadrilla.setLayout(new GridLayout(6,10));
			llenarCuadrilla();
			cuadrilla.setBounds(20,220,1150,560);
			cuadrilla.setOpaque(false);
			ventanaNivelUno.add(cuadrilla);
			cuadrilla.setVisible(false);
			
			//Creo el mapa y lo agrego a la ventana
			mapaImagen=new JLabel();
			mapaImagen.setIcon(new ImageIcon("Sprites\\Mapas\\CmBkLavaM.png"));
			mapaImagen.setBounds(0, 0, 1200, 800);
			ventanaNivelUno.add(mapaImagen);
			ventanaNivelUno.setVisible(true);
			setVisible(false);
		
			hilo=new Hilo(gui,juego);
			hilo.start();
					
			Normal normal=new Normal(100,-177);
			
			elementos.añadirElemento(normal);
			normal.getGrafico().setBounds(100,-177,1000,1000);
			ventanaNivelUno.add(normal.getGrafico());
			ventanaNivelUno.add(mapaImagen);
			
		}
		
	}
	
	class oyenteCreditos implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JFrame cred;
			JLabel panel=new JLabel(new ImageIcon("Sprites\\cred.png"));
			JPanel credPane=new JPanel();
					
			//Creo la ventana de los creditos		
			cred=new JFrame("Creditos");
			cred.setBounds(700,400,245,150);
			cred.setVisible(true);
			cred.setResizable(false);			
			
			//Creo la ventana del panel
			credPane=new JPanel();
			credPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			cred.setContentPane(credPane);
			credPane.setLayout(null);
			
			credPane.add(panel);
			panel.setBounds(0, 0, 245, 122);
			panel.setVisible(true);
			
		}
	}
	
	class oyenteJugar implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			JButton btnNivelUno;
			JButton btnNivelDos;
			
			//Creo la ventana para elegir Nivel
			ventanaElegirNivel=new JFrame("Elegir Nivel");
			ventanaElegirNivel.setBounds(700, 250, 400, 300);
			ventanaElegirNivel.setVisible(true);
			ventanaElegirNivel.setResizable(false);
			
			//Creo el panel para elegir Nivel
			panelElegirNivel=new JPanel();
			panelElegirNivel.setBorder(new EmptyBorder(5, 5, 5, 5));
			ventanaElegirNivel.setContentPane(panelElegirNivel);
			panelElegirNivel.setLayout(null);
			
			//Creo el boton Nivel uno y lo agrego
			 
			btnNivelUno=new JButton(new ImageIcon("Sprites\\medievalbutton\\nivel1-removebg-preview.png"));
			oyenteNivelUno oyenteNivelUno=new oyenteNivelUno();
			btnNivelUno.addActionListener(oyenteNivelUno);
			btnNivelUno.setBounds(ventanaElegirNivel.getWidth()/10,ventanaElegirNivel.getHeight()/5, 110, 150);
			panelElegirNivel.add(btnNivelUno);
			
			//Creo el boton Nivel dos y lo agrego
			btnNivelDos=new JButton(new ImageIcon("Sprites\\medievalbutton\\nivel2-removebg-preview.png"));
			oyenteNivelDos oyenteNivelDos=new oyenteNivelDos();
			btnNivelDos.addActionListener(oyenteNivelDos);
			btnNivelDos.setBounds(ventanaElegirNivel.getWidth()/2+50,ventanaElegirNivel.getHeight()/5, 110, 150);
			panelElegirNivel.add(btnNivelDos);
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
	
	class oyenteComprarBallesta implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			veredicto=true;
			aliadoComprado="Ballesta";
			cuadrilla.setVisible(true);
			
		}
	}
	
	class oyenteComprarMagoDeHielo implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			veredicto=true;
			aliadoComprado="MagoDeHielo";
			cuadrilla.setVisible(true);
			
		}
	}
	
	class oyenteComprarMagoDeFuego implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			veredicto=true;
			aliadoComprado="MagoDeFuego";
			cuadrilla.setVisible(true);
			
		}
	}
	
	class oyenteComprarEscudero implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			veredicto=true;
			aliadoComprado="Escudero";
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
	
	@SuppressWarnings("deprecation")
	private void generarGuerrero(int x, int y) {
		int[] arregloAuxiliar=traducirCoordenadas(x,y);
		Guerrero guerrero=new Guerrero(arregloAuxiliar[1]-65,arregloAuxiliar[3]-550);
		elementos.añadirElemento(guerrero);
		if(arregloAuxiliar[3]!=0 && arregloAuxiliar[0]!=0) {
			guerrero.getGrafico().setBounds(arregloAuxiliar[1]-65,arregloAuxiliar[3]-550,1000,1000);
			ventanaNivelUno.add(guerrero.getGrafico());
			//ventanaNivelUno.add(mapaImagen);
		}
		juego.chequearColision(guerrero);
		cuadrilla.setVisible(false);
		
		veredicto=false;

	}
	
	private void generarBallesta(int x, int y) {
		int[] arregloAuxiliar=traducirCoordenadas(x,y);
		Ballesta ballesta=new Ballesta(arregloAuxiliar[1]-65,arregloAuxiliar[3]-550);
		elementos.añadirElemento(ballesta);
		
		if(arregloAuxiliar[3]!=0 && arregloAuxiliar[0]!=0) {
			ballesta.getGrafico().setBounds(arregloAuxiliar[1]-65,arregloAuxiliar[3]-550,1000,1000);
			ventanaNivelUno.add(ballesta.getGrafico());
			//ventanaNivelUno.add(mapaImagen);
		}
		juego.chequearColision(ballesta);
		
		
		cuadrilla.setVisible(false);
		veredicto=false;
	}
	
	private void generarMagoDeHielo(int x, int y) {
		int[] arregloAuxiliar=traducirCoordenadas(x,y);
		MagoDeHielo MagoDeHielo=new MagoDeHielo(arregloAuxiliar[1]-65,arregloAuxiliar[3]-550);
		elementos.añadirElemento(MagoDeHielo);
		
		if(arregloAuxiliar[3]!=0 && arregloAuxiliar[0]!=0) {
			MagoDeHielo.getGrafico().setBounds(arregloAuxiliar[1]-65,arregloAuxiliar[3]-550,1000,1000);
			ventanaNivelUno.add(MagoDeHielo.getGrafico());
			//ventanaNivelUno.add(mapaImagen);
		}
		juego.chequearColision(MagoDeHielo);
		
		
		cuadrilla.setVisible(false);
		veredicto=false;
	}
	
	private void generarMagoDeFuego(int x, int y) {
		int[] arregloAuxiliar=traducirCoordenadas(x,y);
		MagoDeFuego MagoDeFuego=new MagoDeFuego(arregloAuxiliar[1]-65,arregloAuxiliar[3]-550);
		elementos.añadirElemento(MagoDeFuego);
		
		if(arregloAuxiliar[3]!=0 && arregloAuxiliar[0]!=0) {
			MagoDeFuego.getGrafico().setBounds(arregloAuxiliar[1]-65,arregloAuxiliar[3]-550,1000,1000);
			ventanaNivelUno.add(MagoDeFuego.getGrafico());
			//ventanaNivelUno.add(mapaImagen);
		}
		juego.chequearColision(MagoDeFuego);
		
		
		cuadrilla.setVisible(false);
		veredicto=false;
	}
	
	private void generarEscudero(int x, int y) {
		int[] arregloAuxiliar=traducirCoordenadas(x,y);
		Escudero Escudero=new Escudero(arregloAuxiliar[1]-65,arregloAuxiliar[3]-550);
		elementos.añadirElemento(Escudero);
		
		if(arregloAuxiliar[3]!=0 && arregloAuxiliar[0]!=0) {
			Escudero.getGrafico().setBounds(arregloAuxiliar[1]-65,arregloAuxiliar[3]-550,1000,1000);
			ventanaNivelUno.add(Escudero.getGrafico());
			//ventanaNivelUno.add(mapaImagen);
		}
		juego.chequearColision(Escudero);
		
		
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
						break;
					case "Ballesta":
						generarBallesta(evento.getX(), evento.getY());
						break;
					case "MagoDeHielo":
						generarMagoDeHielo(evento.getX(), evento.getY());
						break;
					case "MagoDeFuego":
						generarMagoDeFuego(evento.getX(), evento.getY());
						break;
					case "Escudero":
						generarEscudero(evento.getX(), evento.getY());
						break;	
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
