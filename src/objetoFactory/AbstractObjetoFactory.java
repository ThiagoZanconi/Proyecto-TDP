package objetoFactory;

import javax.swing.JButton;

import Objetos.Objeto;

public abstract class AbstractObjetoFactory extends JButton {
	public abstract Objeto crearObjeto(int x,int y);

}
