package Objetos;

import javax.swing.ImageIcon;

import visitor.Visitor;

public class RelojTemporal extends MagiaTemporal {

	public RelojTemporal(int x, int y) {
		super(x, y);
		graficoActual.setIcon(new ImageIcon("Sprites\\Premios\\Realentizar enemigos¿.gif"));
		// TODO Auto-generated constructor stub
	}

	@Override
	public void clickeado() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actividadSinColision() {
		// TODO Auto-generated method stub
		
	}

}
