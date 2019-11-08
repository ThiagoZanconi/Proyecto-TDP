package visitor;

import Objetos.MagiaTemporal;
import Objetos.Obstaculo;
import aliados.Aliado;
import disparos.Disparo;
import enemigos.Enemigo;
import juego.ElementoDerrota;

public class VisitorMagiaTemporal extends Visitor{
	protected MagiaTemporal miMagia;
	
	public VisitorMagiaTemporal(MagiaTemporal mt) {
		miMagia=mt;
	}
	
	public void visitarEnemigo(Enemigo e) {
		if(miMagia.usar(e)) {
			miMagia.performStrategy(e);
			miMagia.destruir();
		}
	}

	public void visitarAliado(Aliado a) {
		if(miMagia.usar(a)) {
			miMagia.performStrategy(a);	
			miMagia.destruir();
		}
	}

	public void visitarDisparo(Disparo d) {
		// TODO Auto-generated method stub
		
	}

	public void visitarElementoDerrota(ElementoDerrota e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarObstaculo(Obstaculo o) {
		// TODO Auto-generated method stub
		
	}

}