package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import juego.Juego;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	private JLabel mapaImagen;
	
	private JTextArea textoDescripcion;
	private JLabel fotoDescripcion;
	
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
		
		juego=Juego.getJuego();
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
			
			//Creo el panel del Nivel Uno y le agrego la ventana
			panelNivelUno=new JPanel();
			panelNivelUno.setBorder(new EmptyBorder(5, 5, 5, 5));
			panelNivelUno.setLayout(null);
			ventanaNivelUno.setContentPane(panelNivelUno);
			
			//Creo el mapa y lo agrego a la ventana
			mapaImagen=new JLabel();
			mapaImagen.setIcon(new ImageIcon("Sprites\\Mapas\\CmBkSnMt.png"));
			mapaImagen.setBounds(0, 0, 1300, 1024);
			panelNivelUno.add(mapaImagen);
			ventanaNivelUno.setVisible(true);
			setVisible(false);
			
			//Inicializo descripcion
			textoDescripcion=new JTextArea();
			fotoDescripcion=new JLabel();
			textoDescripcion.setText("");
			fotoDescripcion.setIcon(null);
			
			juego.iniciarJuego();
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
			
			//Creo el panel del juego y le agrego la ventana
			panelNivelUno=new JPanel();
			panelNivelUno.setBorder(new EmptyBorder(5, 5, 5, 5));
			ventanaNivelUno.setContentPane(panelNivelUno);
			panelNivelUno.setLayout(null);	
			
			//Creo el mapa y lo agrego a la ventana
			mapaImagen=new JLabel();
			mapaImagen.setIcon(new ImageIcon("Sprites\\Mapas\\CmBkLavaM.png"));
			mapaImagen.setBounds(0, 0, 1200, 800);
			ventanaNivelUno.add(mapaImagen);
			ventanaNivelUno.setVisible(true);
			setVisible(false);					
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
}
