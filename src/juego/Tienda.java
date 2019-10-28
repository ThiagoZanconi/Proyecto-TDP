package juego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
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
	private JTextArea textoDescripcion;
	private JLabel fotoDescripcion;
	protected boolean crearAliado;
	protected String aliadoComprado;
	protected static GUI gui;
	protected Adaptador adaptador;
	
	public Tienda() {
		crearAliado=false;
		aliadoComprado="";
		gui=gui.getGUI();
		adaptador=adaptador.getAdaptador();
		
		//Creo el boton comprar Guerrero y lo agrego a la ventana
		btnComprarGuerrero=new JButton("Guerrero");
		oyenteComprarGuerrero oyenteComprarGuerrero =new oyenteComprarGuerrero();
		btnComprarGuerrero.addActionListener(oyenteComprarGuerrero);
		btnComprarGuerrero.setBounds(0, 800, 100, 100);
		gui.getVentanaJuego().add(btnComprarGuerrero);
		btnComprarGuerrero.setVisible(true);
		
		//Creo el boton comprar Ballesta y lo agrego a la ventana
		btnComprarBallesta=new JButton("Ballesta");
		oyenteComprarBallesta oyenteComprarBallesta =new oyenteComprarBallesta();
		btnComprarBallesta.addActionListener(oyenteComprarBallesta);
		btnComprarBallesta.setBounds(100, 800, 100, 100);
		gui.getVentanaJuego().add(btnComprarBallesta);
		btnComprarBallesta.setVisible(true);
		
		//Creo el boton comprar Mago de Hielo y lo agrego a la ventana
		btnComprarMagoDeHielo=new JButton("Mago de Hielo");
		oyenteComprarMagoDeHielo oyenteComprarMagoDeHielo =new oyenteComprarMagoDeHielo();
		btnComprarMagoDeHielo.addActionListener(oyenteComprarMagoDeHielo);
		btnComprarMagoDeHielo.setBounds(200, 800, 100, 100);
		gui.getVentanaJuego().add(btnComprarMagoDeHielo);
		btnComprarMagoDeHielo.setVisible(true);
		
		//Creo el boton comprar Mago de Fuego y lo agrego a la ventana
		btnComprarMagoDeFuego=new JButton("Mago de Fuego");
		oyenteComprarMagoDeFuego oyenteComprarMagoDeFuego =new oyenteComprarMagoDeFuego();
		btnComprarMagoDeFuego.addActionListener(oyenteComprarMagoDeFuego);
		btnComprarMagoDeFuego.setBounds(300, 800, 100, 100);
		gui.getVentanaJuego().add(btnComprarMagoDeFuego);
		btnComprarMagoDeFuego.setVisible(true);
		
		//Creo el boton comprar Escudero y lo agrego a la ventana
		btnComprarEscudero=new JButton("Escudero");
		oyenteComprarEscudero oyenteComprarEscudero =new oyenteComprarEscudero();
		btnComprarEscudero.addActionListener(oyenteComprarEscudero);
		btnComprarEscudero.setBounds(400, 800, 100, 100);
		gui.getVentanaJuego().add(btnComprarEscudero);
		btnComprarEscudero.setVisible(true);
		
		//Creo el boton comprar Barricada y lo agrego a la ventana
		btnComprarBarricada=new JButton("Barricada");
		oyenteComprarBarricada oyenteComprarBarricada =new oyenteComprarBarricada();
		btnComprarBarricada.addActionListener(oyenteComprarBarricada);
		btnComprarBarricada.setBounds(500, 800, 100, 100);
		gui.getVentanaJuego().add(btnComprarBarricada);
		btnComprarBarricada.setVisible(true);
	
	}	
	
	public boolean crearAliado() {
		return crearAliado;
	}
	
	public String aliadoComprado() {
		return aliadoComprado;
	}
	
	
	
	public void generarGuerrero(int x, int y) {
		int[] arregloAuxiliar=traducirCoordenadas(x,y);
		Guerrero guerrero=new Guerrero(arregloAuxiliar[1]-65,arregloAuxiliar[3]-550);
		adaptador.añadirElemento(guerrero);
		if(arregloAuxiliar[3]!=0 && arregloAuxiliar[0]!=0) {
			gui.getVentanaJuego().add(guerrero.getGrafico());
		}
		adaptador.chequearColision(guerrero);
		//cuadrilla.setVisible(false);
		crearAliado=false;

	}
	
	public void generarBallesta(int x, int y) {
		int[] arregloAuxiliar=traducirCoordenadas(x,y);
		Ballesta ballesta=new Ballesta(arregloAuxiliar[1]-65,arregloAuxiliar[3]-550);
		adaptador.añadirElemento(ballesta);
		if(arregloAuxiliar[3]!=0 && arregloAuxiliar[0]!=0) {
			gui.getVentanaJuego().add(ballesta.getGrafico());
		}
		adaptador.chequearColision(ballesta);	
		//cuadrilla.setVisible(false);
		crearAliado=false;
	}
	
	public void generarMagoDeHielo(int x, int y) {
		int[] arregloAuxiliar=traducirCoordenadas(x,y);
		MagoDeHielo MagoDeHielo=new MagoDeHielo(arregloAuxiliar[1]-65,arregloAuxiliar[3]-550);
		adaptador.añadirElemento(MagoDeHielo);
		if(arregloAuxiliar[3]!=0 && arregloAuxiliar[0]!=0) {
			gui.getVentanaJuego().add(MagoDeHielo.getGrafico());
		}
		adaptador.chequearColision(MagoDeHielo);
		//cuadrilla.setVisible(false);
		crearAliado=false;
	}
	
	public void generarMagoDeFuego(int x, int y) {
		int[] arregloAuxiliar=traducirCoordenadas(x,y);
		MagoDeFuego MagoDeFuego=new MagoDeFuego(arregloAuxiliar[1]-65,arregloAuxiliar[3]-550);
		adaptador.añadirElemento(MagoDeFuego);
		if(arregloAuxiliar[3]!=0 && arregloAuxiliar[0]!=0) {
			gui.getVentanaJuego().add(MagoDeFuego.getGrafico());
		}
		adaptador.chequearColision(MagoDeFuego);
		//cuadrilla.setVisible(false);
		crearAliado=false;
	}
	
	public void generarEscudero(int x, int y) {
		int[] arregloAuxiliar=traducirCoordenadas(x,y);
		Escudero Escudero=new Escudero(arregloAuxiliar[1]-65,arregloAuxiliar[3]-550);
		adaptador.añadirElemento(Escudero);
		if(arregloAuxiliar[3]!=0 && arregloAuxiliar[0]!=0) {
			gui.getVentanaJuego().add(Escudero.getGrafico());
		}
		adaptador.chequearColision(Escudero);
		//cuadrilla.setVisible(false);
		crearAliado=false;
	}
	
	public void generarBarricada(int x, int y) {
		int[] arregloAuxiliar=traducirCoordenadas(x,y);
		Barricada barricada=new Barricada(arregloAuxiliar[1]-65,arregloAuxiliar[3]-550);
		adaptador.añadirElemento(barricada);
		if(arregloAuxiliar[3]!=0 && arregloAuxiliar[0]!=0) {
			gui.getVentanaJuego().add(barricada.getGrafico());
		}
		adaptador.chequearColision(barricada);
		//cuadrilla.setVisible(false);
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

	private int[] traducirCoordenadas2(int x,int y) {
		int [] toReturn=new int[2];
		toReturn[0]=(int) Math.ceil(x/118);
		toReturn[1]=(int) Math.ceil((y)/56);
		return toReturn;
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
	
	class oyenteComprarGuerrero implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			crearAliado=true;
			aliadoComprado="Guerrero";
			//cuadrilla.setVisible(true);
			//descripcion(aliadoComprado,textoDescripcion,fotoDescripcion);
		}
		
	}
	
	class oyenteComprarBallesta implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {	
			crearAliado=true;
			aliadoComprado="Ballesta";
			//cuadrilla.setVisible(true);
			//descripcion(aliadoComprado,textoDescripcion,fotoDescripcion);
		}
		
	}
	
	class oyenteComprarMagoDeHielo implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			crearAliado=true;
			aliadoComprado="MagoDeHielo";
			//cuadrilla.setVisible(true);
			//descripcion(aliadoComprado,textoDescripcion,fotoDescripcion);
			
		}
	}
	
	class oyenteComprarMagoDeFuego implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			crearAliado=true;
			aliadoComprado="MagoDeFuego";
			//cuadrilla.setVisible(true);
			//descripcion(aliadoComprado,textoDescripcion,fotoDescripcion);
			
		}
	}
	
	class oyenteComprarEscudero implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			crearAliado=true;
			aliadoComprado="Escudero";
			//cuadrilla.setVisible(true);
			//descripcion(aliadoComprado,textoDescripcion,fotoDescripcion);
		}
	}
	
	class oyenteComprarBarricada implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			crearAliado=true;
			aliadoComprado="Barricada";
			//cuadrilla.setVisible(true);
			//descripcion(aliadoComprado,textoDescripcion,fotoDescripcion);
		}
	}
}
