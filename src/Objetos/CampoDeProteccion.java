package Objetos;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import juego.Personaje;
import visitor.Visitor;
import visitor.VisitorCampoDeProteccion;

public class CampoDeProteccion extends MagiaTemporal {
	protected boolean entidadDue�o;                  //false=enemigo, true=aliado
	protected Personaje miDue�o;

	public CampoDeProteccion(int x,int y) {
		super(x,y);
		graficoActual.setIcon(new ImageIcon("Sprites\\Premios\\campo.png"));
		rectangulo=new Rectangle(x,y,80,70);
		miVisitor=new VisitorCampoDeProteccion(this);
	}
	
	public void setEntidadDue�o(boolean b) {
		entidadDue�o=b;
	}
	
	public void setDue�o(Personaje p) {
		miDue�o=p;
	}

	public boolean getEntidadDue�o() {
		return entidadDue�o;
	}
	
	public void destruir() {
		miDue�o.campoDestruido();
		super.destruir();
	}
	
	@Override
	public void aceptar(Visitor v) {
		v.visitarPremio(this);
		
	}

	@Override
	public void actividadSinColision() {
		
		
	}

}
