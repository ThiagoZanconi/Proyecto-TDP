package visitor;

import Objetos.Obstaculo;
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
	public void visitarObstaculo(Obstaculo o) {
		// TODO Auto-generated method stub
		
	}
}
