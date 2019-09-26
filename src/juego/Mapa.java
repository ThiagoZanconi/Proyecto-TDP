package juego;

public final class Mapa {
	protected Celda[][] cuadrilla;
	protected final int largo=10;
	protected final int ancho=6;
	private static final Mapa mapa=new Mapa();
	
	private Mapa() {
		cuadrilla=(Celda[][])new Celda[ancho][largo];  //Arreglo[filas][columnas]
		for(int i=0;i<ancho;i++) {
			for(int j=0;j<largo;j++) {
				cuadrilla[i][j]=new Celda(i,j);
			}
				
		}
		
	}
	
	public static Mapa getMapa() {
		return mapa;
	}
	
	public Celda obtenerCelda(int x, int y) {
		return cuadrilla[x][y];
	}
	
}
