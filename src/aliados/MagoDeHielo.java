package aliados;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import disparos.Disparo;
import disparos.DisparoMagoDeHielo;
import visitor.VisitorAliado;

public class MagoDeHielo extends Aliado {

	public MagoDeHielo(int x,int y) {
		super(150,100,400,100);
		costoMonedas=300;
		imagenes[0] = new JLabel();
		imagenes[0].setIcon(new ImageIcon("Sprites\\MagoDeHielo\\MagoHIdle.gif"));
		graficoActual = new JLabel();
		graficoActual.setIcon(imagenes[0].getIcon());
		graficoActual.setBounds(x, y, 1000,1000);
		colisionVenta=new JLabel();
		colisionVenta.setBounds(x,y,80,70);
		colisionVenta.addMouseListener(click);
		alcanceDeAtaque=new Rectangle(x-700,y,700,80);
		rectangulo=new Rectangle(x,y,80,70);
		miVisitor=new VisitorAliado(this);
	}
	
	public void atacar() {
		if(puedeAtacar) {
			Disparo x=new DisparoMagoDeHielo((int)rectangulo.getX(),(int)rectangulo.getY(),this.getFuerzaDeImpacto(),(int)alcanceDeAtaque.getWidth());
			adaptador.añadirElemento(x);	
		}
	}
}
