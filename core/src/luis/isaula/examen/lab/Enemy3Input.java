package luis.isaula.examen.lab;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class Enemy3Input extends InputListener{
	Enemy3 enemigo;
	
	public Enemy3Input(Enemy3 e){
		super();
		enemigo = e;
	}
	
	@Override
	public boolean touchDown(InputEvent event, float x, float y, int pointer,
			int button) {
		// TODO Auto-generated method stub
		// remover enemigo
		
		enemigo.remove();
		ClasePrincipal.contE3++;
		ClasePrincipal.contE++;
		return super.touchDown(event, x, y, pointer, button);
	}
}
