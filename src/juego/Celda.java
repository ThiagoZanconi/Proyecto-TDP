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
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Aliado getAliado() {
		return aliado;
	}
	
	public void setX(int x) {
		this.x=x;
	}
	
	public void setY(int y) {
		this.y=y;
	}
	
	public void setAliado(Aliado a) {
		aliado=a;
	}
}
