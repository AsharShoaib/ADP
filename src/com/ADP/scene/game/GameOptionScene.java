package com.ADP.scene.game;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.Entity;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;
import com.ADP.controller.ResourceController;
import com.ADP.controller.SceneController;
import com.ADP.controller.TiledSpriteMenuItem;
import com.ADP.controller.SceneController.SceneType;
import com.ADP.pyramidmovers.GameActivity;
import com.ADP.template.TemplateScene;

public class GameOptionScene extends TemplateScene implements IOnMenuItemClickListener {
	
	//Variables
	
	private Sprite background;
	private MenuScene menuChildScene;
	private final int LEVEL_1 = 0;
	private final int LEVEL_2 = 1;
	private final int LEVEL_3 = 2;
	private final int LEVEL_4 = 3;
	private final int LEVEL_5 = 4;
	private final int LEVEL_6 = 5;
	private final int HIGHSCORE = 6;

	private TiledSpriteMenuItem l0;
	private  TiledSpriteMenuItem l1;
	private  TiledSpriteMenuItem l2;
	private  TiledSpriteMenuItem l3;
	private  TiledSpriteMenuItem l4;

	private TiledSpriteMenuItem l5;

	private SpriteMenuItem l6;
	private Sprite LevelLock_2;
	private Sprite LevelLock_3;
	private Sprite LevelLock_4;
	private Sprite LevelLock_5;
	private Sprite LevelLock_6;
	
	private Entity layer1;
	private Entity layer2;
	private ScaleMenuItemDecorator Scale3;
	private ScaleMenuItemDecorator Scale2;
	private ScaleMenuItemDecorator Scale4;
	private ScaleMenuItemDecorator Scale5;
	private ScaleMenuItemDecorator Scale6;
	
	//Class
	@Override
	public void createScene() {
		layer1 = new Entity();
		layer2 = new Entity();
		//layer1.setParent(this);
		//layer2.setParent(this);
		this.attachChild(layer1);
		this.attachChild(layer2);
	    //layer1.attachChild(menuChildScene);

		createBackground();
		createMenuChildScene();
		registerTouchArea(resourceController.soundButton);
	    registerTouchArea(resourceController.musicButton);
		this.sortChildren();

	}

	@Override
	public void onBackKeyPressed() {
        SceneController.getInstance().loadGameSceneModeFromOptions();
		
	}

	@Override
	public SceneType getSceneType() {
		return SceneType.SCENE_GAMEOPTION;
	}

	@Override
	public void disposeScene() {
		background.detachSelf();
		background.dispose();
		this.detachSelf();
		this.dispose();
	}
	
	public void createBackground(){
		background = new Sprite(400,240, resourceController.gameoption_background_region, vbom){
			@Override
			protected void preDraw(GLState pGLState, Camera pCamera){
				super.preDraw(pGLState, pCamera);
			    pGLState.enableDither();
			}
		};

		attachChild(background);
	}
	
