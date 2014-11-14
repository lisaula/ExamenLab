package luis.isaula.examen.lab;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Enemy2 extends Image{
	int x, min=0, max=650;
	
	public Enemy2(Texture tex){
		super(tex);
		addListener(new Enemy2Input(this));
		x=0;
	}
	
	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
		this.setY(this.getY() - 2);
		
			while(x<=max){
				
				x++;
			}
			
		
			/*while(x>=min){
				
				x--;
			}*/
		
		
		
		
		
		if(this.getY()<=0){
			//ClasePrincipal.remover++;
			this.remove();
			ClasePrincipal.coinsAfuera++;
			
		}
	}
	
}
