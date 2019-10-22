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
		graficoActual.setIcon(new ImageIcon("Sprites\\Ballesta\\BallestaProjectile.gif"));
		rectangulo=new Rectangle(x,y,80,80);
		graficoActual.setBounds(x,y+450,80,80);
		miVisitor=new VisitorDisparoAliado(this);
		
	}
	
	public void aceptar(Visitor v) {
		v.visitarDisparo(this);
	}
	
	public void actividadSinColision() {
		rectangulo.setBounds((int)rectangulo.getX()-50,(int)rectangulo.getY(),(int)rectangulo.getWidth(),(int)rectangulo.getHeight());
		graficoActual.setBounds(graficoActual.getX()-50,graficoActual.getY(),graficoActual.getWidth(),graficoActual.getHeight());
	}
	
}