package visitor;
import aliados.Aliado;
import disparos.Disparo;
import enemigos.Enemigo;

public abstract class Visitor {	
	public abstract void visitarEnemigo(Enemigo e);
	public abstract void visitarAliado(Aliado a);
	public abstract void visitarDisparo(Disparo d);
	
}
