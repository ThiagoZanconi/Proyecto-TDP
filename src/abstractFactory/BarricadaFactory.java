package abstractFactory;

import aliados.Barricada;
import juego.Elemento;

public class BarricadaFactory implements AbstractFactory{

	@Override
	public Elemento crearElemento(int x, int y) {
		// TODO Auto-generated method stub
		return new Barricada(x,y);
	}

}
