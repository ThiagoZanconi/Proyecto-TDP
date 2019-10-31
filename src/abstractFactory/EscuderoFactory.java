package abstractFactory;

import aliados.Escudero;
import juego.Elemento;

public class EscuderoFactory implements AbstractFactory {

	@Override
	public Elemento crearElemento(int x, int y) {
		// TODO Auto-generated method stub
		return new Escudero(x,y);
	}

}
