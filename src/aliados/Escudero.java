package aliados;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import visitor.VisitorAliado;

public class Escudero extends Aliado {

	public Escudero(int x,int y) {
		super(100,100,1500,100);
		costoMonedas=300;
		imagenes[0] = new JLabel();
		imagenes[0].setIcon(new ImageIcon("Sprites\\Escudero\\EscuderoAttack.gif"));
		graficoActual = new JLabel();
		graficoActual.setIcon(imagenes[0].getIcon());
		graficoActual.setBounds(x, y, 1000, 1000);
		colisionVenta=new JLabel();
		colisionVenta.setBounds(x,y,80,70);
		colisionVenta.addMouseListener(click);
		alcanceDeAtaque=new Rectangle(x,y,80,80);
		rectangulo=new Rectangle(x,y,80,70);
		miVisitor=new VisitorAliado(this);
	}
	
	public void atacar() {
		
	}

}
