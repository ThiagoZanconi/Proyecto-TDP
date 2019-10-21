package disparos;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import juego.Elemento;
import visitor.Visitor;
import visitor.VisitorDisparoAliado;

public class Disparo extends Elemento {
	
	
	protected int daño;
	protected int velocidad;
	
	
	public Disparo(int x,int y) {
		super(-1);
		this.daño=50;
		this.velocidad=200;
		graficoActual=new JLabel();
		graficoActual.setIcon(new ImageIcon("Sprites\\BallestaProjectile.gif"));
		rectangulo=new Rectangle(x,y,100,100);
		graficoActual.setBounds(rectangulo);
		miVisitor=new VisitorDisparoAliado(this);
		
	}
	
	public void aceptar(Visitor v) {
		v.visitarDisparo(this);
	}
	
	public void actividadSinColision() {
		
	}
	
}