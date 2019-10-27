package abstractFactory;

import juego.Elemento;

public interface AbstractFactory {
	
	public abstract Elemento crearElemento(int x,int y);

}
