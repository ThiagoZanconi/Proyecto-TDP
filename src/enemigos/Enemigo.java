package enemigos;
import juego.Personaje;
import visitor.Visitor;
import visitor.VisitorAlcanceEnemigo;

public abstract class Enemigo extends Personaje {
	protected boolean enMovimiento;
	protected int puntaje;
	protected int cantidadMonedas;
	protected int velocidad;

	public Enemigo(int f, int a, int v,int vp) {
		super(f, a, v,vp);
		enMovimiento=true;
		velocidad=3;
		visitorAlcance=new VisitorAlcanceEnemigo(this);
	}
	
	public void aceptar(Visitor v) {
		v.visitarEnemigo(this);
	}
	
	public void detener() {
		enMovimiento=false;
	}
	
	
	public void actividadSinColision() {
		adaptador.chequearColisionDeAtaques(this);
		mover();
	}
	
	/**
	 * Caminar
	 */
	public void mover() {
		if(enMovimiento) {
			rectangulo.setBounds((int)rectangulo.getX()+velocidad,(int)rectangulo.getY(),(int)rectangulo.getWidth(),(int)rectangulo.getHeight());
			graficoActual.setBounds(graficoActual.getX()+velocidad,graficoActual.getY(),graficoActual.getWidth(),graficoActual.getHeight());
			alcanceDeAtaque.setBounds((int)alcanceDeAtaque.getX()+velocidad,(int)alcanceDeAtaque.getY(),(int)alcanceDeAtaque.getWidth(),(int)alcanceDeAtaque.getHeight());
			if(graficoActual.getX()>1300) {
				graficoActual.setBounds(0,graficoActual.getY(),graficoActual.getWidth(),graficoActual.getHeight());
				rectangulo.setBounds(0,(int)rectangulo.getY(),(int)rectangulo.getWidth(),(int)rectangulo.getHeight());
				alcanceDeAtaque.setBounds(0,(int)alcanceDeAtaque.getY(),(int)alcanceDeAtaque.getWidth(),(int)alcanceDeAtaque.getHeight());
			}	
		}
		else {
			enMovimiento=true;
		}
	}
	
}