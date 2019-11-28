package enemigos;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import disparos.Disparo;
import disparos.DisparoEnemigo;
import visitor.VisitorEnemigo;

public class Rapido extends Enemigo {

	public Rapido(int x, int y) {
		super(200,100,650,100);
		cantidadMonedas=150;
		velocidad=5;
		enMovimiento=true;
		imagenes[0] = new JLabel();
		imagenes[0].setIcon(new ImageIcon("Sprites\\Rapido\\RapidoWalk.gif"));
		graficoActual = new JLabel();
		graficoActual.setIcon(imagenes[0].getIcon());
		graficoActual.setBounds(x,y,1000,1000);
		alcanceDeAtaque=new Rectangle(x,y,80,70);
		rectangulo=new Rectangle(x,y,80,70);
		miVisitor=new VisitorEnemigo(this);
	}
	
	public void generarDisparo() {
		if(puedeAtacar) {
			Disparo x=new DisparoEnemigo((int)rectangulo.getX(),(int)rectangulo.getY(),this.getFuerzaDeImpacto(),(int)alcanceDeAtaque.getWidth());
			adaptador.añadirElemento(x);
		}
	}
}
