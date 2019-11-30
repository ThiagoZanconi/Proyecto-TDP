package Objetos;

import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import visitor.Visitor;
import visitor.VisitorMinaOro;

public class MinaOro extends ObjetoConVida{
	
	public MinaOro(int x,int y) {
		super();
		miVisitor=new VisitorMinaOro(this);
		vida=1;
		costoMonedas=600;
		graficoActual=new JLabel();
		graficoActual.setIcon(new ImageIcon("Sprites\\Objetos\\minaDeOro.gif"));
		graficoActual.setBounds(x,y,1000,1000);
		rectangulo=new Rectangle(x,y,80,70);
		colisiono=false;
	}
	
	public void recibirDaño(int d) {
		vida-=d;
		if(vida<0)
			destruir();
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitarObjeto(this);	
	}

	@Override
	public void actividadSinColision() {
		adaptador.actualizarMonedas(1);	
	}

}
