package enemigos;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import juego.*;
import visitor.VisitorEnemigo;
public class Invocador extends Enemigo {

	public Invocador(int x, int y) {
		super(10,100,100,100);
		enMovimiento=true;
		this.imagenes[0] = new JLabel();
		imagenes[0].setIcon(new ImageIcon("Sprites\\Invocador\\InvocadorSummon.gif"));
		
		this.graficoActual = new JLabel();
		this.graficoActual.setIcon(imagenes[0].getIcon());
		this.graficoActual.setBounds(100, 100, 50, 50);
		
		rectangulo=new Rectangle(x,y,100,50);
		miVisitor=new VisitorEnemigo(this);
	}

}
