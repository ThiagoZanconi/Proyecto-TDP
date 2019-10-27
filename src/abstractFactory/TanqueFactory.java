package abstractFactory;

import enemigos.Tanque;
import juego.Elemento;

public class TanqueFactory implements AbstractFactory {

	@Override
	public Elemento crearElemento(int x, int y) {
		// TODO Auto-generated method stub
		return new Tanque(x,y);
	}

}
