package Objetos;

import javax.swing.ImageIcon;
import visitor.Visitor;

public class CampoDeProteccion extends MagiaTemporal {

	public CampoDeProteccion(int x,int y) {
		super(x,y);
		graficoActual.setIcon(new ImageIcon("Sprites\\Campo.png"));
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
