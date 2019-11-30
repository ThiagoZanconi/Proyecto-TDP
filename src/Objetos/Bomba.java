package Objetos;

import java.awt.Rectangle;
import javax.swing.ImageIcon;
import gui.HiloDuracionObjeto;
import visitor.Visitor;
import visitor.VisitorBomba;

public class Bomba extends ObjetoPrecioso {

	public Bomba(int x,int y) {
		super(x,y);
		rectangulo=new Rectangle(0,-800,2000,2000);
		miVisitor=new VisitorBomba(this);
		daño=10000;
		graficoActual.setIcon(new ImageIcon("Sprites\\Premios\\Explosion2.gif"));
		graficoActual.setBounds(0, 0, 1000, 1000);
		HiloDuracionObjeto hilo=new HiloDuracionObjeto(this,1650);
		hilo.start();
	}

    public void aceptar(Visitor v) {
        v.visitarPremio(this);
    }

}
