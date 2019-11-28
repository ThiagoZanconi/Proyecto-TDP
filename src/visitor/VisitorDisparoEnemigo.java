package visitor;

import Objetos.ObstaculoConVida;
import Objetos.ObstaculoTemporal;
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
		a.recibirDa�o(miDisparoEnemigo.getDa�o());
		miDisparoEnemigo.destruir();
		
	}
	public void visitarDisparo(Disparo d) {
		
	}

	public void visitarElementoDerrota(ElementoDerrota e) {
		
	}

	@Override
	public void VisitarObstaculoTemporal(ObstaculoTemporal o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void VisitarObstaculoConVida(ObstaculoConVida ov) {
		ov.recibirDa�o(miDisparoEnemigo.getDa�o());
		miDisparoEnemigo.destruir();
	}
}
