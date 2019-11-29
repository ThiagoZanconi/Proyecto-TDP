package aliados;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import disparos.Disparo;
import disparos.DisparoMagoDeHielo;
import visitor.VisitorAliado;

public class MagoDeHielo extends Aliado {

	public MagoDeHielo(int x,int y) {
		super(x,y);
		fuerzaDeImpacto=300;
		alcance=400;
		vidaMaxima=800;
		vida=vidaMaxima;
		velocidadDeProyectil=100;
		costoMonedas=500;
		imagenes[0] = new JLabel();
		imagenes[0].setIcon(new ImageIcon("Sprites\\MagoDeHielo\\MagoHIdle.gif"));
		graficoActual = new JLabel();
		graficoActual.setIcon(imagenes[0].getIcon());
		graficoActual.setBounds(x, y, 1000,1000);
		colisionVenta=new JLabel();
		colisionVenta.setBounds(x,y+450,100,100);
		colisionVenta.addMouseListener(click);
		alcanceDeAtaque=new Rectangle(x-700,y,700,70);
		rectangulo=new Rectangle(x,y,80,70);
		miVisitor=new VisitorAliado(this);
	}
	
	public void generarDisparo() {
			Disparo x=new DisparoMagoDeHielo((int)rectangulo.getX(),(int)rectangulo.getY(),this.getFuerzaDeImpacto(),(int)alcanceDeAtaque.getWidth());
			adaptador.añadirElemento(x);	
	}
}
