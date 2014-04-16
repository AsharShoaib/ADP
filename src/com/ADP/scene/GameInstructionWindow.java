package com.ADP.scene;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.ADP.controller.ResourceController;

public class GameInstructionWindow extends Sprite {

    

    
    public GameInstructionWindow(final VertexBufferObjectManager pSpriteVertexBufferObject)
    {
        super(400, 240, 650, 400, ResourceController.getInstance().gameInstructions, pSpriteVertexBufferObject);
        
    }
    
    public GameInstructionWindow(final VertexBufferObjectManager pSpriteVertexBufferObject, boolean t)
    {
        super(400, 240, 650, 400, ResourceController.getInstance().gameOrderInstructions, pSpriteVertexBufferObject);
        
    }
    
    
    

    
    /**
     * Change star`s tile index, depends on stars count.
     * @param starsCount
     */
    public void display( Scene scene)
    {

        scene.attachChild(this);
    }
    
    public void removedisplay( Scene scene)
    {

        scene.detachChild(this);
    }
}
