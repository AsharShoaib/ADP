package com.ADP.scene.game;



import java.io.IOException;
import java.util.Stack;

import org.andengine.engine.camera.hud.HUD;
import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.entity.IEntity;

import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.input.touch.TouchEvent;
import org.andengine.util.SAXUtils;
import org.andengine.util.adt.align.HorizontalAlign;
import org.andengine.util.level.EntityLoader;
import org.andengine.util.level.constants.LevelConstants;
import org.andengine.util.level.simple.SimpleLevelEntityLoaderData;
import org.andengine.util.level.simple.SimpleLevelLoader;
import org.xml.sax.Attributes;

import org.andengine.engine.camera.Camera;
import org.andengine.opengl.util.GLState;
import com.ADP.pyramidmovers.GameActivity;
import com.ADP.pyramidmovers.pyramids;
import com.ADP.scene.GameInstructionWindow;
import com.ADP.template.TemplateScene;
import com.ADP.controller.ResourceController;
import com.ADP.controller.SceneController;
import com.ADP.controller.SceneController.SceneType;

public class GameSceneClock extends TemplateScene
{
	//Game stat
	private HUD gameHUD;
	private Text scoreText;
	private Text timeText;
	private int score = 0;
	private Stack<pyramids> mStack1, mStack2, mStack3;
	private Sprite platform1, platform2, platform3;
    private Sprite gameScene;
    double timeRemaining;
    protected int platform;
	protected int blocks;
    private boolean gameStarted;
	private int moves;
	private float time;
	private IUpdateHandler timer;
	private GameInstructionWindow InstructionWindow;
	private Text scoreText2;
	private Text timeText2;
	private TimerHandler timerFinish;
	private Sprite repeat;

    
    
	//Game LevelLoad
	private static final String TAG_ENTITY = "entity";
	private static final String TAG_ENTITY_ATTRIBUTE_X = "x";
	private static final String TAG_ENTITY_ATTRIBUTE_Y = "y";
	private static final String TAG_ENTITY_ATTRIBUTE_TYPE = "type";
	    
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID1 = "pyramid1";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID2 = "pyramid2";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID3 = "pyramid3";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID4 = "pyramid4";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID5 = "pyramid5";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID6 = "pyramid6";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID7 = "pyramid7";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID8 = "pyramid8";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PLATFORM = "platform";
	

	
	
	private void createStacks(){
		// Create the stacks
		this.mStack1 = new Stack<pyramids>();
		this.mStack2 = new Stack<pyramids>();
		this.mStack3 = new Stack<pyramids>();
		
		this.platform1 = new Sprite(130, 215, resourceController.platform1_region, vbom);
		this.platform2 = new Sprite(399, 215, resourceController.platform2_region, vbom);
		this.platform3 = new Sprite(668, 215, resourceController.platform3_region, vbom);
		
		attachChild(platform1);
		attachChild(platform2);
		attachChild(platform3);
		platform1.setVisible(false);
		platform2.setVisible(false);
		platform3.setVisible(false);


	}


	private void createHUD()
	{
	    gameHUD = new HUD();
	    
	    // CREATE SCORE TEXT
	    scoreText = new Text(22, 420, resourceController.font, "Score: 0123456789", new TextOptions(HorizontalAlign.LEFT), vbom);
	    scoreText.setAnchorCenter(0, 0);    
	    scoreText.setText("Score: 0");
	    gameHUD.attachChild(scoreText);
	    
	 // CREATE TIMER TEXT
	    timeText = new Text(22, 390, resourceController.font, "Time: 0123456789", new TextOptions(HorizontalAlign.LEFT), vbom);
	    timeText.setAnchorCenter(0, 0);    
	    timeText.setText("Time: 0");
	    gameHUD.attachChild(timeText);
	    
	    scoreText2 = new Text(20, 418, resourceController.font, "Score: 0123456789", new TextOptions(HorizontalAlign.LEFT), vbom);
	    scoreText2.setAnchorCenter(0, 0);    
	    scoreText2.setText("Score: 0");
	    scoreText.setColor(0, 0, 0);
	    timeText2 = new Text(20, 393, resourceController.font, "Moves: 0123456789", new TextOptions(HorizontalAlign.LEFT), vbom);
	    timeText2.setAnchorCenter(0, 0);    
	    timeText2.setText("Time: 0");
	    timeText.setColor(0, 0, 0);
	    gameHUD.attachChild(scoreText2);
	    gameHUD.attachChild(timeText2);
	    gameHUD.attachChild(repeat = new Sprite(780, 460, resourceController.gamerepeat_region, vbom)
	    {

	    	@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				switch(pSceneTouchEvent.getAction()) {
	            case TouchEvent.ACTION_DOWN:
	                break;
	            case TouchEvent.ACTION_UP:
					ResourceController.getInstance().unloadGameTextures(GameSceneClock.this);
		        	SceneController.getInstance().loadGameSceneClock(engine);
	        	    break;
	            case TouchEvent.ACTION_MOVE:
	                break;
	            }
				return true;
			}
	    });

