package luis.isaula.examen.lab;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Enemy3 extends Image {
	
	public Enemy3(Texture tex){
		super(tex);
		addListener(new Enemy3Input(this));
	}
	
	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
		this.setY(this.getY() - 5);
		
		if(this.getY()<=0){
			this.remove();
			//ClasePrincipal.remover++;
			ClasePrincipal.afuera++;
		}
	}
	
	
}
