package enemigoFactory;

import enemigos.Enemigo;
import enemigos.Normal;

public class NormalFactory extends AbstractEnemigoFactory{

	@Override
	public Enemigo crearEnemigo(int x, int y) {
		// TODO Auto-generated method stub
		return new Normal(x,y);
	}

}
