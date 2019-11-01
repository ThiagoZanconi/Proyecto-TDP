package aliados;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import disparos.Disparo;
import disparos.DisparoMagoDeFuego;
import visitor.VisitorAliado;

public class MagoDeFuego extends Aliado {

	public MagoDeFuego(int x,int y) {
		super(150,100,500,100);
		imagenes[0] = new JLabel();
		imagenes[0].setIcon(new ImageIcon("Sprites\\MagoDeFuego\\MagoFAttack.gif"));
		graficoActual = new JLabel();
		graficoActual.setIcon(imagenes[0].getIcon());
		this.graficoActual.setBounds(x, y, 1000,1000);
		alcanceDeAtaque=new Rectangle(x-700,y,700,80);
		rectangulo=new Rectangle(x,y,80,70);
		miVisitor=new VisitorAliado(this);
	}
	
	public void atacar() {
		if(puedeAtacar) {
			Disparo x=new DisparoMagoDeFuego((int)rectangulo.getX(),(int)rectangulo.getY(),this.getFuerzaDeImpacto(),(int)alcanceDeAtaque.getWidth());
			adaptador.añadirElemento(x);	
		}
	}

}
