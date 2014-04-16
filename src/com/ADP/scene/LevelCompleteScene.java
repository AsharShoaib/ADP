package com.ADP.scene;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.util.GLState;

import com.ADP.controller.ResourceController;
import com.ADP.controller.SceneController;
import com.ADP.controller.SceneController.SceneType;
import com.ADP.pyramidmovers.GameActivity;
import com.ADP.scene.LevelCompleteWindow.StarsCount;
import com.ADP.template.TemplateScene;

public class LevelCompleteScene  extends TemplateScene {
	
	//Variables
	
	private Sprite background;
	private LevelCompleteWindow CompleteWindow;
	private Sprite button;
	private TimerHandler timer;
	private TemplateScene scene = this;
	
	//Class
	@Override
	public void createScene() {
		if(ResourceController.getInstance().score == 1){
			createBackground();
		}else if(ResourceController.getInstance().score > 1 ){
			createBackground2();
		}
        ResourceController.getInstance().isGameRunning = false;
		CompleteWindow = new LevelCompleteWindow(vbom){
			@Override
    		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				switch(pSceneTouchEvent.getAction()) {
                case TouchEvent.ACTION_DOWN:
                    break;
                case TouchEvent.ACTION_UP:
                	ResourceController.getInstance().unloadGameCompleteTextures();
		            SceneController.getInstance().createShareScoreScreen();
                	break;
                case TouchEvent.ACTION_MOVE:
                    break;
                }
				return true;
			}
		};
		
