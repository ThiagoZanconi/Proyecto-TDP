package enemigos;

import juego.Personaje;
import visitor.Visitor;

public abstract class Enemigo extends Personaje {
	protected boolean enMovimiento;
	protected int puntaje;
	protected int cantidadMonedas;

	public Enemigo(int f, int a, int v,int vp) {
		super(f, a, v,vp);
		enMovimiento=true;
	}
	
	public void aceptar(Visitor v) {
		v.visitarEnemigo(this);
	}
	
	public void detener() {
		enMovimiento=false;
	}
	
	/**
	 * Caminar
	 */
	public void actividadSinColision() {
		if(enMovimiento) {
			rectangulo.setBounds((int)rectangulo.getX()+10,(int)rectangulo.getY(),(int)rectangulo.getWidth(),(int)rectangulo.getHeight());
			graficoActual.setBounds(graficoActual.getX()+10,graficoActual.getY(),graficoActual.getWidth(),graficoActual.getHeight());
			if(graficoActual.getX()>1300) {
				graficoActual.setBounds(0,graficoActual.getY(),graficoActual.getWidth(),graficoActual.getHeight());
				rectangulo.setBounds(0,(int)rectangulo.getY(),(int)rectangulo.getWidth(),(int)rectangulo.getHeight());
			}
				
		}
		else {
			enMovimiento=true;
		}
		
	}
	
	
}