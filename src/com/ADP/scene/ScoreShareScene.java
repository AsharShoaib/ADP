package com.ADP.scene;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.util.GLState;
import org.andengine.util.adt.align.HorizontalAlign;

import com.ADP.controller.ResourceController;
import com.ADP.controller.SceneController;
import com.ADP.controller.SceneController.SceneType;
import com.ADP.pyramidmovers.FacebookManager;
import com.ADP.pyramidmovers.GameActivity;
import com.ADP.template.TemplateScene;

public class ScoreShareScene extends TemplateScene  {
	
	//Variables
	
	private Sprite background;
	private Sprite button;
	private Text HighScore1;
	private Text HighScore11;
	private String level = null;
	private Sprite button2;
	private Sprite button3; 



	
	
	//Class
	@Override
	public void createScene() {
		createBackground();
		createText();
		createButton();

	}

	private void createButton() {
		
		button = new Sprite(404, 70, ResourceController.getInstance().shareButton_region, vbom){
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				switch(pSceneTouchEvent.getAction()) {
                case TouchEvent.ACTION_DOWN:
  		
                    break;
                case TouchEvent.ACTION_UP:
                	if(!ResourceController.getInstance().isloggedFacebook){
                	//	FacebookManager.facebookLogin();
                	}
                	SceneController.getInstance().loadMenuScene(engine, null);
                	if(!ResourceController.getInstance().gameMode){
                		if(ResourceController.getInstance().gameType){
                    		String s;
    						//FacebookManager.facebookFeedDialogClock(Integer.toString(ResourceController.getInstance().level), "Pharo's Clock Mode", Integer.toString(ResourceController.getInstance().currentGameMoves), Float.toString(ResourceController.getInstance().currentGameTime));
                    		
                    		FacebookManager.postLevelCompletionTime(Integer.toString(ResourceController.getInstance().level), "Pharaoh's Clock Mode", Integer.toString(ResourceController.getInstance().currentGameMoves), Float.toString(ResourceController.getInstance().currentGameTime));
                    	}else{
                    	
                    		//FacebookManager.checkUserLoggedIn();
                    		//FacebookManager.facebookLogin();
                    		//FacebookManager.facebookFeedDialogMoves(Integer.toString(ResourceController.getInstance().level), "Egyption Move",  Integer.toString(ResourceController.getInstance().currentGameMoves));
                    		FacebookManager.postLevelCompletionMove(Integer.toString(ResourceController.getInstance().level), "Egyptian Move",  Integer.toString(ResourceController.getInstance().currentGameMoves));
                    	}

                	}else{
                		FacebookManager.postLevelCompletionOrder(level, "Pharaoh's Order",  Integer.toString(ResourceController.getInstance().currentGameMoves), Float.toString(ResourceController.getInstance().currentGameTime));
                	}
                	
                	break;
                case TouchEvent.ACTION_MOVE:
                    break;
                }
				return true;
			}
		};
		this.attachChild(button);
	  		registerTouchArea(button);
	  		
