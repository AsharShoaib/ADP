package com.ADP.scene.game;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;

import com.ADP.controller.ResourceController;
import com.ADP.controller.SceneController;
import com.ADP.controller.SceneController.SceneType;
import com.ADP.pyramidmovers.FacebookManager;
import com.ADP.pyramidmovers.GameActivity;
import com.ADP.template.TemplateScene;

public class GameSceneMode extends TemplateScene implements IOnMenuItemClickListener {
	
	//Variables
	
	private Sprite background;
	private MenuScene menuChildScene;
	private final int CLOCK = 0;
	private final int STEPS = 1;
	private Sprite LevelLock;
	private ScaleMenuItemDecorator scaleClock;

	
	//Class
	@Override
	public void createScene() {
		createBackground();
		createMenuChildScene();
		registerTouchArea(resourceController.soundButton);
	    registerTouchArea(resourceController.musicButton);
	    /*
	    if(((GameActivity) activity).isLevelUnLocked(100).equalsIgnoreCase("false")){
	    	FacebookManager.checkLikeStatus();
	    	if(((GameActivity) activity).isLevelBeat(100).equalsIgnoreCase("false")){
		    	activity.runOnUiThread(new Runnable() {
		            @Override
		            public void run() {
	
	
		                AlertDialog.Builder alert = new AlertDialog.Builder(activity);
		                alert.setTitle("Unlock Pharaoh's Order");
		                alert.setMessage("Would you like to Unlock Pharaoh's Order by liking our Facebook Page?\n" + "Pharaoh's Order has 10 new levels with a completely new game!");
		                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
		                        @Override
		                        public void onClick(DialogInterface dialog, int id) {
		                        	FacebookManager.linkToPage();
									dialog.cancel();
									
	
		                        }
		                });
		                
		                alert.setNegativeButton("No, Never show this again!",new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,int id) {
								((GameActivity) activity).setLevelBeat(100,"true");
								dialog.cancel();
							}
						});
	
		                alert.show();
		            }
		           });
	    	}
	    }*/
	}

	@Override
	public void onBackKeyPressed() {
        SceneController.getInstance().loadMenuSceneFromOptions();
		
	}

	@Override
	public SceneType getSceneType() {
		return SceneType.SCENE_GAMETYPE;
	}

	@Override
	public void disposeScene() {
		camera.setHUD(null);
        camera.setCenter(400, 240);
		background.detachSelf();
		background.dispose();
		this.detachSelf();
		this.dispose();
	}
	
	public void createBackground(){
		background = new Sprite(400,240, resourceController.gametype_background_region, vbom){
			@Override
			protected void preDraw(GLState pGLState, Camera pCamera){
				super.preDraw(pGLState, pCamera);
			    pGLState.enableDither();
			}
		};

		attachChild(background);
	}
	
	

	private void createMenuChildScene()
	{
	    menuChildScene = new MenuScene(camera);
	    menuChildScene.setPosition(0, 0);
	    
	    final IMenuItem clock = scaleClock = new ScaleMenuItemDecorator(new SpriteMenuItem(CLOCK, resourceController.Timer, vbom), 1.2f, 1);
	    final IMenuItem steps = new ScaleMenuItemDecorator(new SpriteMenuItem(STEPS, resourceController.Steps, vbom), 1.2f, 1);

	    
	    menuChildScene.addMenuItem(clock);
	    menuChildScene.addMenuItem(steps);

	    menuChildScene.buildAnimations();
	    menuChildScene.setBackgroundEnabled(false);
	    
	    steps.setPosition(400, 300);
	    clock.setPosition(400, 125);
	    /*
	    if( ((GameActivity) activity).isLevelUnLocked(100).equalsIgnoreCase("false")){
	    	 menuChildScene.detachChild(scaleClock);
	    	 SpriteMenuItem lock;
	    	 menuChildScene.attachChild(lock = new SpriteMenuItem(CLOCK, resourceController.Timer, vbom));
	    	 lock.setPosition(400, 125);
	    	 LevelLock = new Sprite(400, 125, resourceController.typeLockButton, vbom);
	    	 menuChildScene.attachChild(LevelLock);

	    }*/
	    
	    menuChildScene.setOnMenuItemClickListener(this);
	    
	    setChildScene(menuChildScene);
	}
	
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem, float pMenuItemLocalX, float pMenuItemLocalY)
	{
	    switch(pMenuItem.getID())
	    {
	        case CLOCK:
	            //Load Game Scene!
	        	//if( ((GameActivity) activity).isLevelUnLocked(100).equalsIgnoreCase("true")){
	        		if(ResourceController.getInstance().soundFlag)
	        			ResourceController.getInstance().buttonclick.play();
	                ResourceController.getInstance().gameMode = true;
		            SceneController.getInstance().createGameOrderOptionScreen();
	        	//}
	            return true;
	        case STEPS:
	        	if(ResourceController.getInstance().soundFlag)
	        		ResourceController.getInstance().buttonclick.play();
                ResourceController.getInstance().gameMode = false;
	        	SceneController.getInstance().createGameOptionScreen();
	            return true;
	      
	        default:
	            return false;
	    }
	}

}
