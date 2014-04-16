package com.ADP.controller;

import org.andengine.engine.Engine;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.ui.IGameInterface.OnCreateSceneCallback;

import com.ADP.scene.GameLostScene;
import com.ADP.scene.LevelCompleteScene;
import com.ADP.scene.LoadingScene;
import com.ADP.scene.MainMenuScene;
import com.ADP.scene.ScoreShareScene;
import com.ADP.scene.SplashScene;
import com.ADP.scene.game.GameOptionScene;
import com.ADP.scene.game.GameOrderOptionScene;
import com.ADP.scene.game.GameSceneClock;
import com.ADP.scene.game.GameSceneMode;
import com.ADP.scene.game.GameSceneOrder;
import com.ADP.scene.game.GameSceneSteps;
import com.ADP.scene.game.GameTypeScene;
import com.ADP.template.TemplateScene;
import com.ADP.scene.HighScoreScene;


/**
 * 
 * @author Ashar Shoaib
 * @version 1.0
 *
 */

public class SceneController {

	//Scenes
	
	private TemplateScene splashScene;
	private TemplateScene menuScene;
	private TemplateScene gameSceneSteps;
	private TemplateScene gameSceneClock;
	private TemplateScene loadingScene;
	private TemplateScene gameOptionScene;
	private TemplateScene gameTypeScene;
	private TemplateScene gameComplete;
	private TemplateScene HighScoreScene;
	private TemplateScene ShareScoreScene;
	private TemplateScene gameLost;
	private TemplateScene gameSceneOrder;




	
	//Variables
	
	private static final SceneController INSTANCE = new SceneController();
	private SceneType currentSceneType = SceneType.SCENE_SPLASH;
	private TemplateScene currentScene;
	public Engine engine = ResourceController.getInstance().engine;

	public enum SceneType{
		SCENE_SPLASH,
		SCENE_GAMEOPTION,
		SCENE_GAMETYPE,
		SCENE_MENU,
		SCENE_GAME_STEPS,
		SCENE_GAME_CLOCK,
		SCENE_LOADING,
		SCENE_COMPLETE,
		SCENE_HIGHSCORE,
		SCENE_SHARESCORE, 
		SCENE_LOST,
		SCENE_GAME_ORDER
	}
	
	//Class
	
	public void setScene(TemplateScene scene){
		engine.setScene(scene);
		currentScene = scene;
		currentSceneType = scene.getSceneType();
	}	
	
	public void setScene(SceneType sceneType){
		
		switch (sceneType){
		case SCENE_MENU:
			setScene(menuScene);
			break;
		case SCENE_GAME_STEPS:
			setScene(gameSceneSteps);
			break;
		case SCENE_GAME_CLOCK:
			setScene(gameSceneClock);
			break;
		case SCENE_SPLASH:
			setScene(splashScene);
			break;
		case SCENE_LOADING:
			setScene(loadingScene);
			break;
		case SCENE_GAMEOPTION:
			setScene(gameOptionScene);
			break;
		case SCENE_GAMETYPE:
			setScene(gameTypeScene);
			break;
		case SCENE_COMPLETE:
			setScene(gameComplete);
			break;
		case SCENE_HIGHSCORE:
			setScene(HighScoreScene);
			break;
		case SCENE_SHARESCORE:
			setScene(ShareScoreScene);
			break;
		case SCENE_LOST:
			setScene(gameLost);
			break;
		case SCENE_GAME_ORDER:
			setScene(gameSceneOrder);
			break;
		default:
			break;
		}
	}
		//Create Scenes
			public void createSplashScene(OnCreateSceneCallback pOnCreateSceneCallback){
				ResourceController.getInstance().loadSplashScreen();
				splashScene = new SplashScene();
				currentScene = splashScene;
				pOnCreateSceneCallback.onCreateSceneFinished(splashScene);
			}
			
			public void createMenuScene()
			{
			    ResourceController.getInstance().loadMenuResource();
			    menuScene = new MainMenuScene();
			    createLoadScreen();
			    SceneController.getInstance().setScene(menuScene);
				currentScene = menuScene;
			    disposeSplashScene();
			}
			
