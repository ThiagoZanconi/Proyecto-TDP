package visitor;

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
}
