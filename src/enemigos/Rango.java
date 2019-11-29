package enemigos;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import disparos.Disparo;
import disparos.DisparoRango;
import visitor.VisitorEnemigo;

public class Rango extends Enemigo {

	public Rango(int x, int y) {
		super(x,y);
		fuerzaDeImpacto=300;
		alcance=500;
		vidaMaxima=500;
		vida=vidaMaxima;
		velocidadDeProyectil=100;
		cantidadMonedas=200;
		enMovimiento=true;
		imagenes[0] = new JLabel();
		imagenes[0].setIcon(new ImageIcon("Sprites\\Rango\\RangoAttack+Walk.gif"));
		graficoActual = new JLabel();
		graficoActual.setIcon(imagenes[0].getIcon());
		graficoActual.setBounds(x, y,1000,1000);
		alcanceDeAtaque=new Rectangle(x,y, 500,70);
		miVisitor=new VisitorEnemigo(this);
	}

	public void generarDisparo() {
			Disparo x=new DisparoRango((int)rectangulo.getX(),(int)rectangulo.getY(),this.getFuerzaDeImpacto(),(int)alcanceDeAtaque.getWidth());
			adaptador.añadirElemento(x);
	}
}
