package com.ADP.controller;

import java.io.IOException;
import java.util.Random;

import org.andengine.audio.music.Music;
import org.andengine.audio.music.MusicFactory;
import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.engine.camera.hud.HUD;
import org.andengine.entity.sprite.TiledSprite;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder.TextureAtlasBuilderException;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.debug.Debug;

import android.graphics.Color;
import android.view.View;

import com.ADP.pyramidmovers.FacebookManager;
import com.ADP.pyramidmovers.GameActivity;
import com.ADP.template.TemplateScene;
import com.purplebrain.giftiz.sdk.GiftizSDK;

/**
 * 
 * @author Ashar Shoaib
 * @version 1.0
 *
 */

public class ResourceController {
	
	//Variables 
	
	private static final ResourceController INSTANCE = new ResourceController();

    
    public Engine engine;
    public GameActivity activity;
    public Camera camera;
    public VertexBufferObjectManager vbom;
    
	//Textures & Fonts
    	//Splash
	    public ITextureRegion splash_region
	    ;
	    private BitmapTextureAtlas splashTextureAtlas;
	    public Font font;
	    
	    //Game Menu
	    public ITextureRegion menu_background_region;
	    public ITextureRegion play_region;
	    public ITextureRegion options_region;
		public ITextureRegion creditsWindow;

	        
	    public BuildableBitmapTextureAtlas menuTextureAtlas;
	    
	    //Game Loading Screen
	    public ITextureRegion loading_background_region;
	    private BuildableBitmapTextureAtlas loadingTextureAtlas;
	    
	 // Game Options
	    public BuildableBitmapTextureAtlas LevelChooseTextureAtlas;
	    public BuildableBitmapTextureAtlas LevelTypeTextureAtlas;
	    public ITextureRegion gameoption_background_region;
	    public ITextureRegion gametype_background_region;
	    public ITiledTextureRegion Level_1;
	    public ITiledTextureRegion Level_2;
	    public ITiledTextureRegion Level_3;
	    public ITiledTextureRegion Level_4;
	    public ITiledTextureRegion Level_5;
	    public ITextureRegion Timer;
	    public ITextureRegion Steps;
	    public int level;
	    public int GameType;

	    
	    
	 // Game Texture
	    public BuildableBitmapTextureAtlas gameTextureAtlas;
	    public BuildableBitmapTextureAtlas gamecompleteTextureAtlas;
	    public BuildableBitmapTextureAtlas starTextureAtlas;


	        
	    // Game Texture Regions
	    public ITextureRegion platform1_region;
	    public ITextureRegion platform2_region;
	    public ITextureRegion platform3_region;
	    public ITextureRegion background_region;
	    public ITextureRegion pyramid1_region;
	    public ITextureRegion pyramid2_region;
	    public ITextureRegion pyramid3_region;
	    public ITextureRegion pyramid4_region;
	    public ITextureRegion pyramid5_region;
	    public ITextureRegion pyramid6_region;
	    public ITextureRegion pyramid7_region;
	    public ITextureRegion pyramid8_region;
	    public Music music;
	    public Music menu_music;
	    public Music game_music;
	    public Music buttonclick;
	    public Music levelComplete;
	    Random random = new Random();

	    




	    
	 // Level Complete Window
	    public ITextureRegion complete_window_region;
	    public ITextureRegion complete_window_region2;
	    public ITextureRegion complete_window_region3;
	    public ITiledTextureRegion complete_stars_region;

		public int score;

		public TiledTextureRegion invisibleButton_region;

		private BuildableBitmapTextureAtlas LevelChooseButtonsTextureAtlas;

		private BuildableBitmapTextureAtlas gameInstructionTextureAtlas;

		public TextureRegion gameInstructions;


		private BuildableBitmapTextureAtlas creditTextureAtlas;


		public TiledTextureRegion soundbutton_region;


		public TiledTextureRegion musicbutton_region;
		
		public boolean soundFlag = true;
		public boolean musicFlag = true;
		public boolean isGameRunning = false;


		public TextureRegion HighScore;
		public TextureRegion HighScoreButton;


		public TiledTextureRegion Level_6;