		registerTouchArea(CompleteWindow);
		if(!ResourceController.getInstance().gameMode)
			CompletetionStar();
		else
			CompletetionStarOrder();

	}

	@Override
	public void onBackKeyPressed() {
		
	}

	@Override
	public SceneType getSceneType() {
		return SceneType.SCENE_COMPLETE;
	}

	@Override
	public void disposeScene() {
		background.detachSelf();
		background.dispose();
		this.detachSelf();
		this.dispose();
	}
	public void CompletetionStarOrder(){
		timer =  new TimerHandler(2.0f, new ITimerCallback() {
  	       	public void onTimePassed(TimerHandler pTimerHandler) {
  	  		registerTouchArea(button);
  	       	if(ResourceController.getInstance().score == 1){
  				CompleteWindow.display(StarsCount.ONE, scene, camera);
  				if(((GameActivity) activity).getLevelStar(ResourceController.getInstance().level)==0){
  					((GameActivity) activity).setLevelStar(ResourceController.getInstance().level, "1");
  	    		}
  			}else if(ResourceController.getInstance().score == 2 ){
  				CompleteWindow.display(StarsCount.TWO, scene, camera);
  				if(((GameActivity) activity).getLevelStar(ResourceController.getInstance().level)<2){
  					((GameActivity) activity).setLevelStar(ResourceController.getInstance().level, "2");
  					if(ResourceController.getInstance().level< 30){
  						((GameActivity) activity).unLockLevel(ResourceController.getInstance().level+1, "true");
  					}
  	    		}
  			}else if(ResourceController.getInstance().score == 3 ){
  				CompleteWindow.display(StarsCount.THREE, scene, camera);
  				if(((GameActivity) activity).getLevelStar(ResourceController.getInstance().level)!=3){
  					((GameActivity) activity).setLevelStar(ResourceController.getInstance().level, "3");
  					((GameActivity) activity).setLevelBeat(ResourceController.getInstance().level, "true");
  					if(ResourceController.getInstance().level< 30){
  						((GameActivity) activity).unLockLevel(ResourceController.getInstance().level+1, "true");
  						
  					}
  	    		}
  			}
				//((GameActivity) activity).setLevelScore(ResourceController.getInstance().level, "true");
  	       		ResourceController.getInstance().levelComplete.play();
	    		SceneController.getInstance().engine.unregisterUpdateHandler(timer);

  	       	}
  	       });
    		SceneController.getInstance().engine.registerUpdateHandler(timer);
    	
		
	}
	
	public void CompletetionStar(){
		timer =  new TimerHandler(2.0f, new ITimerCallback() {
  	       	public void onTimePassed(TimerHandler pTimerHandler) {
  	  		registerTouchArea(button);
  	       	if(ResourceController.getInstance().score == 1){
  				CompleteWindow.display(StarsCount.ONE, scene, camera);
  				if(((GameActivity) activity).getLevelStar(ResourceController.getInstance().level)==0){
  					((GameActivity) activity).setLevelStar(ResourceController.getInstance().level, "1");
  	    		}
  			}else if(ResourceController.getInstance().score == 2 ){
  				CompleteWindow.display(StarsCount.TWO, scene, camera);
  				if(((GameActivity) activity).getLevelStar(ResourceController.getInstance().level)<2){
  					((GameActivity) activity).setLevelStar(ResourceController.getInstance().level, "2");
  					if(ResourceController.getInstance().level< 6){
  						((GameActivity) activity).unLockLevel(ResourceController.getInstance().level+1, "true");
  					}
  	    		}
  			}else if(ResourceController.getInstance().score == 3 ){
  				CompleteWindow.display(StarsCount.THREE, scene, camera);
  				if(((GameActivity) activity).getLevelStar(ResourceController.getInstance().level)!=3){
  					((GameActivity) activity).setLevelStar(ResourceController.getInstance().level, "3");
  					((GameActivity) activity).setLevelBeat(ResourceController.getInstance().level, "true");
  					if(ResourceController.getInstance().level< 6){
  						((GameActivity) activity).unLockLevel(ResourceController.getInstance().level+1, "true");
  						if(ResourceController.getInstance().level< 5)
  							((GameActivity) activity).unLockLevel(11, "true");
  					}
  	    		}
  			}
				//((GameActivity) activity).setLevelScore(ResourceController.getInstance().level, "true");
  	       		if(!ResourceController.getInstance().levelComplete.isReleased())
  	       			ResourceController.getInstance().levelComplete.play();
	    		SceneController.getInstance().engine.unregisterUpdateHandler(timer);

  	       	}
  	       });
    		SceneController.getInstance().engine.registerUpdateHandler(timer);
    	
		
	}
	
	public void createBackground(){
		
		background = new Sprite(400,240, resourceController.complete_window_region2, vbom){
			@Override
			protected void preDraw(GLState pGLState, Camera pCamera){
				super.preDraw(pGLState, pCamera);
			    pGLState.enableDither();
			    
			}
			
			
		};
		
		
		button = new Sprite(400,240, resourceController.invisibleButton_region, vbom){
			@Override
    		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				switch(pSceneTouchEvent.getAction()) {
                case TouchEvent.ACTION_DOWN:
			            ResourceController.getInstance().unloadGameCompleteTextures();
			            SceneController.getInstance().createShareScoreScreen();
			            //SceneController.getInstance().loadMenuScene(engine, null);
             
                    break;
                case TouchEvent.ACTION_UP:
                	
                	break;
                case TouchEvent.ACTION_MOVE:
                    break;
                }
				return true;
			}
		};
		attachChild(background);
		attachChild(button);

	}
	
	
	public void createBackground2(){
		background = new Sprite(400,240, resourceController.complete_window_region, vbom){
			@Override
			protected void preDraw(GLState pGLState, Camera pCamera){
				super.preDraw(pGLState, pCamera);
			    pGLState.enableDither();
			}
		};
		
		button = new Sprite(400,240, resourceController.invisibleButton_region, vbom){
			@Override
    		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				switch(pSceneTouchEvent.getAction()) {
                case TouchEvent.ACTION_DOWN:
			           // ResourceController.getInstance().unloadGameCompleteTextures();
			            //SceneController.getInstance().loadMenuScene(engine, null);
                		
                    break;
                case TouchEvent.ACTION_UP:
			            ResourceController.getInstance().unloadGameCompleteTextures();
			            SceneController.getInstance().createShareScoreScreen();
			           // SceneController.getInstance().loadMenuScene(engine, null);

                	
                	break;
                case TouchEvent.ACTION_MOVE:
                    break;
                }
				return true;
			}
		};
		attachChild(button);
		attachChild(background);
		
	}





}
