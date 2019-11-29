package stateTiendaPremios;

public class EstadoCrearTesoro extends EstadoTienda{
	
	public EstadoCrearTesoro(int x,int y) {
		super(x,y);
	}

	@Override
	public void crearPremio(int x, int y) {
		adaptador.setCrearPremio(false);
		adaptador.actualizarMonedas(250);	
	}
	

}
