package enemigos;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import visitor.VisitorEnemigo;

public class Invocador extends Enemigo {

	public Invocador(int x, int y) {
		super(10,100,1000,100);
		enMovimiento=true;
		imagenes[0] = new JLabel();
		imagenes[0].setIcon(new ImageIcon("Sprites\\Invocador\\InvocadorWalk.gif"));
		graficoActual = new JLabel();
		graficoActual.setIcon(imagenes[0].getIcon());
		graficoActual.setBounds(x,y,1000,1000);
		alcanceDeAtaque=new Rectangle(x,y,80,70);
		rectangulo=new Rectangle(x,y,80,70);
		miVisitor=new VisitorEnemigo(this);
	}
	
	public void actividadSinColision(){
		adaptador.chequearColisionDeAtaques(this);
		mover();
		invocar();
	}
	
	public void atacar() {
		
	}
	
	public void invocar() {
		
	}

}
