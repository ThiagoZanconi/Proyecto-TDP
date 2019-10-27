package abstractFactory;

import enemigos.Normal;
import juego.Elemento;

public class NormalFactory implements AbstractFactory{

	@Override
	public Elemento crearElemento(int x, int y) {
		// TODO Auto-generated method stub
		return new Normal(x,y);
	}

}