			public void createLoadScreen()
			{
			    ResourceController.getInstance().loadLoadingScreen();
			    loadingScene = new LoadingScene();

			}
			public void createGameOptionScreen()
			{
			    ResourceController.getInstance().loadGameOptionResource();
			    gameOptionScene = new GameOptionScene();
				currentScene = gameOptionScene;
			    SceneController.getInstance().setScene(gameOptionScene);

			}
			
			public void createGameOrderOptionScreen()
			{
			    ResourceController.getInstance().loadGameOptionOrderResource();
			    gameOptionScene = new GameOrderOptionScene();
				currentScene = gameOptionScene;
			    SceneController.getInstance().setScene(gameOptionScene);

			}
			public void createGameTypeScreen()
			{
			    ResourceController.getInstance().loadGameTypeResource();
			    gameTypeScene = new GameTypeScene();
				currentScene = gameTypeScene;
			    SceneController.getInstance().setScene(gameTypeScene);
			}
			
			public void createGameModeScreen()
			{
			    ResourceController.getInstance().loadGameTypeOrderResource();
			    gameTypeScene = new GameSceneMode();
				currentScene = gameTypeScene;
			    SceneController.getInstance().setScene(gameTypeScene);
			}
			public void createShareScoreScreen()
			{
			    ResourceController.getInstance().loadShareSceneGraphics();
			    ShareScoreScene = new ScoreShareScene();
				currentScene = ShareScoreScene;
			    SceneController.getInstance().setScene(ShareScoreScene);
			}
			
			public void createHighScoreScreen() {
				HighScoreScene = new HighScoreScene();
				currentScene = HighScoreScene;
			    SceneController.getInstance().setScene(HighScoreScene);
			}
			
			public void createGameScreenOrder() {
				gameSceneOrder = new GameSceneOrder();
				currentScene = gameSceneOrder;
			}
			
			public void loadGameSceneSteps(final Engine mEngine)
			{
			    setScene(loadingScene);
			    if(ResourceController.getInstance().isGameRunning){
				    ResourceController.getInstance().unloadMenuTextures();
				    ResourceController.getInstance().unloadGameOptionTextures();
				    ResourceController.getInstance().unloadGameTypeTextures();
				    ResourceController.getInstance().unloadGameModeTextures();
			    }
			    mEngine.registerUpdateHandler(new TimerHandler(0.1f, new ITimerCallback() 
			    {
			        public void onTimePassed(final TimerHandler pTimerHandler) 
			        {
			            mEngine.unregisterUpdateHandler(pTimerHandler);
			            ResourceController.getInstance().loadGameResources();
			            gameSceneSteps = new GameSceneSteps();
						currentScene = gameSceneSteps;
			            setScene(gameSceneSteps);
			        }
			    }));
			}
			
			public void loadGameSceneClock(final Engine mEngine)
			{
			    setScene(loadingScene);
			    if(ResourceController.getInstance().isGameRunning){
				    ResourceController.getInstance().unloadMenuTextures();
				    ResourceController.getInstance().unloadGameOptionTextures();
				    ResourceController.getInstance().unloadGameTypeTextures();
				    ResourceController.getInstance().unloadGameModeTextures();
			    }

			    mEngine.registerUpdateHandler(new TimerHandler(0.1f, new ITimerCallback() 
			    {
			        public void onTimePassed(final TimerHandler pTimerHandler) 
			        {
			            mEngine.unregisterUpdateHandler(pTimerHandler);
			            ResourceController.getInstance().loadGameResources();
			            gameSceneClock = new GameSceneClock();
						currentScene = gameSceneClock;
			            setScene(gameSceneClock);
			            
			        }
			    }));
			}
			
			
			public void loadGameSceneOrder(final Engine mEngine)
			{
			    setScene(loadingScene);
			    if(ResourceController.getInstance().isGameRunning){
				    ResourceController.getInstance().unloadMenuTextures();
				    ResourceController.getInstance().unloadGameOptionTextures();
				    if(ResourceController.getInstance().LevelTypeTextureAtlas != null)
				    	ResourceController.getInstance().unloadGameTypeTextures();
				    ResourceController.getInstance().unloadGameModeTextures();
			    }
			    mEngine.registerUpdateHandler(new TimerHandler(0.1f, new ITimerCallback() 
			    {
			        public void onTimePassed(final TimerHandler pTimerHandler) 
			        {
			            mEngine.unregisterUpdateHandler(pTimerHandler);
			            ResourceController.getInstance().loadGameOrderResources();
			            gameSceneOrder = new GameSceneOrder();
						currentScene = gameSceneOrder;
			            setScene(gameSceneOrder);
			        }
			    }));
			}
			
			
			public void createGameCompleteScreen(TemplateScene scene)
			{
				if(ResourceController.getInstance().gameMode == false){
					ResourceController.getInstance().unloadGameTextures(scene);
				}else{
					ResourceController.getInstance().unloadGameOrderTextures(scene);
				}
			    ResourceController.getInstance().loadGameCompleteResource();
			    gameComplete = new LevelCompleteScene();
				currentScene = gameComplete;
			    SceneController.getInstance().setScene(gameComplete);
			}
			
