package com.ADP.scene;

import java.util.Random;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.util.GLState;

import com.ADP.controller.ResourceController;
import com.ADP.controller.SceneController;
import com.ADP.controller.SceneController.SceneType;
import com.ADP.pyramidmovers.GameActivity;
import com.ADP.template.TemplateScene;

public class GameLostScene extends TemplateScene  {

	private Sprite background;
	private Sprite tryagainButton;
	private Sprite quitButton;

	@Override
	public void createScene() {
        ResourceController.getInstance().isGameRunning = false;
		createBackground();
		createButtons();

		    
	}

	private void createButtons() {
		
		tryagainButton = new Sprite(167,200, ResourceController.getInstance().tryagainButton_region, vbom){
			
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				switch(pSceneTouchEvent.getAction()) {
				case TouchEvent.ACTION_DOWN:
	                break;
	            case TouchEvent.ACTION_UP:
	            	tryagainButton.setScale(1.5f);
	            	SceneController.getInstance().loadGameSceneClock(engine);
	            	ResourceController.getInstance().unloadGameLostTextures();
	            	
	        	    break;
	            case TouchEvent.ACTION_MOVE:
	                break;
	            }
				return true;
			}
			
		};
		
		quitButton = new Sprite(633,200, ResourceController.getInstance().quitButton_region, vbom){
			
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				switch(pSceneTouchEvent.getAction()) {
				case TouchEvent.ACTION_DOWN:
	                break;
	            case TouchEvent.ACTION_UP:
	            	quitButton.setScale(1.5f);
		            SceneController.getInstance().loadMenuScene(engine, null);
	            	ResourceController.getInstance().unloadGameLostTextures();
	        	    break;
	            case TouchEvent.ACTION_MOVE:
	                break;
	            }
				return true;
			}
			
		};
		attachChild(tryagainButton);
  		registerTouchArea(tryagainButton);
  		attachChild(quitButton);
  		registerTouchArea(quitButton);

	}

	private void createBackground() {
		background = new Sprite(400,240, ResourceController.getInstance().lostBackground_region, vbom){
			@Override
			protected void preDraw(GLState pGLState, Camera pCamera){
				super.preDraw(pGLState, pCamera);
			    pGLState.enableDither();
			    
			}
			
			
		};
		
		attachChild(background);		
	}

	@Override
	public void onBackKeyPressed() {
        SceneController.getInstance().loadMenuScene(engine, null);
		
	}

	@Override
	public SceneType getSceneType() {
		return SceneType.SCENE_LOST;
	}

	@Override
	public void disposeScene() {
		// TODO Auto-generated method stub
		
	}

}
