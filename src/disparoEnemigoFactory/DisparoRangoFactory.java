package disparoEnemigoFactory;

import disparos.DisparoEnemigo;
import disparos.DisparoRango;
import enemigos.Enemigo;

public class DisparoRangoFactory extends AbstractDisparoEnemigoFactory {

	@Override
	public DisparoEnemigo crearDisparo(Enemigo e) {
		return new DisparoRango((int)e.getRectangulo().getX(),(int)e.getRectangulo().getY(),e.getFuerzaDeImpacto(),(int)e.getAlcanceDeAtaque().getWidth());
	}
	

}
