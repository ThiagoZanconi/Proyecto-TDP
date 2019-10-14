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
		this.imagenes[0] = new JLabel();
		imagenes[0].setIcon(new ImageIcon("Sprites\\EnemigoCaminando.gif"));
		
		this.graficoActual = new JLabel();
		this.graficoActual.setIcon(imagenes[0].getIcon());
		this.graficoActual.setBounds(100, 100, tamañoAncho, tamañoLargo);
		
		rectangulo=new Rectangle(x,y,100,100);
		miVisitor=new VisitorEnemigo();
	}

	public void aceptar(Visitor v) {
		v.visitarEnemigo(this);
		
	}
}
