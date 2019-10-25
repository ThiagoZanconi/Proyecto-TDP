package enemigos;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import disparos.Disparo;
import disparos.DisparoRango;
import visitor.VisitorEnemigo;

public class Rango extends Enemigo {

	public Rango(int x, int y) {
		super(100,100,1000,100);
		enMovimiento=true;
		imagenes[0] = new JLabel();
		imagenes[0].setIcon(new ImageIcon("Sprites\\Rango\\RangoAttack+Walk.gif"));
		graficoActual = new JLabel();
		graficoActual.setIcon(imagenes[0].getIcon());
		graficoActual.setBounds(x, y, 80, 80);
		alcanceDeAtaque=new Rectangle(x,y, 700,70);
		rectangulo=new Rectangle(x,y,80,70);
		miVisitor=new VisitorEnemigo(this);
	}

	public void atacar() {
		if(puedeAtacar) {
			Disparo x=new DisparoRango((int)rectangulo.getX(),(int)rectangulo.getY(),this.getFuerzaDeImpacto(),(int)alcanceDeAtaque.getWidth());
			adaptador.añadirDisparo(x);
		}
	}
}
