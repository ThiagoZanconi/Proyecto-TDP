package juego;

public abstract class Personaje extends Elemento{
	protected int fuerzaDeImpacto;
	protected int alcance;
	protected int velocidadDeProyectil;
	
	public Personaje(int f,int a,int v,int vp) {
		super(v);
		fuerzaDeImpacto=f;
		alcance=a;
		velocidadDeProyectil=vp;
	}
	
	public void atacar() {
		Disparo x=new Disparo(fuerzaDeImpacto,velocidadDeProyectil);
		
	}
	
	public void recibirDanio(int fuerzaImpacto) {
		
		this.vida-=fuerzaImpacto;
		if(this.vida<=0) {
			//matar(); 
		}
	}
	
	
}
