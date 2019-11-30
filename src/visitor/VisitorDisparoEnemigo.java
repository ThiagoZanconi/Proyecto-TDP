package visitor;

import Objetos.Objeto;
import Objetos.Obstaculo;
import Objetos.Premio;
import aliados.Aliado;
import disparos.Disparo;
import disparos.DisparoEnemigo;
import enemigos.Enemigo;
import juego.ElementoDerrota;

public class VisitorDisparoEnemigo extends Visitor {
	
	protected DisparoEnemigo miDisparoEnemigo;
	
	public VisitorDisparoEnemigo(DisparoEnemigo d) {
		miDisparoEnemigo=d;
	}
	
	public void visitarEnemigo(Enemigo e) {
		
	}
	public void visitarAliado(Aliado a) {
		a.recibirDaño(miDisparoEnemigo.getDaño());
		miDisparoEnemigo.destruir();
		
	}
	public void visitarDisparo(Disparo d) {
		
	}

	public void visitarElementoDerrota(ElementoDerrota e) {
		
	}

	@Override
	public void VisitarObstaculo(Obstaculo ot) {
		miDisparoEnemigo.aceptar(ot.getVisitor());
		
	}

	@Override
	public void visitarPremio(Premio p) {
		miDisparoEnemigo.aceptar(p.getVisitor());
		
	}

	@Override
	public void visitarObjeto(Objeto o) {
		miDisparoEnemigo.aceptar(o.getVisitor());
		
	}
}
