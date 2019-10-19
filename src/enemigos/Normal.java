package enemigos;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import juego.*;
import visitor.Visitor;
import visitor.VisitorEnemigo;
public class Normal extends Enemigo {

	public Normal(int x,int y) {
		super(100,100,100,100);
		enMovimiento=true;
		this.imagenes[0] = new JLabel();
		imagenes[0].setIcon(new ImageIcon("Sprites\\EnemigoCaminando.gif"));
		
		this.graficoActual = new JLabel();
		this.graficoActual.setIcon(imagenes[0].getIcon());
		this.graficoActual.setBounds(100, 100, tamañoAncho, tamañoLargo);
		
		rectangulo=new Rectangle(x,y,100,50);
		miVisitor=new VisitorEnemigo();
		colisiono=false;
	}

	public void aceptar(Visitor v) {
		v.visitarEnemigo(this);
		
	}
	
	public void avanzar() {
		if(!colisiono) {
			rectangulo.setBounds((int)rectangulo.getX()+10,(int)rectangulo.getY(),(int)rectangulo.getWidth(),(int)rectangulo.getHeight());
			graficoActual.setBounds((int)graficoActual.getX()+10,(int)graficoActual.getY(),(int)graficoActual.getWidth(),(int)graficoActual.getHeight());
		}
		
	}
}
