package enemigoFactory;

import enemigos.Enemigo;
import enemigos.Tanque;

public class TanqueFactory extends AbstractEnemigoFactory {

	@Override
	public Enemigo crearEnemigo(int x, int y) {
		// TODO Auto-generated method stub
		return new Tanque(x,y);
	}

}
