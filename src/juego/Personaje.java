package juego;

public abstract class Personaje extends Elemento{
	protected int fuerzaDeImpacto;
	protected int alcance;
	
	public Personaje(int f,int a,int v) {
		super(v);
		fuerzaDeImpacto=f;
		alcance=a;
	}
	
	public void recibirDanio(int fuerzaImpacto) {
		
		this.vida-=fuerzaImpacto;
		if(this.vida<=0) {
			//matar(); 
		}
	}

}
