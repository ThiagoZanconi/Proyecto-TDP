package Objetos;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import visitor.Visitor;
import visitor.VisitorPared;

public class Pared extends ObjetoPrecioso{

	public Pared(int x, int y) {
		super(x, y);
		vida=1200;
		miVisitor=new VisitorPared(this);
		graficoActual.setIcon(new ImageIcon("Sprites\\Premios\\pared.png"));
		graficoActual.setBounds(x,y+450, 1000, 1000);
		rectangulo=new Rectangle(x,y,80,70);
	}
	
	public void aceptar(Visitor v) {
		v.visitarPremio(this);
		
	}

	public void recibirDaño(int daño) {
		vida-=daño;
		if(vida<0)
			destruir();
	}

}
