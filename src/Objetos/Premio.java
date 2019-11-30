package Objetos;

import javax.swing.JLabel;

public abstract class Premio extends Objeto{
	protected int daño;
	
	public Premio(int x,int y){
		super();
		vida=-1;
		graficoActual=new JLabel();
		graficoActual.setBounds(x,y,1000,1000);
	}
	
	public int getDaño() {
		return daño;
	}
}
