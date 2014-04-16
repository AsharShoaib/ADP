package com.ADP.scene;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.ADP.controller.ResourceController;

public class GameCreditsWindow extends Sprite{
	
   

    
    public GameCreditsWindow(final VertexBufferObjectManager pSpriteVertexBufferObject)
    {
        super(400, 240, 650, 400, ResourceController.getInstance().creditsWindow, pSpriteVertexBufferObject);

    }
    
    
    
    public void display( Scene scene)
    {

        scene.attachChild(this);
    }
    
    public void removedisplay( Scene scene)
    {

        scene.detachChild(this);

    }

}
