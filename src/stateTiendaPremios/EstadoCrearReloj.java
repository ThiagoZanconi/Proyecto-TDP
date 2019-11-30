package stateTiendaPremios;

import Objetos.Premio;
import Objetos.RelojRealentizador;

public class EstadoCrearReloj extends EstadoTienda {
	
	public EstadoCrearReloj(int x,int y) {
		super(x,y);
	}

	@Override
	public void crearPremio(int x, int y) {
		adaptador.setCrearPremio(false);
		Premio reloj=new RelojRealentizador(x,y);
		adaptador.añadirElemento(reloj);
		
	}

}
