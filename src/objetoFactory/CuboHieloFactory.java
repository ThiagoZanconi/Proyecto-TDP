package objetoFactory;

import Objetos.CuboHielo;
import Objetos.Objeto;

public class CuboHieloFactory extends AbstractObjetoFactory {

	@Override
	public Objeto crearObjeto(int x, int y) {
		// TODO Auto-generated method stub
		return new CuboHielo(x,y);
	}

}
