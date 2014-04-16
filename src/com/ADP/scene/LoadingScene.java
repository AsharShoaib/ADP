package com.ADP.scene;


import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;

import com.ADP.template.TemplateScene;
import com.ADP.controller.SceneController.SceneType;

public class LoadingScene extends TemplateScene
{
    @Override
    public void createScene()
    {
    	createBackground();
    }

    @Override
    public void onBackKeyPressed()
    {
        return;
    }

    @Override
    public SceneType getSceneType()
    {
        return SceneType.SCENE_LOADING;
    }

    @Override
    public void disposeScene()
    {

    }
    
    private void createBackground()
	{
	    attachChild(new Sprite(400, 240, resourceController.loading_background_region, vbom)
	    {
	        @Override
	        protected void preDraw(GLState pGLState, Camera pCamera) 
	        {
	            super.preDraw(pGLState, pCamera);
	            pGLState.enableDither();
	        }
	    });
	}
}