	private void createLockButton(){
		if( ((GameActivity) activity).isLevelUnLocked(2).equalsIgnoreCase("false")){
			 menuChildScene.detachChild(Scale2);
			 menuChildScene.detachChild(Scale3);
			 menuChildScene.detachChild(Scale4);
			 menuChildScene.detachChild(Scale5);
			 menuChildScene.detachChild(Scale6);
			 
			 TiledSpriteMenuItem level2, level3, level4, level5, level6;

			 menuChildScene.attachChild(level2 = new TiledSpriteMenuItem(LEVEL_2, resourceController.Level_2, vbom));
			 menuChildScene.attachChild(level3 = new TiledSpriteMenuItem(LEVEL_3, resourceController.Level_3, vbom));
			 menuChildScene.attachChild(level4 = new TiledSpriteMenuItem(LEVEL_4, resourceController.Level_4, vbom));
			 menuChildScene.attachChild(level5 = new TiledSpriteMenuItem(LEVEL_5, resourceController.Level_5, vbom));
			 menuChildScene.attachChild(level6 = new TiledSpriteMenuItem(LEVEL_6, resourceController.Level_6, vbom));
			
			 level2.setPosition(404, 321);
			 level3.setPosition(679, 321);
			 level4.setPosition(125, 190);
			 level5.setPosition(404, 190);
			 level6.setPosition(679, 190);
			 
	    	 LevelLock_2 = new Sprite(404, 321, resourceController.LevelLock, vbom);
	    	 LevelLock_3 = new Sprite(679, 321, resourceController.LevelLock, vbom);
	    	 LevelLock_4 = new Sprite(125, 190, resourceController.LevelLock, vbom);
	    	 LevelLock_5 = new Sprite(404, 190, resourceController.LevelLock, vbom);
	    	 LevelLock_6 = new Sprite(679, 190, resourceController.LevelLock, vbom);
	    	 
	    	 menuChildScene.attachChild(LevelLock_2);
	    	 menuChildScene.attachChild(LevelLock_3);
	    	 menuChildScene.attachChild(LevelLock_4);
	    	 menuChildScene.attachChild(LevelLock_5);
	    	 menuChildScene.attachChild(LevelLock_6);
	    	

	    }else if(((GameActivity) activity).isLevelUnLocked(3).equalsIgnoreCase("false")){
	    	
			 menuChildScene.detachChild(Scale3);
			 menuChildScene.detachChild(Scale4);
			 menuChildScene.detachChild(Scale5);
			 menuChildScene.detachChild(Scale6);
			 
			 TiledSpriteMenuItem level3, level4, level5, level6;

			 menuChildScene.attachChild(level3 = new TiledSpriteMenuItem(LEVEL_3, resourceController.Level_3, vbom));
			 menuChildScene.attachChild(level4 = new TiledSpriteMenuItem(LEVEL_4, resourceController.Level_4, vbom));
			 menuChildScene.attachChild(level5 = new TiledSpriteMenuItem(LEVEL_5, resourceController.Level_5, vbom));
			 menuChildScene.attachChild(level6 = new TiledSpriteMenuItem(LEVEL_6, resourceController.Level_6, vbom));
			
			 level3.setPosition(679, 321);
			 level4.setPosition(125, 190);
			 level5.setPosition(404, 190);
			 level6.setPosition(679, 190);
			 
	    	 LevelLock_3 = new Sprite(679, 321, resourceController.LevelLock, vbom);
	    	 LevelLock_4 = new Sprite(125, 190, resourceController.LevelLock, vbom);
	    	 LevelLock_5 = new Sprite(404, 190, resourceController.LevelLock, vbom);
	    	 LevelLock_6 = new Sprite(679, 190, resourceController.LevelLock, vbom);
	    	 
	    	 menuChildScene.attachChild(LevelLock_3);
	    	 menuChildScene.attachChild(LevelLock_4);
	    	 menuChildScene.attachChild(LevelLock_5);
	    	 menuChildScene.attachChild(LevelLock_6);
	    	
	    }else if(((GameActivity) activity).isLevelUnLocked(4).equalsIgnoreCase("false")){
			 menuChildScene.detachChild(Scale4);
			 menuChildScene.detachChild(Scale5);
			 menuChildScene.detachChild(Scale6);
			 
			 TiledSpriteMenuItem  level4, level5, level6;

			 menuChildScene.attachChild(level4 = new TiledSpriteMenuItem(LEVEL_4, resourceController.Level_4, vbom));
			 menuChildScene.attachChild(level5 = new TiledSpriteMenuItem(LEVEL_5, resourceController.Level_5, vbom));
			 menuChildScene.attachChild(level6 = new TiledSpriteMenuItem(LEVEL_6, resourceController.Level_6, vbom));
			
			 level4.setPosition(125, 190);
			 level5.setPosition(404, 190);
			 level6.setPosition(679, 190);
			 
	    	 LevelLock_4 = new Sprite(125, 190, resourceController.LevelLock, vbom);
	    	 LevelLock_5 = new Sprite(404, 190, resourceController.LevelLock, vbom);
	    	 LevelLock_6 = new Sprite(679, 190, resourceController.LevelLock, vbom);

	    	 menuChildScene.attachChild(LevelLock_4);
	    	 menuChildScene.attachChild(LevelLock_5);
	    	 menuChildScene.attachChild(LevelLock_6);
	    	 
	    }else if(((GameActivity) activity).isLevelUnLocked(5).equalsIgnoreCase("false")){
	    	
			 menuChildScene.detachChild(Scale5);
			 menuChildScene.detachChild(Scale6);
			 
			 TiledSpriteMenuItem  level5, level6;

			 menuChildScene.attachChild(level5 = new TiledSpriteMenuItem(LEVEL_5, resourceController.Level_5, vbom));
			 menuChildScene.attachChild(level6 = new TiledSpriteMenuItem(LEVEL_6, resourceController.Level_6, vbom));
			
			 level5.setPosition(404, 190);
			 level6.setPosition(679, 190);
			 
	    	 LevelLock_5 = new Sprite(404, 190, resourceController.LevelLock, vbom);
	    	 LevelLock_6 = new Sprite(679, 190, resourceController.LevelLock, vbom);
	    	 
	    	 menuChildScene.attachChild(LevelLock_5);
	    	 menuChildScene.attachChild(LevelLock_6);
	    	 
	    }else if(((GameActivity) activity).isLevelUnLocked(6).equalsIgnoreCase("false")){
	    	
			 menuChildScene.detachChild(Scale6);
			 
			 TiledSpriteMenuItem level6;

			 menuChildScene.attachChild(level6 = new TiledSpriteMenuItem(LEVEL_6, resourceController.Level_6, vbom));
			
			 level6.setPosition(679, 190);
	    	 LevelLock_6 = new Sprite(679, 190, resourceController.LevelLock, vbom);
	    	 
	    	 menuChildScene.attachChild(LevelLock_6);

	    }
	}

