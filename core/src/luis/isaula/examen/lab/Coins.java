package luis.isaula.examen.lab;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Coins extends Image {

	public Coins(Texture t){
		super(t);
		addListener(new CoinsInput(this));
	}
	
	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
		this.setY(this.getY() - 1);
		
		if(this.getY()<=0){
			this.remove();
			ClasePrincipal.coinsAfuera++;
			//ClasePrincipal.remover++;
		}
	}
}
