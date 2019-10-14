package aliados;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import juego.*;
import visitor.VisitorAliado;
public class Ballesta extends Aliado {
	public Ballesta(int x,int y) {
		super(100,100,100,100);
		this.imagenes[0] = new JLabel();
		imagenes[0].setIcon(new ImageIcon("Sprites\\Ballista_Turret.png"));
		
		this.graficoActual = new JLabel();
		this.graficoActual.setIcon(imagenes[0].getIcon());
		this.graficoActual.setBounds(100, 100, tamaņoAncho, tamaņoLargo);
		
		rectangulo=new Rectangle(x,y,100,100);
		miVisitor=new VisitorAliado();
	}
	
	public int getAncho() {
		return tamaņoAncho;
	}
	
	public int getLargo() {
		return tamaņoLargo;
	}

}
