package Objetos;

import java.awt.Rectangle;
import visitor.VisitorBomba;

public class Bomba extends ObjetoPrecioso {

	public Bomba(int x,int y) {
		super(x,y);
		rectangulo=new Rectangle(x,y,80,70);
		miVisitor=new VisitorBomba(this);
	}

}
