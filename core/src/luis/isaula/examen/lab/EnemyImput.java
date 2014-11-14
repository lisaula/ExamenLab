package luis.isaula.examen.lab;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class EnemyImput extends InputListener {
	Enemy enemigo;
	
	public EnemyImput(Enemy e){
		super();
		enemigo = e;
	}
	
	@Override
	public boolean touchDown(InputEvent event, float x, float y, int pointer,
			int button) {
		// TODO Auto-generated method stub
		// remover enemigo
		
		enemigo.remove();
		ClasePrincipal.contE++;
		return super.touchDown(event, x, y, pointer, button);
	}
	
	
	
}
