package luis.isaula.examen.lab;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Enemy extends Image {
	
	public Enemy(Texture tex){
		super(tex);
		addListener(new EnemyImput(this));
	}
	
	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
		this.setY(this.getY() - 2);
		
		if(this.getY()<=0){
			this.remove();
			ClasePrincipal.afuera++;
			//ClasePrincipal.remover++;
		}
	}
	
	
}
