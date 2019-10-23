package disparos;

import java.awt.Rectangle;
import juego.Elemento;
import visitor.Visitor;

public class Disparo extends Elemento {
	
	protected int daño;
	protected int velocidad;
	
	public Disparo(int x,int y,int d) {
		super(-1);
		daño=d;
		this.velocidad=200;
		rectangulo=new Rectangle(x,y,80,80);
	}
	
	public void aceptar(Visitor v) {
		v.visitarDisparo(this);
	}
	
	public void actividadSinColision() {
		rectangulo.setBounds((int)rectangulo.getX()-30,(int)rectangulo.getY(),(int)rectangulo.getWidth(),(int)rectangulo.getHeight());
		graficoActual.setBounds(graficoActual.getX()-30,graficoActual.getY(),graficoActual.getWidth(),graficoActual.getHeight());
	}
	
	public int getDaño() {
		return daño;
	}
	
}