		public TextureRegion LevelLock;


		public TextureRegion typeLockButton;
		
		public HUD soundHUD;
		public TiledSprite soundButton;
		public TiledSprite musicButton;
		
		public boolean isloggedFacebook;
		public boolean gameType, gameMode;
		public int currentGameMoves;
		public float currentGameTime;


		private BuildableBitmapTextureAtlas shareTextureAtlas;


		public TextureRegion shareButton_region;


		public TextureRegion shareBackground_region;


		public TextureRegion emailbutton_region;


		public TextureRegion ratebutton_region;


		public TextureRegion Invitebutton_region;


		public TextureRegion Likebutton_region;


		private BuildableBitmapTextureAtlas gameLostTextureAtlas;


		public TextureRegion lostBackground_region;


		public TextureRegion tryagainButton_region;


		public TextureRegion quitButton_region;


		public TextureRegion backgroundOrder_region;


		public TextureRegion Orderplatform1_region;


		public TextureRegion Orderplatform2_region;


		public TextureRegion Orderplatform3_region;


		public TextureRegion Orderplatform4_region;


		public TextureRegion Orderplatform5_region;


		public TextureRegion Orderplatform6_region;


		public TextureRegion Orderplatform7_region;


		public BuildableBitmapTextureAtlas gameOrderTextureAtlas;


		public TextureRegion gameOrderInstructions;


		private BuildableBitmapTextureAtlas gameOrderInstructionTextureAtlas;


		private BuildableBitmapTextureAtlas gameOrderPyramidTextureAtlas;


		public TextureRegion pyramid1Yellow_region;


		public TextureRegion pyramid2Yellow_region;


		public TextureRegion pyramid3Yellow_region;


		public TextureRegion pyramid4Yellow_region;


		public TextureRegion pyramid5Yellow_region;


		public TextureRegion pyramid6Yellow_region;


		public TextureRegion pyramid7Yellow_region;


		public TextureRegion pyramid8Yellow_region;


		public TextureRegion pyramid1Red_region;


		public TextureRegion pyramid2Red_region;


		public TextureRegion pyramid3Red_region;


		public TextureRegion pyramid4Red_region;


		public TextureRegion pyramid5Red_region;


		public TextureRegion pyramid6Red_region;


		public TextureRegion pyramid7Red_region;


		public TextureRegion pyramid8Red_region;


		public TextureRegion pyramid1Green_region;


		public TextureRegion pyramid2Green_region;


		public TextureRegion pyramid3Green_region;


		public TextureRegion pyramid4Green_region;


		public TextureRegion pyramid5Green_region;


		public TextureRegion pyramid6Green_region;


		public TextureRegion pyramid7Green_region;


		public TextureRegion pyramid8Green_region;


		public TextureRegion pyramid1Blue_region;


		public TextureRegion pyramid2Blue_region;


		public TextureRegion pyramid3Blue_region;


		public TextureRegion pyramid4Blue_region;


		public TextureRegion pyramid5Blue_region;


		public TextureRegion pyramid6Blue_region;


		public TextureRegion pyramid7Blue_region;


		public TextureRegion pyramid8Blue_region;


		public TextureRegion pyramid1Orange_region;


		public TextureRegion pyramid2Orange_region;


		public TextureRegion pyramid3Orange_region;


		public TextureRegion pyramid4Orange_region;


		public TextureRegion pyramid5Orange_region;


		public TextureRegion pyramid6Orange_region;


		public TextureRegion pyramid7Orange_region;


		public TextureRegion pyramid8Orange_region;


		public TextureRegion pyramid1Pink_region;


		public TextureRegion pyramid2Pink_region;


		public TextureRegion pyramid3Pink_region;


		public TextureRegion pyramid4Pink_region;


		public TextureRegion pyramid5Pink_region;


		public TextureRegion pyramid6Pink_region;


		public TextureRegion pyramid7Pink_region;


		public TextureRegion pyramid8Pink_region;


		private BuildableBitmapTextureAtlas gameOrderPlatformTextureAtlas;


		public TiledTextureRegion Level_9;


		public TiledTextureRegion Level_10;


