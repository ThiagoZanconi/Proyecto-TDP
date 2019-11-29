package Objetos;

import javax.swing.ImageIcon;

public class Tesoro extends ObjetoPrecioso {

	public Tesoro(int x,int y) {
		super(x,y);
		graficoActual.setIcon(new ImageIcon("Sprites\\Premios\\Monedas.gif"));
	}

	@Override
	public void clickeado() {
		adaptador.actualizarMonedas(700);
	}

}
