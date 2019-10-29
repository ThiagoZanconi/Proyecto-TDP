package juego;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import adaptador.Adaptador;
import aliados.Ballesta;
import aliados.Barricada;
import aliados.Escudero;
import aliados.Guerrero;
import aliados.MagoDeFuego;
import aliados.MagoDeHielo;
import gui.GUI;

public class Tienda {
	private JButton btnComprarGuerrero;
	private JButton btnComprarBallesta;
	private JButton btnComprarMagoDeHielo;
	private JButton btnComprarMagoDeFuego;
	private JButton btnComprarEscudero;
	private JButton btnComprarBarricada;
	
	protected int puntaje;
	protected int monedas;
	private JLabel labelPuntaje;
	private JLabel labelMonedas;
	private JLabel imagenMonedas;
	
	protected JPanel cuadrilla;
	protected boolean crearAliado;
	protected String aliadoComprado;
	protected static GUI gui;
	protected Adaptador adaptador;
	
	public Tienda() {
		crearAliado=false;
		aliadoComprado="";
		gui=GUI.getGUI();
		adaptador=Adaptador.getAdaptador();
		
		//Creo el boton comprar Guerrero y lo agrego a la ventana
		btnComprarGuerrero=new JButton("Guerrero");
		oyenteComprarGuerrero oyenteComprarGuerrero =new oyenteComprarGuerrero();
		btnComprarGuerrero.addActionListener(oyenteComprarGuerrero);
		btnComprarGuerrero.setBounds(0, 670, 100, 100);
		gui.getVentanaJuego().add(btnComprarGuerrero);
		btnComprarGuerrero.setVisible(true);
		
		//Creo el boton comprar Ballesta y lo agrego a la ventana
		btnComprarBallesta=new JButton("Ballesta");
		oyenteComprarBallesta oyenteComprarBallesta =new oyenteComprarBallesta();
		btnComprarBallesta.addActionListener(oyenteComprarBallesta);
		btnComprarBallesta.setBounds(100, 670, 100, 100);
		gui.getVentanaJuego().add(btnComprarBallesta);
		btnComprarBallesta.setVisible(true);
		
		//Creo el boton comprar Mago de Hielo y lo agrego a la ventana
		btnComprarMagoDeHielo=new JButton("Mago de Hielo");
		oyenteComprarMagoDeHielo oyenteComprarMagoDeHielo =new oyenteComprarMagoDeHielo();
		btnComprarMagoDeHielo.addActionListener(oyenteComprarMagoDeHielo);
		btnComprarMagoDeHielo.setBounds(200, 670, 100, 100);
		gui.getVentanaJuego().add(btnComprarMagoDeHielo);
		btnComprarMagoDeHielo.setVisible(true);
		
		//Creo el boton comprar Mago de Fuego y lo agrego a la ventana
		btnComprarMagoDeFuego=new JButton("Mago de Fuego");
		oyenteComprarMagoDeFuego oyenteComprarMagoDeFuego =new oyenteComprarMagoDeFuego();
		btnComprarMagoDeFuego.addActionListener(oyenteComprarMagoDeFuego);
		btnComprarMagoDeFuego.setBounds(300, 670, 100, 100);
		gui.getVentanaJuego().add(btnComprarMagoDeFuego);
		btnComprarMagoDeFuego.setVisible(true);
		
		//Creo el boton comprar Escudero y lo agrego a la ventana
		btnComprarEscudero=new JButton("Escudero");
		oyenteComprarEscudero oyenteComprarEscudero =new oyenteComprarEscudero();
		btnComprarEscudero.addActionListener(oyenteComprarEscudero);
		btnComprarEscudero.setBounds(400,670, 100, 100);
		gui.getVentanaJuego().add(btnComprarEscudero);
		btnComprarEscudero.setVisible(true);
		
		//Creo el boton comprar Barricada y lo agrego a la ventana
		btnComprarBarricada=new JButton("Barricada");
		oyenteComprarBarricada oyenteComprarBarricada =new oyenteComprarBarricada();
		btnComprarBarricada.addActionListener(oyenteComprarBarricada);
		btnComprarBarricada.setBounds(500, 670, 100, 100);
		gui.getVentanaJuego().add(btnComprarBarricada);
		btnComprarBarricada.setVisible(true);
		
		//Creo la cuadrilla
		cuadrilla=new JPanel();
		cuadrilla.setLayout(new GridLayout(6,10));
		llenarCuadrilla();
		cuadrilla.setBounds(0,70,1110,600);
		cuadrilla.setOpaque(false);
		gui.getVentanaJuego().add(cuadrilla);
		cuadrilla.setVisible(false);
		
		//Monedas
		imagenMonedas=new JLabel();
		imagenMonedas.setIcon(new ImageIcon("Sprites\\monedas.png"));
		imagenMonedas.setBounds(650, 30, 32, 32);
		gui.getVentanaJuego().add(imagenMonedas);
		monedas=100;
		labelMonedas=new JLabel();
		labelMonedas.setText(String.valueOf(monedas));
		labelMonedas.setBounds(685,30,40,30);
		labelMonedas.setBorder(BorderFactory.createLineBorder(Color.black));
		labelMonedas.setBackground(Color.green);
		labelMonedas.setOpaque(true);
		gui.getVentanaJuego().add(labelMonedas);
		
		//Puntaje
		puntaje= 0;
		labelPuntaje= new JLabel();
		labelPuntaje.setText(String.valueOf(puntaje));
		labelPuntaje.setBounds(400,30,40,30);
		labelPuntaje.setBorder(BorderFactory.createLineBorder(Color.black));
		labelPuntaje.setBackground(Color.green);
		labelPuntaje.setOpaque(true);
		gui.getVentanaJuego().add(labelPuntaje);
		
		//Añado el MouseListener
		gui.getVentanaJuego().addMouseListener(click);	
	
	}	
	
