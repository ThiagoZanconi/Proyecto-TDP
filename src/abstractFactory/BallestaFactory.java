package abstractFactory;

import aliados.Guerrero;
import juego.Elemento;

public class BallestaFactory implements AbstractFactory {

	@Override
	public Guerrero crearElemento(int x,int y) {
		// TODO Auto-generated method stub
		return new Guerrero(x,y);
	}

}
