package visitor;

import Objetos.Obstaculo;
import Objetos.ObstaculoConVida;
import Objetos.ObstaculoTemporal;
import aliados.Aliado;
import disparos.Disparo;
import disparos.DisparoAliado;
import enemigos.Enemigo;
import juego.ElementoDerrota;

public class VisitorDisparoAliado extends Visitor {
	protected DisparoAliado miDisparoAliado;
	
	public VisitorDisparoAliado(DisparoAliado d) {
		miDisparoAliado=d;
	}
	
	public void visitarEnemigo(Enemigo e) {
		e.recibirDaño(miDisparoAliado.getDaño());
		miDisparoAliado.destruir();
	}
	public void visitarAliado(Aliado a) {
		
	}
	public void visitarDisparo(Disparo d) {
		
	}

	public void visitarElementoDerrota(ElementoDerrota e) {
		
	}

	public void VisitarObstaculoTemporal(ObstaculoTemporal o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void VisitarObstaculo(Obstaculo ot) {
		miDisparoAliado.aceptar(ot.getVisitor());
		
	}
}
