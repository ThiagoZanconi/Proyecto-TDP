package enemigos;
import juego.Personaje;
import visitor.Visitor;

public abstract class Enemigo extends Personaje {
	protected boolean enMovimiento;
	protected int puntaje;
	protected int cantidadMonedas;
	protected int velocidad;

	public Enemigo(int f, int a, int v,int vp) {
		super(f, a, v,vp);
		enMovimiento=true;
		velocidad=3;
	}
	
	public void aceptar(Visitor v) {
		v.visitarEnemigo(this);
	}
	
	public void detener() {
		enMovimiento=false;
	}
	
	
	public void actividadSinColision() {
		mover();
	}
	
	/**
	 * Caminar
	 */
	public void mover() {
		if(enMovimiento) {
			rectangulo.setBounds((int)rectangulo.getX()+velocidad,(int)rectangulo.getY(),(int)rectangulo.getWidth(),(int)rectangulo.getHeight());
			graficoActual.setBounds(graficoActual.getX()+velocidad,graficoActual.getY(),graficoActual.getWidth(),graficoActual.getHeight());
			alcanceDeAtaque.setBounds((int)rectangulo.getX()+velocidad,(int)rectangulo.getY(),(int)rectangulo.getWidth(),(int)rectangulo.getHeight());
			if(graficoActual.getX()>1300) {
				graficoActual.setBounds(0,graficoActual.getY(),graficoActual.getWidth(),graficoActual.getHeight());
				rectangulo.setBounds(0,(int)rectangulo.getY(),(int)rectangulo.getWidth(),(int)rectangulo.getHeight());
				alcanceDeAtaque.setBounds(0,(int)rectangulo.getY(),(int)rectangulo.getWidth(),(int)rectangulo.getHeight());
			}	
		}
		else {
			enMovimiento=true;
		}
	}
	
}