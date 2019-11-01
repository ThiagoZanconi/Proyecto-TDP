package aliados;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import disparos.Disparo;
import disparos.DisparoAliado;
import visitor.VisitorAliado;

public class Guerrero extends Aliado {
	public Guerrero(int x,int y) {
		super(150,100,1000,100);
		imagenes[0] = new JLabel();
		imagenes[0].setIcon(new ImageIcon("Sprites\\Guerrero\\GuerreroAttack.gif"));
		graficoActual = new JLabel();
		graficoActual.setIcon(imagenes[0].getIcon());
		graficoActual.setBounds(x, y, 1000, 1000);
		alcanceDeAtaque=new Rectangle(x,y,120,80);
		rectangulo=new Rectangle(x,y,80,70);
		miVisitor=new VisitorAliado(this);
	}
	
	public void atacar() {
		if(puedeAtacar) {
			Disparo x=new DisparoAliado((int)rectangulo.getX(),(int)rectangulo.getY(),this.getFuerzaDeImpacto(),(int)alcanceDeAtaque.getWidth());
			adaptador.añadirElemento(x);	
		}
	}

}
