package visitor;
import Objetos.Objeto;
import Objetos.Obstaculo;
import Objetos.Premio;
import aliados.Aliado;
import disparos.Disparo;
import enemigos.Enemigo;
import juego.ElementoDerrota;

public class VisitorEnemigo extends Visitor {
	protected Enemigo miEnemigo;
	
	public VisitorEnemigo(Enemigo e) {
		miEnemigo=e;
	}
	
	public void visitarAliado(Aliado a) {
		miEnemigo.aceptar(a.getVisitor());
		
	}
	/**
	 * Colision enemigo con enemigo no hace nada
	 */
	public void visitarEnemigo(Enemigo e) {
		
	}

	public void visitarDisparo(Disparo d) {
		miEnemigo.aceptar(d.getVisitor());
		
	}
	
	public void visitarElementoDerrota(ElementoDerrota e) {
		e.derrota();
	}

	@Override
	public void VisitarObstaculo(Obstaculo o) {
		miEnemigo.aceptar(o.getVisitor());
	}

	@Override
	public void visitarPremio(Premio p) {
		miEnemigo.aceptar(p.getVisitor());
		
	}

	@Override
	public void visitarObjeto(Objeto o) {
		miEnemigo.aceptar(o.getVisitor());
		
	}
}
