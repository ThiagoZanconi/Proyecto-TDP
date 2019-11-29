package Objetos;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import gui.HiloDuracionObjeto;
import visitor.VisitorBomba;

public class Bomba extends ObjetoPrecioso {
	protected int da�o;

	public Bomba(int x,int y) {
		super(x,y);
		rectangulo=new Rectangle(x,y,500,500);
		miVisitor=new VisitorBomba(this);
		da�o=10000;
		graficoActual.setIcon(new ImageIcon("Sprites\\Premios\\Explosion2.gif"));
		graficoActual.setBounds(0, 0, 1000, 1000);
		HiloDuracionObjeto hilo=new HiloDuracionObjeto(this,2000);
		hilo.start();
	}
	
	public int getDa�o() {
		return da�o;
	}

}
