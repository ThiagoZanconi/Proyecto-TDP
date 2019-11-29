package visitor;

import Objetos.Cactus;
import Objetos.Objeto;
import Objetos.Obstaculo;
import Objetos.Premio;
import aliados.Aliado;
import disparos.Disparo;
import enemigos.Enemigo;
import juego.ElementoDerrota;

public class VisitorCactus extends VisitorObstaculo{
	
	private Cactus miCactus;
	
	public VisitorCactus(Cactus c) {
		miCactus=c;		
	}
	
	public void visitarEnemigo(Enemigo e) {
		e.atacar();
		e.detener();
		miCactus.atacar(e);
	}

	public void visitarAliado(Aliado a) {
		a.atacar();
		miCactus.atacar(a);
	}

	public void visitarDisparo(Disparo d) {
		miCactus.recibirDaño(d.getDaño());
		d.destruir();
	}

	@Override
	public void visitarElementoDerrota(ElementoDerrota e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void VisitarObstaculo(Obstaculo ot) {
		miCactus.destruir();
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
