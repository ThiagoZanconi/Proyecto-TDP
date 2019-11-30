package juego;

import java.util.Random;
import Objetos.Cactus;
import Objetos.Duna;
import Objetos.Lago;
import Objetos.Obstaculo;
import Objetos.Piedra;
import aliadoFactory.AbstractAliadoFactory;
import aliadoFactory.BallestaFactory;
import aliadoFactory.BarricadaFactory;
import aliadoFactory.EscuderoFactory;
import aliadoFactory.GuerreroFactory;
import aliadoFactory.MagoDeFuegoFactory;
import aliadoFactory.MagoDeHieloFactory;
import disparos.DisparoEnemigo;
import enemigoFactory.AbstractEnemigoFactory;
import enemigoFactory.CuradorFactory;
import enemigoFactory.InvocadorFactory;
import enemigoFactory.NormalFactory;
import enemigoFactory.RangoFactory;
import enemigoFactory.RapidoFactory;
import enemigoFactory.TanqueFactory;
import enemigos.Enemigo;
import gui.Hilo;
import gui.HiloAparicionEnemigos;
import objetoFactory.AbstractObjetoFactory;
import objetoFactory.CuboHieloFactory;
import objetoFactory.DummyFactory;
import objetoFactory.FlechasFactory;
import objetoFactory.MinaOroFactory;

public abstract class Nivel {
	protected static Juego juego;
	protected HiloAparicionEnemigos hiloAparicionEnemigos;
	protected Hilo hiloGeneral;	
	public Nivel(Juego j) {
		juego=j;
		hiloGeneral=new Hilo(juego);
	}
	
	public void iniciar() {
		hiloGeneral.start();
		hiloAparicionEnemigos.start();	
	}
	
	public void detenerJuego() {
		hiloGeneral.detenerHilo();
		hiloAparicionEnemigos.detenerHilo();
	}
	
	public void instanciarBotonesAliado(AbstractAliadoFactory []botones) {
		botones[0]=new GuerreroFactory();
		botones[0].setText("Guerrero");
		
		botones[1]=new BallestaFactory();
		botones[1].setText("Ballesta");
		
		botones[2]=new MagoDeHieloFactory();
		botones[2].setText("MagoDeHielo");
		
		botones[3]=new MagoDeFuegoFactory();
		botones[3].setText("MagoDeFuego");
		
		botones[4]=new EscuderoFactory();
		botones[4].setText("Escudero");
		
		botones[5]=new BarricadaFactory();
		botones[5].setText("Barricada");
	}
	
	public void instanciarBotonesObjeto(AbstractObjetoFactory []botones) {
		botones[0]=new CuboHieloFactory();
		botones[0].setText("CuboHielo");
				
		botones[1]=new DummyFactory();
		botones[1].setText("Dummy");
				
		botones[2]=new FlechasFactory();
		botones[2].setText("Flechas");
				
		botones[3]=new MinaOroFactory();
		botones[3].setText("MinaOroFactory");		
	}
	
	public Enemigo generarEnemigoAleatorio(int x,int y) {
		Enemigo toReturn=null;
		Random r=new Random();
		int n=r.nextInt(100);
		if(n<30) 
			toReturn=generarNormal(x,y);
		else
			if(n<50)
				toReturn=generarRapido(x,y);
			else
				if(n<70)
					toReturn=generarTanque(x,y);
				else
					if(n<84)
						toReturn=generarRango(x,y);
					else
						if(n<92)
							toReturn=generarCurador(x,y);
						else
							toReturn=generarInvocador(x,y);
		return toReturn;	
	}
	
	public Obstaculo generarObstaculoAleatorio() {
		Random r=new Random();
		int fila=traducirFila(r.nextInt(700));
		int columna=traducirColumna(r.nextInt(1110));
		Obstaculo obstaculo=new Piedra(columna,fila);
		
		switch(r.nextInt(4)) {
			case(0):
				return obstaculo=new Piedra(columna,fila);
				
			case(1):
				return obstaculo=new Duna(columna,fila);
				
			case(2):
				return obstaculo=new Lago(columna,fila);
				
			case(3):
				return obstaculo=new Cactus(columna,fila);
				
		}
		return obstaculo;
		
		
	}
	
	public Enemigo generarEnemigoAleatorio() {
		Enemigo toReturn=null;
		Random r=new Random();
		int fila=traducirFila(r.nextInt(700));
		int n=r.nextInt(100);
		if(n<30)
			toReturn=generarNormal(-65,fila);
		else
			if(n<50)
				toReturn=generarRapido(-65,fila);
			else
				if(n<70)
					toReturn=generarTanque(-65,fila);
				else
					if(n<84)
						toReturn=generarRango(-65,fila);
					else
						if(n<92)
							toReturn=generarCurador(-65,fila);
						else
							toReturn=generarInvocador(-65,fila);
		return toReturn;
	}
	
	public DisparoEnemigo crearDisparo(Enemigo e) {
		return null;
	}
	
	protected Enemigo generarInvocador(int x, int y) {
		AbstractEnemigoFactory f=new InvocadorFactory();
		Enemigo toReturn=f.crearEnemigo(x, y);
		return toReturn;
	}

	protected Enemigo generarCurador(int x, int y) {
		AbstractEnemigoFactory f=new CuradorFactory();
		Enemigo toReturn=f.crearEnemigo(x, y);
		return toReturn;
	}

	protected Enemigo generarRango(int x, int y) {
		AbstractEnemigoFactory f=new RangoFactory();
		Enemigo toReturn=f.crearEnemigo(x, y);
		return toReturn;
	}

	protected Enemigo generarTanque(int x, int y) {
		AbstractEnemigoFactory f=new TanqueFactory();
		Enemigo toReturn=f.crearEnemigo(x, y);
		return toReturn;
	}

	protected Enemigo generarRapido(int x, int y) {
		AbstractEnemigoFactory f=new RapidoFactory();
		Enemigo toReturn=f.crearEnemigo(x, y);
		return toReturn;
	}

	protected Enemigo generarNormal(int x, int y) {
		AbstractEnemigoFactory f=new NormalFactory();
		Enemigo toReturn=f.crearEnemigo(x, y);
		return toReturn;
	}

	protected int traducirFila(int y) {
		int toReturn;
		if(y<200)
			toReturn=150;
		else
			if(y<300)
				toReturn=250;
			else
				if(y<400)
					toReturn=350;
				else
					if(y<500)
						toReturn=450;
					else
						if(y<600)
							toReturn=550;
						else
							toReturn=650;
		return toReturn-550;
	}
	
	protected int traducirColumna(int x) {
		int toReturn;
		if(x<120)
			toReturn=65;
			else
				if(x<230)
					toReturn=175;
				else
					if(x<340)
						toReturn=285;
					else
						if(x<450)
							toReturn=395;
						else
							if(x<560)
								toReturn=505;
							else
								if(x<670)
									toReturn=615;
								else
									if(x<780)
										toReturn=725;
									else
										if(x<890)
											toReturn=835;
										else
											if(x<1000)
												toReturn=945;
											else
													toReturn=1055;	
		return toReturn-65;
	}
}
