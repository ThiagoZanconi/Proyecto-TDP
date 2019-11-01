package enemigoFactory;

import enemigos.Curador;
import enemigos.Enemigo;

public class CuradorFactory extends AbstractEnemigoFactory {

	@Override
	public Enemigo crearEnemigo(int x, int y) {
		// TODO Auto-generated method stub
		return new Curador(x,y);
	}

}
