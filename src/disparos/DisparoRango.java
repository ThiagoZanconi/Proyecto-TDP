package disparos;

import javax.swing.ImageIcon;

public class DisparoRango extends DisparoEnemigo{

	public DisparoRango(int x, int y, int d, int a) {
		super(x, y, d, a);
		graficoActual.setIcon(new ImageIcon("Sprites\\Rango\\RangoProjectile.gif"));
		graficoActual.setBounds(x,y+450,80,80);
	}

}
