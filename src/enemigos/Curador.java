package enemigos;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import juego.*;
import visitor.VisitorEnemigo;
public class Curador extends Enemigo {

	public Curador(int x, int y) {
		super(10,100,100,100);
		enMovimiento=true;
		this.imagenes[0] = new JLabel();
		imagenes[0].setIcon(new ImageIcon("Sprites\\Curador\\CuradorWalk.gif"));
		
		this.graficoActual = new JLabel();
		this.graficoActual.setIcon(imagenes[0].getIcon());
		this.graficoActual.setBounds(x, y, 1000, 1000);
		
		rectangulo=new Rectangle(x,y,100,70);
		miVisitor=new VisitorEnemigo(this);
	}
	
	public void atacar() {
		
	}
}
