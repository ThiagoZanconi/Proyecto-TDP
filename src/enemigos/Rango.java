package enemigos;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import juego.*;
import visitor.VisitorEnemigo;
public class Rango extends Enemigo {

	public Rango(int x, int y) {
		super(10,100,100,100);
		enMovimiento=true;
		this.imagenes[0] = new JLabel();
		imagenes[0].setIcon(new ImageIcon("Sprites\\Rango\\RangoAttack+Walk.gif"));
		
		this.graficoActual = new JLabel();
		this.graficoActual.setIcon(imagenes[0].getIcon());
		this.graficoActual.setBounds(x, y, 80, 80);
		
		rectangulo=new Rectangle(x,y,80,100);
		miVisitor=new VisitorEnemigo(this);
	}

	public void atacar() {
		
	}
}
