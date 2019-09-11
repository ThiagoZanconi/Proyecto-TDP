package juego;

public class Mapa {
	protected Celda[][] mapa;
	protected final int largo=10;
	protected final int ancho=6;
	
	public Mapa() {
		mapa=(Celda[][])new Celda[largo][ancho];
		for(int i=0;i<largo;i++) {
			for(int j=0;j<ancho;j++) {
				mapa[i][j]=new Celda(i,j);
			}
				
		}
		
	}
}
