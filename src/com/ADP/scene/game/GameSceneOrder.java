package com.ADP.scene.game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.camera.hud.HUD;
import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.entity.IEntity;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.util.GLState;
import org.andengine.util.SAXUtils;
import org.andengine.util.adt.align.HorizontalAlign;
import org.andengine.util.level.EntityLoader;
import org.andengine.util.level.constants.LevelConstants;
import org.andengine.util.level.simple.SimpleLevelEntityLoaderData;
import org.andengine.util.level.simple.SimpleLevelLoader;
import org.xml.sax.Attributes;

import com.ADP.controller.ResourceController;
import com.ADP.controller.SceneController;
import com.ADP.controller.SceneController.SceneType;
import com.ADP.pyramidmovers.GameActivity;
import com.ADP.pyramidmovers.pyramids;
import com.ADP.scene.GameInstructionWindow;
import com.ADP.template.TemplateScene;
import com.purplebrain.giftiz.sdk.GiftizSDK;

public class GameSceneOrder extends TemplateScene
{
	//Game stat
	private HUD gameHUD;
	private Text scoreText;
	private Text timeText;
	private int score = 0;
	private Stack<pyramids> mStack1, mStack2, mStack3, mStack4, mStack5, mStack6, mStack7;
	private Sprite platform1, platform2, platform3;
    private Sprite gameScene;
    double timeRemaining;
    protected int platform;
	protected int blocks;
	private int pyramid;
    private boolean gameStarted;
	private int moves;
	private float time;
	private IUpdateHandler timer;
	private GameInstructionWindow InstructionWindow;
	private Text scoreText2;
	private Text timeText2;
	private TimerHandler timerFinish;
	private Sprite platform4;
	private Sprite platform5;
	private Sprite platform6;
	private Sprite platform7;
	private ArrayList<pyramids> Stack= new ArrayList<pyramids>(); 
	private float scale;
	private double gameTimeCompletion;
	private Sprite repeat;



    
	//Game LevelLoad
	private static final String TAG_ENTITY = "entity";
	private static final String TAG_ENTITY_ATTRIBUTE_X = "x";
	private static final String TAG_ENTITY_ATTRIBUTE_Y = "y";
	private static final String TAG_ENTITY_ATTRIBUTE_TYPE = "type";
	private static final String TAG_ENTITY_ATTRIBUTE_STACK = "stack";

	    
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID1YELLOW = "pyramidyellow1";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID2YELLOW = "pyramidyellow2";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID3YELLOW = "pyramidyellow3";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID4YELLOW = "pyramidyellow4";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID5YELLOW = "pyramidyellow5";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID6YELLOW = "pyramidyellow6";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID7YELLOW = "pyramidyellow7";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID8YELLOW = "pyramidyellow8";
	
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID1RED = "pyramidred1";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID2RED = "pyramidred2";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID3RED = "pyramidred3";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID4RED = "pyramidred4";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID5RED = "pyramidred5";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID6RED = "pyramidred6";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID7RED = "pyramidred7";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID8RED = "pyramidred8";
	
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID1GREEN = "pyramidgreen1";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID2GREEN = "pyramidgreen2";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID3GREEN = "pyramidgreen3";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID4GREEN = "pyramidgreen4";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID5GREEN = "pyramidgreen5";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID6GREEN = "pyramidgreen6";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID7GREEN = "pyramidgreen7";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID8GREEN = "pyramidgreen8";
	
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID1BLUE = "pyramidblue1";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID2BLUE = "pyramidblue2";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID3BLUE = "pyramidblue3";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID4BLUE = "pyramidblue4";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID5BLUE = "pyramidblue5";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID6BLUE = "pyramidblue6";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID7BLUE = "pyramidblue7";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID8BLUE = "pyramidblue8";
	
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID1ORANGE = "pyramidorange1";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID2ORANGE = "pyramidorange2";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID3ORANGE = "pyramidorange3";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID4ORANGE = "pyramidorange4";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID5ORANGE = "pyramidorange5";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID6ORANGE = "pyramidorange6";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID7ORANGE = "pyramidorange7";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID8ORANGE = "pyramidorange8";
	
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID1PINK = "pyramidpink1";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID2PINK = "pyramidpink2";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID3PINK = "pyramidpink3";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID4PINK = "pyramidpink4";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID5PINK = "pyramidpink5";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID6PINK = "pyramidpink6";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID7PINK = "pyramidpink7";
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID8PINK = "pyramidpink8";
	
