package enemigos;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import visitor.VisitorEnemigo;

public class Rapido extends Enemigo {

	public Rapido(int x, int y) {
		super(10,100,100,100);
		velocidad=5;
		enMovimiento=true;
		imagenes[0] = new JLabel();
		imagenes[0].setIcon(new ImageIcon("Sprites\\Rapido\\RapidoWalk.gif"));
		graficoActual = new JLabel();
		graficoActual.setIcon(imagenes[0].getIcon());
		graficoActual.setBounds(100, 100, 50, 50);
		rectangulo=new Rectangle(x,y,100,70);
		miVisitor=new VisitorEnemigo(this);
	}
	
	public void atacar() {
		
	}
}
