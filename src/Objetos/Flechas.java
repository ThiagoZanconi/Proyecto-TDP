package Objetos;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import gui.HiloDuracionObjeto;
import visitor.Visitor;
import visitor.VisitorFlechas;

public class Flechas extends ObjetoTemporal {
	protected int daño;
	
	public Flechas(int x,int y) {
		super();
		miVisitor=new VisitorFlechas(this);
		daño=2000;
		costoMonedas=200;
		graficoActual=new JLabel();
		graficoActual.setIcon(new ImageIcon("Sprites\\Objetos\\lluviaDeFlechas.gif"));
		graficoActual.setBounds(x,y,1000,1000);
		rectangulo=new Rectangle(x,y,300,300);
		colisiono=false;
		HiloDuracionObjeto hilo=new HiloDuracionObjeto(this,900);
		hilo.start();
	}
	
	public int getDaño() {
		return daño;
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitarObjeto(this);	
	}

	@Override
	public void actividadSinColision() {
		
	}

}
