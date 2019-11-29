package visitor;

import Objetos.Obstaculo;
import Objetos.Piedra;
import aliados.Aliado;
import disparos.Disparo;
import enemigos.Enemigo;
import juego.ElementoDerrota;

public class VisitorPiedra extends VisitorObstaculo {
	protected Piedra miPiedra;
	
	public VisitorPiedra(Piedra p) {
		miPiedra=p;
	}

	
	public void visitarEnemigo(Enemigo e) {
		e.detener();
		e.atacar();
	}

	public void visitarAliado(Aliado a) {
		a.atacar();
	}

	public void visitarDisparo(Disparo d) {
		miPiedra.recibirDaño(d.getDaño());
		d.destruir();
	}

	public void visitarElementoDerrota(ElementoDerrota e) {
		// TODO Auto-generated method stub
		
	}

	public void VisitarObstaculo(Obstaculo ot) {
		miPiedra.destruir();
	}

}
