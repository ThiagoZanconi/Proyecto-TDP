package juego;

public final class Mapa {
	protected Celda[][] cuadrilla;
	protected final int largo=10;
	protected final int ancho=6;
	private static final Mapa mapa=new Mapa();
	
	private Mapa() {
		cuadrilla=(Celda[][])new Celda[largo][ancho];
		for(int i=0;i<largo;i++) {
			for(int j=0;j<ancho;j++) {
				cuadrilla[i][j]=new Celda(i,j);
			}
				
		}
		
	}
	
	public static Mapa getMapa() {
		return mapa;
	}
}
