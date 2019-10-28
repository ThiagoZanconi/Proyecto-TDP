package juego;
import gui.*;
public final class Juego {
	
	protected static Tienda tienda;
	protected static GUI gui;
	protected static Elementos elementos;
	protected static final Juego juego=new Juego();
	
	private Juego() {
		gui=gui.getGUI();
		elementos=elementos.getElementos();
		
	}
	
	public static Juego getJuego() {
		return juego;
	}
	
	public void iniciarJuego() {
		tienda=new Tienda();
	}
	
	public boolean crearAliado() {
		return tienda.crearAliado();
	}
	
	public String aliadoComprado() {
		return tienda.aliadoComprado();
	}
	
	public void generarGuerrero(int x, int y) {
		tienda.generarGuerrero(x,y);
	}
	
	public void generarBallesta(int x, int y) {
		tienda.generarBallesta(x,y);
	}
	
	public void generarMagoDeHielo(int x, int y) {
		tienda.generarMagoDeHielo(x, y);
	}
	
	public void generarMagoDeFuego(int x, int y) {
		tienda.generarMagoDeFuego(x,y);
	}
	
	public void generarEscudero(int x, int y) {
		tienda.generarEscudero(x, y);
	}
	
	public void generarBarricada(int x, int y) {
		tienda.generarBarricada(x, y);
	}
	/**
	 * Utilizamos dos iteraciones distintas ya que chequear ambas colisiones en un mismo recorrido de lista puede generar problemas
	 */
	
	public void mover() {
		for(int i=0;i<elementos.size();i++) {
			elementos.getElemento(i).actividadSinColision();
			for(int j=i+1;j<elementos.size();j++) {
				chequearColision(elementos.getElemento(i),elementos.getElemento(j));
			}
			
			
		}
		elementos.eliminar();
	}
	
	/**
	 * Chequea la colision entre dos elementos e1 y e2 (Si hay colision se ejecutan las operaciones correspondientes a la colision en cuestion)
	 * @param e1 
	 * @param e2 
	 */
	
	public void chequearColision(Elemento e1,Elemento e2) {
		elementos.chequearColision(e1,e2);
	}
	
	
	/**
	 * Chequea la colision de un elemento con todos los otros elementos
	 * @param e1
	 */
	public void chequearColision(Elemento e1) {
		for(int i=0;i<elementos.size();i++) {
			if(e1!=elementos.getElemento(i)) {
				chequearColision(elementos.getElemento(i),e1);
			}
			
		}
	}
	
	

}
