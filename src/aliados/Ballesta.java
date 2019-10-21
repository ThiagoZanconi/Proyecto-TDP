package aliados;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import disparos.Disparo;
import disparos.DisparoAliado;
import visitor.VisitorAliado;

public class Ballesta extends Aliado {
	
	public Ballesta(int x,int y) {
		super(200,1000,500,150);
		this.imagenes[0] = new JLabel();
		imagenes[0].setIcon(new ImageIcon("Sprites\\Ballesta\\BallestaAttack.gif"));
		
		this.graficoActual = new JLabel();
		this.graficoActual.setIcon(imagenes[0].getIcon());
		this.graficoActual.setBounds(100, 100, 50, 50);
		
		alcanceDeAtaque=new Rectangle(x,y,700,80);
		rectangulo=new Rectangle(x,y,80,80);
		miVisitor=new VisitorAliado(this);
		
	}
	
	public void atacar() {
		Disparo x=new DisparoAliado((int)rectangulo.getX(),(int)rectangulo.getY());
		adaptador.añadirDisparo(x);	
	}

}
