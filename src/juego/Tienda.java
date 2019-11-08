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
import aliadoFactory.AbstractAliadoFactory;
import aliados.Aliado;
import gui.GUI;

public class Tienda {	
	protected AbstractAliadoFactory []botones;
	protected JButton btnVender;
	protected JButton cancelarActividad;
	protected AbstractAliadoFactory btnClickeado;
	
	protected int puntaje;
	protected int monedas;
	protected JLabel labelPuntaje;
	protected JLabel labelMonedas;
	protected JLabel imagenMonedas;
	
	protected JTextArea texto;
	protected JLabel foto;
	
	protected JPanel cuadrilla;
	protected boolean crearAliado;
	protected boolean vender;
	protected String aliadoComprado;
	protected static GUI gui;
	protected Nivel nivel;
	protected Adaptador adaptador;
	
	public Tienda(Nivel n) {
		crearAliado=false;
		aliadoComprado="";
		gui=GUI.getGUI();
		adaptador=Adaptador.getAdaptador();
		nivel=n;
		
		botones=new AbstractAliadoFactory[6];
		nivel.instanciarBotones(botones);
		OyenteComprarAliado oyenteComprarAliado=new OyenteComprarAliado();
		
		botones[0].setBounds(0, 670, 100, 100);
		botones[0].addActionListener(oyenteComprarAliado);
		gui.getVentanaJuego().add(botones[0],0);
		
		botones[1].setBounds(100, 670, 100, 100);
		botones[1].addActionListener(oyenteComprarAliado);
		gui.getVentanaJuego().add(botones[1],0);
		
		
		botones[2].setBounds(200, 670, 100, 100);
		botones[2].addActionListener(oyenteComprarAliado);
		gui.getVentanaJuego().add(botones[2],0);
		
		botones[3].setBounds(300, 670, 100, 100);
		botones[3].addActionListener(oyenteComprarAliado);
		gui.getVentanaJuego().add(botones[3],0);
		
		botones[4].setBounds(400, 670, 100, 100);
		botones[4].addActionListener(oyenteComprarAliado);
		gui.getVentanaJuego().add(botones[4],0);
		
		botones[5].setBounds(500, 670, 100, 100);
		botones[5].addActionListener(oyenteComprarAliado);
		gui.getVentanaJuego().add(botones[5],0);
		
		btnVender=new JButton("Vender");
		btnVender.setBounds(600,670,100,100);
		OyenteBotonVender oyenteVender=new OyenteBotonVender();
		btnVender.addActionListener(oyenteVender);
		gui.getVentanaJuego().add(btnVender,0);
		
		cancelarActividad=new JButton("Cancelar");
		cancelarActividad.setBounds(700,670,100,100);
		OyenteCancelarActividad oyenteCancelarActividad=new OyenteCancelarActividad();
		cancelarActividad.addActionListener(oyenteCancelarActividad);
		gui.getVentanaJuego().add(cancelarActividad,0);
		
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
		gui.getVentanaJuego().add(imagenMonedas,0);
		monedas=300;
		labelMonedas=new JLabel();
		labelMonedas.setText(String.valueOf(monedas));
		labelMonedas.setBounds(685,30,40,30);
		labelMonedas.setBorder(BorderFactory.createLineBorder(Color.black));
		labelMonedas.setBackground(Color.green);
		labelMonedas.setOpaque(true);
		gui.getVentanaJuego().add(labelMonedas,0);
		
		//Puntaje
		puntaje= 0;
		labelPuntaje= new JLabel();
		labelPuntaje.setText(String.valueOf(puntaje));
		labelPuntaje.setBounds(400,30,40,30);
		labelPuntaje.setBorder(BorderFactory.createLineBorder(Color.black));
		labelPuntaje.setBackground(Color.green);
		labelPuntaje.setOpaque(true);
		gui.getVentanaJuego().add(labelPuntaje,0);
		
		//Descripcion del personaje
		
		texto=new JTextArea();
		foto=new JLabel();
		
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
	
	public boolean getVender() {
		return vender;
	}
	
	public void setVender(boolean b) {
		vender=b;	
	}
	
	public String aliadoComprado() {
		return aliadoComprado;
	}
	
	public void generarAliado(int x,int y) {
		int[] arregloAuxiliar=traducirCoordenadas(x,y);
		Aliado aliado=btnClickeado.crearAliado(arregloAuxiliar[0]-65,arregloAuxiliar[1]-550);
		adaptador.chequearColision(aliado);
		if(aliado.getCostoMonedas()<=monedas && !aliado.getColisiono()) {
			monedas-=aliado.getCostoMonedas();
			adaptador.añadirElemento(aliado);
			gui.getVentanaJuego().add(aliado.getColisionVenta(),0);
			cuadrilla.setVisible(false);
			crearAliado=false;
		}
	}
	
	public void actualizarMonedas(int cantidad) {
		monedas+=cantidad;
		labelMonedas.setText(String.valueOf(monedas));
	}
	
	private void descripcion() {
		
		texto.setEditable(false);
		texto.setBackground(gui.getVentanaJuego().getBackground());
				
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
		gui.getVentanaJuego().add(foto,0);
		gui.getVentanaJuego().add(texto,0);
	
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
	
	class OyenteBotonVender implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			vender=true;
			crearAliado=false;
		}
	}
	
	class OyenteCancelarActividad implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			vender=false;
			crearAliado=false;
			cuadrilla.setVisible(false);
		}
	}
	
	class OyenteComprarAliado implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			cuadrilla.setVisible(true);
			vender=false;
			crearAliado=true;
			btnClickeado=(AbstractAliadoFactory)e.getSource();
			descripcion();
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