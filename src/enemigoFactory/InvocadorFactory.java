package enemigoFactory;

import enemigos.Enemigo;
import enemigos.Invocador;

public class InvocadorFactory extends AbstractEnemigoFactory {

	@Override
	public Enemigo crearEnemigo(int x, int y) {
		// TODO Auto-generated method stub
		return new Invocador(x,y);
	}

}
