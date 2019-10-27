package abstractFactory;

import enemigos.Curador;
import juego.Elemento;

public class CuradorFactory implements AbstractFactory {

	@Override
	public Elemento crearElemento(int x, int y) {
		// TODO Auto-generated method stub
		return new Curador(x,y);
	}

}
