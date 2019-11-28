package enemigos;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import disparos.Disparo;
import disparos.DisparoEnemigo;
import visitor.VisitorEnemigo;

public class Tanque extends Enemigo {

	public Tanque(int x, int y) {
		super(200,100,2000,100);
		cantidadMonedas=300;
		enMovimiento=true;
		imagenes[0] = new JLabel();
		imagenes[0].setIcon(new ImageIcon("Sprites\\Tanque\\TanqueWalk.gif"));
		graficoActual = new JLabel();
		graficoActual.setIcon(imagenes[0].getIcon());
		graficoActual.setBounds(x,y,1000,1000);
		alcanceDeAtaque=new Rectangle(x,y,80,70);
		rectangulo=new Rectangle(x,y,80,70);
		miVisitor=new VisitorEnemigo(this);
		velocidad=2;
	}
	
	public void generarDisparo() {
		if(puedeAtacar) {
			Disparo x=new DisparoEnemigo((int)rectangulo.getX(),(int)rectangulo.getY(),this.getFuerzaDeImpacto(),(int)alcanceDeAtaque.getWidth());
			adaptador.añadirElemento(x);
		}
	}
	
}
