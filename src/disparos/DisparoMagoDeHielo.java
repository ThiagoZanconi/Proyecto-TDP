package disparos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DisparoMagoDeHielo extends DisparoAliado{
	public DisparoMagoDeHielo(int x,int y,int d) {
		super(x,y,d);
		graficoActual=new JLabel();
		graficoActual.setIcon(new ImageIcon("Sprites\\MagoDeHielo\\MagoHProjectile.gif"));
		graficoActual.setBounds(x,y+450,80,80);
	}

}
