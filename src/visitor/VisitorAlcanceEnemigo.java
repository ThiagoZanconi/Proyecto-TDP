package visitor;

import aliados.Aliado;
import disparos.Disparo;
import enemigos.Enemigo;
import juego.Elemento;

public class VisitorAlcanceEnemigo extends VisitorAlcance{
	protected Enemigo miEnemigo;
	public VisitorAlcanceEnemigo(Enemigo e) {
		miEnemigo=e;	
	}
	
	public void visitarEnemigo(Enemigo e) {
		
	}
	
	public void visitarAliado(Aliado e) {
		
	}
	
	public void visitarDisparo(Disparo d) {
		
	}
	

}
