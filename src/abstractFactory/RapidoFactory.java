package abstractFactory;

import enemigos.Rapido;
import juego.Elemento;

public class RapidoFactory implements AbstractFactory {

	@Override
	public Elemento crearElemento(int x, int y) {
		// TODO Auto-generated method stub
		return new Rapido(x,y);
	}

}
