package juego;

import visitor.Visitor;
import visitor.VisitorElementoDerrota;

public class ElementoDerrota extends Elemento {

	public ElementoDerrota() {
		super(-1);
		miVisitor=new VisitorElementoDerrota(this);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actividadSinColision() {
		// TODO Auto-generated method stub
		
	}
	
	public void derrota() {
		
	}

}
