package disparos;

import javax.swing.ImageIcon;

public class DisparoBallesta extends DisparoAliado{
	public DisparoBallesta(int x, int y,int d,int a) {
		super(x,y,d,a);
		graficoActual.setIcon(new ImageIcon("Sprites\\Ballesta\\BallestaProjectile.gif"));
		graficoActual.setBounds(x,y+450,80,80);
	}

}
