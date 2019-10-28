package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
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

public final class GUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JButton btnJugar;

	private JFrame ventanaNivelUno;
	private JPanel panelNivelUno;
	//hay que añadir nivel dos
	
	private JFrame ventanaElegirNivel;
	private JPanel panelElegirNivel;
	
	private JPanel contentPane;
	private JLabel menuImagen;
	private JLabel menuLluvia;
		
	private JPanel cuadrilla;
	
	private int puntaje;
	private int monedas;
	private JLabel mapaImagen;
	private JLabel labelPuntaje;
	private JLabel labelMonedas;
	private JLabel imagenMonedas;
	private JLabel labelCoordenadas;
	
	private JTextArea textoDescripcion;
	private JLabel fotoDescripcion;
	
	private Hilo hilo;
	private static final GUI gui=new GUI();
	private Elementos elementos;
	private Juego juego;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private GUI() {
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
		titulo.setIcon(new ImageIcon("Sprites\\titulotest2.png"));
		titulo.setBounds(300, -25, 690, 200);
		contentPane.add(titulo);
				
		//Imagen del menu
		menuImagen=new JLabel();
		menuImagen.setIcon(new ImageIcon("Sprites\\menu1.png"));
		menuImagen.setBounds(0, 0, 1200, 800);
		contentPane.add(menuImagen);
		
		juego=juego.getJuego();
	}
	
	public static GUI getGUI() {
		return gui;	
	}
	
	public JFrame getVentanaJuego() {
		return ventanaNivelUno;
	}
	
	public JPanel getPanelNivelUno() {
		return panelNivelUno;
	}
	
	class oyenteSalir implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	class oyenteNivelUno implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			ventanaElegirNivel.setVisible(false);
			
			//Creo la ventana del Nivel Uno.
			ventanaNivelUno=new JFrame("ventanaJuego");
			ventanaNivelUno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ventanaNivelUno.setBounds(0, 0, 1200, 1000);
			ventanaNivelUno.addMouseListener(click);
			
			//Creo el panel del Nivel Uno y le agrego la ventana
			panelNivelUno=new JPanel();
			panelNivelUno.setBorder(new EmptyBorder(5, 5, 5, 5));
			ventanaNivelUno.setContentPane(panelNivelUno);
			panelNivelUno.setLayout(null);
			
			//Inicializo descripcion
			textoDescripcion=new JTextArea();
			fotoDescripcion=new JLabel();
			textoDescripcion.setText("");
			fotoDescripcion.setIcon(null);
			
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
			
			//Crea cosas relacionadas a monedas
			imagenMonedas=new JLabel();
			imagenMonedas.setIcon(new ImageIcon("Sprites\\monedas.png"));
			imagenMonedas.setBounds(650, 30, 32, 32);
			ventanaNivelUno.add(imagenMonedas);
			monedas=10000;
			labelMonedas=new JLabel();
			labelMonedas.setText(String.valueOf(monedas));
			labelMonedas.setBounds(685,30,40,30);
			labelMonedas.setBorder(BorderFactory.createLineBorder(Color.black));
			labelMonedas.setBackground(Color.green);
			labelMonedas.setOpaque(true);
			ventanaNivelUno.add(labelMonedas);
				
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
			ventanaNivelUno.add(curador.getGrafico());
			
			Invocador invocador=new Invocador(300,-260);
			elementos.añadirElemento(invocador);
			invocador.getGrafico().setBounds(300,-260,1000,1000);
			ventanaNivelUno.add(invocador.getGrafico());
			
			juego.iniciarJuego();
			//ventanaNivelUno.add(mapaImagen);	
		}
		
	}
	
	class oyenteNivelDos implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		
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
	
	MouseListener click=new MouseListener() {
		@Override
		public void mousePressed(MouseEvent evento) {
			labelCoordenadas.setText("X: "+evento.getX()+" Y: "+evento.getY());
			if(juego.crearAliado()  ) {
				switch (juego.aliadoComprado()) {
					case "Guerrero":
						juego.generarGuerrero(evento.getX(), evento.getY());
						break;
					case "Ballesta":
						juego.generarBallesta(evento.getX(), evento.getY());
						break;
					case "MagoDeHielo":
						juego.generarMagoDeHielo(evento.getX(), evento.getY());
						break;
					case "MagoDeFuego":
						juego.generarMagoDeFuego(evento.getX(), evento.getY());
						break;
					case "Escudero":
						juego.generarEscudero(evento.getX(), evento.getY());
						break;	
					case "Barricada":
						juego.generarBarricada(evento.getX(), evento.getY());
						break;		
				}
				cuadrilla.setVisible(false);
	
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
