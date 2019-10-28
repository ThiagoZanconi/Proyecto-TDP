package juego;
import java.util.Random;

import enemigos.Curador;
import enemigos.Invocador;
import enemigos.Normal;
import enemigos.Rango;
import enemigos.Rapido;
import enemigos.Tanque;
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
	
	//Aliados
	
	public void generarGuerrero(int x, int y) {
		tienda.generarGuerrero(x,y);
	}
	
	public void generarBallesta(int x, int y) {
		tienda.generarBallesta(x,y);
	}
	
	public void generarMagoDeHielo(int x, int y) {
		tienda.generarMagoDeHielo(x,y);
	}
	
	public void generarMagoDeFuego(int x, int y) {
		tienda.generarMagoDeFuego(x,y);
	}
	
	public void generarEscudero(int x, int y) {
		tienda.generarEscudero(x,y);
	}
	
	public void generarBarricada(int x, int y) {
		tienda.generarBarricada(x,y);
	}
	
	//Enemigos
	
	public void generarCurador(int x,int y) {
		Curador curador=new Curador(x,y);
		elementos.añadirElemento(curador);
		gui.getVentanaJuego().add(curador.getGrafico());
	}
	
	public void generarInvocador(int x, int y) {
		Invocador invocador=new Invocador(x,y);
		elementos.añadirElemento(invocador);
		gui.getVentanaJuego().add(invocador.getGrafico());
	}
	
	public void generarNormal(int x, int y) {
		Normal normal=new Normal(x,y);
		elementos.añadirElemento(normal);
		gui.getVentanaJuego().add(normal.getGrafico());
	}
	
	public void generarRango(int x,int y) {
		Rango rango=new Rango(x,y);
		elementos.añadirElemento(rango);
		gui.getVentanaJuego().add(rango.getGrafico());
	}
	
	public void generarRapido(int x, int y) {
		Rapido rapido=new Rapido(x,y);
		elementos.añadirElemento(rapido);
		gui.getVentanaJuego().add(rapido.getGrafico());
	}
	
	public void generarTanque(int x, int y) {
		Tanque tanque=new Tanque(x,y);
		elementos.añadirElemento(tanque);
		gui.getVentanaJuego().add(tanque.getGrafico());
	}
	
	public void generarEnemigoAleatorio() {
		Random r=new Random();
		int fila=r.nextInt(6);
		int n=r.nextInt(100);
		if(n<30)
			generarNormal(0,fila);
		else
			if(n<50)
				generarRapido(0,fila);
			else
				if(n<70)
					generarTanque(0,fila);
				else
					if(n<84)
						generarRango(0,fila);
					else
						if(n<92)
							generarCurador(0,fila);
						else
							generarInvocador(0,fila);
	}
	
	
	
	
	/**
	 * 
	 */
	public void mover() {
		for(int i=0;i<elementos.size();i++) {
			elementos.getElemento(i).actividadSinColision();
			for(int j=i+1;j<elementos.size();j++) {
				elementos.chequearColision(elementos.getElemento(i),elementos.getElemento(j));
			}	
		}
		elementos.eliminar();
	}

}
