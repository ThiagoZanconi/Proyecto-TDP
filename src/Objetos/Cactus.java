package Objetos;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import visitor.VisitorCactus;

public class Cactus extends ObstaculoConVida{

	public Cactus(int v,int x,int y) {
		super(v);
		miVisitor=new VisitorCactus(this);
		graficoActual = new JLabel();
		graficoActual.setIcon(new ImageIcon("Sprites\\Obstaculos\\cactus.png"));
		graficoActual.setBounds(x, y, 1000, 1000);
		rectangulo=new Rectangle(x,y,80,70);
	}
	
	

}
