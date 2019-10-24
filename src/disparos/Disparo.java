package disparos;

import java.awt.Rectangle;

import javax.swing.JLabel;

import juego.Elemento;
import visitor.Visitor;

public class Disparo extends Elemento {
	
	protected int velocidad;
	protected int distanciaRecorrida;
	protected int da�o;

	protected int alcance;
	
	
	public Disparo(int x,int y,int d,int a) {
		super(-1);
		velocidad=30;
		distanciaRecorrida=0;
		rectangulo=new Rectangle(x,y,30,80);
		da�o=d;
		alcance=a;
		graficoActual=new JLabel();
	}
	
	public void aceptar(Visitor v) {
		v.visitarDisparo(this);
	}
	
	public void actividadSinColision() {
		mover();
	}
	
	public int getDa�o() {
		return da�o;
	}
	
	public void mover() {
		rectangulo.setBounds((int)rectangulo.getX()-velocidad,(int)rectangulo.getY(),(int)rectangulo.getWidth(),(int)rectangulo.getHeight());
		graficoActual.setBounds(graficoActual.getX()-velocidad,graficoActual.getY(),graficoActual.getWidth(),graficoActual.getHeight());
		distanciaRecorrida+=velocidad;
		if(distanciaRecorrida>alcance) {
			destruir();
		}
	}
	
}