package abstractFactory;

import enemigos.Rango;
import juego.Elemento;

public class RangoFactory implements AbstractFactory {

	@Override
	public Elemento crearElemento(int x, int y) {
		// TODO Auto-generated method stub
		return new Rango(x,y);
	}

}