	  		button2 = new Sprite(700, 120, ResourceController.getInstance().nextbutton_region, vbom){
				public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
					switch(pSceneTouchEvent.getAction()) {
	                case TouchEvent.ACTION_DOWN:
	  		
	                    break;
	                case TouchEvent.ACTION_UP:
	                	if(!ResourceController.getInstance().gameMode){
	                		if(ResourceController.getInstance().gameType){
	                			camera.setHUD(null);
	        	                camera.setCenter(400, 240);
	        	                resourceController.level++;
	        	                ResourceController.getInstance().gameType = true;
	        	                ResourceController.getInstance().isGameRunning = true;
	        		            SceneController.getInstance().loadGameSceneClock(engine);
	                		}else{
	                			camera.setHUD(null);
	            	            camera.setCenter(400, 240);
	        	                resourceController.level++;
	                            ResourceController.getInstance().gameType = false;
	                            ResourceController.getInstance().isGameRunning = true;
	            	        	SceneController.getInstance().loadGameSceneSteps(engine);
	                		}

	                	}else{
	    		        	camera.setHUD(null);
	    		            camera.setCenter(400, 240);
	                		resourceController.level++;
	    	                ResourceController.getInstance().isGameRunning = true;
	    		        	SceneController.getInstance().loadGameSceneOrder(engine);
	                	}
	                	
	                	break;
	                case TouchEvent.ACTION_MOVE:
	                    break;
	                }
					return true;
				}
			};
			if(resourceController.level == 6 || resourceController.level == 30 ){
				
			}else{
				this.attachChild(button2);
			  		registerTouchArea(button2);	
			}
			
			button3 = new Sprite(100, 120, ResourceController.getInstance().backbutton_region, vbom){
				public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
					switch(pSceneTouchEvent.getAction()) {
	                case TouchEvent.ACTION_DOWN:
	  		
	                    break;
	                case TouchEvent.ACTION_UP:
	                	if(!ResourceController.getInstance().gameMode){
	                			SceneController.getInstance().loadMenuScene(engine, null);                			
	                	}else{
	                    	SceneController.getInstance().loadMenuSceneFromOrder(engine, null);
	                	}
	                	
	                	break;
	                case TouchEvent.ACTION_MOVE:
	                    break;
	                }
					return true;
				}
			};
			this.attachChild(button3);
	  		registerTouchArea(button3);
	}

	public void createText(){
		
		HighScore1 = new Text(400, 230, resourceController.font, 
	    		"HighScore1.setText(Level 1 - Least Number Of Moves:  +((GameActivity) activity).getLevelScore(1) + Best Time:  +((GameActivity) activity).getLevelTime(1) + Level Passed = +((GameActivity) activity).isLevelBeat(1)); "
	    		, new TextOptions(HorizontalAlign.CENTER), vbom);
	   
	    
	    HighScore11 = new Text(398, 228, resourceController.font, 
	    		"HighScore1.setText(Level 1 - Least Number Of Moves:  +((GameActivity) activity).getLevelScore(1) + Best Time:  +((GameActivity) activity).getLevelTime(1) + Level Passed = +((GameActivity) activity).isLevelBeat(1)); "
	    		, new TextOptions(HorizontalAlign.CENTER), vbom);

	    
	    
	  HighScore1.setScale(1.7f); 
	  HighScore11.setScale(1.7f); 
	  if(!ResourceController.getInstance().gameMode){
		if(ResourceController.getInstance().gameType){
			String s;
			if(((GameActivity) activity).isLevelBeat(ResourceController.getInstance().level).equalsIgnoreCase("true")){
	    		s = "Yes";
	    	}else{
	    		s = "No";
	    	}
	    
		    HighScore1.setText("Level " + ResourceController.getInstance().level + "\n" + "Number Of Moves: " + ResourceController.getInstance().currentGameMoves + "\n  Time: " + ResourceController.getInstance().currentGameTime + "\n Best Time: " + ((GameActivity) activity).getLevelTime(ResourceController.getInstance().level)); 
		    HighScore11.setText("Level " + ResourceController.getInstance().level + "\n" + "Number Of Moves: " + ResourceController.getInstance().currentGameMoves + "\n  Time: " + ResourceController.getInstance().currentGameTime + "\n Best Time: " + ((GameActivity) activity).getLevelTime(ResourceController.getInstance().level)); 
		}else{
			String s;
			if(((GameActivity) activity).isLevelBeat(ResourceController.getInstance().level).equalsIgnoreCase("true")){
	    		s = "Yes";
	    	}else{
	    		s = "No";
	    	}
			HighScore1.setText("Level " + ResourceController.getInstance().level + "\n" + "Number Of Moves: " + ResourceController.getInstance().currentGameMoves + "\n Best Time: " + ((GameActivity) activity).getLevelTime(ResourceController.getInstance().level) + "\nLevel Passed = " +
		    		s); 
		    HighScore11.setText("Level " + ResourceController.getInstance().level + "\n" + "Number Of Moves: " + ResourceController.getInstance().currentGameMoves + "\n Best Time: " + ((GameActivity) activity).getLevelTime(ResourceController.getInstance().level) + "\nLevel Passed = " +
		    		s); 
		}
	  }else{
		  if(ResourceController.getInstance().level == 21){
			  level = "1";
		  }else if(ResourceController.getInstance().level == 22){
			  level ="2";
		  }else if(ResourceController.getInstance().level == 23){
			  level = "3";
		  }else if(ResourceController.getInstance().level == 24){
			  level ="4";
		  }else if(ResourceController.getInstance().level == 25){
			  level ="5";
		  }else if(ResourceController.getInstance().level == 26){
			  level ="6";
		  }else if(ResourceController.getInstance().level == 27){
			  level ="7";
		  }else if(ResourceController.getInstance().level ==28){
			  level ="8";
		  }else if(ResourceController.getInstance().level == 29){
			  level ="9";
		  }else if(ResourceController.getInstance().level == 30){
			  level ="10";
		  }
		  String s;
			if(((GameActivity) activity).isLevelBeat(ResourceController.getInstance().level).equalsIgnoreCase("true")){
	    		s = "Yes";
	    	}else{
	    		s = "No";
	    	}
	    
		    HighScore1.setText("Level " + level + "\n" + "Number Of Moves: " + ResourceController.getInstance().currentGameMoves + "\n  Time: " + ResourceController.getInstance().currentGameTime + "\n Best Time: " + ((GameActivity) activity).getLevelTime(ResourceController.getInstance().level)); 
		    HighScore11.setText("Level " + level + "\n" + "Number Of Moves: " + ResourceController.getInstance().currentGameMoves + "\n  Time: " + ResourceController.getInstance().currentGameTime + "\n Best Time: " + ((GameActivity) activity).getLevelTime(ResourceController.getInstance().level));  

	  }
	    HighScore1.setColor(0, 0, 0);
	   
	
	    this.attachChild(HighScore1);
	    this.attachChild(HighScore11);

	}
	@Override
	public void onBackKeyPressed() {
		if(!ResourceController.getInstance().gameMode){
    		
	    	SceneController.getInstance().loadMenuScene(engine, null);

    	}else{
        	SceneController.getInstance().loadMenuSceneFromOrder(engine, null);
    	}
		
	}

	@Override
	public SceneType getSceneType() {
		return SceneType.SCENE_SHARESCORE;
	}

	@Override
	public void disposeScene() {
		background.detachSelf();
		background.dispose();
		this.detachSelf();
		this.dispose();
	}
	
	
	
	public void createBackground(){
		
		background = new Sprite(400,240, ResourceController.getInstance().shareBackground_region, vbom){
			@Override
			protected void preDraw(GLState pGLState, Camera pCamera){
				super.preDraw(pGLState, pCamera);
			    pGLState.enableDither();
			    
			}
			
			
		};
		
		attachChild(background);

	}

}