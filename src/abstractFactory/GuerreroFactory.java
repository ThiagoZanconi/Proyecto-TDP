package abstractFactory;

import aliados.Guerrero;
import juego.Elemento;

public class GuerreroFactory implements AbstractFactory {

	@Override
	public Elemento crearElemento(int x, int y) {
		// TODO Auto-generated method stub
		return new Guerrero(x,y);
	}

}
