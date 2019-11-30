package objetoFactory;

import Objetos.Dummy;
import Objetos.Objeto;

public class DummyFactory extends AbstractObjetoFactory{

	@Override
	public Objeto crearObjeto(int x, int y) {
		// TODO Auto-generated method stub
		return new Dummy(x,y);
	}

}
