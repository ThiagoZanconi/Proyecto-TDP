package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import aliados.Ballesta;
import aliados.Guerrero;
import enemigos.Normal;
import juego.Aliado;
import juego.Elementos;

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
	
	private JFrame ventanaNivelUno;
	private JPanel panelNivelUno;
	//hay que añadir nivel dos
	
	private JFrame ventanaElegirNivel;
	private JPanel panelElegirNivel;
	
	private JPanel contentPane;
	private JPanel cuadrilla;
	
	
	private boolean veredicto;
	
	private int puntaje;

	
	private JLabel mapaImagen;
	private JLabel labelPuntaje;
	private JLabel labelCoordenadas;
	
	private Hilo hilo;
	private GUI gui;
	private Elementos elementos;
	
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
		elementos=new Elementos();
		
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, 1200, 800);
		
		//Creo el panel de inicio
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		//Creo el boton jugar y lo agrego al panel de inicio
		btnJugar=new JButton(new ImageIcon("Sprites\\medievalbutton\\play-removebg-preview.png"));
		oyenteJugar oyenteJugar=new oyenteJugar();
		btnJugar.addActionListener(oyenteJugar);
		btnJugar.setBounds(this.getWidth()/2,this.getHeight()/2, 220, 236);
		contentPane.add(btnJugar);
		
		
		gui=this;
	}
	
	public void mover() {
		for(int i=0;i<elementos.getEnemigos().size();i++) {
			
			if(elementos.getEnemigos().get(i).enMovimiento()) {
				JLabel grafico =elementos.getEnemigos().get(i).getGrafico();
				Rectangle r=elementos.getEnemigos().get(i).getRectangulo();
				
				r.setBounds((int)r.getX()+10,(int)r.getY(),(int)r.getWidth(),(int)r.getHeight());	
				
				if(elementos.chequearColision(elementos.getEnemigos().get(i))) {
					r.setBounds((int)r.getX()-10,(int)r.getY(),(int)r.getWidth(),(int)r.getHeight());
				}
				else {
					grafico.setBounds(grafico.getX()+10, grafico.getY(), grafico.getWidth(), grafico.getHeight());
				
					if(grafico.getX()>1300) {
						grafico.setBounds(-100, grafico.getY(), grafico.getWidth(), grafico.getHeight());
						r.setBounds(-100,(int)r.getY(),(int)r.getWidth(),(int)r.getHeight());	
					}
					
				}
			
				
			}
			
			
			
		}
		
		
		
		
		this.repaint();
		
		
	}
	
	class oyenteNivelUno implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			aliadoComprado="";
		
			
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
			//mapaImagen.setIcon(new ImageIcon("Sprites\\Mapas\\CmBkLavaM.png"));
			mapaImagen.setBounds(0, 0, 1200, 800);
			ventanaNivelUno.add(mapaImagen);
			ventanaNivelUno.setVisible(true);
			setVisible(false);
			
			
			
			hilo=new Hilo(gui);
			hilo.start();
			
			
			Normal normal=new Normal(100,-177);
			elementos.añadirEnemigo(normal);
			elementos.añadirElemento(normal);
			normal.getGrafico().setBounds(100,-177,1000,1000);
			ventanaNivelUno.add(normal.getGrafico());
			ventanaNivelUno.add(mapaImagen);
			
		}
		
	}
	
	class oyenteNivelDos implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			aliadoComprado="";
		
			
			//Creo la ventana del juego
			ventanaNivelUno=new JFrame("ventanaJuego");
			ventanaNivelUno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ventanaNivelUno.setBounds(0, 0, 1200, 1000);
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
			cuadrilla.setBounds(20,200,1150,560);
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
			
			
			
			hilo=new Hilo(gui);
			hilo.start();
			
			
			Normal normal=new Normal(100,-177);
			elementos.añadirEnemigo(normal);
			elementos.añadirElemento(normal);
			normal.getGrafico().setBounds(100,-177,1000,1000);
			ventanaNivelUno.add(normal.getGrafico());
			ventanaNivelUno.add(mapaImagen);
			
		}
		
	}
	
	class oyenteJugar implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			JButton btnNivelUno;
			JButton btnNivelDos;
			
			//Creo la ventana para elegir Nivel
			ventanaElegirNivel=new JFrame("Elegir Nivel");
			ventanaElegirNivel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ventanaElegirNivel.setBounds(500, 250, 400, 300);
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
		Guerrero guerrero=new Guerrero(arregloAuxiliar[1]-65,arregloAuxiliar[3]-550);
		elementos.añadirAliado(guerrero);
		elementos.añadirElemento(guerrero);
		
		
		
		if(arregloAuxiliar[3]!=0 && arregloAuxiliar[0]!=0) {
			
			
			
			guerrero.getGrafico().setBounds(arregloAuxiliar[1]-65,arregloAuxiliar[3]-550,1000,1000);
			ventanaNivelUno.add(guerrero.getGrafico());
			ventanaNivelUno.add(mapaImagen);
		}
		
		cuadrilla.setVisible(false);
		
		veredicto=false;
	}
	
	private void generarBallesta(int x, int y) {
		int[] arregloAuxiliar=traducirCoordenadas(x,y);
		Ballesta ballesta=new Ballesta(arregloAuxiliar[1]-65,arregloAuxiliar[3]-550);
		elementos.añadirAliado(ballesta);
		elementos.añadirElemento(ballesta);
		
		
		
		if(arregloAuxiliar[3]!=0 && arregloAuxiliar[0]!=0) {
			
			
			ballesta.getGrafico().setBounds(arregloAuxiliar[1]-65,arregloAuxiliar[3]-550,1000,1000);
			ventanaNivelUno.add(ballesta.getGrafico());
			ventanaNivelUno.add(mapaImagen);
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
						break;
					case "Ballesta":
						generarBallesta(evento.getX(), evento.getY());
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