	private void createMenuChildScene()
	{
	    menuChildScene = new MenuScene(camera);
	    menuChildScene.setPosition(0, 0);
	    
	    final IMenuItem Level_1 = new ScaleMenuItemDecorator(l0=new TiledSpriteMenuItem(LEVEL_1, resourceController.Level_1, vbom), 1.2f, 1);
	    final IMenuItem Level_2 = Scale2 = new ScaleMenuItemDecorator(l1=new TiledSpriteMenuItem(LEVEL_2, resourceController.Level_2, vbom), 1.2f, 1);
	    final IMenuItem Level_3 = Scale3 = new ScaleMenuItemDecorator(l2=new TiledSpriteMenuItem(LEVEL_3, resourceController.Level_3, vbom), 1.2f, 1);
	    final IMenuItem Level_4 = Scale4 = new ScaleMenuItemDecorator(l3=new TiledSpriteMenuItem(LEVEL_4, resourceController.Level_4, vbom), 1.2f, 1);
	    final IMenuItem Level_5 = Scale5 = new ScaleMenuItemDecorator(l4=new TiledSpriteMenuItem(LEVEL_5, resourceController.Level_5, vbom), 1.2f, 1);
	    final IMenuItem Level_6 = Scale6 = new ScaleMenuItemDecorator(l5=new TiledSpriteMenuItem(LEVEL_6, resourceController.Level_6, vbom), 1.2f, 1);
	    final IMenuItem HighScore = new ScaleMenuItemDecorator(l6=new SpriteMenuItem(HIGHSCORE, resourceController.HighScoreButton, vbom), 1.2f, 1);

	    l0.setSelected(((GameActivity) activity).getLevelStar(1));
	    l1.setSelected(((GameActivity) activity).getLevelStar(2));
	    l2.setSelected(((GameActivity) activity).getLevelStar(3));
	    l3.setSelected(((GameActivity) activity).getLevelStar(4));
	    l4.setSelected(((GameActivity) activity).getLevelStar(5));
	    l5.setSelected(((GameActivity) activity).getLevelStar(6));
	    
	    menuChildScene.addMenuItem(Level_1);
	    menuChildScene.addMenuItem(Level_2);
	    menuChildScene.addMenuItem(Level_3);
	    menuChildScene.addMenuItem(Level_4);
	    menuChildScene.addMenuItem(Level_5);
	    menuChildScene.addMenuItem(Level_6);
	    menuChildScene.addMenuItem(HighScore);
	    
	    menuChildScene.buildAnimations();
	    menuChildScene.setBackgroundEnabled(false);
	    
	    Level_1.setPosition(125, 322);
	    Level_2.setPosition(404, 321);
	    Level_3.setPosition(679, 321);
	    Level_4.setPosition(125, 190);
	    Level_5.setPosition(404, 190);
	    Level_6.setPosition(679, 190);
	    HighScore.setPosition(404, 90);
	     
	    createLockButton();
	    
	    menuChildScene.setOnMenuItemClickListener(this);
	   
	    
	    setChildScene(menuChildScene);
	    //this.getChildByIndex(1).attachChild(menuChildScene);
	}
	
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem, float pMenuItemLocalX, float pMenuItemLocalY)
	{
	    switch(pMenuItem.getID())
	    {
	        case LEVEL_1:
	        	resourceController.level = 1;
	        	if(ResourceController.getInstance().soundFlag)
	            	ResourceController.getInstance().buttonclick.play();
	            SceneController.getInstance().createGameTypeScreen();
	            
	            return true;
	        case LEVEL_2:
	        	if(((GameActivity) activity).isLevelUnLocked(2).equalsIgnoreCase("true")){
		        	resourceController.level = 2;
		        	if(ResourceController.getInstance().soundFlag)
		            	ResourceController.getInstance().buttonclick.play();
		            SceneController.getInstance().createGameTypeScreen();
	        	}
	            return true;
	        case LEVEL_3:
	        	if(((GameActivity) activity).isLevelUnLocked(3).equalsIgnoreCase("true")){
		        	resourceController.level = 3;
		            SceneController.getInstance().createGameTypeScreen();
	        	}
	            return true;
	        case LEVEL_4:
	        	
	        	if(((GameActivity) activity).isLevelUnLocked(4).equalsIgnoreCase("true")){
	        		resourceController.level = 4;
		        	if(ResourceController.getInstance().soundFlag)
		            	ResourceController.getInstance().buttonclick.play();
		            SceneController.getInstance().createGameTypeScreen();
	            }
	            return true;
	        case LEVEL_5:
	        	if(((GameActivity) activity).isLevelUnLocked(5).equalsIgnoreCase("true")){
		        	resourceController.level = 5;
		        	if(ResourceController.getInstance().soundFlag)
		            	ResourceController.getInstance().buttonclick.play();
		            SceneController.getInstance().createGameTypeScreen();
	        	}
	            return true;
	        case LEVEL_6:
	        	if(((GameActivity) activity).isLevelUnLocked(6).equalsIgnoreCase("true")){
		        	resourceController.level = 6;
		        	if(ResourceController.getInstance().soundFlag)
		            	ResourceController.getInstance().buttonclick.play();
		            SceneController.getInstance().createGameTypeScreen();
	        	}
	            return true;
	        case HIGHSCORE:
	        	 if(!ResourceController.getInstance().soundFlag)
		            	ResourceController.getInstance().buttonclick.play();
	        	 ResourceController.getInstance().gameMode=false;
	            SceneController.getInstance().createHighScoreScreen();
	            return true;
	        default:
	            return false;
	    }
	}
	
	public void buttonUpdate(){
		l0.setSelected(((GameActivity) activity).getLevelStar(1));
	    l1.setSelected(((GameActivity) activity).getLevelStar(2));
	    l2.setSelected(((GameActivity) activity).getLevelStar(3));
	    l3.setSelected(((GameActivity) activity).getLevelStar(4));
	    l4.setSelected(((GameActivity) activity).getLevelStar(5));
	}


}
