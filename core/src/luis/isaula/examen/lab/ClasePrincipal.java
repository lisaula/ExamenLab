package luis.isaula.examen.lab;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class ClasePrincipal extends ApplicationAdapter {
	Texture img;
	Stage stage, menu, go;
	int pos, e=0,coins=0, health=5;
	static int contE = 0, contC = 0, contE3=0, contC2=0, afuera=0, coinsAfuera=0, pausa=0;
	boolean entro=false, cambiar, again=false, empezar=false, perdio=false;
	boolean lose=false;
	
	
	@Override
	public void create () {
		img = new Texture("nubes.jpg");
		Image fondo = new Image(img);
		Image m = new Image(new Texture("Menu.png"));
		Image over = new Image(new Texture("GameOver.png"));
		Image p = new Image(new Texture("Pausado.png"));
		
		p.setHeight(490);
		p.setWidth(640);
		
		m.setHeight(500);
		m.setWidth(650);
		
		fondo.setHeight(500);
		fondo.setWidth(650);
		
		over.setHeight(500);
		over.setWidth(650);
		
		stage = new Stage();
		menu=new Stage();
		go=new Stage();
		
		
		stage.addActor(fondo);
		
		menu.addActor(m);
		go.addActor(over);
		Gdx.input.setInputProcessor(stage);
		
		
		
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//Primer menu.
		menu.draw();
		menu.act();
		if(Gdx.input.justTouched()){
			entro = true;
		}
		
		//Validar Pasar del Menu
		if(entro){
			stage.draw();
			stage.act();
			empezar=true;
			
			if(perdio || health<=0){
				go.draw();
				go.act();
				empezar=false;
				if(Gdx.input.justTouched()){
					again = true;
					perdio=false;
					health=5;
					contE3-=1;
				}
			}
			
		}
		
		
		
		//Validar entrar al juego
		if(empezar){
			if(pos%25==0){
				AddEnemy3();
			}
			
			if(cambiar){
				if(pos%40==0){
						AddEnemy1();
						
						cambiar=!cambiar;
					}
			}else{
					if(pos%40==0){
						AddCoins();
						addCoinsPlus();
						cambiar=!cambiar;
					}
			}
		
		//Rules
			if(contE3>0){
				perdio = true;
				
			}
			if (coinsAfuera>0){
				health-=1;
				coinsAfuera -=1;
			}
			
			if(contE>0){
				health -=1;
				contE -=1;
			}
			
			if(contC>0){
				health+=1;
				contC-=1;
				System.out.println("VIDA AUMENTO: "+2);
				
			}
			if(contC2>0){
				health +=3;
				contC2-=1;
			}
		
		}
		
		
		//Validar Game Over
		
		
		//Repetir juego despues de GameOver
		if(again){
			stage.draw();
			stage.act();
			again=false;
			
		}
		
		
			
		
		if(pos%50==0){
		System.out.println("\nVIDA: "+health);
		System.out.println("ENEMIGOS CREADOS: "+e+" ENEMIGOS ELIMINADOS: "+contE);
		System.out.println("Coins CREADOS: "+coins+" Coins ELIMINADOS: "+contC);
		}
		
		/*
		 * Variable pos para llevar tiempo.
		 */
		pos++;
	
		}
	
		
	
	
	public void AddEnemy1(){
		int rnd= (int)(Math.random() * 2);
		Enemy enemigo[]= new Enemy[2];
		enemigo[0]= new Enemy(new Texture("Bomba_TWW.png"));
		enemigo[1]= new Enemy(new Texture("Bomba.png"));
		
		enemigo[1].setHeight(95);
		enemigo[1].setWidth(80);
		
		enemigo[0].setHeight(95);
		enemigo[0].setWidth(80);
		
		stage.addActor(enemigo[rnd]);
		
		enemigo[rnd].setY(400);
		int random=(int)(Math.random() * 550);
		enemigo[rnd].setX(random);
		e++;
	
	}
	
	public void addCoinsPlus(){
		Enemy2 enemigo= new Enemy2(new Texture("coin-money-5.png"));
		
		enemigo.setHeight(70);
		enemigo.setWidth(80);
		
		stage.addActor(enemigo);
		
		enemigo.setY(400);
		int random=(int)(Math.random() * 550);
		enemigo.setX(random);
		coins++;
		
		
	}
	
	public void AddEnemy3(){
		Enemy3 enemigo= new Enemy3(new Texture("handgrenade.png"));
		
		enemigo.setHeight(90);
		enemigo.setWidth(80);
		
		stage.addActor(enemigo);
		
		enemigo.setY(400);
		int random=(int)(Math.random() * 550);
		enemigo.setX(random);
		e++;
	}
	
	public void AddCoins(){
		
			
		Coins c = new Coins(new Texture("coin.png"));
		
		
		c.setHeight(80);
		c.setWidth(80);
		
		
		
		stage.addActor(c);
		c.setY(400);
		int random=(int)(Math.random() * 550);
		c.setX(random);
		coins++;
		
	}
	
	
}
