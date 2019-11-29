package Objetos;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import visitor.VisitorPiedra;

public class Piedra extends ObstaculoConVida{

	public Piedra(int x,int y) {
		super();
		vida=2000;
		miVisitor=new VisitorPiedra(this);
		graficoActual = new JLabel();
		graficoActual.setIcon(new ImageIcon("Sprites\\Obstaculos\\piedra.png"));
		graficoActual.setBounds(x, y, 1000, 1000);
		rectangulo=new Rectangle(x,y,80,70);
	}
	
	

}
