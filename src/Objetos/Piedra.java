package Objetos;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import gui.HiloDuracionObjeto;
import visitor.VisitorLago;
import visitor.VisitorObstaculoConVida;

public class Piedra extends ObstaculoConVida{

	public Piedra(int v,int x,int y) {
		super(v);
		miVisitor=new VisitorObstaculoConVida(this);
		graficoActual = new JLabel();
		graficoActual.setIcon(new ImageIcon("Sprites\\Obstaculos\\piedra.png"));
		graficoActual.setBounds(x, y, 1000, 1000);
		rectangulo=new Rectangle(x,y,80,70);
	}
	
	

}
