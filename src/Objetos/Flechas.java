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
		vida=-1;
		daño=30;
		costoMonedas=350;
		graficoActual=new JLabel();
		graficoActual.setIcon(new ImageIcon("Sprites\\Objetos\\lluviaDeFlechas.gif"));
		graficoActual.setBounds(x-90,y-110,1000,1000);
		rectangulo=new Rectangle(x-50,y-50,200,200);
		colisiono=false;
		HiloDuracionObjeto hilo=new HiloDuracionObjeto(this,1700);
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
