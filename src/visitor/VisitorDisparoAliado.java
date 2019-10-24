package visitor;


import aliados.Aliado;
import disparos.Disparo;
import disparos.DisparoAliado;
import enemigos.Enemigo;

public class VisitorDisparoAliado extends Visitor {
	protected DisparoAliado miDisparoAliado;
	
	public VisitorDisparoAliado(DisparoAliado d) {
		miDisparoAliado=d;
	}
	
	public void visitarEnemigo(Enemigo e) {
		e.recibirDaño(miDisparoAliado.getDaño());
		miDisparoAliado.destruir();
	}
	public void visitarAliado(Aliado a) {
		
	}
	public void visitarDisparo(Disparo d) {
		
	}

}
