package visitor;

import Objetos.Objeto;
import Objetos.Obstaculo;
import Objetos.Premio;
import aliados.Aliado;
import disparos.Disparo;
import enemigos.Enemigo;
import juego.ElementoDerrota;
import juego.Personaje;

public class VisitorAlcanceEnemigo extends VisitorAlcance{
	
	public VisitorAlcanceEnemigo(Personaje p) {
		miPersonaje=p;	
	}
	
	public void visitarEnemigo(Enemigo e) {
		
	}
	
	public void visitarAliado(Aliado e) {
		miPersonaje.atacar();
	}
	
	public void visitarDisparo(Disparo d) {
		
	}
	
	public void visitarElementoDerrota(ElementoDerrota e) {
		
	}

	@Override
	public void VisitarObstaculo(Obstaculo o) {
		miPersonaje.aceptar(o.getVisitor());
		
	}

	@Override
	public void visitarPremio(Premio p) {
		miPersonaje.atacar();
		
	}

	@Override
	public void visitarObjeto(Objeto o) {
		miPersonaje.atacar();
		
	}

}
