package Objetos;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import juego.Personaje;
import visitor.Visitor;
import visitor.VisitorLago;

public class Lago extends ObstaculoTemporal{
	protected int daño;
	protected boolean puedeAtacar;

	public Lago(int x,int y) {
		super(-1);
		daño=200;
		puedeAtacar=true;
		miVisitor=new VisitorLago(this);
		graficoActual = new JLabel();
		graficoActual.setIcon(new ImageIcon("Sprites\\Obstaculos\\lagoasesino.gif"));
		graficoActual.setBounds(x, y, 1000, 1000);
		rectangulo=new Rectangle(x,y,80,70);
	}
	
	public void aceptar(Visitor v) {
		v.visitarObstaculo(this);
	}
	
	public int getDaño() {
		return daño;
	}
	
	public boolean getPuedeAtacar() {
		return puedeAtacar;
	}

	public void setPuedeAtacar(boolean b) {
		puedeAtacar=b;
	}
	
	public void atacar(Personaje p) {
		if(puedeAtacar) {
			p.recibirDaño(daño);
		}
	}
}