package juego;

public class Celda {
	protected Elemento elemento; 
	protected int x;
	protected int y;
	
	public Celda(int x,int y) {
		this.x=x;
		this.y=y;
		elemento=null;
	}
	
	public void vaciar() {
		elemento=null;
	}
}
