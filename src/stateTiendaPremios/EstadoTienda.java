package stateTiendaPremios;

import adaptador.Adaptador;

public abstract class EstadoTienda {
	protected int x;
	protected int y;
	protected Adaptador adaptador;
	
	public EstadoTienda(int x,int y) {
		this.x=x;
		this.y=y;
		adaptador=Adaptador.getAdaptador();
	}
	
	public abstract void crearPremio(int x,int y);

}
