package luis.isaula.examen.lab;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class Enemy2Input extends InputListener {
	Enemy2 enemigo;
	int tocar;
	public Enemy2Input(Enemy2 e){
		super();
		enemigo = e;
		tocar=0;
	}
	
	@Override
	public boolean touchDown(InputEvent event, float x, float y, int pointer,
			int button) {
		// TODO Auto-generated method stub
		// remover enemigo
		tocar++;
		if(tocar>=3){
			enemigo.remove();
			tocar=0;
			ClasePrincipal.contC2++;
		}
		
		return super.touchDown(event, x, y, pointer, button);
	}
}
