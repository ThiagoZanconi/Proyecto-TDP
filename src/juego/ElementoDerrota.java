package juego;

import java.awt.Rectangle;

import visitor.Visitor;
import visitor.VisitorElementoDerrota;

public class ElementoDerrota extends Elemento {

	public ElementoDerrota() {
		super(-1);
		rectangulo=new Rectangle();
		rectangulo.setBounds(1110,100,50,800);//Hay que ajustar colision
		miVisitor=new VisitorElementoDerrota(this);
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitarElementoDerrota(this);
	}

	@Override
	public void actividadSinColision() {
		
	}
	
	public void derrota() {
		System.out.println("Derrota");
	}

}
