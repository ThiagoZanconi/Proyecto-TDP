package enemigos;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import juego.Personaje;
import stateEnemigos.EstadoVelocidad;
import stateEnemigos.VelocidadNormal;
import stateTiendaPremios.EstadoCrearBarricada;
import stateTiendaPremios.EstadoCrearBomba;
import stateTiendaPremios.EstadoCrearCampo;
import stateTiendaPremios.EstadoCrearReloj;
import stateTiendaPremios.EstadoCrearTesoro;
import visitor.Visitor;
import visitor.VisitorAlcanceEnemigo;

public abstract class Enemigo extends Personaje {
	protected boolean enMovimiento;
	protected int puntaje;
	protected int cantidadMonedas;
	protected int velocidadNormal;
	protected EstadoVelocidad estadoVelocidad;
	protected String premio;
	protected JLabel iconoPremio;
	protected JLabel colisionClick;

	protected Enemigo(int x,int y) {
		super(x,y);
		enMovimiento=true;
		velocidadNormal=3;
		visitorAlcance=new VisitorAlcanceEnemigo(this);
		estadoVelocidad=new VelocidadNormal(this);
		
		iconoPremio=new JLabel();
		colisionClick=new JLabel();
		premio="";                                   //Por defecto los enemigos no tienen ningun premio
		
		Random r=new Random();
		switch(r.nextInt(1)) {
		case(0):
			premio="CampoDeProteccion";
			break;
		case(1):	
			premio="Tesoro";
			break;
		}
	}
	
	public int getVelocidadNormal() {
		return velocidadNormal;
	}
	
	public void setEstadoVelocidad(EstadoVelocidad e) {
		estadoVelocidad=e;
	}
	
	public int velocidad() {
		return estadoVelocidad.velocidad();
	}
	
	public void aceptar(Visitor v) {
		v.visitarEnemigo(this);
	}
	
	public void detener() {
		enMovimiento=false;
	}
	
	
	public void actividadSinColision() {
		adaptador.chequearColisionDeAtaques(this);
		mover();
	}
	
	public void destruir() {
		adaptador.eliminarElemento(this);
		graficoActual.setVisible(false);
		otorgarMonedas();
		
		if(!premio.equals("")) {
			iconoPremio.setBounds((int)rectangulo.getX(),(int)rectangulo.getY(),1000,1000);
			colisionClick.setBounds((int)rectangulo.getX(),(int)rectangulo.getY()+450,100,100);
			colisionClick.addMouseListener(click);
			switch(premio) {
			case("Tesoro"):
				iconoPremio.setIcon(new ImageIcon("Sprites\\Premios\\Monedas.gif"));
				adaptador.setEstadoTienda(new EstadoCrearTesoro((int)rectangulo.getX(),(int)rectangulo.getY()));
				break;
			case("Bomba"):
				iconoPremio.setIcon(new ImageIcon("Sprites\\Premios\\bomba.png"));
				adaptador.setEstadoTienda(new EstadoCrearBomba((int)rectangulo.getX(),(int)rectangulo.getY()));
				break;
			case("CampoDeProteccion"):
				iconoPremio.setIcon(new ImageIcon("Sprites\\Premios\\campoIcono.gif"));
				adaptador.setEstadoTienda(new EstadoCrearCampo((int)rectangulo.getX(),(int)rectangulo.getY()));
				adaptador.aņadirCampo(true);
				break;
			case("RelojTemporal"):
				iconoPremio.setIcon(new ImageIcon("Sprites\\Premios\\ralentizaIcono.png"));
				adaptador.setEstadoTienda(new EstadoCrearReloj((int)rectangulo.getX(),(int)rectangulo.getY()));
				break;
			case("Barricada"):
				iconoPremio.setIcon(new ImageIcon(""));
				adaptador.setEstadoTienda(new EstadoCrearBarricada((int)rectangulo.getX(),(int)rectangulo.getY()));
				break;		
			}
			adaptador.aņadirElementoGrafico(colisionClick);
			adaptador.aņadirElementoGrafico(iconoPremio);
		}
		
	}
	
	public void otorgarMonedas() {
		adaptador.actualizarMonedas(cantidadMonedas);
	}
	
	/**
	 * Caminar
	 */
	public void mover() {
		if(enMovimiento) {
			rectangulo.setBounds((int)rectangulo.getX()+velocidad(),(int)rectangulo.getY(),(int)rectangulo.getWidth(),(int)rectangulo.getHeight());
			graficoActual.setBounds(graficoActual.getX()+velocidad(),graficoActual.getY(),graficoActual.getWidth(),graficoActual.getHeight());
			alcanceDeAtaque.setBounds((int)alcanceDeAtaque.getX()+velocidad(),(int)alcanceDeAtaque.getY(),(int)alcanceDeAtaque.getWidth(),(int)alcanceDeAtaque.getHeight());
		}
		else {
			enMovimiento=true;
		}
	}
	
	MouseListener click=new MouseListener() {
		@Override
		public void mousePressed(MouseEvent evento) { 
			adaptador.setCrearPremio(true);
			adaptador.eliminarElementoGrafico(colisionClick);
			adaptador.eliminarElementoGrafico(iconoPremio);
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