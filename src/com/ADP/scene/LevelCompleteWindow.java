package com.ADP.scene;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.sprite.TiledSprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.ADP.controller.ResourceController;
import com.ADP.controller.SceneController;

public class LevelCompleteWindow extends Sprite
{
    private TiledSprite star1;
    private TiledSprite star2;
    private TiledSprite star3;
	private Sprite button;
    private boolean flag;
    public int level;

    
    public enum StarsCount
    {
        ONE,
        TWO,
        THREE
    }
    
    public LevelCompleteWindow(final VertexBufferObjectManager pSpriteVertexBufferObject)
    {
        super(400, 240, 650, 400, ResourceController.getInstance().complete_window_region3, pSpriteVertexBufferObject);
        flag = false;
        attachStars(pSpriteVertexBufferObject);

    }
    
    
    
    private void attachStars(VertexBufferObjectManager pSpriteVertexBufferObject)
    {
        star1 = new TiledSprite(150, 150, ResourceController.getInstance().complete_stars_region, pSpriteVertexBufferObject);
        star2 = new TiledSprite(325, 150, ResourceController.getInstance().complete_stars_region, pSpriteVertexBufferObject);
        star3 = new TiledSprite(500, 150, ResourceController.getInstance().complete_stars_region, pSpriteVertexBufferObject);
        attachChild(star1);
        attachChild(star2);
        attachChild(star3);
    }
    
    /**
     * Change star`s tile index, depends on stars count.
     * @param starsCount
     */
    public void display(final StarsCount starsCount, Scene scene, Camera camera)
    {
    	// Change stars tile index, based on stars count (1-3)
    	switch (starsCount)
    	{
    	case ONE:
    		star1.setCurrentTileIndex(0);
    		star2.setCurrentTileIndex(1);
    		star3.setCurrentTileIndex(1);
    		break;
    		
    	case TWO:
    		star1.setCurrentTileIndex(0);
    		star2.setCurrentTileIndex(0);
    		star3.setCurrentTileIndex(1);
    		break;
    	case THREE:
    		star1.setCurrentTileIndex(0);
    		star2.setCurrentTileIndex(0);
    		star3.setCurrentTileIndex(0);
    		break;

    	}
        
        
        // Hide HUD
       // camera.getHUD().setVisible(false);
        
        // Attach our level complete panel in the middle of camera
        //setPosition(camera.getCenterX(), camera.getCenterY());
        scene.attachChild(this);
    }
    
 
}