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

public class GameOrderOptionScene extends TemplateScene implements IOnMenuItemClickListener {
	
	//Variables
	
	private Sprite background;
	private MenuScene menuChildScene;
	private final int LEVEL_1 = 0;
	private final int LEVEL_2 = 1;
	private final int LEVEL_3 = 2;
	private final int LEVEL_4 = 3;
	private final int LEVEL_5 = 4;
	private final int LEVEL_6 = 5;
	private final int LEVEL_7 = 6;
	private final int LEVEL_8 = 7;
	private final int LEVEL_9 = 8;
	private final int LEVEL_10 = 9;
	private final int HIGHSCORE = 10;


	private TiledSpriteMenuItem l0;
	private  TiledSpriteMenuItem l1;
	private  TiledSpriteMenuItem l2;
	private  TiledSpriteMenuItem l3;
	private  TiledSpriteMenuItem l4;
	private TiledSpriteMenuItem l5;
	private TiledSpriteMenuItem l6;
	private  TiledSpriteMenuItem l7;
	private  TiledSpriteMenuItem l8;
	private  TiledSpriteMenuItem l9;
	
	
	private Sprite LevelLock_2;
	private Sprite LevelLock_3;
	private Sprite LevelLock_4;
	private Sprite LevelLock_5;
	private Sprite LevelLock_6;
	private Sprite LevelLock_7;
	private Sprite LevelLock_8;
	private Sprite LevelLock_9;
	private Sprite LevelLock_10;
	
