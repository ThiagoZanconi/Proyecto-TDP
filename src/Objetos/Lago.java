package Objetos;

import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import gui.HiloDuracionObjeto;
import juego.Personaje;
import visitor.Visitor;
import visitor.VisitorLago;

public class Lago extends ObstaculoTemporal{
	protected int daño;

	public Lago(int x,int y) {
		super();
		daño=40;
		miVisitor=new VisitorLago(this);
		graficoActual = new JLabel();
		graficoActual.setIcon(new ImageIcon("Sprites\\Obstaculos\\lagoasesino.gif"));
		graficoActual.setBounds(x, y, 1000, 1000);
		rectangulo=new Rectangle(x,y,80,70);
		duracion=new HiloDuracionObjeto(this,15000);
		duracion.start();
	}
	
	public void aceptar(Visitor v) {
		v.VisitarObstaculo(this);
	}
	
	public void atacar(Personaje p) {
		estado.atacar(daño, p);
	}
}