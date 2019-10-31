package aliadoFactory;

import aliados.Aliado;
import aliados.MagoDeHielo;

public class MagoDeHieloFactory extends AbstractAliadoFactory {

	@Override
	public Aliado crearAliado(int x, int y) {
		// TODO Auto-generated method stub
		return new MagoDeHielo(x,y);
	}

}
