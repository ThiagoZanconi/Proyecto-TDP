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

import Objetos.Objeto;
import adaptador.Adaptador;
import aliadoFactory.AbstractAliadoFactory;
import aliados.Aliado;
import gui.GUI;
import objetoFactory.AbstractObjetoFactory;
import stateTiendaPremios.EstadoTienda;

public class Tienda {		
	protected JButton btnVender;
	protected JButton cancelarActividad;
	
	protected AbstractAliadoFactory []botonesAliado;
	protected AbstractAliadoFactory btnAliadoClickeado;
	
	protected AbstractObjetoFactory []botonesObjeto;
	protected AbstractObjetoFactory btnObjetoClickeado;
	
	protected EstadoTienda estado;
	
	protected int puntaje;
	protected int monedas;
	protected JLabel labelPuntaje;
	protected JLabel labelMonedas;
	protected JLabel imagenMonedas;
	
	protected JTextArea texto;
	protected JLabel foto;
	
	protected JPanel cuadrilla;
	protected boolean crearAliado;
	protected boolean crearObjeto;
	protected boolean vender;
	protected boolean añadirCampo;
	protected boolean crearPremio;
	protected static GUI gui;
	protected Nivel nivel;
	protected Adaptador adaptador;
	
	public Tienda(Nivel n) {
		crearAliado=false;
		crearObjeto=false;
		añadirCampo=false;
		crearPremio=false;
		gui=GUI.getGUI();
		adaptador=Adaptador.getAdaptador();
		nivel=n;
		
		botonesAliado=new AbstractAliadoFactory[6];
		nivel.instanciarBotonesAliado(botonesAliado);
		OyenteComprarAliado oyenteComprarAliado=new OyenteComprarAliado();
		
		botonesAliado[0].setBounds(0, 670, 100, 100);
		botonesAliado[0].addActionListener(oyenteComprarAliado);
		gui.getVentanaJuego().add(botonesAliado[0],0);
		
		botonesAliado[1].setBounds(100, 670, 100, 100);
		botonesAliado[1].addActionListener(oyenteComprarAliado);
		gui.getVentanaJuego().add(botonesAliado[1],0);
		
		
		botonesAliado[2].setBounds(200, 670, 100, 100);
		botonesAliado[2].addActionListener(oyenteComprarAliado);
		gui.getVentanaJuego().add(botonesAliado[2],0);
		
		botonesAliado[3].setBounds(300, 670, 100, 100);
		botonesAliado[3].addActionListener(oyenteComprarAliado);
		gui.getVentanaJuego().add(botonesAliado[3],0);
		
		botonesAliado[4].setBounds(400, 670, 100, 100);
		botonesAliado[4].addActionListener(oyenteComprarAliado);
		gui.getVentanaJuego().add(botonesAliado[4],0);
		
		botonesAliado[5].setBounds(500, 670, 100, 100);
		botonesAliado[5].addActionListener(oyenteComprarAliado);
		gui.getVentanaJuego().add(botonesAliado[5],0);	
		
		botonesObjeto=new AbstractObjetoFactory[4];
		nivel.instanciarBotonesObjeto(botonesObjeto);
		OyenteComprarObjeto oyenteComprarObjeto=new OyenteComprarObjeto();
		
		botonesObjeto[0].setBounds(0,770,100,100);
		botonesObjeto[0].addActionListener(oyenteComprarObjeto);
		gui.getVentanaJuego().add(botonesObjeto[0],0);
		
		botonesObjeto[1].setBounds(100,770,100,100);
		botonesObjeto[1].addActionListener(oyenteComprarObjeto);
		gui.getVentanaJuego().add(botonesObjeto[1],0);
		
		botonesObjeto[2].setBounds(200,770,100,100);
		botonesObjeto[2].addActionListener(oyenteComprarObjeto);
		gui.getVentanaJuego().add(botonesObjeto[2],0);
		
		botonesObjeto[3].setBounds(300,770,100,100);
		botonesObjeto[3].addActionListener(oyenteComprarObjeto);
		gui.getVentanaJuego().add(botonesObjeto[3],0);
		
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
		monedas=1500;
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
	
	public boolean getAñadirCampo() {
		return añadirCampo;
	}
	
	public void crearCampo(boolean b) {
		añadirCampo=b;
		
	}
	
	public boolean getVender() {
		return vender;
	}
	
	public void setVender(boolean b) {
		vender=b;	
	}
	
	public void setEstado(EstadoTienda e) {
		estado=e;
	}
	
	public void setCrearPremio(boolean b) {
		crearPremio=b;
	}
	
	public void generarAliado(int x,int y) {
		int[] arregloAuxiliar=traducirCoordenadas(x,y);
		Aliado aliado=btnAliadoClickeado.crearAliado(arregloAuxiliar[0]-65,arregloAuxiliar[1]-550);
		adaptador.chequearColision(aliado);
		if(aliado.getCostoMonedas()<=monedas && !aliado.getColisiono()) {
			actualizarMonedas(-aliado.getCostoMonedas());
			adaptador.añadirElemento(aliado);
			gui.getVentanaJuego().add(aliado.getColisionVenta(),0);
			cuadrilla.setVisible(false);
			crearAliado=false;
		}
	}
	
	public void generarObjeto(int x,int y) {
		int[] arregloAuxiliar=traducirCoordenadas(x,y);
		Objeto objeto=btnObjetoClickeado.crearObjeto(arregloAuxiliar[0]-65,arregloAuxiliar[1]-550);
		adaptador.chequearColision(objeto);
		if(objeto.getCostoMonedas()<=monedas && !objeto.getColisiono()) {
			actualizarMonedas(-objeto.getCostoMonedas());
			adaptador.añadirElemento(objeto);
			//gui.getVentanaJuego().add(objeto.getColisionVenta(),0);
			cuadrilla.setVisible(false);
			crearObjeto=false;
		}
	}
	
	public void actualizarMonedas(int cantidad) {
		monedas+=cantidad;
		labelMonedas.setText(String.valueOf(monedas));
	}
	
	private void descripcion() {
		
		texto.setEditable(false);
		texto.setBackground(gui.getVentanaJuego().getBackground());
				
		switch (btnAliadoClickeado.getText()) {
			case "Guerrero":
				texto.setText("Guerrero"+"\n"+""+"\n"+"Alcance: Cuerpo a cuerpo"+"\n"+"Daño: Medio"+"\n"+"Vida: Alta"+"\n"+"Valor: 300");
				texto.setBounds(800,670,300,110);
									
				foto.setIcon(new ImageIcon("Sprites\\Guerrero\\GuerreroIdle.gif"));
				foto.setBounds(920, 790, 128, 128);
				break;
			case "Ballesta":
				texto.setText("Ballesta"+"\n"+""+"\n"+"Alcance: Ilimitado"+"\n"+"Daño: Medio"+"\n"+"Vida: Baja"+"\n"+"Valor: 350");
				texto.setBounds(800,670,300,110);
									
				foto.setIcon(new ImageIcon("Sprites\\Ballesta\\BallestaIdle.gif"));
				foto.setBounds(850, 800, 128, 128);
				break;
			case "MagoDeHielo":
				texto.setText("Mago de Hielo"+"\n"+""+"\n"+"Alcance: Alto"+"\n"+"Daño: Medio"+"\n"+"Vida: Baja"+"\n"+"Valor: 500"+"\n"+"Ralentiza Enemigos");
				texto.setBounds(800,670,300,130);
									
				foto.setIcon(new ImageIcon("Sprites\\MagoDeHielo\\MagoHIdle.gif"));
				foto.setBounds(850, 800, 128, 128);
				break;
			case "MagoDeFuego":
				texto.setText("Mago de Fuego"+"\n"+""+"\n"+"Alcance: Medio"+"\n"+"Daño: Alto"+"\n"+"Vida: Media"+"\n"+"Valor: 600");
				texto.setBounds(800,670,300,110);
									
				foto.setIcon(new ImageIcon("Sprites\\MagoDeFuego\\MagoFIdle.gif"));
				foto.setBounds(850, 800, 128, 128);
				break;
			case "Escudero":
				texto.setText("Escudero"+"\n"+""+"\n"+"Alcance: Cuerpo a cuerpo"+"\n"+"Daño: Bajo"+"\n"+"Vida: Muy Alta"+"\n"+"Valor: 400");
				texto.setBounds(800,670,300,110);
								
				foto.setIcon(new ImageIcon("Sprites\\Escudero\\EscuderoIdle.gif"));
				foto.setBounds(920, 790, 128, 128);
				break;
			case "Barricada":
				texto.setText("Barricada"+"\n"+""+"\n"+"Alcance: Nulo"+"\n"+"Daño: Nulo"+"\n"+"Vida: Muy Alta"+"\n"+"Valor: 600"+"\n"+"Abarca dos casillas en vertical");
				texto.setBounds(800,670,300,130);
				
				foto.setIcon(new ImageIcon("Sprites\\Barricada\\Barricada.png"));
				foto.setBounds(950, 800, 128, 128);
				break;	
		}
		gui.getVentanaJuego().add(texto,0);
		gui.getVentanaJuego().add(foto,0);
	
	}	

	public int[] traducirCoordenadas(int x,int y) {
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
			crearPremio=false;
			añadirCampo=false;
		}
	}
	
	class OyenteCancelarActividad implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			vender=false;
			crearAliado=false;
			crearPremio=false;
			añadirCampo=false;
			cuadrilla.setVisible(false);
		}
	}
	
	class OyenteComprarAliado implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			cuadrilla.setVisible(true);
			vender=false;
			crearPremio=false;
			añadirCampo=false;
			crearObjeto=false;
			crearAliado=true;
			btnAliadoClickeado=(AbstractAliadoFactory)e.getSource();
			descripcion();
		}
	}
	
	class OyenteComprarObjeto implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			cuadrilla.setVisible(true);
			vender=false;
			crearPremio=false;
			añadirCampo=false;
			crearAliado=false;
			crearObjeto=true;
			btnObjetoClickeado=(AbstractObjetoFactory)e.getSource();
		}
	}
	
	MouseListener click=new MouseListener() {
		@Override
		public void mousePressed(MouseEvent evento) {
			if(crearAliado) {
				generarAliado(evento.getX(),evento.getY());	
			}	
			if(crearObjeto) {
				generarObjeto(evento.getX(),evento.getY());
			}
			if(crearPremio) {
				estado.crearPremio(evento.getX(),evento.getY());
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