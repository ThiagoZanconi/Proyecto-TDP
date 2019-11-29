package juego;
import java.awt.Rectangle;
import visitor.*;
import javax.swing.JLabel;
import adaptador.Adaptador;

public abstract class Elemento {
	protected Visitor miVisitor;
	protected int vida;
	protected JLabel imagenes[];
	protected JLabel graficoActual;
	protected Rectangle rectangulo;
	protected Adaptador adaptador;
	
	protected Elemento() {
		imagenes=new JLabel[1];
		adaptador=Adaptador.getAdaptador();
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
	
	public void destruir() {
		adaptador.eliminarElemento(this);
		graficoActual.setVisible(false);
	}
}
