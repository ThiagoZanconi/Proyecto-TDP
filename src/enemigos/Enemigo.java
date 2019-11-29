package enemigos;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Objetos.Cactus;
import Objetos.Duna;
import Objetos.Lago;
import Objetos.Piedra;
import juego.Personaje;
import stateEnemigos.EstadoVelocidad;
import stateEnemigos.VelocidadNormal;
import visitor.Visitor;
import visitor.VisitorAlcanceEnemigo;

public abstract class Enemigo extends Personaje {
	protected boolean enMovimiento;
	protected int puntaje;
	protected int cantidadMonedas;
	protected int velocidadNormal;
	protected EstadoVelocidad estadoVelocidad;
	protected String premio;

	protected Enemigo(int x,int y) {
		super(x,y);
		enMovimiento=true;
		velocidadNormal=3;
		visitorAlcance=new VisitorAlcanceEnemigo(this);
		estadoVelocidad=new VelocidadNormal(this);
		premio="";                                   //Por defecto los enemigos no tienen ningun premio
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
		JLabel iconoPremio=new JLabel();
		switch(premio) {
		case("Tesoro"):
			iconoPremio.setIcon(new ImageIcon("Sprites\\Premios\\Monedas.gif"));
			break;
		case("Bomba"):
			iconoPremio.setIcon(new ImageIcon("Sprites\\Premios\\bomba.png"));
			break;
		case("CampoDeProteccion"):
			iconoPremio.setIcon(new ImageIcon(""));
			break;
		case("RelojTemporal"):
			iconoPremio.setIcon(new ImageIcon(""));
			break;
		case("Barricada"):
			iconoPremio.setIcon(new ImageIcon(""));
			break;
			
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
	
	
}