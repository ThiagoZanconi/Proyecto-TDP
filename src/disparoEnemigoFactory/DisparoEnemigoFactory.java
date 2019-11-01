package disparoEnemigoFactory;

import disparos.DisparoEnemigo;
import enemigos.Enemigo;

public class DisparoEnemigoFactory extends AbstractDisparoEnemigoFactory{
	
	public DisparoEnemigo crearDisparo(Enemigo e) {
		return new DisparoEnemigo((int)e.getRectangulo().getX(),(int)e.getRectangulo().getY(),e.getFuerzaDeImpacto(),(int)e.getAlcanceDeAtaque().getWidth());	
	}

}
