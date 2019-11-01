package enemigoFactory;

import enemigos.Enemigo;
import enemigos.Rapido;

public class RapidoFactory extends AbstractEnemigoFactory {

	@Override
	public Enemigo crearEnemigo(int x, int y) {
		// TODO Auto-generated method stub
		return new Rapido(x,y);
	}

}
