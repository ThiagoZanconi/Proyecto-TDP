package juego;

public final class Mapa {
	protected Celda[][] cuadrilla;
	
	public Mapa() {
		cuadrilla=(Celda[][])new Celda[6][10];  //Arreglo[filas][columnas]
		for(int i=0;i<6;i++) {
			for(int j=0;j<10;j++) {
				cuadrilla[i][j]=new Celda(i,j);
			}
				
		}
		
	}
	
	public Celda obtenerCelda(int x, int y) {
		return cuadrilla[x][y];
	}
	
}
