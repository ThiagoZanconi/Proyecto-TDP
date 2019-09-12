package juego;

public abstract class Personaje extends Elemento{
	protected int fuerzaDeImpacto;
	protected int alcance;
	
	public Personaje(int f,int a,int v) {
		super(v);
		fuerzaDeImpacto=f;
		alcance=a;
	}

}
