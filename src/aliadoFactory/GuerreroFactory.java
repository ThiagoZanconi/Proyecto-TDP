package aliadoFactory;

import aliados.Aliado;
import aliados.Guerrero;

public class GuerreroFactory extends AbstractAliadoFactory{

	@Override
	public Aliado crearAliado(int x, int y) {
		// TODO Auto-generated method stub
		return new Guerrero(x,y);
	}

}
