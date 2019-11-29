package visitor;

import Objetos.Objeto;
import Objetos.Obstaculo;
import Objetos.ObstaculoTemporal;
import Objetos.Premio;
import aliados.Aliado;
import disparos.Disparo;
import enemigos.Enemigo;
import juego.ElementoDerrota;

public class VisitorAliado extends Visitor {
	protected Aliado miAliado;
	
	public VisitorAliado(Aliado a) {
		miAliado=a;
	}
	
	/**
	 * Al momento de insertar un aliado sobre otro aliado se genera una colision que denega la creacion del nuevo aliado
	 */
	public void visitarAliado(Aliado a) {
		a.setColisiono(true);
	}
	
	/**
	 * El enemigo colisiona con el aliado por lo que deja de caminar
	 */
	public void visitarEnemigo(Enemigo e) {
		e.detener();
	}

	public void visitarDisparo(Disparo d) {
		miAliado.aceptar(d.getVisitor());
	}
	
	public void visitarElementoDerrota(ElementoDerrota e) {
		
	}

	public void VisitarObstaculoTemporal(ObstaculoTemporal o) {
		
		
	}

	@Override
	public void VisitarObstaculo(Obstaculo o) {
		miAliado.aceptar(o.getVisitor());
		
	}

	@Override
	public void visitarPremio(Premio p) {
		miAliado.aceptar(p.getVisitor());
		
	}

	@Override
	public void visitarObjeto(Objeto o) {
		miAliado.aceptar(o.getVisitor());
		
	}

}
