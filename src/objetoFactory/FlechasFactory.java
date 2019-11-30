package objetoFactory;

import Objetos.Flechas;
import Objetos.Objeto;

public class FlechasFactory extends AbstractObjetoFactory {

	@Override
	public Objeto crearObjeto(int x, int y) {
		// TODO Auto-generated method stub
		return new Flechas(x,y);
	}

}
