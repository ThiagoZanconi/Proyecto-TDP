package visitor;

import aliados.Aliado;
import disparos.Disparo;
import enemigos.Enemigo;
import juego.ElementoDerrota;

public class VisitorElementoDerrota extends Visitor {
	protected ElementoDerrota miElementoDerrota;
	
	public VisitorElementoDerrota(ElementoDerrota e) {
		miElementoDerrota=e;	
	}

	@Override
	public void visitarEnemigo(Enemigo e) {
		miElementoDerrota.aceptar(e.getVisitor());
	}

	@Override
	public void visitarAliado(Aliado a) {
		
	}

	@Override
	public void visitarDisparo(Disparo d) {
		
	}
	
	public void visitarElementoDerrota(ElementoDerrota e) {
		
	}

}
