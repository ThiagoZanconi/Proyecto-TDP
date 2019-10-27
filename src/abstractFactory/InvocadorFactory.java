package abstractFactory;

import enemigos.Invocador;
import juego.Elemento;

public class InvocadorFactory implements AbstractFactory {

	@Override
	public Elemento crearElemento(int x, int y) {
		// TODO Auto-generated method stub
		return new Invocador(x,y);
	}

}
