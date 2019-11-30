package objetoFactory;

import Objetos.MinaOro;
import Objetos.Objeto;

public class MinaOroFactory extends AbstractObjetoFactory {

	@Override
	public Objeto crearObjeto(int x, int y) {
		// TODO Auto-generated method stub
		return new MinaOro(x,y);
	}

}
