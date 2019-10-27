package abstractFactory;

import aliados.MagoDeHielo;
import juego.Elemento;

public class MagoDeHieloFactory implements AbstractFactory {

	@Override
	public Elemento crearElemento(int x, int y) {
		// TODO Auto-generated method stub
		return new MagoDeHielo(x,y);
	}

}