			public void createGameLost(TemplateScene scene)
			{
				ResourceController.getInstance().unloadGameTextures(scene);
				ResourceController.getInstance().loadGameLostResources();
			    gameLost = new GameLostScene();
				currentScene = gameLost;
			    SceneController.getInstance().setScene(gameLost);
			}
			
			public void loadMenuScene(final Engine mEngine, TemplateScene game)
			{
			    setScene(loadingScene);
			    if(ResourceController.getInstance().gameTextureAtlas != null){
			    	ResourceController.getInstance().unloadGameTextures(game);
			    }else
			    if(ResourceController.getInstance().gameOrderTextureAtlas != null){
			    	ResourceController.getInstance().unloadGameOrderTextures(game);
			    }
			    mEngine.registerUpdateHandler(new TimerHandler(0.1f, new ITimerCallback() 
			    {
			        public void onTimePassed(final TimerHandler pTimerHandler) 
			        {
			            mEngine.unregisterUpdateHandler(pTimerHandler);
			            ResourceController.getInstance().loadMenuResource();

			            ResourceController.getInstance().loadGameTypeOrderResource();
					    gameTypeScene = new GameSceneMode();
			            
					    menuScene = new MainMenuScene();
						currentScene = menuScene;
						createGameOptionScreen();	
						}
			    }));
			}
			
			public void loadMenuSceneFromOrder(final Engine mEngine, TemplateScene game)
			{
			    setScene(loadingScene);
			    if(ResourceController.getInstance().gameTextureAtlas != null){
			    	ResourceController.getInstance().unloadGameTextures(game);
			    }else
			    if(ResourceController.getInstance().gameOrderTextureAtlas != null){
			    	ResourceController.getInstance().unloadGameOrderTextures(game);
			    }
			    mEngine.registerUpdateHandler(new TimerHandler(0.1f, new ITimerCallback() 
			    {
			        public void onTimePassed(final TimerHandler pTimerHandler) 
			        {
			            mEngine.unregisterUpdateHandler(pTimerHandler);
			            ResourceController.getInstance().loadMenuResource();
			            ResourceController.getInstance().loadGameTypeOrderResource();
					    gameTypeScene = new GameSceneMode();
					    
					    menuScene = new MainMenuScene();
						currentScene = menuScene;
						createGameOrderOptionScreen();			        
						}
			    }));
			}

			public void loadMenuSceneFromOptions()
			{
				currentScene = menuScene;
				SceneController.getInstance().setScene(menuScene);
			}
			
			public void loadGameOptionScene()
			{
				currentScene = gameOptionScene;
				setScene(gameOptionScene);
			}
			public void loadGameSceneMode() {
				currentScene = gameTypeScene;
				setScene(gameTypeScene);				
			}
			public void loadGameSceneModeFromOptions() {
			    gameTypeScene = new GameSceneMode();
				currentScene = gameTypeScene;
				setScene(gameTypeScene);				
			}
			public void loadGameOrderOptionScene() {
				currentScene = gameOptionScene;
			    SceneController.getInstance().setScene(gameOptionScene);				
			}

			
		//Dispose Scenes
			public void disposeSplashScene(){
				ResourceController.getInstance().unloadSplashScreen();
				splashScene.dispose();
				splashScene = null;
			}
	
	//Getters and Setters
	
	public static SceneController getInstance(){
		return INSTANCE;
	}
	
	public SceneType getCurrectSceneTyper(){
		return currentSceneType;
	}
	
	public TemplateScene getCurrentScene(){
		return currentScene;
	}

	
	

	
	
}