	private Entity layer1;
	private Entity layer2;
	private ScaleMenuItemDecorator Scale3;
	private ScaleMenuItemDecorator Scale2;
	private ScaleMenuItemDecorator Scale4;
	private ScaleMenuItemDecorator Scale5;
	private ScaleMenuItemDecorator Scale6;
	private ScaleMenuItemDecorator Scale7;
	private ScaleMenuItemDecorator Scale8;
	private ScaleMenuItemDecorator Scale9;
	private ScaleMenuItemDecorator Scale10;
	
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
		if( ((GameActivity) activity).isLevelUnLocked(22).equalsIgnoreCase("false")){
			 menuChildScene.detachChild(Scale2);
			 menuChildScene.detachChild(Scale3);
			 menuChildScene.detachChild(Scale4);
			 menuChildScene.detachChild(Scale5);
			 menuChildScene.detachChild(Scale6);
			 menuChildScene.detachChild(Scale7);
			 menuChildScene.detachChild(Scale8);
			 menuChildScene.detachChild(Scale9);
			 menuChildScene.detachChild(Scale10);
			 
			 TiledSpriteMenuItem level2, level3, level4, level5, level6, level7, level8, level9, level10;

			 menuChildScene.attachChild(level2 = new TiledSpriteMenuItem(LEVEL_2, resourceController.Level_2, vbom));
			 menuChildScene.attachChild(level3 = new TiledSpriteMenuItem(LEVEL_3, resourceController.Level_3, vbom));
			 menuChildScene.attachChild(level4 = new TiledSpriteMenuItem(LEVEL_4, resourceController.Level_4, vbom));
			 menuChildScene.attachChild(level5 = new TiledSpriteMenuItem(LEVEL_5, resourceController.Level_5, vbom));
			 menuChildScene.attachChild(level6 = new TiledSpriteMenuItem(LEVEL_6, resourceController.Level_6, vbom));
			 menuChildScene.attachChild(level7 = new TiledSpriteMenuItem(LEVEL_7, resourceController.Level_7, vbom));
			 menuChildScene.attachChild(level8 = new TiledSpriteMenuItem(LEVEL_8, resourceController.Level_8, vbom));
			 menuChildScene.attachChild(level9 = new TiledSpriteMenuItem(LEVEL_9, resourceController.Level_9, vbom));
			 menuChildScene.attachChild(level10 = new TiledSpriteMenuItem(LEVEL_10, resourceController.Level_10, vbom));
			
			 level2.setPosition(266, 300);
			 level3.setPosition(401, 300);
			    level4.setPosition(536, 300);
			    level5.setPosition(671, 300);
			    level6.setPosition(131, 170);
			    level7.setPosition(266, 170);
			    level8.setPosition(401, 170);
			    level9.setPosition(536, 170);
			    level10.setPosition(671, 170);	 
			    
		    	 LevelLock_2 = new Sprite(266, 300, resourceController.LevelLock, vbom);
		    	 LevelLock_3 = new Sprite(401, 300, resourceController.LevelLock, vbom);
		    	 LevelLock_4 = new Sprite(536, 300, resourceController.LevelLock, vbom);
		    	 LevelLock_5 = new Sprite(671, 300, resourceController.LevelLock, vbom);
		    	 LevelLock_6 = new Sprite(131, 170, resourceController.LevelLock, vbom);
		    	 LevelLock_7 = new Sprite(266, 170, resourceController.LevelLock, vbom);
		    	 LevelLock_8 = new Sprite(401, 170, resourceController.LevelLock, vbom);
		    	 LevelLock_9 = new Sprite(536, 170, resourceController.LevelLock, vbom);
		    	 LevelLock_10 = new Sprite(671, 170, resourceController.LevelLock, vbom);
		    	 
	    	 
	    	 menuChildScene.attachChild(LevelLock_2);
	    	 menuChildScene.attachChild(LevelLock_3);
	    	 menuChildScene.attachChild(LevelLock_4);
	    	 menuChildScene.attachChild(LevelLock_5);
	    	 menuChildScene.attachChild(LevelLock_6);
	    	 menuChildScene.attachChild(LevelLock_7);
	    	 menuChildScene.attachChild(LevelLock_8);
	    	 menuChildScene.attachChild(LevelLock_9);
	    	 menuChildScene.attachChild(LevelLock_10);
	    	

	    }else if(((GameActivity) activity).isLevelUnLocked(23).equalsIgnoreCase("false")){
	    	
			 menuChildScene.detachChild(Scale3);
			 menuChildScene.detachChild(Scale4);
			 menuChildScene.detachChild(Scale5);
			 menuChildScene.detachChild(Scale6);
			 menuChildScene.detachChild(Scale7);
			 menuChildScene.detachChild(Scale8);
			 menuChildScene.detachChild(Scale9);
			 menuChildScene.detachChild(Scale10);
			 
			 TiledSpriteMenuItem level3, level4, level5, level6, level7, level8, level9, level10;

			 menuChildScene.attachChild(level3 = new TiledSpriteMenuItem(LEVEL_3, resourceController.Level_3, vbom));
			 menuChildScene.attachChild(level4 = new TiledSpriteMenuItem(LEVEL_4, resourceController.Level_4, vbom));
			 menuChildScene.attachChild(level5 = new TiledSpriteMenuItem(LEVEL_5, resourceController.Level_5, vbom));
			 menuChildScene.attachChild(level6 = new TiledSpriteMenuItem(LEVEL_6, resourceController.Level_6, vbom));
			 menuChildScene.attachChild(level7 = new TiledSpriteMenuItem(LEVEL_7, resourceController.Level_7, vbom));
			 menuChildScene.attachChild(level8 = new TiledSpriteMenuItem(LEVEL_8, resourceController.Level_8, vbom));
			 menuChildScene.attachChild(level9 = new TiledSpriteMenuItem(LEVEL_9, resourceController.Level_9, vbom));
			 menuChildScene.attachChild(level10 = new TiledSpriteMenuItem(LEVEL_10, resourceController.Level_10, vbom));
			 
			    level3.setPosition(401, 300);
			    level4.setPosition(536, 300);
			    level5.setPosition(671, 300);
			    level6.setPosition(131, 170);
			    level7.setPosition(266, 170);
			    level8.setPosition(401, 170);
			    level9.setPosition(536, 170);
			    level10.setPosition(671, 170);	  
				 
		    	 LevelLock_3 = new Sprite(401, 300, resourceController.LevelLock, vbom);
		    	 LevelLock_4 = new Sprite(536, 300, resourceController.LevelLock, vbom);
		    	 LevelLock_5 = new Sprite(671, 300, resourceController.LevelLock, vbom);
		    	 LevelLock_6 = new Sprite(131, 170, resourceController.LevelLock, vbom);
		    	 LevelLock_7 = new Sprite(266, 170, resourceController.LevelLock, vbom);
		    	 LevelLock_8 = new Sprite(401, 170, resourceController.LevelLock, vbom);
		    	 LevelLock_9 = new Sprite(536, 170, resourceController.LevelLock, vbom);
		    	 LevelLock_10 = new Sprite(671, 170, resourceController.LevelLock, vbom);
	    	 
	    	 menuChildScene.attachChild(LevelLock_3);
	    	 menuChildScene.attachChild(LevelLock_4);
	    	 menuChildScene.attachChild(LevelLock_5);
	    	 menuChildScene.attachChild(LevelLock_6);
	    	 menuChildScene.attachChild(LevelLock_7);
	    	 menuChildScene.attachChild(LevelLock_8);
	    	 menuChildScene.attachChild(LevelLock_9);
	    	 menuChildScene.attachChild(LevelLock_10);
	    	
	    	
	    }else if(((GameActivity) activity).isLevelUnLocked(24).equalsIgnoreCase("false")){
			 menuChildScene.detachChild(Scale4);
			 menuChildScene.detachChild(Scale5);
			 menuChildScene.detachChild(Scale6);
			 menuChildScene.detachChild(Scale7);
			 menuChildScene.detachChild(Scale8);
			 menuChildScene.detachChild(Scale9);
			 menuChildScene.detachChild(Scale10);
			 
			 TiledSpriteMenuItem  level4, level5, level6, level7, level8, level9, level10;

			 menuChildScene.attachChild(level4 = new TiledSpriteMenuItem(LEVEL_4, resourceController.Level_4, vbom));
			 menuChildScene.attachChild(level5 = new TiledSpriteMenuItem(LEVEL_5, resourceController.Level_5, vbom));
			 menuChildScene.attachChild(level6 = new TiledSpriteMenuItem(LEVEL_6, resourceController.Level_6, vbom));
			 menuChildScene.attachChild(level7 = new TiledSpriteMenuItem(LEVEL_7, resourceController.Level_7, vbom));
			 menuChildScene.attachChild(level8 = new TiledSpriteMenuItem(LEVEL_8, resourceController.Level_8, vbom));
			 menuChildScene.attachChild(level9 = new TiledSpriteMenuItem(LEVEL_9, resourceController.Level_9, vbom));
			 menuChildScene.attachChild(level10 = new TiledSpriteMenuItem(LEVEL_10, resourceController.Level_10, vbom));
			 
			 
			 level4.setPosition(536, 300);
			 level5.setPosition(671, 300);
			 level6.setPosition(131, 170);
			 level7.setPosition(266, 170);
			 level8.setPosition(401, 170);
			 level9.setPosition(536, 170);
			 level10.setPosition(671, 170);
			 
	    	 LevelLock_4 = new Sprite(536, 300, resourceController.LevelLock, vbom);
	    	 LevelLock_5 = new Sprite(671, 300, resourceController.LevelLock, vbom);
	    	 LevelLock_6 = new Sprite(131, 170, resourceController.LevelLock, vbom);
	    	 LevelLock_7 = new Sprite(266, 170, resourceController.LevelLock, vbom);
	    	 LevelLock_8 = new Sprite(401, 170, resourceController.LevelLock, vbom);
	    	 LevelLock_9 = new Sprite(536, 170, resourceController.LevelLock, vbom);
	    	 LevelLock_10 = new Sprite(671, 170, resourceController.LevelLock, vbom);
	    	 
	    	
	    	 menuChildScene.attachChild(LevelLock_4);
	    	 menuChildScene.attachChild(LevelLock_5);
	    	 menuChildScene.attachChild(LevelLock_6);
	    	 menuChildScene.attachChild(LevelLock_7);
	    	 menuChildScene.attachChild(LevelLock_8);
	    	 menuChildScene.attachChild(LevelLock_9);
	    	 menuChildScene.attachChild(LevelLock_10);
	    	
	    	 
	    }else if(((GameActivity) activity).isLevelUnLocked(25).equalsIgnoreCase("false")){
	    	
	    	
			 menuChildScene.detachChild(Scale5);
			 menuChildScene.detachChild(Scale6);
			 menuChildScene.detachChild(Scale7);
			 menuChildScene.detachChild(Scale8);
			 menuChildScene.detachChild(Scale9);
			 menuChildScene.detachChild(Scale10);
			 
			 TiledSpriteMenuItem level5, level6, level7, level8, level9, level10;

			 menuChildScene.attachChild(level5 = new TiledSpriteMenuItem(LEVEL_5, resourceController.Level_5, vbom));
			 menuChildScene.attachChild(level6 = new TiledSpriteMenuItem(LEVEL_6, resourceController.Level_6, vbom));
			 menuChildScene.attachChild(level7 = new TiledSpriteMenuItem(LEVEL_7, resourceController.Level_7, vbom));
			 menuChildScene.attachChild(level8 = new TiledSpriteMenuItem(LEVEL_8, resourceController.Level_8, vbom));
			 menuChildScene.attachChild(level9 = new TiledSpriteMenuItem(LEVEL_9, resourceController.Level_9, vbom));
			 menuChildScene.attachChild(level10 = new TiledSpriteMenuItem(LEVEL_10, resourceController.Level_10, vbom));
			 
			
			 level5.setPosition(671, 300);
			 level6.setPosition(131, 170);
			 level7.setPosition(266, 170);
			 level8.setPosition(401, 170);
			 level9.setPosition(536, 170);
			 level10.setPosition(671, 170);
			 
	    	
	    	 LevelLock_5 = new Sprite(671, 300, resourceController.LevelLock, vbom);
	    	 LevelLock_6 = new Sprite(131, 170, resourceController.LevelLock, vbom);
	    	 LevelLock_7 = new Sprite(266, 170, resourceController.LevelLock, vbom);
	    	 LevelLock_8 = new Sprite(401, 170, resourceController.LevelLock, vbom);
	    	 LevelLock_9 = new Sprite(536, 170, resourceController.LevelLock, vbom);
	    	 LevelLock_10 = new Sprite(671, 170, resourceController.LevelLock, vbom);
	    	 
	    	 
	    	 menuChildScene.attachChild(LevelLock_5);
	    	 menuChildScene.attachChild(LevelLock_6);
	    	 menuChildScene.attachChild(LevelLock_7);
	    	 menuChildScene.attachChild(LevelLock_8);
	    	 menuChildScene.attachChild(LevelLock_9);
	    	 menuChildScene.attachChild(LevelLock_10);
	    	
	    	 
	    }else if(((GameActivity) activity).isLevelUnLocked(26).equalsIgnoreCase("false")){
	    	
	    	
			 menuChildScene.detachChild(Scale6);
			 menuChildScene.detachChild(Scale7);
			 menuChildScene.detachChild(Scale8);
			 menuChildScene.detachChild(Scale9);
			 menuChildScene.detachChild(Scale10);
			 
			 TiledSpriteMenuItem  level6, level7, level8, level9, level10;

			 menuChildScene.attachChild(level6 = new TiledSpriteMenuItem(LEVEL_6, resourceController.Level_6, vbom));
			 menuChildScene.attachChild(level7 = new TiledSpriteMenuItem(LEVEL_7, resourceController.Level_7, vbom));
			 menuChildScene.attachChild(level8 = new TiledSpriteMenuItem(LEVEL_8, resourceController.Level_8, vbom));
			 menuChildScene.attachChild(level9 = new TiledSpriteMenuItem(LEVEL_9, resourceController.Level_9, vbom));
			 menuChildScene.attachChild(level10 = new TiledSpriteMenuItem(LEVEL_10, resourceController.Level_10, vbom));
			 
			 level6.setPosition(131, 170);
			 level7.setPosition(266, 170);
			 level8.setPosition(401, 170);
			 level9.setPosition(536, 170);
			 level10.setPosition(671, 170);
			 
	    	 LevelLock_6 = new Sprite(131, 170, resourceController.LevelLock, vbom);
	    	 LevelLock_7 = new Sprite(266, 170, resourceController.LevelLock, vbom);
	    	 LevelLock_8 = new Sprite(401, 170, resourceController.LevelLock, vbom);
	    	 LevelLock_9 = new Sprite(536, 170, resourceController.LevelLock, vbom);
	    	 LevelLock_10 = new Sprite(671, 170, resourceController.LevelLock, vbom);
	    	 
	    	 menuChildScene.attachChild(LevelLock_6);
	    	 menuChildScene.attachChild(LevelLock_7);
	    	 menuChildScene.attachChild(LevelLock_8);
	    	 menuChildScene.attachChild(LevelLock_9);
	    	 menuChildScene.attachChild(LevelLock_10);
	    	

	    }else if(((GameActivity) activity).isLevelUnLocked(27).equalsIgnoreCase("false")){
	    	
			 menuChildScene.detachChild(Scale7);
			 menuChildScene.detachChild(Scale8);
			 menuChildScene.detachChild(Scale9);
			 menuChildScene.detachChild(Scale10);
			 
			 TiledSpriteMenuItem level7, level8, level9, level10;

			 menuChildScene.attachChild(level7 = new TiledSpriteMenuItem(LEVEL_7, resourceController.Level_7, vbom));
			 menuChildScene.attachChild(level8 = new TiledSpriteMenuItem(LEVEL_8, resourceController.Level_8, vbom));
			 menuChildScene.attachChild(level9 = new TiledSpriteMenuItem(LEVEL_9, resourceController.Level_9, vbom));
			 menuChildScene.attachChild(level10 = new TiledSpriteMenuItem(LEVEL_10, resourceController.Level_10, vbom));
			 
			 level7.setPosition(266, 170);
			 level8.setPosition(401, 170);
			 level9.setPosition(536, 170);
			 level10.setPosition(671, 170);
			 
	    	 LevelLock_7 = new Sprite(266, 170, resourceController.LevelLock, vbom);
	    	 LevelLock_8 = new Sprite(401, 170, resourceController.LevelLock, vbom);
	    	 LevelLock_9 = new Sprite(536, 170, resourceController.LevelLock, vbom);
	    	 LevelLock_10 = new Sprite(671, 170, resourceController.LevelLock, vbom);
	    	 
	    	 menuChildScene.attachChild(LevelLock_7);
	    	 menuChildScene.attachChild(LevelLock_8);
	    	 menuChildScene.attachChild(LevelLock_9);
	    	 menuChildScene.attachChild(LevelLock_10);
	    }else if(((GameActivity) activity).isLevelUnLocked(28).equalsIgnoreCase("false")){
	    	
			 menuChildScene.detachChild(Scale8);
			 menuChildScene.detachChild(Scale9);
			 menuChildScene.detachChild(Scale10);
			 
			 TiledSpriteMenuItem level8, level9, level10;

			 menuChildScene.attachChild(level8 = new TiledSpriteMenuItem(LEVEL_8, resourceController.Level_8, vbom));
			 menuChildScene.attachChild(level9 = new TiledSpriteMenuItem(LEVEL_9, resourceController.Level_9, vbom));
			 menuChildScene.attachChild(level10 = new TiledSpriteMenuItem(LEVEL_10, resourceController.Level_10, vbom));
			 
			 level8.setPosition(401, 170);
			 level9.setPosition(536, 170);
			 level10.setPosition(671, 170);
			 
	    	 LevelLock_8 = new Sprite(401, 170, resourceController.LevelLock, vbom);
	    	 LevelLock_9 = new Sprite(536, 170, resourceController.LevelLock, vbom);
	    	 LevelLock_10 = new Sprite(671, 170, resourceController.LevelLock, vbom);
	    	 
	    	 menuChildScene.attachChild(LevelLock_8);
	    	 menuChildScene.attachChild(LevelLock_9);
	    	 menuChildScene.attachChild(LevelLock_10);
	    }else if(((GameActivity) activity).isLevelUnLocked(29).equalsIgnoreCase("false")){
	    	
			 menuChildScene.detachChild(Scale9);
			 menuChildScene.detachChild(Scale10);
			 
			 TiledSpriteMenuItem level9, level10;

			 menuChildScene.attachChild(level9 = new TiledSpriteMenuItem(LEVEL_9, resourceController.Level_9, vbom));
			 menuChildScene.attachChild(level10 = new TiledSpriteMenuItem(LEVEL_10, resourceController.Level_10, vbom));
			 
			 level9.setPosition(536, 170);
			 level10.setPosition(671, 170);
			 
	    	 LevelLock_9 = new Sprite(536, 170, resourceController.LevelLock, vbom);
	    	 LevelLock_10 = new Sprite(671, 170, resourceController.LevelLock, vbom);
	    	 
	    	 menuChildScene.attachChild(LevelLock_9);
	    	 menuChildScene.attachChild(LevelLock_10);
	    	 
	    }else if(((GameActivity) activity).isLevelUnLocked(30).equalsIgnoreCase("false")){
	    	
			 menuChildScene.detachChild(Scale10);
			 
			 TiledSpriteMenuItem level10;

			 menuChildScene.attachChild(level10 = new TiledSpriteMenuItem(LEVEL_10, resourceController.Level_10, vbom));
			 
			 
			 level10.setPosition(671, 170);
			 
	    	 LevelLock_10 = new Sprite(671, 170, resourceController.LevelLock, vbom);
	    	 
	    	
	    	 menuChildScene.attachChild(LevelLock_10);
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
	    final IMenuItem Level_7 = Scale7 = new ScaleMenuItemDecorator(l6=new TiledSpriteMenuItem(LEVEL_7, resourceController.Level_7, vbom), 1.2f, 1);
	    final IMenuItem Level_8 = Scale8 = new ScaleMenuItemDecorator(l7=new TiledSpriteMenuItem(LEVEL_8, resourceController.Level_8, vbom), 1.2f, 1);
	    final IMenuItem Level_9 = Scale9 = new ScaleMenuItemDecorator(l8=new TiledSpriteMenuItem(LEVEL_9, resourceController.Level_9, vbom), 1.2f, 1);
	    final IMenuItem Level_10 = Scale10 = new ScaleMenuItemDecorator(l9=new TiledSpriteMenuItem(LEVEL_10, resourceController.Level_10, vbom), 1.2f, 1);
	    final IMenuItem HighScore = new ScaleMenuItemDecorator(new SpriteMenuItem(HIGHSCORE, resourceController.HighScoreButton, vbom), 1.2f, 1);

	    l0.setSelected(((GameActivity) activity).getLevelStar(21));
	    l1.setSelected(((GameActivity) activity).getLevelStar(22));
	    l2.setSelected(((GameActivity) activity).getLevelStar(23));
	    l3.setSelected(((GameActivity) activity).getLevelStar(24));
	    l4.setSelected(((GameActivity) activity).getLevelStar(25));
	    l5.setSelected(((GameActivity) activity).getLevelStar(26));
	    l6.setSelected(((GameActivity) activity).getLevelStar(27));
	    l7.setSelected(((GameActivity) activity).getLevelStar(28));
	    l8.setSelected(((GameActivity) activity).getLevelStar(29));
	    l9.setSelected(((GameActivity) activity).getLevelStar(30));

	
	    menuChildScene.addMenuItem(Level_1);
	    menuChildScene.addMenuItem(Level_2);
	    menuChildScene.addMenuItem(Level_3);
	    menuChildScene.addMenuItem(Level_4);
	    menuChildScene.addMenuItem(Level_5);
	    menuChildScene.addMenuItem(Level_6);
	    menuChildScene.addMenuItem(Level_7);
	    menuChildScene.addMenuItem(Level_8);
	    menuChildScene.addMenuItem(Level_9);
	    menuChildScene.addMenuItem(Level_10);
	    menuChildScene.addMenuItem(HighScore);

	    
	    
	    menuChildScene.buildAnimations();
	    menuChildScene.setBackgroundEnabled(false);
	    
	    Level_1.setPosition(131, 300);
	    Level_2.setPosition(266, 300);
	    Level_3.setPosition(401, 300);
	    Level_4.setPosition(536, 300);
	    Level_5.setPosition(671, 300);
	    Level_6.setPosition(131, 170);
	    Level_7.setPosition(266, 170);
	    Level_8.setPosition(401, 170);
	    Level_9.setPosition(536, 170);
	    Level_10.setPosition(671, 170);
	    HighScore.setPosition(404, 60);
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
	        	resourceController.level = 21;
	        	if(ResourceController.getInstance().soundFlag)
	            	ResourceController.getInstance().buttonclick.play();
	        	camera.setHUD(null);
	            camera.setCenter(400, 240);
                ResourceController.getInstance().isGameRunning = true;
	        	SceneController.getInstance().loadGameSceneOrder(engine);	            
	            return true;
	        case LEVEL_2:
	        	if(((GameActivity) activity).isLevelUnLocked(22).equalsIgnoreCase("true")){
		        	resourceController.level = 22;
		        	if(ResourceController.getInstance().soundFlag)
		            	ResourceController.getInstance().buttonclick.play();
		        	camera.setHUD(null);
		            camera.setCenter(400, 240);
	                ResourceController.getInstance().isGameRunning = true;
		        	SceneController.getInstance().loadGameSceneOrder(engine);	        	}
	            return true;
	        case LEVEL_3:
	        	if(((GameActivity) activity).isLevelUnLocked(23).equalsIgnoreCase("true")){
		        	resourceController.level = 23;
		        	camera.setHUD(null);
		            camera.setCenter(400, 240);
	                ResourceController.getInstance().isGameRunning = true;
		        	SceneController.getInstance().loadGameSceneOrder(engine);	        	}
	            return true;
	        case LEVEL_4:
	        	
	        	if(((GameActivity) activity).isLevelUnLocked(24).equalsIgnoreCase("true")){
	        		resourceController.level = 24;
		        	if(ResourceController.getInstance().soundFlag)
		            	ResourceController.getInstance().buttonclick.play();
		        	camera.setHUD(null);
		            camera.setCenter(400, 240);
	                ResourceController.getInstance().isGameRunning = true;
		        	SceneController.getInstance().loadGameSceneOrder(engine);	            }
	            return true;
	        case LEVEL_5:
	        	if(((GameActivity) activity).isLevelUnLocked(25).equalsIgnoreCase("true")){
		        	resourceController.level = 25;
		        	if(ResourceController.getInstance().soundFlag)
		            	ResourceController.getInstance().buttonclick.play();
		        	camera.setHUD(null);
		            camera.setCenter(400, 240);
	                ResourceController.getInstance().isGameRunning = true;
		        	SceneController.getInstance().loadGameSceneOrder(engine);	        	}
	            return true;
	        case LEVEL_6:
	        	if(((GameActivity) activity).isLevelUnLocked(26).equalsIgnoreCase("true")){
		        	resourceController.level = 26;
		        	if(ResourceController.getInstance().soundFlag)
		            	ResourceController.getInstance().buttonclick.play();
		        	camera.setHUD(null);
		            camera.setCenter(400, 240);
	                ResourceController.getInstance().isGameRunning = true;
		        	SceneController.getInstance().loadGameSceneOrder(engine);	        	}
	            return true;
	        case LEVEL_7:
	        	if(((GameActivity) activity).isLevelUnLocked(27).equalsIgnoreCase("true")){
		        	resourceController.level = 27;
		        	if(ResourceController.getInstance().soundFlag)
		            	ResourceController.getInstance().buttonclick.play();
		        	camera.setHUD(null);
		            camera.setCenter(400, 240);
	                ResourceController.getInstance().isGameRunning = true;
		        	SceneController.getInstance().loadGameSceneOrder(engine);	        	}
	            return true;
	        case LEVEL_8:
	        	if(((GameActivity) activity).isLevelUnLocked(28).equalsIgnoreCase("true")){
		        	resourceController.level = 28;
		        	if(ResourceController.getInstance().soundFlag)
		            	ResourceController.getInstance().buttonclick.play();
		        	camera.setHUD(null);
		            camera.setCenter(400, 240);
	                ResourceController.getInstance().isGameRunning = true;
		        	SceneController.getInstance().loadGameSceneOrder(engine);	        	}
	            return true;
	        case LEVEL_9:
	        	if(((GameActivity) activity).isLevelUnLocked(29).equalsIgnoreCase("true")){
		        	resourceController.level = 29;
		        	if(ResourceController.getInstance().soundFlag)
		            	ResourceController.getInstance().buttonclick.play();
		        	camera.setHUD(null);
		            camera.setCenter(400, 240);
	                ResourceController.getInstance().isGameRunning = true;
		        	SceneController.getInstance().loadGameSceneOrder(engine);
		        	}
	            return true;
	        case LEVEL_10:
	        	if(((GameActivity) activity).isLevelUnLocked(30).equalsIgnoreCase("true")){
		        	resourceController.level = 30;
		        	if(ResourceController.getInstance().soundFlag)
		            	ResourceController.getInstance().buttonclick.play();
		        	camera.setHUD(null);
		            camera.setCenter(400, 240);
	                ResourceController.getInstance().isGameRunning = true;
		        	SceneController.getInstance().loadGameSceneOrder(engine);
	        	}
	            return true;
	        case HIGHSCORE:
	        	 if(!ResourceController.getInstance().soundFlag)
		            	ResourceController.getInstance().buttonclick.play();
	        	 ResourceController.getInstance().gameMode = true;
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
