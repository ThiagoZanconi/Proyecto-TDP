package gui;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import juego.Juego;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class GUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JButton btnJugar;

	private JFrame ventanaJuego;
	private JPanel panelJuego;
	//hay que añadir nivel dos
	
	private JFrame ventanaElegirNivel;
	private JPanel panelElegirNivel;
	
	private JPanel contentPane;
	private JLabel menuImagen;
	private JLabel menuLluvia;

	private JLabel mapaImagen;
	
	private static final GUI gui=new GUI();
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
		menuPrincipal();
		juego=Juego.getJuego();
	}
	
	public static GUI getGUI() {
		return gui;	
	}
	
	public JFrame getVentanaJuego() {
		return ventanaJuego;
	}
	
	public void menuPrincipal() {
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
		oyenteOpciones oyenteOpciones=new oyenteOpciones();
		btnOpciones.addActionListener(oyenteOpciones);
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
		menuLluvia=new JLabel();
		menuLluvia.setIcon(new ImageIcon("Sprites\\rain.gif"));
		menuLluvia.setBounds(0, -130, 1400, 1000);
		contentPane.add(menuLluvia);
			
		//Label del titulo
		JLabel titulo=new JLabel();
		titulo.setIcon(new ImageIcon("Sprites\\titulo.png"));
		titulo.setBounds(280, -25, 800, 200);
		contentPane.add(titulo);
				
		//Imagen del menu
		menuImagen=new JLabel();
		menuImagen.setIcon(new ImageIcon("Sprites\\menu1.png"));
		menuImagen.setBounds(0, 0, 1200, 800);
		contentPane.add(menuImagen);
		setVisible(true);
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
			ventanaJuego=new JFrame("ventanaJuego");
			ventanaJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ventanaJuego.setBounds(0, 0, 1200, 1000);
			
			//Creo el panel del Nivel Uno y le agrego la ventana
			panelJuego=new JPanel();
			panelJuego.setBorder(new EmptyBorder(5, 5, 5, 5));
			panelJuego.setLayout(null);
			ventanaJuego.setContentPane(panelJuego);
			
			//Creo el mapa y lo agrego a la ventana
			mapaImagen=new JLabel();
			mapaImagen.setIcon(new ImageIcon("Sprites\\Mapas\\CmBkSnMt.png"));
			mapaImagen.setBounds(0, 0, 1300, 1024);
			panelJuego.add(mapaImagen);
			ventanaJuego.setVisible(true);
			setVisible(false);
			
			juego.iniciarNivelUno();
		}	
	}
	
	class oyenteNivelDos implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		
			ventanaElegirNivel.setVisible(false);
						
			//Creo la ventana del juego
			ventanaJuego=new JFrame("ventanaJuego");
			ventanaJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ventanaJuego.setBounds(0, 0, 1200, 1000);
			
			//Creo el panel del juego y le agrego la ventana
			panelJuego=new JPanel();
			panelJuego.setBorder(new EmptyBorder(5, 5, 5, 5));
			ventanaJuego.setContentPane(panelJuego);
			panelJuego.setLayout(null);	
			
			//Creo el mapa y lo agrego a la ventana
			mapaImagen=new JLabel();
			mapaImagen.setIcon(new ImageIcon("Sprites\\Mapas\\mapa2.png"));
			mapaImagen.setBounds(0, 0, 1300, 1024);
			ventanaJuego.add(mapaImagen);
			ventanaJuego.setVisible(true);
			setVisible(false);
			
			juego.iniciarNivelDos();
		}
	}
	
	class oyenteOpciones implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JFrame opc;
			JLabel panel=new JLabel(new ImageIcon("Sprites\\opciones.png"));
			JPanel opcPane=new JPanel();
					
			//Creo la ventana de las opciones		
			opc=new JFrame("Opciones");
			opc.setBounds(700,400,550,288);
			opc.setVisible(true);
			opc.setResizable(false);			
			
			//Creo la ventana del panel
			opcPane=new JPanel();
			opcPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			opc.setContentPane(opcPane);
			opcPane.setLayout(null);
			
			opcPane.add(panel);
			panel.setBounds(0, 0, 550, 274);
			panel.setVisible(true);
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
			JLabel fondo;
			
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
			btnNivelUno=new JButton(new ImageIcon("Sprites\\nivelUno.png"));
			oyenteNivelUno oyenteNivelUno=new oyenteNivelUno();
			btnNivelUno.addActionListener(oyenteNivelUno);
			btnNivelUno.setBounds(115, 40, 168, 70);
			panelElegirNivel.add(btnNivelUno);
			
			//Creo el boton Nivel dos y lo agrego
			btnNivelDos=new JButton(new ImageIcon("Sprites\\nivelDos.png"));
			oyenteNivelDos oyenteNivelDos=new oyenteNivelDos();
			btnNivelDos.addActionListener(oyenteNivelDos);
			btnNivelDos.setBounds(115, 160, 168, 70);
			panelElegirNivel.add(btnNivelDos);
			
			//Creo el fondo
			fondo=new JLabel(new ImageIcon("Sprites\\elegirNivel.png"));
			panelElegirNivel.add(fondo);
			fondo.setBounds(0,0,400,300);
			fondo.setVisible(true);
		}
	}
	
}
