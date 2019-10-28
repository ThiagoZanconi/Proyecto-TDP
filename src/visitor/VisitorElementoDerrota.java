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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarAliado(Aliado a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarDisparo(Disparo d) {
		// TODO Auto-generated method stub
		
	}

}
