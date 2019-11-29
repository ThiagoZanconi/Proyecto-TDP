package aliados;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import disparos.Disparo;
import disparos.DisparoBallesta;
import visitor.VisitorAliado;

public class Ballesta extends Aliado {
	
	public Ballesta(int x,int y) {
		super(x,y);
		fuerzaDeImpacto=200;
		alcance=1800;
		vidaMaxima=500;
		vida=vidaMaxima;
		velocidadDeProyectil=150;
		costoMonedas=350;
		
		rectangulo=new Rectangle(x,y,80,70);
		alcanceDeAtaque=new Rectangle(x-1800,y,1800,70);
		imagenes[0] = new JLabel();
		imagenes[0].setIcon(new ImageIcon("Sprites\\Ballesta\\BallestaAttack.gif"));
		graficoActual = new JLabel();
		graficoActual.setIcon(imagenes[0].getIcon());
		graficoActual.setBounds(x, y, 1000,1000); //El grafico es muy grande para que tenga un mouselistener
		colisionVenta=new JLabel();
		colisionVenta.setBounds(x,y+450,100,100); //Hay que ajustar parametros
		colisionVenta.addMouseListener(click);
		miVisitor=new VisitorAliado(this);
	}
	
	public void generarDisparo() {
			Disparo x=new DisparoBallesta((int)rectangulo.getX(),(int)rectangulo.getY(),this.getFuerzaDeImpacto(),(int)alcanceDeAtaque.getWidth());
			adaptador.añadirElemento(x);	

	}

}
