package enemigos;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import visitor.VisitorEnemigo;

public class Rango extends Enemigo {

	public Rango(int x, int y) {
		super(10,100,1000,100);
		enMovimiento=true;
		imagenes[0] = new JLabel();
		imagenes[0].setIcon(new ImageIcon("Sprites\\Rango\\RangoAttack+Walk.gif"));
		graficoActual = new JLabel();
		graficoActual.setIcon(imagenes[0].getIcon());
		graficoActual.setBounds(x, y, 80, 80);
		alcanceDeAtaque=new Rectangle(x,y,700,80);
		rectangulo=new Rectangle(x,y,80,70);
		miVisitor=new VisitorEnemigo(this);
	}

	public void atacar() {
		
	}
}
