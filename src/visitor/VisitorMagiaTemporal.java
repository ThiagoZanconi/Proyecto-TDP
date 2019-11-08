package visitor;

import Objetos.MagiaTemporal;
import Objetos.Obstaculo;
import aliados.Aliado;
import disparos.Disparo;
import enemigos.Enemigo;
import juego.ElementoDerrota;

public class VisitorMagiaTemporal extends Visitor{
	protected MagiaTemporal miMagia;
	
	public void visitarEnemigo(Enemigo e) {
		if(e!=miMagia.getPersonaje() && !miMagia.afectaUsuario())
			miMagia.performStrategy(e);
	}

	public void visitarAliado(Aliado a) {
		if(a!=miMagia.getPersonaje() && !miMagia.afectaUsuario())
			miMagia.performStrategy(a);		
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