		public TiledTextureRegion Level_7;


		public TiledTextureRegion Level_8;


		private BuildableBitmapTextureAtlas LevelTypeOrderTextureAtlas;
		
		public boolean isLiked;


		public TextureRegion Giftizbutton_region;


		public TextureRegion nextbutton_region;


		public TextureRegion backbutton_region;


		private BuildableBitmapTextureAtlas GiftizTextureAtlas;


		public TextureRegion Giftizbutton_region2;


		public TextureRegion Giftizbutton_region3;


		public TextureRegion gamerepeat_region;

		
		
	//Class
		public void setScore(int i){
			score=i;
		}
	
		//Resource Loading
	    
	
			// Menu 
	
			public void loadMenuResource(){
				
				loadMenuGraphics();
			    loadMenuAudio();
			    loadMenuFonts();
				loadMenuGiftizGraphics();
			    //FacebookManager.checkUserLoggedIn();
			    isloggedFacebook = FacebookManager.useFacebook;
			}
			
			public void loadMenuGraphics(){
				BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
				menuTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
				menu_background_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, activity, "MainMenu.png");
				play_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, activity, "PlayButton.png");
				options_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, activity, "OptionButton.png");
				soundbutton_region = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(menuTextureAtlas, activity, "soundButton.png", 2, 1);
				musicbutton_region =BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(menuTextureAtlas, activity, "musicButton.png", 2, 1); 
				emailbutton_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, activity, "EmailButton.png");
				ratebutton_region =BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, activity, "RateButton.png"); 
				Invitebutton_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, activity, "InviteButton.png");
				Likebutton_region =BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, activity, "LikeButton.png"); 
				try 
				{
				    this.menuTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
				    this.menuTextureAtlas.load();
				} 
				catch (final TextureAtlasBuilderException e)
				{
				        Debug.e(e);
				}
				
			
					
				
				BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
				creditTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
				creditsWindow = BitmapTextureAtlasTextureRegionFactory.createFromAsset(creditTextureAtlas, activity, "credits.png");
				HighScore = BitmapTextureAtlasTextureRegionFactory.createFromAsset(creditTextureAtlas, activity, "HighScore.png");
				try 
				{
				    this.creditTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
				    this.creditTextureAtlas.load();
				} 
				catch (final TextureAtlasBuilderException e)
				{
				        Debug.e(e);
				}


			}
			
			public void loadMenuGiftizGraphics(){
				BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
				GiftizTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);

		        	Giftizbutton_region =BitmapTextureAtlasTextureRegionFactory.createFromAsset(GiftizTextureAtlas, activity, "giftiz_logo.png"); 
		      
		        	Giftizbutton_region2 =BitmapTextureAtlasTextureRegionFactory.createFromAsset(GiftizTextureAtlas, activity, "giftiz_logo_badge.png"); 
		      
		        	Giftizbutton_region3 =BitmapTextureAtlasTextureRegionFactory.createFromAsset(GiftizTextureAtlas, activity, "giftiz_logo_warning.png"); 
		        
				try 
				{
				    this.GiftizTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
				    this.GiftizTextureAtlas.load();
				} 
				catch (final TextureAtlasBuilderException e)
				{
				        Debug.e(e);
				}
			}
			public void loadMenuAudio(){
				MusicFactory.setAssetBasePath("sound/");
				try
				{
					menu_music = MusicFactory.createMusicFromAsset(engine.getMusicManager(), activity, "menu_music.ogg");
					buttonclick = MusicFactory.createMusicFromAsset(engine.getMusicManager(), activity, "button_click.ogg");
				}
				catch (IOException e)
				{
				    e.printStackTrace();
				}
			}
			
			//Loading Screen
			
			public void loadLoadingScreen(){
				BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
				loadingTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
				
				loading_background_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(loadingTextureAtlas, activity, "LoadingScreen.png");       
				try 
				{
				    this.loadingTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
				    this.loadingTextureAtlas.load();
				} 
				catch (final TextureAtlasBuilderException e)
				{
				        Debug.e(e);
				}
			}
			
			// Game Type Menu
			public void loadGameTypeOrderResource() {
				// TODO Auto-generated method stub
				GameType=0;
				loadGameTypeOrderGraphics();
				loadGameTypeOrderAudio();
			}
			
			public void loadGameTypeOrderGraphics(){
				BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
				LevelTypeOrderTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
				Timer = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LevelTypeOrderTextureAtlas, activity, "LevelModeOrder.png");
				Steps = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LevelTypeOrderTextureAtlas, activity, "LevelModeNormal.png");
				gametype_background_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LevelTypeOrderTextureAtlas, activity, "LevelChooseMode.png");
				typeLockButton = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LevelTypeOrderTextureAtlas, activity, "TypeButtonLock.png");
				try 
				{
				    this.LevelTypeOrderTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
				    this.LevelTypeOrderTextureAtlas.load();
				} 
				catch (final TextureAtlasBuilderException e)
				{
				        Debug.e(e);
				}

			}
			
			public void loadGameTypeOrderAudio(){
				
			}
					public void loadGameTypeResource(){
						
						GameType=0;
						loadGameTypeGraphics();
						loadGameTypeAudio();
					}
					
					public void loadGameTypeGraphics(){
						BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
						LevelTypeTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
						Timer = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LevelTypeTextureAtlas, activity, "LevelTypeClock.png");
						Steps = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LevelTypeTextureAtlas, activity, "LevelType.png");
						gametype_background_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LevelTypeTextureAtlas, activity, "LevelTypeScene.png");
						typeLockButton = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LevelTypeTextureAtlas, activity, "TypeButtonLock.png");
						try 
						{
						    this.LevelTypeTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
						    this.LevelTypeTextureAtlas.load();
						} 
						catch (final TextureAtlasBuilderException e)
						{
						        Debug.e(e);
						}

					}
					
					public void loadGameTypeAudio(){
						
					}
					
			// Game Options Menu
					
					public void loadGameOptionResource(){
						
						level = 0;
						loadGameOptionGraphics();
						loadGameOptionAudio();
					}
					
					public void loadGameOptionGraphics(){
						BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
						LevelChooseTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
						Level_5 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(LevelChooseTextureAtlas, activity, "LevelButton5.png", 2, 2);
						Level_6 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(LevelChooseTextureAtlas, activity, "LevelButton6.png", 2, 2);
						gameoption_background_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LevelChooseTextureAtlas, activity, "LevelChooseScene.png");
						HighScoreButton = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LevelChooseTextureAtlas, activity, "HighScoreButton.png");
						LevelLock = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LevelChooseTextureAtlas, activity, "LevelButtonLock.png");
						try 
						{
						    this.LevelChooseTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
						    this.LevelChooseTextureAtlas.load();
						} 
						catch (final TextureAtlasBuilderException e)
						{
						        Debug.e(e);
						}
						
						BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
						LevelChooseButtonsTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
						Level_1 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(LevelChooseButtonsTextureAtlas, activity, "LevelButton.png", 2, 2);
						Level_2 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(LevelChooseButtonsTextureAtlas, activity, "LevelButton2.png", 2, 2);
						Level_3 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(LevelChooseButtonsTextureAtlas, activity, "LevelButton3.png", 2, 2);
						Level_4 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(LevelChooseButtonsTextureAtlas, activity, "LevelButton4.png", 2, 2);
						
						try 
						{
						    this.LevelChooseButtonsTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
						    this.LevelChooseButtonsTextureAtlas.load();
						} 
						catch (final TextureAtlasBuilderException e)
						{
						        Debug.e(e);
						}

					}
					
					public void loadGameOptionAudio(){
						
					}
					

					public void loadGameOptionOrderResource(){
						
						level = 0;
						loadGameOptionOrderGraphics();
						loadGameOptionOrderAudio();
					}
					
					public void loadGameOptionOrderGraphics(){
						BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
						LevelChooseTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
						Level_9 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(LevelChooseTextureAtlas, activity, "LevelButton9.png", 2, 2);
						Level_10 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(LevelChooseTextureAtlas, activity, "LevelButton10.png", 2, 2);
						gameoption_background_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LevelChooseTextureAtlas, activity, "LevelChooseScene.png");
						HighScoreButton = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LevelChooseTextureAtlas, activity, "HighScoreButton.png");
						LevelLock = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LevelChooseTextureAtlas, activity, "LevelButtonLock.png");
						try 
						{
						    this.LevelChooseTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
						    this.LevelChooseTextureAtlas.load();
						} 
						catch (final TextureAtlasBuilderException e)
						{
						        Debug.e(e);
						}
						
						BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
						LevelChooseButtonsTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
						Level_1 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(LevelChooseButtonsTextureAtlas, activity, "LevelButton.png", 2, 2);
						Level_2 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(LevelChooseButtonsTextureAtlas, activity, "LevelButton2.png", 2, 2);
						Level_3 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(LevelChooseButtonsTextureAtlas, activity, "LevelButton3.png", 2, 2);
						Level_4 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(LevelChooseButtonsTextureAtlas, activity, "LevelButton4.png", 2, 2);
						Level_5 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(LevelChooseButtonsTextureAtlas, activity, "LevelButton5.png", 2, 2);
						Level_6 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(LevelChooseButtonsTextureAtlas, activity, "LevelButton6.png", 2, 2);
						Level_7 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(LevelChooseButtonsTextureAtlas, activity, "LevelButton7.png", 2, 2);
						Level_8 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(LevelChooseButtonsTextureAtlas, activity, "LevelButton8.png", 2, 2);
						
						try 
						{
						    this.LevelChooseButtonsTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
						    this.LevelChooseButtonsTextureAtlas.load();
						} 
						catch (final TextureAtlasBuilderException e)
						{
						        Debug.e(e);
						}

					}
					
					public void loadGameOptionOrderAudio(){
						
					}
			
			//Game
			
			public void loadMenuFonts()
		    {
		        FontFactory.setAssetBasePath("font/");
		        final ITexture fontTexture = new BitmapTextureAtlas(activity.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		
		        font = FontFactory.createFromAsset(activity.getFontManager(), fontTexture, activity.getAssets(), "Bangers.ttf", 40, true, Color.WHITE);
		        font.load();
		    }
			
			public void loadGameResources(){
				loadGameGraphics();
				loadGameAudio();
			}
			
			public void loadGameGraphics(){
				BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/game/");
			    gameTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
			    
			    platform1_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "platform.png");
			    platform2_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "platform.png");
			    platform3_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "platform.png");
			    if(random.nextBoolean() == true)
			    	background_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "GameBackground.png");
			    else
			    	background_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "GameBackground2.png");
			    pyramid1_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "pyramid-1.png");
			    pyramid2_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "pyramid-2.png");
			    pyramid3_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "pyramid-3.png");
			    pyramid4_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "pyramid-4.png");
			    pyramid5_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "pyramid-5.png");
			    pyramid6_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "pyramid-6.png");
			    pyramid7_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "pyramid-7.png");
			    pyramid8_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "pyramid-8.png");
			    gamerepeat_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "gamerepeat.png");
			    try 
			    {
			        this.gameTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
			        this.gameTextureAtlas.load();
			    } 
			    catch (final TextureAtlasBuilderException e)
			    {
			        Debug.e(e);
			    }
			    
			    BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/game/");
			    gameInstructionTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
			    
			    gameInstructions = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameInstructionTextureAtlas, activity, "instructions.png");

			    try 
			    {
			        this.gameInstructionTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
			        this.gameInstructionTextureAtlas.load();
			    } 
			    catch (final TextureAtlasBuilderException e)
			    {
			        Debug.e(e);
			    }
			    
			   
			}
			
			public void loadGameFonts(){
				
			}
			
			public void loadGameAudio(){
				MusicFactory.setAssetBasePath("sound/");
				try
				{
				    music = MusicFactory.createMusicFromAsset(engine.getMusicManager(), activity, "pyramid_sound_drop.ogg");
				    game_music = MusicFactory.createMusicFromAsset(engine.getMusicManager(), activity, "level_music.ogg");
				}
				catch (IOException e)
				{
				    e.printStackTrace();
				}
				
			}
			
			// Game Complete Window
			
			public void loadGameCompleteResource(){
				
				loadGameCompleteGraphics();
				loadGameCompleteAudio();
			}
			
			public void loadGameCompleteGraphics(){
				BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/game/");
			    gamecompleteTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
			    
			    if(score > 1){
			    	complete_window_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gamecompleteTextureAtlas, activity, "LevelCompleteWindow1.png");
			    }else{
			    	complete_window_region2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gamecompleteTextureAtlas, activity, "LevelCompleteWindow2.png");
			    }
			    complete_window_region3 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gamecompleteTextureAtlas, activity, "Complete.png");

			    try 
			    {
			        this.gamecompleteTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
			        this.gamecompleteTextureAtlas.load();
			    } 
			    catch (final TextureAtlasBuilderException e)
			    {
			        Debug.e(e);
			    }
			    BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/game/");
			    starTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
			    
			    invisibleButton_region = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(starTextureAtlas, activity, "InvisibleScreen.png", 2, 1);
			    complete_stars_region = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(starTextureAtlas, activity, "star.png", 2, 1);
			    try 
			    {
			        this.starTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
			        this.starTextureAtlas.load();
			    } 
			    catch (final TextureAtlasBuilderException e)
			    {
			        Debug.e(e);
			    }

			    
			}
			
			public void loadGameCompleteAudio(){
				
				MusicFactory.setAssetBasePath("sound/");
				try
				{
				    levelComplete = MusicFactory.createMusicFromAsset(engine.getMusicManager(), activity, "level_complete_window.ogg");
				}
				catch (IOException e)
				{
				    e.printStackTrace();
				}
			}
			
			public void loadGameLostResources(){
				
				loadGameLostGraphics();
				loadGameLostAudio();
			}
			
			public void loadGameLostGraphics(){
				
				 BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
				    gameLostTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
				    
				    lostBackground_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameLostTextureAtlas, activity, "lostScene.png");
				    tryagainButton_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameLostTextureAtlas, activity, "tryagainButton.png");
				    quitButton_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameLostTextureAtlas, activity, "quitButton.png");

				    try 
				    {
				        this.gameLostTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
				        this.gameLostTextureAtlas.load();
				    } 
				    catch (final TextureAtlasBuilderException e)
				    {
				        Debug.e(e);
				    }
				    
			    
			}
			
			public void loadGameLostAudio(){
				
		
				
			}
			public void loadShareSceneGraphics(){
				BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
			    shareTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
			    
			    shareButton_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(shareTextureAtlas, activity, "shareButton.png");
			    shareBackground_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(shareTextureAtlas, activity, "shareBackground.png");
			    nextbutton_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(shareTextureAtlas, activity, "next.png");
			    backbutton_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(shareTextureAtlas, activity, "back.png");
			    try 
			    {
			        this.shareTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
			        this.shareTextureAtlas.load();
			    } 
			    catch (final TextureAtlasBuilderException e)
			    {
			        Debug.e(e);
			    }
			}
			
			//Splash Screen
			public void loadSplashScreen(){
				BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
				splashTextureAtlas = new BitmapTextureAtlas(activity.getTextureManager(), 800, 480, TextureOptions.BILINEAR);
				splash_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(splashTextureAtlas, activity, "Stamp.png", 0, 0);
				splashTextureAtlas.load();
			}
			
			    
			public void loadMenuTextures()
			{
			    menuTextureAtlas.load();
			}
			
			//Game - Order
			
			public void loadGameOrderResources(){
				loadGameOrderGraphics();
				loadGameOrderAudio();
				
			}
			
			public void loadGameOrderGraphics(){
				BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/game/");
			    gameOrderTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
			    
			    Orderplatform1_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderTextureAtlas, activity, "platformOrder.png");
			    Orderplatform2_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderTextureAtlas, activity, "platformOrder.png");
			    Orderplatform3_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderTextureAtlas, activity, "platformOrder.png");
			    Orderplatform4_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderTextureAtlas, activity, "platformOrder.png");
			    Orderplatform5_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderTextureAtlas, activity, "platformOrder.png");
			    Orderplatform6_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderTextureAtlas, activity, "platformOrder.png");
			    Orderplatform7_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderTextureAtlas, activity, "platformOrder.png");
			    gamerepeat_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderTextureAtlas, activity, "gamerepeat.png");
			    if(random.nextBoolean() == true)
			    	backgroundOrder_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderTextureAtlas, activity, "GameBackground3.png");
			    else
			    	backgroundOrder_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderTextureAtlas, activity, "GameBackground3.png");
			   			    
			    try 
			    {
			        this.gameOrderTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
			        this.gameOrderTextureAtlas.load();
			    } 
			    catch (final TextureAtlasBuilderException e)
			    {
			        Debug.e(e);
			    }
			    
			    BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/game/");
			    gameOrderPlatformTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
			    
			    Orderplatform1_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPlatformTextureAtlas, activity, "platformOrder.png");
			    Orderplatform2_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPlatformTextureAtlas, activity, "platformOrder.png");
			    Orderplatform3_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPlatformTextureAtlas, activity, "platformOrder.png");
			    Orderplatform4_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPlatformTextureAtlas, activity, "platformOrder.png");
			    Orderplatform5_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPlatformTextureAtlas, activity, "platformOrder.png");
			    Orderplatform6_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPlatformTextureAtlas, activity, "platformOrder.png");
			    Orderplatform7_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPlatformTextureAtlas, activity, "platformOrder.png");
	    
			    try 
			    {
			        this.gameOrderPlatformTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
			        this.gameOrderPlatformTextureAtlas.load();
			    } 
			    catch (final TextureAtlasBuilderException e)
			    {
			        Debug.e(e);
			    }
			    
			    BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/game/");
			    gameOrderInstructionTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
			    
			    gameOrderInstructions = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderInstructionTextureAtlas, activity, "instructions2.png");

			    try 
			    {
			        this.gameOrderInstructionTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
			        this.gameOrderInstructionTextureAtlas.load();
			    } 
			    catch (final TextureAtlasBuilderException e)
			    {
			        Debug.e(e);
			    }
			    
			    BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/game/");
			    gameOrderPyramidTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
			    
			    pyramid1Yellow_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramid-1.png");
			    pyramid2Yellow_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramid-2.png");
			    pyramid3Yellow_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramid-3.png");
			    pyramid4Yellow_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramid-4.png");
			    pyramid5Yellow_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramid-5.png");
			    pyramid6Yellow_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramid-6.png");
			    pyramid7Yellow_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramid-7.png");

			    pyramid1Red_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramidred-1.png");
			    pyramid2Red_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramidred-2.png");
			    pyramid3Red_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramidred-3.png");
			    pyramid4Red_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramidred-4.png");
			    pyramid5Red_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramidred-5.png");
			    pyramid6Red_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramidred-6.png");
			    pyramid7Red_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramidred-7.png");

			    pyramid1Green_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramidgreen-1.png");
			    pyramid2Green_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramidgreen-2.png");
			    pyramid3Green_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramidgreen-3.png");
			    pyramid4Green_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramidgreen-4.png");
			    pyramid5Green_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramidgreen-5.png");
			    pyramid6Green_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramidgreen-6.png");
			    pyramid7Green_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramidgreen-7.png");

			    pyramid1Blue_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramidblue-1.png");
			    pyramid2Blue_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramidblue-2.png");
			    pyramid3Blue_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramidblue-3.png");
			    pyramid4Blue_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramidblue-4.png");
			    pyramid5Blue_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramidblue-5.png");
			    pyramid6Blue_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramidblue-6.png");
			    pyramid7Blue_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramidblue-7.png");

			    pyramid1Orange_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramidorange-1.png");
			    pyramid2Orange_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramidorange-2.png");
			    pyramid3Orange_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramidorange-3.png");
			    pyramid4Orange_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramidorange-4.png");
			    pyramid5Orange_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramidorange-5.png");
			    pyramid6Orange_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramidorange-6.png");
			    pyramid7Orange_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramidorange-7.png");

			    pyramid1Pink_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramidpink-1.png");
			    pyramid2Pink_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramidpink-2.png");
			    pyramid3Pink_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramidpink-3.png");
			    pyramid4Pink_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramidpink-4.png");
			    pyramid5Pink_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramidpink-5.png");
			    pyramid6Pink_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramidpink-6.png");
			    pyramid7Pink_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOrderPyramidTextureAtlas, activity, "pyramidpink-7.png");

			    
			    try 
			    {
			        this.gameOrderPyramidTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
			        this.gameOrderPyramidTextureAtlas.load();
			    } 
			    catch (final TextureAtlasBuilderException e)
			    {
			        Debug.e(e);
			    }
			    BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/game/");
			    gameInstructionTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
			    
			    gameInstructions = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameInstructionTextureAtlas, activity, "instructions.png");

			    try 
			    {
			        this.gameInstructionTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
			        this.gameInstructionTextureAtlas.load();
			    } 
			    catch (final TextureAtlasBuilderException e)
			    {
			        Debug.e(e);
			    }
			    
			}
			
			public void loadGameOrderFonts(){
				
			}
			
			public void loadGameOrderAudio(){
				MusicFactory.setAssetBasePath("sound/");
				try
				{
				    music = MusicFactory.createMusicFromAsset(engine.getMusicManager(), activity, "pyramid_sound_drop.ogg");
				    game_music = MusicFactory.createMusicFromAsset(engine.getMusicManager(), activity, "level_music.ogg");
				}
				catch (IOException e)
				{
				    e.printStackTrace();
				}
				
			}
		//Unloading Resources
			
			public void unloadSplashScreen(){
				splashTextureAtlas.unload();
			}
			public void unloadMenuTextures()
			{
			    menuTextureAtlas.unload();
			    if(GiftizTextureAtlas!=null)
			    	GiftizTextureAtlas.unload();
			    if(!menu_music.isReleased())
			    	menu_music.release();
			}
			public void unloadGameOptionTextures()
			{
				LevelChooseTextureAtlas.unload();
				LevelChooseButtonsTextureAtlas.unload();
			}
			public void unloadGameTypeTextures()
			{
				LevelTypeTextureAtlas.unload();
				if(!buttonclick.isReleased())
					buttonclick.release();
			}
			public void unloadGameModeTextures()
			{
				LevelTypeOrderTextureAtlas.unload();
				if(!buttonclick.isReleased())
					buttonclick.release();
			}
			public void unloadGameTextures(TemplateScene game)
			{
				gameTextureAtlas.unload();
				gameInstructionTextureAtlas.unload();
				if(game!=null){
					game.disposeScene();
				}
				if(!music.isReleased()){
					music.release();
				}
				if(!game_music.isReleased()){
					game_music.release();
				}
				

			}
			public void unloadGameCompleteTextures()
			{
				gamecompleteTextureAtlas.unload();
				starTextureAtlas.unload();
				levelComplete.release();
			}
			public void unloadShareTextures()
			{
				shareTextureAtlas.unload();
			}
			public void unloadGameLostTextures()
			{
				gameLostTextureAtlas.unload();
			}
			public void unloadGameOrderTextures(TemplateScene game)
			{
				gameOrderPyramidTextureAtlas.unload();
				gameOrderTextureAtlas.unload();
				gameInstructionTextureAtlas.unload();
				gameOrderPlatformTextureAtlas.unload();
				if(game!=null){
					game.disposeScene();
				}
				if(!music.isReleased()){
					music.release();
				}
				if(!game_music.isReleased()){
					game_music.release();
				}
			}

			//
/**
 * @param engine
 * @param activity
 * @param camera
 * @param vbom
 * 
 * This method will be used to prepare this class by setting the parameters
 * It will be used to access these parameters from different classes
 */

	 public static void prepareController(Engine engine, GameActivity activity, Camera camera, VertexBufferObjectManager vbom){
		 
		 getInstance().engine = engine;
	     getInstance().activity = activity;
	     getInstance().camera = camera;
	     getInstance().vbom = vbom;
	 }

	 
	 //Getters and Setters
	 
	 public static ResourceController getInstance() {
			return INSTANCE;
		}

	

	
	

}
