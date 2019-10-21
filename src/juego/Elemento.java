package juego;
import java.awt.Rectangle;
import visitor.*;
import javax.swing.JLabel;

import adaptador.Adaptador;

public abstract class Elemento {
	protected int fuerzaDeImpacto;
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
	
	public abstract void actividadSinColision();
	
	public Adaptador getAdaptador() {
		return adaptador;
	}
	
	public Rectangle getRectangulo() {
		return rectangulo;
	}
	
	public JLabel getGrafico(){
		return this.graficoActual;
	}
	
	public Visitor getVisitor() {
		return miVisitor;
	}
	
	public int getFuerzaDeImpacto() {
		return fuerzaDeImpacto;
	}
	
	public void destruir() {
		adaptador.eliminarElemento(this);
		graficoActual.setVisible(false);
	}
}
