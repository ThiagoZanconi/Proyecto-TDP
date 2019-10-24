package enemigos;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import visitor.VisitorEnemigo;

public class Tanque extends Enemigo {

	public Tanque(int x, int y) {
		super(10,100,2000,100);
		enMovimiento=true;
		imagenes[0] = new JLabel();
		imagenes[0].setIcon(new ImageIcon("Sprites\\Tanque\\TanqueWalk.gif"));
		graficoActual = new JLabel();
		graficoActual.setIcon(imagenes[0].getIcon());
		graficoActual.setBounds(100, 100, 50, 50);
		alcanceDeAtaque=new Rectangle(x,y,700,80);
		rectangulo=new Rectangle(x,y,100,70);
		miVisitor=new VisitorEnemigo(this);
		velocidad=2;
	}
	
	public void atacar() {
		
	}
}
