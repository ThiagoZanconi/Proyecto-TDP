package Objetos;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import visitor.Visitor;

public class CampoDeProteccion extends MagiaTemporal {
	protected boolean entidadDue�o;                  //false=enemigo, true=aliado

	public CampoDeProteccion(int x,int y) {
		super(x,y);
		graficoActual.setIcon(new ImageIcon("Sprites\\Campo.png"));
		rectangulo=new Rectangle(x,y,80,70);
	}
	
	public void setEntidadDue�o(boolean b) {
		entidadDue�o=b;
	}

	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actividadSinColision() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clickeado() {
		// TODO Auto-generated method stub
		
	}

}
