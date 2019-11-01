package disparoEnemigoFactory;

import disparos.DisparoEnemigo;
import enemigos.Enemigo;

public abstract class AbstractDisparoEnemigoFactory {
	public abstract DisparoEnemigo crearDisparo(Enemigo e);

}