	    registerTouchArea(repeat);
	    
	    camera.setHUD(gameHUD);
	}
	

	private void addToScore()
	{
		score += (3*timeRemaining);
			if(moves < Math.pow(2,blocks)-1)
				score -= ((Math.pow(2,blocks)-1)-moves) ;
		
	    scoreText.setText("Score: " + score);
	    scoreText2.setText("Score: " + score);

	}
	
	private void addToMoves(float f)
	{
	    moves += f;
	}
	
	
	private void updateTime()
	{
	    timeText.setText("Time Left: " + timeRemaining);
	    timeText2.setText("Time Left: " + timeRemaining);

	}
	
    @Override
    public void createScene()
    {
    	createBackground();
        createHUD();
        createStacks();
        gameStarted = false;
        time = 0;
        timeRemaining = (Math.pow(2,ResourceController.getInstance().level))* 30 - (Math.pow(ResourceController.getInstance().level,3));
        //timeRemaining = 3;
        loadLevel(ResourceController.getInstance().level);
        InstructionWindow = new GameInstructionWindow(vbom){
        	@Override
    		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				switch(pSceneTouchEvent.getAction()) {
                case TouchEvent.ACTION_DOWN:
                    break;
                case TouchEvent.ACTION_UP:
      	       		InstructionWindow.removedisplay(GameSceneClock.this);
                	break;
                case TouchEvent.ACTION_MOVE:
                    break;
                }
				return true;
			}
        };
        registerTouchArea(InstructionWindow);
        InstructionWindow.display(this);
	    ResourceController.getInstance().game_music.play();
	    ResourceController.getInstance().game_music.setLooping(true);

    }
    
    public void startTimer(){
    	if(!gameStarted){
    		timer =  new TimerHandler(1.0f, new ITimerCallback() {
  	       	public void onTimePassed(TimerHandler pTimerHandler) {
  	                       timeRemaining--;
  	                       time++;
  	                       updateTime();
  	                       gameStarted=true;
  	       		if (timeRemaining == 0) {
  	       			SceneController.getInstance().engine.unregisterUpdateHandler(pTimerHandler);
  	       			SceneController.getInstance().createGameLost(GameSceneClock.this);
  	       		}
  	       		if (timeRemaining <= 10) {
  	       		}
  	       		if (timeRemaining > 0){
  	       			pTimerHandler.reset();
  	       		}
  	       	}
  	       });
    		SceneController.getInstance().engine.registerUpdateHandler(timer);
    	}
    }

    @Override
    public void onBackKeyPressed()
    {
        ResourceController.getInstance().isGameRunning = false;
        SceneController.getInstance().loadMenuScene(engine, this);
    }

    @Override
    public SceneType getSceneType()
    {
        return SceneType.SCENE_GAME_STEPS;
    }

    @Override
    public void disposeScene()
    {
    	camera.setHUD(null);
        camera.setCenter(400, 240);
    }
    
    private void createBackground()
	{
    	gameScene = new Sprite(400, 240, resourceController.background_region, vbom)
	    {
	        @Override
	        protected void preDraw(GLState pGLState, Camera pCamera) 
	        {
	            super.preDraw(pGLState, pCamera);
	            pGLState.enableDither();
	        }
	    };
	    attachChild(gameScene);
	}  
    
    private void checkForCollisionsWithPlatform (pyramids Pyramids, boolean firstBlock) {
    	
    	Stack<pyramids> stack = null;
	    Sprite tower = null;
	    if (Pyramids.collidesWith(platform1) && (mStack1.size() == 0 ||             
	            Pyramids.getmWeight() < ((pyramids) mStack1.peek()).getmWeight())) {
	        stack = mStack1;
	        tower = platform1;
	        addToMoves(1);
            addToScore();
		    ResourceController.getInstance().music.play();

	    } else if (Pyramids.collidesWith(platform2) && (mStack2.size() == 0 || 
	            Pyramids.getmWeight() < ((pyramids) mStack2.peek()).getmWeight())) {
	        stack = mStack2;
	        tower = platform2;
	        addToMoves(1);
            addToScore();
		    ResourceController.getInstance().music.play();


	    } else if (Pyramids.collidesWith(platform3) && (mStack3.size() == 0 || 
	    		Pyramids.getmWeight() < ((pyramids) mStack3.peek()).getmWeight())) {
	        stack = mStack3;
	        tower = platform3;
	        addToMoves(1);
            addToScore();
		    ResourceController.getInstance().music.play();

	    } else {
	        stack = Pyramids.getmStack();
	        tower = Pyramids.getmPlatform();
	    }
	    Pyramids.getmStack().remove(Pyramids);
	    if (stack != null && tower !=null && stack.size() == 0) {
	    	Pyramids.setPosition(tower.getX(), tower.getY() - tower.getHeight()/2 +
	    			Pyramids.getHeight()/2 + 6);
	    } else if (stack != null && tower !=null && stack.size() > 0 && firstBlock == false) {
	    	Pyramids.setPosition(tower.getX(), ((pyramids) stack.peek()).getY() + 
	    			Pyramids.getHeight());
	    }else if (stack != null && tower !=null && stack.size() > 0 && firstBlock == true) {
	    	Pyramids.setPosition(tower.getX(), ((pyramids) stack.peek()).getY() + 
	    			Pyramids.getHeight() - 11);
	    }
	    stack.add(Pyramids);
	    Pyramids.setmStack(stack);
	    Pyramids.setmPlatform(tower);
	    checkForFinish(platform);
}
    private void checkForFinish(int i){
    	if(i == 2){
    		if(mStack2.size() == blocks){
    			ResourceController.getInstance().currentGameTime = time;
    			ResourceController.getInstance().currentGameMoves = moves;
    			timerFinish =  new TimerHandler(1.0f, new ITimerCallback() {
    	  	       	public void onTimePassed(TimerHandler pTimerHandler) {
    	  	       	if(timeRemaining >((((Math.pow(2,ResourceController.getInstance().level))* 30 - (Math.pow(ResourceController.getInstance().level,3))))/3.0)*2)
        				ResourceController.getInstance().setScore(3);
        			else if(timeRemaining >(((Math.pow(2,ResourceController.getInstance().level))* 30 - (Math.pow(ResourceController.getInstance().level,3))))/2.0)
        				ResourceController.getInstance().setScore(2);
        			else 
	        				ResourceController.getInstance().setScore(1);
	        			if(((GameActivity) activity).getLevelTime(ResourceController.getInstance().level) > time || ((GameActivity) activity).getLevelTime(ResourceController.getInstance().level) == 0)
	    					((GameActivity) activity).setLevelTime(ResourceController.getInstance().level, Float.toString(time));
	    	       		SceneController.getInstance().engine.unregisterUpdateHandler(timer);
	    	       		SceneController.getInstance().engine.unregisterUpdateHandler(timerFinish);
	        		    ResourceController.getInstance().game_music.stop();
	    	            SceneController.getInstance().createGameCompleteScreen(GameSceneClock.this);
    	  	       	}
    	  	       });
    	    		SceneController.getInstance().engine.registerUpdateHandler(timerFinish);
    		}
    	}else if (i == 3){
			if(mStack3.size() == blocks){
				ResourceController.getInstance().currentGameTime = time;
    			ResourceController.getInstance().currentGameMoves = moves;
				timerFinish =  new TimerHandler(1.0f, new ITimerCallback() {
    	  	       	public void onTimePassed(TimerHandler pTimerHandler) {
    	  	       	if(timeRemaining >((((Math.pow(2,ResourceController.getInstance().level))* 30 - (Math.pow(ResourceController.getInstance().level,3))))/3.0)*2)
        				ResourceController.getInstance().setScore(3);
        			else if(timeRemaining >(((Math.pow(2,ResourceController.getInstance().level))* 30 - (Math.pow(ResourceController.getInstance().level,3))))/2.0)
        				ResourceController.getInstance().setScore(2);
        			else 
	        				ResourceController.getInstance().setScore(1);
	        			if(((GameActivity) activity).getLevelTime(ResourceController.getInstance().level) < time || ((GameActivity) activity).getLevelTime(ResourceController.getInstance().level) == 0 )
	    					((GameActivity) activity).setLevelTime(ResourceController.getInstance().level, Float.toString(time));
	    	       		SceneController.getInstance().engine.unregisterUpdateHandler(timer);
	    	       		SceneController.getInstance().engine.unregisterUpdateHandler(timerFinish);
	        		    ResourceController.getInstance().game_music.stop();
	    	            SceneController.getInstance().createGameCompleteScreen(GameSceneClock.this);
    	  	       	}
    	  	       });
    	    	   SceneController.getInstance().engine.registerUpdateHandler(timerFinish);
				
			 }
    	}
    	
    }
    
    private void loadLevel(int levelID)
    {
        final SimpleLevelLoader levelLoader = new SimpleLevelLoader(vbom);
        
        
        levelLoader.registerEntityLoader(new EntityLoader<SimpleLevelEntityLoaderData>(LevelConstants.TAG_LEVEL)
        {
            public IEntity onLoadEntity(final String pEntityName, final IEntity pParent, final Attributes pAttributes, final SimpleLevelEntityLoaderData pSimpleLevelEntityLoaderData) throws IOException 
            {

                return GameSceneClock.this;
            }
        });
        
        levelLoader.registerEntityLoader(new EntityLoader<SimpleLevelEntityLoaderData>(TAG_ENTITY)
        {
            public IEntity onLoadEntity(final String pEntityName, final IEntity pParent, final Attributes pAttributes, final SimpleLevelEntityLoaderData pSimpleLevelEntityLoaderData) throws IOException
            {
                final int x = SAXUtils.getIntAttributeOrThrow(pAttributes, TAG_ENTITY_ATTRIBUTE_X);
                final int y = SAXUtils.getIntAttributeOrThrow(pAttributes, TAG_ENTITY_ATTRIBUTE_Y);
                final String type = SAXUtils.getAttributeOrThrow(pAttributes, TAG_ENTITY_ATTRIBUTE_TYPE);
                
                final pyramids pyramidLevel;
                
                if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID1))
                {
                	pyramidLevel = new pyramids(1, x, y, resourceController.pyramid1_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(2.0f);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f);
	                	          checkForCollisionsWithPlatform(this, true);
	                	          if(!gameStarted){
	                	        	  startTimer();
	                	          }
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                    mStack1.add(pyramidLevel);
                    pyramidLevel.setmStack(mStack1);
                    pyramidLevel.setmPlatform(platform1);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);

                }
                else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID2))
                {
                	pyramidLevel = new pyramids(2, x, y, resourceController.pyramid2_region, vbom){
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(2.0f);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                    mStack1.add(pyramidLevel);
                    pyramidLevel.setmStack(mStack1);
                    pyramidLevel.setmPlatform(platform1);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);

                }    
                else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID3))
                {
                	pyramidLevel = new pyramids(3, x, y, resourceController.pyramid3_region, vbom){
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(2.0f);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}
                	};
                    mStack1.add(pyramidLevel);
                    pyramidLevel.setmStack(mStack1);
                    pyramidLevel.setmPlatform(platform1);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);

                }    
                else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID4))
                {
                	pyramidLevel = new pyramids(4, x, y, resourceController.pyramid4_region, vbom){
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(2.0f);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                    mStack1.add(pyramidLevel);
                    pyramidLevel.setmStack(mStack1);
                    pyramidLevel.setmPlatform(platform1);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);

                }    
                else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID5))
                {
                	pyramidLevel = new pyramids(5, x, y, resourceController.pyramid5_region, vbom){
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(2.0f);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}
                	};
                    mStack1.add(pyramidLevel);
                    pyramidLevel.setmStack(mStack1);
                    pyramidLevel.setmPlatform(platform1);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);

                }    
                else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID6))
                {
                	pyramidLevel = new pyramids(6, x, y, resourceController.pyramid6_region, vbom){
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(2.0f);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                    mStack1.add(pyramidLevel);
                    pyramidLevel.setmStack(mStack1);
                    pyramidLevel.setmPlatform(platform1);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);

                }    
                else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID7))
                {
                	pyramidLevel = new pyramids(7, x, y, resourceController.pyramid7_region, vbom){
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(2.0f);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                    mStack1.add(pyramidLevel);
                    pyramidLevel.setmStack(mStack1);
                    pyramidLevel.setmPlatform(platform1);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);

                }    
                else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID8))
                {
                	pyramidLevel = new pyramids(8, x, y, resourceController.pyramid8_region, vbom){
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(2.0f);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                    mStack1.add(pyramidLevel);
                    pyramidLevel.setmStack(mStack1);
                    pyramidLevel.setmPlatform(platform1);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);

                }
                else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PLATFORM))
                {
                	pyramidLevel = new pyramids(8, x, y, resourceController.pyramid8_region, vbom);
                	pyramidLevel.setVisible(false);
                	platform = x;
                	blocks = y;

                }
                else
                {
                    throw new IllegalArgumentException();
                }

                pyramidLevel.setCullingEnabled(true);

                return pyramidLevel;
            }
        });

        levelLoader.loadLevelFromAsset(activity.getAssets(), "level/" + levelID + ".lvl");
    }
}