	private static final Object TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PLATFORM = "platform";
	

	
	
	private void createStacks(){
		// Create the stacks
		this.mStack1 = new Stack<pyramids>();
		this.mStack2 = new Stack<pyramids>();
		this.mStack3 = new Stack<pyramids>();
		this.mStack4 = new Stack<pyramids>();
		this.mStack5 = new Stack<pyramids>();
		this.mStack6 = new Stack<pyramids>();
		this.mStack7 = new Stack<pyramids>();

		
		this.platform1 = new Sprite(57, 215, resourceController.Orderplatform1_region, vbom);
		this.platform2 = new Sprite(171, 215, resourceController.Orderplatform2_region, vbom);
		this.platform3 = new Sprite(285, 215, resourceController.Orderplatform3_region, vbom);
		this.platform4 = new Sprite(399, 215, resourceController.Orderplatform4_region, vbom);
		this.platform5 = new Sprite(513, 215, resourceController.Orderplatform5_region, vbom);
		this.platform6 = new Sprite(627, 215, resourceController.Orderplatform6_region, vbom);
		this.platform7 = new Sprite(741, 215, resourceController.Orderplatform7_region, vbom);
		
		attachChild(platform1);
		attachChild(platform2);
		attachChild(platform3);
		attachChild(platform4);
		attachChild(platform5);
		attachChild(platform6);
		attachChild(platform7);

		
		platform1.setVisible(false);
		platform2.setVisible(false);
		platform3.setVisible(false);
		platform4.setVisible(false);
		platform5.setVisible(false);
		platform6.setVisible(false);
		platform7.setVisible(false);
	}


