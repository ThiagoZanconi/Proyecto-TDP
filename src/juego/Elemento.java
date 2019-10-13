package juego;
import java.awt.Rectangle;
import visitor.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Elemento {
	protected int vida;
	protected final int tamaņoAncho=32;
	protected final int tamaņoLargo=32;
	protected JLabel imagenes[];
	protected JLabel grafico;
	protected Rectangle rectangulo;
	
	public Elemento(int v) {
		vida=v;
		imagenes=new JLabel[1];
		
	}
	
	public Rectangle getRectangulo() {
		return rectangulo;
	}
	
	public abstract void aceptar(Visitor v);

}
