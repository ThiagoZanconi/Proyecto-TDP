package juego;
import java.awt.Rectangle;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Elemento {
	protected int vida;
	protected final int tama�oAncho=32;
	protected final int tama�oLargo=32;
	protected ImageIcon imagenes[];
	protected JLabel grafico;
	protected Rectangle rectangulo;
	
	public Elemento(int v) {
		vida=v;
		imagenes=new ImageIcon[1];
		
	}

}
