package enemigoFactory;

import enemigos.Enemigo;
import enemigos.Rango;

public class RangoFactory extends AbstractEnemigoFactory {

	@Override
	public Enemigo crearEnemigo(int x, int y) {
		// TODO Auto-generated method stub
		return new Rango(x,y);
	}

}
