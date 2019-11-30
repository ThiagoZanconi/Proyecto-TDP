package Objetos;

import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import visitor.Visitor;
import visitor.VisitorDummy;

public class Dummy extends ObjetoConVida {
	
	public Dummy(int x,int y) {
		super();
		miVisitor=new VisitorDummy(this);
		vida=1;
		costoMonedas=400;
		graficoActual=new JLabel();
		graficoActual.setIcon(new ImageIcon("Sprites\\Objetos\\dummyExplosivo.png"));
		graficoActual.setBounds(x,y,1000,1000);
		rectangulo=new Rectangle(x,y,80,70);
		colisiono=false;
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitarObjeto(this);
		
	}

	@Override
	public void actividadSinColision() {
		// TODO Auto-generated method stub
		
	}

}
