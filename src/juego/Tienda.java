package juego;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import adaptador.Adaptador;
import aliadoFactory.AbstractAliadoFactory;
import aliados.Aliado;
import gui.GUI;

public class Tienda {
	protected AbstractAliadoFactory btn1;
	protected AbstractAliadoFactory btn2;
	protected AbstractAliadoFactory btn3;
	protected AbstractAliadoFactory btn4;
	protected AbstractAliadoFactory btn5;
	protected AbstractAliadoFactory btn6;
	
	protected NivelUno nivel;
	
	protected AbstractAliadoFactory btnClickeado;
	
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
	
	public Tienda(NivelUno n) {
		crearAliado=false;
		aliadoComprado="";
		gui=GUI.getGUI();
		adaptador=Adaptador.getAdaptador();
		nivel=n;
		
		btn1=nivel.instanciarBoton();
		oyenteComprarAliado oyenteComprarAliado1=new oyenteComprarAliado();
		btn1.addActionListener(oyenteComprarAliado1);
		btn1.setBounds(0, 670, 100, 100);
		gui.getVentanaJuego().add(btn1,0);
		btn1.setVisible(true);
		
		btn2=nivel.instanciarBoton();
		oyenteComprarAliado oyenteComprarAliado2=new oyenteComprarAliado();
		btn2.addActionListener(oyenteComprarAliado2);
		btn2.setBounds(100, 670, 100, 100);
		gui.getVentanaJuego().add(btn2,0);
		btn2.setVisible(true);
		
		btn3=nivel.instanciarBoton();
		oyenteComprarAliado oyenteComprarAliado3=new oyenteComprarAliado();
		btn3.addActionListener(oyenteComprarAliado3);
		btn3.setBounds(200, 670, 100, 100);
		gui.getVentanaJuego().add(btn3,0);
		btn3.setVisible(true);
		
		btn4=nivel.instanciarBoton();
		oyenteComprarAliado oyenteComprarAliado4=new oyenteComprarAliado();
		btn4.addActionListener(oyenteComprarAliado4);
		btn4.setBounds(300, 670, 100, 100);
		gui.getVentanaJuego().add(btn4,0);
		btn4.setVisible(true);
		
		btn5=nivel.instanciarBoton();
		oyenteComprarAliado oyenteComprarAliado5=new oyenteComprarAliado();
		btn5.addActionListener(oyenteComprarAliado5);
		btn5.setBounds(400, 670, 100, 100);
		gui.getVentanaJuego().add(btn5,0);
		btn5.setVisible(true);
		
		btn6=nivel.instanciarBoton();
		oyenteComprarAliado oyenteComprarAliado6=new oyenteComprarAliado();
		btn6.addActionListener(oyenteComprarAliado6);
		btn6.setBounds(500, 670, 100, 100);
		gui.getVentanaJuego().add(btn6,0);
		btn6.setVisible(true);
		
		//Creo la cuadrilla
		cuadrilla=new JPanel();
		cuadrilla.setLayout(new GridLayout(6,10));
		llenarCuadrilla();
		cuadrilla.setBounds(0,70,1110,600);
		cuadrilla.setOpaque(false);
		gui.getVentanaJuego().add(cuadrilla,0);
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
	
	public void generarAliado(int x,int y) {
		int[] arregloAuxiliar=traducirCoordenadas(x,y);
		Aliado aliado=btnClickeado.crearAliado(arregloAuxiliar[0]-65,arregloAuxiliar[1]-550);
		adaptador.añadirElemento(aliado);
		gui.getVentanaJuego().add(aliado.getGrafico(),0);
		adaptador.chequearColision(aliado);
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
	
	class oyenteComprarAliado implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			cuadrilla.setVisible(true);
			crearAliado=true;
			btnClickeado=(AbstractAliadoFactory)e.getSource();
			//descripcion(aliadoComprado,textoDescripcion,fotoDescripcion);
		}
	}
	
	MouseListener click=new MouseListener() {
		@Override
		public void mousePressed(MouseEvent evento) {
			if(crearAliado) {
				generarAliado(evento.getX(), evento.getY());	
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