package enemigos;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import disparos.Disparo;
import disparos.DisparoEnemigo;
import visitor.VisitorEnemigo;

public class Normal extends Enemigo {

	public Normal(int x,int y) {
		super(100,100,1000,100);
		enMovimiento=true;
		imagenes[0] = new JLabel();
		imagenes[0].setIcon(new ImageIcon("Sprites\\Normal\\NormalWalk.gif"));
		graficoActual = new JLabel();
		graficoActual.setIcon(imagenes[0].getIcon());
		graficoActual.setBounds(100, 100, 50, 100);
		alcanceDeAtaque=new Rectangle(x,y,80,70);
		rectangulo=new Rectangle(x,y,80,70);
		miVisitor=new VisitorEnemigo(this);
	}
	
	public void atacar() {
		if(puedeAtacar) {
			Disparo x=new DisparoEnemigo((int)rectangulo.getX(),(int)rectangulo.getY(),this.getFuerzaDeImpacto(),(int)alcanceDeAtaque.getWidth());
			adaptador.añadirElemento(x);
		}
	}
}
