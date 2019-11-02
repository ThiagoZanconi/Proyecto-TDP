package juego;

import java.awt.Rectangle;
import visitor.Visitor;
import visitor.VisitorElementoDerrota;

public class ElementoDerrota extends Elemento {

	public ElementoDerrota() {
		super(-1);
		rectangulo=new Rectangle();
		rectangulo.setBounds(1110,-450,50,800);
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
		//Abrir ventana Con cartel que muestre la derrota y un boton aceptar para volver al menu principal
	}

}
