package com.ADP.scene;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;
import org.andengine.util.adt.color.Color;
import org.andengine.entity.scene.background.Background;
import com.ADP.controller.SceneController.SceneType;
import com.ADP.template.TemplateScene;

/**
 * 
 * @author Ashar Shoaib
 * @version 1.0
 *
 */

public class SplashScene extends TemplateScene {
	
	//Variables
	
	private Sprite splash;
	
	//Class
	@Override
	public void createScene() {
		
		splash = new Sprite(0,0, resourceController.splash_region, vbom){
			@Override
			protected void preDraw(GLState pGLState, Camera pCamera){
				super.preDraw(pGLState, pCamera);
			    pGLState.enableDither();
			}
		};
		splash.setScale(1.5f);
		splash.setPosition(400, 240);
		attachChild(splash);
		
		setBackground(new Background(Color.WHITE));
	}

	@Override
	public void onBackKeyPressed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SceneType getSceneType() {
		return SceneType.SCENE_SPLASH;
	}

	@Override
	public void disposeScene() {
		splash.detachSelf();
		splash.dispose();
		this.detachSelf();
		this.dispose();
	}

}
