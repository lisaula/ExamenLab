package luis.isaula.examen.lab;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class CoinsInput extends InputListener {
	Coins c;
	
	public CoinsInput(Coins co){
		super();
		c=co;
	}
	
	@Override
	public boolean touchDown(InputEvent event, float x, float y, int pointer,
			int button) {
		// TODO Auto-generated method stub
		c.remove();
		ClasePrincipal.contC++;
		return super.touchDown(event, x, y, pointer, button);
	}
	
}
