package disparos;

import java.awt.Rectangle;

import javax.swing.JLabel;

import juego.Elemento;
import visitor.Visitor;

public abstract class Disparo extends Elemento {
	
	protected int velocidad;
	protected int distanciaRecorrida;
	protected int daño;
	protected int alcance;
	
	public Disparo(int x,int y,int d,int a) {
		super(-1);
		velocidad=30;
		distanciaRecorrida=0;
		rectangulo=new Rectangle(x,y,30,80);
		daño=d;
		alcance=a;
		graficoActual=new JLabel();
	}
	
	public String esUn() {
		return "Disparo";
	}
	
	public void aceptar(Visitor v) {
		v.visitarDisparo(this);
	}
	
	public void actividadSinColision() {
		mover();
	}
	
	public int getDaño() {
		return daño;
	}
	
	public abstract void mover();
	
}