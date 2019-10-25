package disparos;

import javax.swing.ImageIcon;

public class DisparoMagoDeFuego extends DisparoAliado {

	public DisparoMagoDeFuego(int x, int y, int d, int a) {
		super(x, y, d, a);
		graficoActual.setIcon(new ImageIcon("Sprites\\MagoDeFuego\\MagoFProjectile.gif"));
		graficoActual.setBounds(x,y+450,80,80);
	}

}
