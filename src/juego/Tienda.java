package juego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import adaptador.Adaptador;
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
	protected Adaptador adaptador;
	protected static GUI gui;
	
	public Tienda() {
		crearAliado=false;
		aliadoComprado="";
		adaptador=adaptador.getAdaptador();
		gui=gui.getGUI();
	}	
	
	class oyenteComprarGuerrero implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			crearAliado=true;
			aliadoComprado="Guerrero";
			//cuadrilla.setVisible(true);
			
			descripcion(aliadoComprado,textoDescripcion,fotoDescripcion);
			
			
		}
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
	
	MouseListener click=new MouseListener() {
		@Override
		public void mousePressed(MouseEvent evento) {
			if(crearAliado) {
				switch (aliadoComprado) {
					case "Guerrero":
						//generarGuerrero(evento.getX(), evento.getY());
						break;
					case "Ballesta":
						//generarBallesta(evento.getX(), evento.getY());
						break;
					case "MagoDeHielo":
						//generarMagoDeHielo(evento.getX(), evento.getY());
						break;
					case "MagoDeFuego":
						//generarMagoDeFuego(evento.getX(), evento.getY());
						break;
					case "Escudero":
						//generarEscudero(evento.getX(), evento.getY());
						break;	
					case "Barricada":
						//generarBarricada(evento.getX(), evento.getY());
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
