package Objetos;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import gui.HiloDuracionObjeto;
import visitor.Visitor;
import visitor.VisitorDuna;

public class Duna extends ObstaculoTemporal{
	

	public Duna(int x,int y) {
		super();
		miVisitor=new VisitorDuna(this);
		graficoActual = new JLabel();
		graficoActual.setIcon(new ImageIcon("Sprites\\Obstaculos\\ralentiza.png"));
		graficoActual.setBounds(x, y, 1000, 1000);
		rectangulo=new Rectangle(x,y,80,70);
		duracion=new HiloDuracionObjeto(this,15000);
		duracion.start();
	}
	
	public void aceptar(Visitor v) {
		v.VisitarObstaculo(this);
	}
	
	
}