	private void createHUD()
	{
	    gameHUD = new HUD();
	    
	    // CREATE SCORE TEXT
	    scoreText = new Text(22, 420, resourceController.font, "Score: 0123456789", new TextOptions(HorizontalAlign.LEFT), vbom);
	    scoreText.setAnchorCenter(0, 0);    
	    scoreText.setText("Moves: 0");
	    gameHUD.attachChild(scoreText);
	    
	 // CREATE TIMER TEXT
	    timeText = new Text(22, 390, resourceController.font, "Time: 0123456789", new TextOptions(HorizontalAlign.LEFT), vbom);
	    timeText.setAnchorCenter(0, 0);    
	    timeText.setText("Time: 0");
	    gameHUD.attachChild(timeText);
	    
	    scoreText2 = new Text(20, 418, resourceController.font, "Score: 0123456789", new TextOptions(HorizontalAlign.LEFT), vbom);
	    scoreText2.setAnchorCenter(0, 0);    
	    scoreText2.setText("Moves: 0");
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
					ResourceController.getInstance().unloadGameTextures(GameSceneOrder.this);
		        	SceneController.getInstance().loadGameSceneOrder(engine);
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
	
	public void startTimer(){
    	if(!gameStarted){
    		timer =  new TimerHandler(1.0f, new ITimerCallback() {
  	       	public void onTimePassed(TimerHandler pTimerHandler) {
  	                       timeRemaining++;
  	                       time++;
  	                       updateTime();
  	                       gameStarted=true;
  	       		
  	       		if (timeRemaining > 0){
  	       			pTimerHandler.reset();
  	       		}
  	       	}
  	       });
    		SceneController.getInstance().engine.registerUpdateHandler(timer);
    	}
    }

	private void addToScore()
	{
		
	    scoreText.setText("Moves: " + moves);
	    scoreText2.setText("Moves: " + moves);

	}
	
	private void addToMoves(float f)
	{
	    moves += f;
	}
	
	
	private void updateTime()
	{
	    timeText.setText("Time: " + timeRemaining);
	    timeText2.setText("Time: " + timeRemaining);

	}
	
    @Override
    public void createScene()
    {
    	createBackground();
        createHUD();
        createStacks();
        gameStarted = false;
        time = 0;
        timeRemaining = 0;
        loadLevel(ResourceController.getInstance().level);
        InstructionWindow = new GameInstructionWindow(vbom,true){
        	@Override
    		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				switch(pSceneTouchEvent.getAction()) {
                case TouchEvent.ACTION_DOWN:
                    break;
                case TouchEvent.ACTION_UP:
      	       		InstructionWindow.removedisplay(GameSceneOrder.this);
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
    

    @Override
    public void onBackKeyPressed()
    {
        ResourceController.getInstance().isGameRunning = false;
        SceneController.getInstance().loadMenuSceneFromOrder(engine, this);
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
    	gameScene = new Sprite(400, 240, resourceController.backgroundOrder_region, vbom)
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
	            (Pyramids.getmWeight() < ((pyramids) mStack1.peek()).getmWeight()) && Pyramids.getmColor() ==  ((pyramids) mStack1.peek()).getmColor())) {
	        stack = mStack1;
	        tower = platform1;
	        addToMoves(1);
            addToScore();
		    ResourceController.getInstance().music.play();

	    } else if (Pyramids.collidesWith(platform2) && (mStack2.size() == 0 || 
	            (Pyramids.getmWeight() < ((pyramids) mStack2.peek()).getmWeight()) && Pyramids.getmColor() ==  ((pyramids) mStack2.peek()).getmColor())) {
	        stack = mStack2;
	        tower = platform2;
	        addToMoves(1);
            addToScore();
		    ResourceController.getInstance().music.play();


	    } else if (Pyramids.collidesWith(platform3) && (mStack3.size() == 0 || 
	    		(Pyramids.getmWeight() < ((pyramids) mStack3.peek()).getmWeight()) && Pyramids.getmColor() ==  ((pyramids) mStack3.peek()).getmColor())) {
	        stack = mStack3;
	        tower = platform3;
	        addToMoves(1);
            addToScore();
		    ResourceController.getInstance().music.play();

	    } else if (Pyramids.collidesWith(platform4) && (mStack4.size() == 0 || 
	    		(Pyramids.getmWeight() < ((pyramids) mStack4.peek()).getmWeight()) && Pyramids.getmColor() ==  ((pyramids) mStack4.peek()).getmColor())) {
	        stack = mStack4;
	        tower = platform4;
	        addToMoves(1);
            addToScore();
		    ResourceController.getInstance().music.play();
	    } else if (Pyramids.collidesWith(platform5) && (mStack5.size() == 0 || 
	    		(Pyramids.getmWeight() < ((pyramids) mStack5.peek()).getmWeight()) && Pyramids.getmColor() ==  ((pyramids) mStack5.peek()).getmColor())) {
	        stack = mStack5;
	        tower = platform5;
	        addToMoves(1);
            addToScore();
		    ResourceController.getInstance().music.play();
	    } else if (Pyramids.collidesWith(platform6) && (mStack6.size() == 0 || 
	    		(Pyramids.getmWeight() < ((pyramids) mStack6.peek()).getmWeight()) && Pyramids.getmColor() ==  ((pyramids) mStack6.peek()).getmColor())) {
	        stack = mStack6;
	        tower = platform6;
	        addToMoves(1);
            addToScore();
		    ResourceController.getInstance().music.play();
		    
	    } else if (Pyramids.collidesWith(platform7) && (mStack7.size() == 0 || 
		    		(Pyramids.getmWeight() < ((pyramids) mStack7.peek()).getmWeight()) && Pyramids.getmColor() ==  ((pyramids) mStack7.peek()).getmColor())) {
		        stack = mStack7;
		        tower = platform7;
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
	   // removePyramidStack(Pyramids.getmPlatform()).pop();
	    stack.add(Pyramids);
	    if(!gameStarted){
      	  startTimer();
        }
	    Pyramids.setmStack(stack);
	    Pyramids.setmPlatform(tower);
	    checkForFinish();
    }
    
    private Stack removePyramidStack(Sprite s) {
    	if(s.getX() == 57){
    		return mStack1;
    	}else if(s.getX() == 171){
    		return mStack2;
    	}else if(s.getX() == 285){
    		return mStack3;
    	}else if(s.getX() == 399){
    		return mStack4;
    	}else if(s.getX() == 513){
    		return mStack5;
    	}else if(s.getX() == 627){
    		return mStack6;
    	}else if(s.getX() == 741){
    		return mStack7;
    	}
		return null;	
	}


	private void checkForFinish(){
    	int i = 0;
    	if(checkStack(mStack1)){
    		i++;
    	}
    	if(checkStack(mStack2)){
    		i++;
    	}
    	if(checkStack(mStack3)){
    		i++;
    	}
    	if(checkStack(mStack4)){
    		i++;
    	}
    	if(checkStack(mStack5)){
    		i++;
    	}
    	if(checkStack(mStack6)){
    		i++;
    	}
    	if(checkStack(mStack7)){
    		i++;
    	}
    	
    	if(i == pyramid){
    		ResourceController.getInstance().currentGameTime = time;
			ResourceController.getInstance().currentGameMoves = moves;
			timerFinish =  new TimerHandler(1.0f, new ITimerCallback() {
	  	       	public void onTimePassed(TimerHandler pTimerHandler) {
	  	       	if(timeRemaining < (gameTimeCompletion))
    				ResourceController.getInstance().setScore(3);
    			else if(timeRemaining < gameTimeCompletion+(gameTimeCompletion/3) )
    				ResourceController.getInstance().setScore(2);
    			else 
        				ResourceController.getInstance().setScore(1);
        			if(((GameActivity) activity).getLevelTime(ResourceController.getInstance().level) > time|| ((GameActivity) activity).getLevelTime(ResourceController.getInstance().level) == 0)
    					((GameActivity) activity).setLevelTime(ResourceController.getInstance().level, Float.toString(time));
        			if(((GameActivity) activity).getLevelScore(ResourceController.getInstance().level) > moves || ((GameActivity) activity).getLevelScore(ResourceController.getInstance().level) == 0)
    					((GameActivity) activity).setLevelScore(ResourceController.getInstance().level, Integer.toString(moves));
        			SceneController.getInstance().engine.unregisterUpdateHandler(timer);
    	       		SceneController.getInstance().engine.unregisterUpdateHandler(timerFinish);
        		    ResourceController.getInstance().game_music.stop();
            		ResourceController.getInstance().isGameRunning = false;
    	            SceneController.getInstance().createGameCompleteScreen(GameSceneOrder.this);
	  	       	}
	  	       });
	    		SceneController.getInstance().engine.registerUpdateHandler(timerFinish);
		}
			
    }
    
    private boolean checkStack (Stack<pyramids> stack){
    	if(!stack.isEmpty()){
    		int num=0;
	    	int color = ((pyramids) stack.peek()).getmColor();
	    	for(pyramids i : stack){
	    		num++;
	    	}
	    	if(num == blocks){
		    	for(pyramids i : stack) {
		    		if(i.getmColor() != color){
		    			return false;
		    		}
		    	}
		    	return true;
	    	}
    	}
		return false;
    }
    
    private void loadLevel(int levelID)
    {
        final SimpleLevelLoader levelLoader = new SimpleLevelLoader(vbom);
        
        
        levelLoader.registerEntityLoader(new EntityLoader<SimpleLevelEntityLoaderData>(LevelConstants.TAG_LEVEL)
        {
            public IEntity onLoadEntity(final String pEntityName, final IEntity pParent, final Attributes pAttributes, final SimpleLevelEntityLoaderData pSimpleLevelEntityLoaderData) throws IOException 
            {

                return GameSceneOrder.this;
            }
        });
        
        levelLoader.registerEntityLoader(new EntityLoader<SimpleLevelEntityLoaderData>(TAG_ENTITY)
        {




			public IEntity onLoadEntity(final String pEntityName, final IEntity pParent, final Attributes pAttributes, final SimpleLevelEntityLoaderData pSimpleLevelEntityLoaderData) throws IOException
            {
                final int x = SAXUtils.getIntAttributeOrThrow(pAttributes, TAG_ENTITY_ATTRIBUTE_X);
                final int y = SAXUtils.getIntAttributeOrThrow(pAttributes, TAG_ENTITY_ATTRIBUTE_Y);
                final int s = SAXUtils.getIntAttributeOrThrow(pAttributes, TAG_ENTITY_ATTRIBUTE_STACK);
                final String type = SAXUtils.getAttributeOrThrow(pAttributes, TAG_ENTITY_ATTRIBUTE_TYPE);
                
                final pyramids pyramidLevel;
                
                if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID1YELLOW))
                {
                	pyramidLevel = new pyramids(1, x, y, resourceController.pyramid1Yellow_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, true);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                    pyramidLevel.setmColor(1);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID2YELLOW))
                {
                	pyramidLevel = new pyramids(2, x, y, resourceController.pyramid2Yellow_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                    pyramidLevel.setmColor(1);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID3YELLOW))
                {
                	pyramidLevel = new pyramids(3, x, y, resourceController.pyramid3Yellow_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                    pyramidLevel.setmColor(1);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);
                	
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID4YELLOW))
                {
                	pyramidLevel = new pyramids(4, x, y, resourceController.pyramid4Yellow_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                    pyramidLevel.setmColor(1);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);	
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID5YELLOW))
                {
                	pyramidLevel = new pyramids(5, x, y, resourceController.pyramid5Yellow_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                    pyramidLevel.setmColor(1);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);
                	
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID6YELLOW))
                {
                	pyramidLevel = new pyramids(6, x, y, resourceController.pyramid6Yellow_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                    pyramidLevel.setmColor(1);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID7YELLOW))
                {
                	pyramidLevel = new pyramids(7, x, y, resourceController.pyramid7Yellow_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                	
                    pyramidLevel.setmColor(1);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID1RED))
                {
                	pyramidLevel = new pyramids(1, x, y, resourceController.pyramid1Red_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, true);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                    pyramidLevel.setmColor(2);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID2RED))
                {
                	pyramidLevel = new pyramids(2, x, y, resourceController.pyramid2Red_region, vbom) {
            		@Override
            		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
            			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
            	            return false;
            			switch(pSceneTouchEvent.getAction()) {
		                 case TouchEvent.ACTION_DOWN:
		                     this.setScale(scale*2);
		                     break;
		                 case TouchEvent.ACTION_UP:
		                     this.setScale(1.0f); this.setScaleX(scale);
                	          checkForCollisionsWithPlatform(this, false);
		                     break;
		                 case TouchEvent.ACTION_MOVE:
		                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
		                     break;
		                 }

            			return true;
            		}

            	};
            	if(s == 1){
                    mStack1.add(pyramidLevel);
                    pyramidLevel.setmStack(mStack1);
                    pyramidLevel.setmPlatform(platform1);

            	}else if(s==2){
                    mStack2.add(pyramidLevel);
                    pyramidLevel.setmStack(mStack2);
                    pyramidLevel.setmPlatform(platform2);

            	}else if(s==3){
                    mStack3.add(pyramidLevel);
                    pyramidLevel.setmStack(mStack3);
                    pyramidLevel.setmPlatform(platform3);

            	}else if(s==4){
                    mStack4.add(pyramidLevel);
                    pyramidLevel.setmStack(mStack4);
                    pyramidLevel.setmPlatform(platform4);

            	}else if(s==5){
                    mStack5.add(pyramidLevel);
                    pyramidLevel.setmStack(mStack5);
                    pyramidLevel.setmPlatform(platform5);

            	}else if(s==6){
                    mStack6.add(pyramidLevel);
                    pyramidLevel.setmStack(mStack6);
                    pyramidLevel.setmPlatform(platform6);

            	}else if(s==7){
                    mStack7.add(pyramidLevel);
                    pyramidLevel.setmStack(mStack7);
                    pyramidLevel.setmPlatform(platform7);
            	}
                pyramidLevel.setmColor(2);
                registerTouchArea(pyramidLevel);
                setTouchAreaBindingOnActionDownEnabled(true);
                setTouchAreaBindingOnActionMoveEnabled(true);
                	
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID3RED))
                {
                	pyramidLevel = new pyramids(3, x, y, resourceController.pyramid3Red_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                    pyramidLevel.setmColor(2);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID4RED))
                {
                	pyramidLevel = new pyramids(4, x, y, resourceController.pyramid4Red_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                    pyramidLevel.setmColor(2);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID5RED))
                {
                	pyramidLevel = new pyramids(5, x, y, resourceController.pyramid5Red_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                    pyramidLevel.setmColor(2);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID6RED))
                {
                	pyramidLevel = new pyramids(6, x, y, resourceController.pyramid6Red_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                    pyramidLevel.setmColor(2);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID7RED))
                {
                	pyramidLevel = new pyramids(7, x, y, resourceController.pyramid7Red_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                    pyramidLevel.setmColor(2);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID1GREEN))
                {
                	pyramidLevel = new pyramids(1, x, y, resourceController.pyramid1Green_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, true);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                    pyramidLevel.setmColor(3);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID2GREEN))
                {
                	pyramidLevel = new pyramids(2, x, y, resourceController.pyramid2Green_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                    pyramidLevel.setmColor(3);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID3GREEN))
                {
                	pyramidLevel = new pyramids(3, x, y, resourceController.pyramid3Green_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                    pyramidLevel.setmColor(3);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID4GREEN))
                {
                	pyramidLevel = new pyramids(4, x, y, resourceController.pyramid4Green_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                    pyramidLevel.setmColor(3);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID5GREEN))
                {
                	pyramidLevel = new pyramids(5, x, y, resourceController.pyramid5Green_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                    pyramidLevel.setmColor(3);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID6GREEN))
                {
                	pyramidLevel = new pyramids(6, x, y, resourceController.pyramid6Green_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                    pyramidLevel.setmColor(3);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID7GREEN))
                {
                	pyramidLevel = new pyramids(7, x, y, resourceController.pyramid7Green_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                    pyramidLevel.setmColor(3);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID1BLUE))
                {
                	pyramidLevel = new pyramids(1, x, y, resourceController.pyramid1Blue_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, true);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                    pyramidLevel.setmColor(4);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID2BLUE))
                {
                	pyramidLevel = new pyramids(2, x, y, resourceController.pyramid2Blue_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                    pyramidLevel.setmColor(4);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID3BLUE))
                {
                	pyramidLevel = new pyramids(3, x, y, resourceController.pyramid3Blue_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                    pyramidLevel.setmColor(4);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID4BLUE))
                {
                	pyramidLevel = new pyramids(4, x, y, resourceController.pyramid4Blue_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                    pyramidLevel.setmColor(4);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID5BLUE))
                {
                	pyramidLevel = new pyramids(5, x, y, resourceController.pyramid5Blue_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                    pyramidLevel.setmColor(4);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID6BLUE))
                {
                	pyramidLevel = new pyramids(6, x, y, resourceController.pyramid6Blue_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                    pyramidLevel.setmColor(4);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID7BLUE))
                {
                	pyramidLevel = new pyramids(7, x, y, resourceController.pyramid7Blue_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                    pyramidLevel.setmColor(4);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID1ORANGE))
                {
                	pyramidLevel = new pyramids(1, x, y, resourceController.pyramid1Orange_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, true);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                    pyramidLevel.setmColor(5);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID2ORANGE))
                {
                	pyramidLevel = new pyramids(2, x, y, resourceController.pyramid2Orange_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                    pyramidLevel.setmColor(5);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID3ORANGE))
                {
                	pyramidLevel = new pyramids(3, x, y, resourceController.pyramid3Orange_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                    pyramidLevel.setmColor(5);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID4ORANGE))
                {
                	pyramidLevel = new pyramids(4, x, y, resourceController.pyramid4Orange_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                    pyramidLevel.setmColor(5);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID5ORANGE))
                {
                	pyramidLevel = new pyramids(5, x, y, resourceController.pyramid5Orange_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                    pyramidLevel.setmColor(5);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID6ORANGE))
                {
                	pyramidLevel = new pyramids(6, x, y, resourceController.pyramid6Orange_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                    pyramidLevel.setmColor(5);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID7ORANGE))
                {
                	pyramidLevel = new pyramids(7, x, y, resourceController.pyramid7Orange_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                    pyramidLevel.setmColor(5);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID1PINK))
                {
                	pyramidLevel = new pyramids(1, x, y, resourceController.pyramid1Pink_region, vbom) {
            		@Override
            		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
            			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
            	            return false;
            			switch(pSceneTouchEvent.getAction()) {
		                 case TouchEvent.ACTION_DOWN:
		                     this.setScale(scale*2);
		                     break;
		                 case TouchEvent.ACTION_UP:
		                     this.setScale(1.0f); this.setScaleX(scale);
                	          checkForCollisionsWithPlatform(this, true);
		                     break;
		                 case TouchEvent.ACTION_MOVE:
		                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
		                     break;
		                 }

            			return true;
            		}

            	};
            	if(s == 1){
                    mStack1.add(pyramidLevel);
                    pyramidLevel.setmStack(mStack1);
                    pyramidLevel.setmPlatform(platform1);

            	}else if(s==2){
                    mStack2.add(pyramidLevel);
                    pyramidLevel.setmStack(mStack2);
                    pyramidLevel.setmPlatform(platform2);

            	}else if(s==3){
                    mStack3.add(pyramidLevel);
                    pyramidLevel.setmStack(mStack3);
                    pyramidLevel.setmPlatform(platform3);

            	}else if(s==4){
                    mStack4.add(pyramidLevel);
                    pyramidLevel.setmStack(mStack4);
                    pyramidLevel.setmPlatform(platform4);

            	}else if(s==5){
                    mStack5.add(pyramidLevel);
                    pyramidLevel.setmStack(mStack5);
                    pyramidLevel.setmPlatform(platform5);

            	}else if(s==6){
                    mStack6.add(pyramidLevel);
                    pyramidLevel.setmStack(mStack6);
                    pyramidLevel.setmPlatform(platform6);

            	}else if(s==7){
                    mStack7.add(pyramidLevel);
                    pyramidLevel.setmStack(mStack7);
                    pyramidLevel.setmPlatform(platform7);
            	}
                pyramidLevel.setmColor(6);
                registerTouchArea(pyramidLevel);
                setTouchAreaBindingOnActionDownEnabled(true);
                setTouchAreaBindingOnActionMoveEnabled(true);
                	
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID2PINK))
                {
                	pyramidLevel = new pyramids(2, x, y, resourceController.pyramid2Pink_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                    pyramidLevel.setmColor(6);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID3PINK))
                {
                	pyramidLevel = new pyramids(3, x, y, resourceController.pyramid3Pink_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                    pyramidLevel.setmColor(6);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID4PINK))
                {
                	pyramidLevel = new pyramids(4, x, y, resourceController.pyramid4Pink_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                    pyramidLevel.setmColor(6);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID5PINK))
                {
                	pyramidLevel = new pyramids(5, x, y, resourceController.pyramid5Pink_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                    pyramidLevel.setmColor(6);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID6PINK))
                {
                	pyramidLevel = new pyramids(6, x, y, resourceController.pyramid6Pink_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                    pyramidLevel.setmColor(6);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);
                }else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PYRAMID7PINK))
                {
                	pyramidLevel = new pyramids(7, x, y, resourceController.pyramid7Pink_region, vbom) {
                		@Override
                		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                			if (((pyramids) this.getmStack().peek()).getmWeight() != this.getmWeight())
                	            return false;
                			switch(pSceneTouchEvent.getAction()) {
			                 case TouchEvent.ACTION_DOWN:
			                     this.setScale(scale*2);
			                     break;
			                 case TouchEvent.ACTION_UP:
			                     this.setScale(1.0f); this.setScaleX(scale);
	                	          checkForCollisionsWithPlatform(this, false);
			                     break;
			                 case TouchEvent.ACTION_MOVE:
			                     this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
			                     break;
			                 }

                			return true;
                		}

                	};
                	if(s == 1){
                        mStack1.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack1);
                        pyramidLevel.setmPlatform(platform1);

                	}else if(s==2){
                        mStack2.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack2);
                        pyramidLevel.setmPlatform(platform2);

                	}else if(s==3){
                        mStack3.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack3);
                        pyramidLevel.setmPlatform(platform3);

                	}else if(s==4){
                        mStack4.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack4);
                        pyramidLevel.setmPlatform(platform4);

                	}else if(s==5){
                        mStack5.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack5);
                        pyramidLevel.setmPlatform(platform5);

                	}else if(s==6){
                        mStack6.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack6);
                        pyramidLevel.setmPlatform(platform6);

                	}else if(s==7){
                        mStack7.add(pyramidLevel);
                        pyramidLevel.setmStack(mStack7);
                        pyramidLevel.setmPlatform(platform7);
                	}
                    pyramidLevel.setmColor(6);
                    registerTouchArea(pyramidLevel);
                    setTouchAreaBindingOnActionDownEnabled(true);
                    setTouchAreaBindingOnActionMoveEnabled(true);
                }
                else if (type.equals(TAG_ENTITY_ATTRIBUTE_TYPE_VALUE_PLATFORM))
                {
                	pyramidLevel = new pyramids(8, x, y, resourceController.pyramid1Blue_region, vbom);
                	pyramidLevel.setVisible(false);
                	gameTimeCompletion = x;
                	blocks = y;
                	pyramid = s;

                }
                else
                {
                    throw new IllegalArgumentException();
                }

                pyramidLevel.setCullingEnabled(true);
                
                if(blocks > 4){
                	pyramidLevel.setScaleX(0.5f);
                	scale = (float) 0.5;
                }else{
                	pyramidLevel.setScaleX(1.0f);
                	scale = (float) 1.0;
                }
                return pyramidLevel;
            }
        });

        levelLoader.loadLevelFromAsset(activity.getAssets(), "levelOrder/" + levelID + ".lvl");
    }

}
