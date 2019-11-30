package visitor;

import Objetos.Objeto;
import Objetos.Obstaculo;
import Objetos.Premio;
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

	@Override
	public void VisitarObstaculo(Obstaculo ot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarPremio(Premio p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarObjeto(Objeto o) {
		// TODO Auto-generated method stub
		
	}

}
