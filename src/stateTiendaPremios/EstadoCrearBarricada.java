package stateTiendaPremios;

import Objetos.Pared;
import Objetos.Premio;

public class EstadoCrearBarricada extends EstadoTienda {
	
	public EstadoCrearBarricada(int x,int y) {   //Se llama crear barricada pero crea una pared
		super(x,y);
	}

	@Override
	public void crearPremio(int x, int y) {
		adaptador.setCrearPremio(false);
		Premio pared=new Pared(x,y);
		adaptador.añadirElemento(pared);
		
	}
	
	

}
