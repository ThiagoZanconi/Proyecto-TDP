package aliadoFactory;

import aliados.Aliado;
import aliados.Barricada;

public class BarricadaFactory extends AbstractAliadoFactory{

	@Override
	public Aliado crearAliado(int x, int y) {
		// TODO Auto-generated method stub
		return new Barricada(x,y);
	}
	
	

}
