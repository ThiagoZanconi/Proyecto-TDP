package aliados;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import disparos.Disparo;
import disparos.DisparoBallesta;
import visitor.VisitorAliado;

public class Ballesta extends Aliado {
	
	public Ballesta(int x,int y) {
		super(150,1000,500,150);
		costoMonedas=300;
		imagenes[0] = new JLabel();
		imagenes[0].setIcon(new ImageIcon("Sprites\\Ballesta\\BallestaAttack.gif"));
		graficoActual = new JLabel();
		graficoActual.setIcon(imagenes[0].getIcon());
		graficoActual.setBounds(x, y, 1000,1000);
		colisionVenta=new JLabel();
		colisionVenta.setBounds(x,y,80,60);
		//OyenteVenderAliado oyenteVender=new OyenteVenderAliado();
		//graficoActual.addMouseListener( click);       El grafico es muy grande para que tenga un mouselistener
		alcanceDeAtaque=new Rectangle(x-700,y,700,70);
		rectangulo=new Rectangle(x,y,80,60);
		miVisitor=new VisitorAliado(this);
	}
	
	public void atacar() {
		if(puedeAtacar) {
			Disparo x=new DisparoBallesta((int)rectangulo.getX(),(int)rectangulo.getY(),this.getFuerzaDeImpacto(),(int)alcanceDeAtaque.getWidth());
			adaptador.añadirElemento(x);	
		}
		
	}

}
