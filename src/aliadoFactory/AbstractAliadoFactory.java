package aliadoFactory;

import javax.swing.JButton;

import aliados.Aliado;

public abstract class AbstractAliadoFactory extends JButton {
	public abstract Aliado crearAliado(int x,int y);

}