	private void llenarCuadrilla() {
		for(int i=0;i<60;i++) {
			JLabel labelAuxiliar=new JLabel();
			labelAuxiliar.setBorder(BorderFactory.createLineBorder(Color.black));
			cuadrilla.add(labelAuxiliar);
		}
	}	
	
	public boolean crearAliado() {
		return crearAliado;
	}
	
	public String aliadoComprado() {
		return aliadoComprado;
	}
	
	public void generarGuerrero(int x, int y) {
		int[] arregloAuxiliar=traducirCoordenadas(x,y);
		Guerrero guerrero=new Guerrero(arregloAuxiliar[0]-65,arregloAuxiliar[1]-550);
		adaptador.añadirElemento(guerrero);
		gui.getVentanaJuego().add(guerrero.getGrafico());
		adaptador.chequearColision(guerrero);
		cuadrilla.setVisible(false);
		crearAliado=false;
	}
	
	public void generarBallesta(int x, int y) {
		int[] arregloAuxiliar=traducirCoordenadas(x,y);
		Ballesta ballesta=new Ballesta(arregloAuxiliar[0]-65,arregloAuxiliar[1]-550);
		adaptador.añadirElemento(ballesta);
		gui.getVentanaJuego().add(ballesta.getGrafico());
		adaptador.chequearColision(ballesta);	
		cuadrilla.setVisible(false);
		crearAliado=false;
	}
	
	public void generarMagoDeHielo(int x, int y) {
		int[] arregloAuxiliar=traducirCoordenadas(x,y);
		MagoDeHielo MagoDeHielo=new MagoDeHielo(arregloAuxiliar[0]-65,arregloAuxiliar[1]-550);
		adaptador.añadirElemento(MagoDeHielo);
		gui.getVentanaJuego().add(MagoDeHielo.getGrafico());
		adaptador.chequearColision(MagoDeHielo);
		cuadrilla.setVisible(false);
		crearAliado=false;
	}
	
	public void generarMagoDeFuego(int x, int y) {
		int[] arregloAuxiliar=traducirCoordenadas(x,y);
		MagoDeFuego MagoDeFuego=new MagoDeFuego(arregloAuxiliar[0]-65,arregloAuxiliar[1]-550);
		adaptador.añadirElemento(MagoDeFuego);
		gui.getVentanaJuego().add(MagoDeFuego.getGrafico());
		adaptador.chequearColision(MagoDeFuego);
		cuadrilla.setVisible(false);
		crearAliado=false;
	}
	
	public void generarEscudero(int x, int y) {
		int[] arregloAuxiliar=traducirCoordenadas(x,y);
		Escudero Escudero=new Escudero(arregloAuxiliar[0]-65,arregloAuxiliar[1]-550);
		adaptador.añadirElemento(Escudero);
		gui.getVentanaJuego().add(Escudero.getGrafico());
		adaptador.chequearColision(Escudero);
		cuadrilla.setVisible(false);
		crearAliado=false;
	}
	
	public void generarBarricada(int x, int y) {
		int[] arregloAuxiliar=traducirCoordenadas(x,y);
		Barricada barricada=new Barricada(arregloAuxiliar[0]-65,arregloAuxiliar[1]-550);
		adaptador.añadirElemento(barricada);
		gui.getVentanaJuego().add(barricada.getGrafico());
		adaptador.chequearColision(barricada);
		cuadrilla.setVisible(false);
		crearAliado=false;
	}
	
