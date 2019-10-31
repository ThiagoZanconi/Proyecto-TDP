package abstractFactory;

import aliados.MagoDeFuego;
import juego.Elemento;

public class MagoDeFuegoFactory implements AbstractFactory {

	@Override
	public Elemento crearElemento(int x, int y) {
		// TODO Auto-generated method stub
		return new MagoDeFuego(x,y);
	}

}
