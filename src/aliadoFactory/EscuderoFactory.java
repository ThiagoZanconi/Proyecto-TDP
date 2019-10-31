package aliadoFactory;

import aliados.Aliado;
import aliados.Escudero;

public class EscuderoFactory extends AbstractAliadoFactory {

	@Override
	public Aliado crearAliado(int x, int y) {
		// TODO Auto-generated method stub
		return new Escudero(x,y);
	}

}