	private void descripcion(String nombreAliado, JTextArea texto, JLabel foto) {
		
		texto.setEditable(false);
		texto.setBackground(gui.getPanelNivelUno().getBackground());
				
		switch (aliadoComprado) {
			case "Guerrero":
				texto.setText("Guerrero"+"\n"+""+"\n"+"Alcance: Cuerpo a cuerpo"+"\n"+"Daño: Medio"+"\n"+"Vida: Media"+"\n"+"Valor: 200");
				texto.setBounds(775,810,300,110);
									
				foto.setIcon(new ImageIcon("Sprites\\Guerrero\\GuerreroIdle.gif"));
				foto.setBounds(920, 790, 128, 128);
				break;
			case "Ballesta":
				texto.setText("Ballesta"+"\n"+""+"\n"+"Alcance: ??"+"\n"+"Daño: Medio"+"\n"+"Vida: Baja"+"\n"+"Valor: 500");
				texto.setBounds(775,810,300,110);
									
				foto.setIcon(new ImageIcon("Sprites\\Ballesta\\BallestaIdle.gif"));
				foto.setBounds(850, 800, 128, 128);
				break;
			case "MagoDeHielo":
				texto.setText("Mago de Hielo"+"\n"+""+"\n"+"Alcance: ??"+"\n"+"Daño: Medio"+"\n"+"Vida: Baja"+"\n"+"Valor: 800"+"\n"+"Ralentiza Enemigos");
				texto.setBounds(775,810,300,130);
									
				foto.setIcon(new ImageIcon("Sprites\\MagoDeHielo\\MagoHIdle.gif"));
				foto.setBounds(850, 800, 128, 128);
				break;
			case "MagoDeFuego":
				texto.setText("Mago de Fuego"+"\n"+""+"\n"+"Alcance: ??"+"\n"+"Daño: Alto"+"\n"+"Vida: Media"+"\n"+"Valor: 600");
				texto.setBounds(775,810,300,110);
									
				foto.setIcon(new ImageIcon("Sprites\\MagoDeFuego\\MagoFIdle.gif"));
				foto.setBounds(850, 800, 128, 128);
				break;
			case "Escudero":
				texto.setText("Escudero"+"\n"+""+"\n"+"Alcance: Cuerpo a cuerpo"+"\n"+"Daño: Bajo"+"\n"+"Vida: Alta"+"\n"+"Valor: 400");
				texto.setBounds(775,810,300,110);
								
				foto.setIcon(new ImageIcon("Sprites\\Escudero\\EscuderoIdle.gif"));
				foto.setBounds(920, 790, 128, 128);
				break;
			case "Barricada":
				texto.setText("Barricada"+"\n"+""+"\n"+"Alcance: Nulo"+"\n"+"Daño: Nulo"+"\n"+"Vida: Alta"+"\n"+"Valor: 200"+"\n"+"Abarca dos casillas en vertical");
				texto.setBounds(775,810,300,130);
				
				foto.setIcon(new ImageIcon("Sprites\\Barricada\\Barricada.png"));
				foto.setBounds(950, 800, 128, 128);
				break;	
		}
		gui.getPanelNivelUno().add(foto);
		gui.getPanelNivelUno().add(texto);
	
	}	

	private int[] traducirCoordenadas(int x,int y) {
		int[]toReturn=new int[2];
		//Traducir coordenada X
		if(x<120)
			toReturn[0]=65;
			else
				if(x<230)
					toReturn[0]=175;
				else
					if(x<340)
						toReturn[0]=285;
					else
						if(x<450)
							toReturn[0]=395;
						else
							if(x<560)
								toReturn[0]=505;
							else
								if(x<670)
									toReturn[0]=615;
								else
									if(x<780)
										toReturn[0]=725;
									else
										if(x<890)
											toReturn[0]=835;
										else
											if(x<1000)
												toReturn[0]=945;
											else
													toReturn[0]=1055;									
		//Traducir coordenada Y
		if(y<200)
			toReturn[1]=150;
		else
			if(y<300)
				toReturn[1]=250;
			else
				if(y<400)
					toReturn[1]=350;
				else
					if(y<500)
						toReturn[1]=450;
					else
						if(y<600)
							toReturn[1]=550;
						else
							toReturn[1]=650;
		return toReturn;
	}
	
	class oyenteComprarGuerrero implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			cuadrilla.setVisible(true);
			crearAliado=true;
			aliadoComprado="Guerrero";
			//descripcion(aliadoComprado,textoDescripcion,fotoDescripcion);
		}
		
	}
	
	class oyenteComprarBallesta implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			cuadrilla.setVisible(true);
			crearAliado=true;
			aliadoComprado="Ballesta";
			//descripcion(aliadoComprado,textoDescripcion,fotoDescripcion);
		}
		
	}
	
	class oyenteComprarMagoDeHielo implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			cuadrilla.setVisible(true);
			crearAliado=true;
			aliadoComprado="MagoDeHielo";
			//descripcion(aliadoComprado,textoDescripcion,fotoDescripcion);
			
		}
	}
	
	class oyenteComprarMagoDeFuego implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			cuadrilla.setVisible(true);
			crearAliado=true;
			aliadoComprado="MagoDeFuego";
			//descripcion(aliadoComprado,textoDescripcion,fotoDescripcion);
			
		}
	}
	
	class oyenteComprarEscudero implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			cuadrilla.setVisible(true);
			crearAliado=true;
			aliadoComprado="Escudero";
			//descripcion(aliadoComprado,textoDescripcion,fotoDescripcion);
		}
	}
	
	class oyenteComprarBarricada implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			cuadrilla.setVisible(true);
			crearAliado=true;
			aliadoComprado="Barricada";
			//descripcion(aliadoComprado,textoDescripcion,fotoDescripcion);
		}
	}
	
	MouseListener click=new MouseListener() {
		@Override
		public void mousePressed(MouseEvent evento) {
			if(crearAliado) {
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
					case "Barricada":
						generarBarricada(evento.getX(), evento.getY());
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
