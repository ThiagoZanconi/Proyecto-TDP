package juego;
import javax.swing.Icon;
import javax.swing.JLabel;

public abstract class Elemento {
	protected int vida;
	protected final int tamaņoAncho=32;
	protected final int tamaņoLargo=32;
	protected Icon imagenes[];
	protected JLabel grafico;
	
	public Elemento(int v) {
		vida=v;
		imagenes=new Icon[1];
		
	}

}
