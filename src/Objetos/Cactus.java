package Objetos;

import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import juego.Personaje;
import visitor.VisitorCactus;

public class Cactus extends ObstaculoConVida{
	protected int daño;
	
	public Cactus(int x,int y) {
		super();
		vida=1500;
		daño=50;
		miVisitor=new VisitorCactus(this);
		graficoActual = new JLabel();
		graficoActual.setIcon(new ImageIcon("Sprites\\Obstaculos\\cactus.png"));
		graficoActual.setBounds(x, y, 1000, 1000);
		rectangulo=new Rectangle(x,y,80,70);
	}
	
	public void atacar(Personaje p) {
		estado.atacar(daño, p);
	}

}
