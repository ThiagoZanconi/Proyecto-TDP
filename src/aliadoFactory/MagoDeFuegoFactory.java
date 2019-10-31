package aliadoFactory;

import aliados.Aliado;
import aliados.MagoDeFuego;

public class MagoDeFuegoFactory extends AbstractAliadoFactory{

	@Override
	public Aliado crearAliado(int x, int y) {
		// TODO Auto-generated method stub
		return new MagoDeFuego(x,y);
	}

}
