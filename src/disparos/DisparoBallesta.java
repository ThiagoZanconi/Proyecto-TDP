package disparos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DisparoBallesta extends DisparoAliado{
	public DisparoBallesta(int x, int y,int d) {
		super(x,y,d);
		graficoActual=new JLabel();
		graficoActual.setIcon(new ImageIcon("Sprites\\Ballesta\\BallestaProjectile.gif"));
		graficoActual.setBounds(x,y+450,80,80);
	}

}
