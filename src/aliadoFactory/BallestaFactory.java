package aliadoFactory;

import aliados.Aliado;
import aliados.Ballesta;

public class BallestaFactory extends AbstractAliadoFactory {

	@Override
	public Aliado crearAliado(int x, int y) {
		// TODO Auto-generated method stub
		return new Ballesta(x,y);
	}

}
