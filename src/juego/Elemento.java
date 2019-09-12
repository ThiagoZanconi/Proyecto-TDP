package juego;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Elemento {
	protected int vida;
	protected final int tamañoAncho=32;
	protected final int tamañoLargo=32;
	protected ImageIcon imagenes[];
	protected JLabel grafico;
	
	public Elemento(int v) {
		vida=v;
		imagenes=new ImageIcon[1];
		
	}

}
