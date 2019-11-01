package juego;

import java.util.Random;

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

public abstract class Nivel {
	
	public void instanciarBotones(AbstractAliadoFactory []botones) {
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
	public Enemigo generarEnemigoAleatorio(int x,int y) {
		Enemigo toReturn=null;
		Random r=new Random();
		int n=r.nextInt(100);
		if(n<30) {
			toReturn=generarNormal(x,y);
			//toReturn=generarInvocador(x,y);
		}
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
}
