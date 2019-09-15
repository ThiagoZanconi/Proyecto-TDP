package juego;

public class Celda {
	protected Aliado aliado; 
	protected int x;
	protected int y;
	
	public Celda(int x,int y) {
		this.x=x;
		this.y=y;
		aliado=null;
	}
	
	public void vaciar() {
		aliado=null;
	}
}
