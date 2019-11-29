package stateTiendaPremios;

import Objetos.Bomba;
import Objetos.Premio;

public class EstadoCrearBomba extends EstadoTienda {
	
	public EstadoCrearBomba(int x,int y) {
		super(x,y);
	}

	@Override
	public void crearPremio(int x, int y) {
		adaptador.setCrearPremio(false);
		Premio bomba=new Bomba(x,y);
		adaptador.añadirElemento(bomba);
		
	}
	

}
