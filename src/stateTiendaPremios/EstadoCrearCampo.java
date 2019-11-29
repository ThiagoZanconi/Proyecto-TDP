package stateTiendaPremios;

public class EstadoCrearCampo extends EstadoTienda{
	
	public EstadoCrearCampo(int x,int y) {
		super(x,y);
	}

	@Override
	public void crearPremio(int x, int y) {
		adaptador.setCrearPremio(false);
	}
	

}
