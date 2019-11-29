package visitor;

import Objetos.Obstaculo;
import Objetos.ObstaculoConVida;
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

}
