package visitor;

import aliados.Aliado;
import disparos.Disparo;
import enemigos.Enemigo;
import juego.Elemento;

public class VisitorAlcanceEnemigo extends VisitorAlcance{
	public VisitorAlcanceEnemigo(Elemento e) {
		miElemento=e;	
	}
	
	public void visitarEnemigo(Enemigo e) {
		
	}
	
	public void visitarAliado(Aliado e) {
		
	}
	
	public void visitarDisparo(Disparo d) {
		
	}
	

}
