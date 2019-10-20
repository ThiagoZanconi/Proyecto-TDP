package juego;
import java.awt.Rectangle;
import visitor.*;
import javax.swing.JLabel;

import adaptador.Adaptador;

public abstract class Elemento {
	protected boolean enMovimiento;
	protected Visitor miVisitor;
	protected int vida;
	protected JLabel imagenes[];
	protected JLabel graficoActual;
	protected Rectangle rectangulo;
	protected Adaptador adaptador;
	
	public Elemento(int v) {
		vida=v;
		imagenes=new JLabel[1];
		adaptador=adaptador.getAdaptador();
	}
	
	public abstract void aceptar(Visitor v);
	
	public Adaptador getAdaptador() {
		return adaptador;
	}
	
	public Rectangle getRectangulo() {
		return rectangulo;
	}
	
	public JLabel getGrafico(){
		return this.graficoActual;
	}
	
	public boolean enMovimiento() {
		return enMovimiento;
	}
	
	public void setEnMovimiento(boolean x) {
		enMovimiento=x;
	}
	
	public Visitor getVisitor() {
		return miVisitor;
	}
}
