package com.ADP.scene;

import java.util.Random;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.camera.hud.HUD;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.sprite.TiledSprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.util.GLState;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import com.ADP.controller.ResourceController;
import com.ADP.controller.SceneController;
import com.ADP.controller.SceneController.SceneType;
import com.ADP.pyramidmovers.FacebookManager;
import com.ADP.pyramidmovers.GameActivity;
import com.ADP.scene.game.GameSceneClock;
import com.ADP.template.TemplateScene;
import com.purplebrain.giftiz.sdk.GiftizSDK;
import com.purplebrain.giftiz.sdk.GiftizSDK.Inner.ButtonNeedsUpdateDelegate;


public class MainMenuScene extends TemplateScene implements IOnMenuItemClickListener {
	
	private MenuScene menuChildScene;
	private final int MENU_PLAY = 0;
	private final int MENU_OPTIONS = 1;
	private final int MENU_EMAIL = 2;
	private final int MENU_RATE = 3;
	private final int MENU_INVITE = 4;
	private final int MENU_LIKE = 5;
	private final int MENU_GIFTIZ = 6;
	private IMenuItem playMenuItem;
	private IMenuItem optionsMenuItem;
	private IMenuItem emailMenuItem;
	private IMenuItem rateMenuItem;
	private IMenuItem inviteMenuItem;
	private IMenuItem likeMenuItem;
	private IMenuItem giftizMenuItem;
	private GameCreditsWindow creditwindow;
	
	// Data members
    private Intent emailIntent;
    private String feedback;
	private boolean status;
	private TimerHandler timer;
	

	private void createMenuChildScene()
	{
	    menuChildScene = new MenuScene(camera);
	    menuChildScene.setPosition(0, 0);
	    
	    
	    playMenuItem = new ScaleMenuItemDecorator(new SpriteMenuItem(MENU_PLAY, resourceController.play_region, vbom), 1.2f, 1);
	    optionsMenuItem = new ScaleMenuItemDecorator(new SpriteMenuItem(MENU_OPTIONS, resourceController.options_region, vbom), 1.2f, 1);
	    emailMenuItem = new ScaleMenuItemDecorator(new SpriteMenuItem(MENU_EMAIL, resourceController.emailbutton_region, vbom), 1.2f, 1);
	    rateMenuItem = new ScaleMenuItemDecorator(new SpriteMenuItem(MENU_RATE, resourceController.ratebutton_region, vbom), 1.2f, 1);
	    inviteMenuItem = new ScaleMenuItemDecorator(new SpriteMenuItem(MENU_INVITE, resourceController.Invitebutton_region, vbom), 1.2f, 1);
	    likeMenuItem = new ScaleMenuItemDecorator(new SpriteMenuItem(MENU_LIKE, resourceController.Likebutton_region, vbom), 1.2f, 1);
	    switch (GiftizSDK.Inner.getButtonStatus(activity)) {
        case ButtonInvisible : 
        	status = false;
        	break;
		case ButtonBadge:
		    giftizMenuItem = new ScaleMenuItemDecorator(new SpriteMenuItem(MENU_GIFTIZ, resourceController.Giftizbutton_region2, vbom), 1.2f, 1);

        	status = true;
			break;
		case ButtonNaked:
		    giftizMenuItem = new ScaleMenuItemDecorator(new SpriteMenuItem(MENU_GIFTIZ, resourceController.Giftizbutton_region, vbom), 1.2f, 1);

        	status = true;
			break;
		case ButtonWarning:
		    giftizMenuItem = new ScaleMenuItemDecorator(new SpriteMenuItem(MENU_GIFTIZ, resourceController.Giftizbutton_region3, vbom), 1.2f, 1);

        	status = true;
			break;
		default:
			break;
        }
	    
	   

	    menuChildScene.addMenuItem(playMenuItem);
	    menuChildScene.addMenuItem(optionsMenuItem);
	    menuChildScene.addMenuItem(emailMenuItem);
	    menuChildScene.addMenuItem(rateMenuItem);
	    menuChildScene.addMenuItem(inviteMenuItem);
	    menuChildScene.addMenuItem(likeMenuItem);
	    if(status){
		    menuChildScene.addMenuItem(giftizMenuItem);
	    }
	    
	    menuChildScene.buildAnimations();
	    menuChildScene.setBackgroundEnabled(false);
	    
	    playMenuItem.setPosition(400, 180);
	    optionsMenuItem.setPosition(400, 70);
	    emailMenuItem.setPosition(750, 180);
	    rateMenuItem.setPosition(750, 70);
	    inviteMenuItem.setPosition(50, 180);
	    likeMenuItem.setPosition(50, 70);
	    if(status){
		    giftizMenuItem.setPosition(45, 428);
	    }
	    menuChildScene.setOnMenuItemClickListener(this);
	    
	    setChildScene(menuChildScene);
	}
	
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem, float pMenuItemLocalX, float pMenuItemLocalY)
	{
	    switch(pMenuItem.getID())
	    {
	        case MENU_PLAY:
	            //Load Game Scene!
	            SceneController.getInstance().createGameModeScreen();
	            if(ResourceController.getInstance().soundFlag)
	            	ResourceController.getInstance().buttonclick.play();
	            return true;
	        case MENU_OPTIONS:
	    	    registerTouchArea(creditwindow);
	            if(ResourceController.getInstance().soundFlag)
	            	ResourceController.getInstance().buttonclick.play();
	    	    creditwindow.display(this);
	    	    playMenuItem.setPosition(1000, 1000);
	    	    optionsMenuItem.setPosition(1000, 1000);
	    	    emailMenuItem.setPosition(1000, 1000);
	    	    rateMenuItem.setPosition(1000, 1000);
	    	    inviteMenuItem.setPosition(1000, 1000);
	    	    likeMenuItem.setPosition(1000, 1000);
	            return true;
	        case MENU_EMAIL:
	            if(ResourceController.getInstance().soundFlag)
	            	ResourceController.getInstance().buttonclick.play();
	         

	            // Create the Intent, and give it the pre-defined value
	            // that the Android machine automatically associates with
	            // sending an email.
	            emailIntent = new Intent(android.content.Intent.ACTION_SEND);
	            emailIntent.setType("plain/text");

	            // Put extra information into the Intent, including the email address
	            // that you wish to send to, and any subject (optional, of course).
	            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"ashardevelopmentproject@gmail.com"});
	            emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Pyramid Movers - Feedback");

	            // Acquire feedback from an EditText and save it to a String.
	            //feedback = feedbackBox.getText().toString();

	            // Put the message into the Intent as more extra information,                   
	            emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, feedback);

	            // Start the Intent, which will launch the user's email 
	            // app (make sure you save any necessary information in YOUR app
	            // in your onPause() method, as launching the email Intent will
	            // pause your app). This will create what I discussed above - a
	            // popup box that the user can use to determine which app they would like
	            // to use in order to send the email.
	            activity.startActivity(Intent.createChooser(emailIntent, "Send us an email using."));
	            return true;
	        case MENU_RATE:
	    	    registerTouchArea(creditwindow);
	            if(ResourceController.getInstance().soundFlag)
	            	ResourceController.getInstance().buttonclick.play();
	            Uri uri = Uri.parse("market://details?id=" + activity.getPackageName());
	            Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
	            try {
	              activity.startActivity(goToMarket);
	            } catch (ActivityNotFoundException e) {
	              Toast.makeText(activity, "Couldn't launch the market", Toast.LENGTH_LONG).show();
	            }
	            return true;
	        case MENU_INVITE:
	    	    registerTouchArea(creditwindow);
	            if(ResourceController.getInstance().soundFlag)
	            	ResourceController.getInstance().buttonclick.play();
	            FacebookManager.facebookRequestDialog();
	            return true;
	        case MENU_LIKE:
	            if(ResourceController.getInstance().soundFlag)
	            	ResourceController.getInstance().buttonclick.play();
	            FacebookManager.linkToPage();
	            return true;
	        case MENU_GIFTIZ:
	        	GiftizSDK.Inner.buttonClicked(activity); 
	    		updateButtonImage();		
	            return true;
	        default:
	            return false;
	    }
	}
	
	private void createHUD()
	{
	    resourceController.soundHUD = new HUD();
	    
	    
	    resourceController.soundHUD.attachChild(resourceController.soundButton = new TiledSprite(715, 460, ResourceController.getInstance().soundbutton_region, vbom)
	    {

	    	@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				switch(pSceneTouchEvent.getAction()) {
	            case TouchEvent.ACTION_DOWN:
	                break;
	            case TouchEvent.ACTION_UP:
	            	if(!ResourceController.getInstance().soundFlag){
	            		this.setCurrentTileIndex(0);
	            		ResourceController.getInstance().soundFlag = true;
	            	}else{
	            		this.setCurrentTileIndex(1);
	            		ResourceController.getInstance().soundFlag = false;
	            	}
	        	    break;
	            case TouchEvent.ACTION_MOVE:
	                break;
	            }
				return true;
			}
	    });
	    
	    
	    resourceController.soundHUD.attachChild(resourceController.musicButton = new TiledSprite(755, 460, ResourceController.getInstance().musicbutton_region, vbom)
	    {
	    	@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				switch(pSceneTouchEvent.getAction()) {
	            case TouchEvent.ACTION_DOWN:
	                break;
	            case TouchEvent.ACTION_UP:
	            	if(!ResourceController.getInstance().musicFlag){
	            		this.setCurrentTileIndex(0);
	            	    ResourceController.getInstance().menu_music.resume();
	            	    ResourceController.getInstance().menu_music.setLooping(true);
	            	    ResourceController.getInstance().musicFlag = true;
	            	}else{
	            		this.setCurrentTileIndex(1);
	            	    ResourceController.getInstance().menu_music.setLooping(false);
	        	    	ResourceController.getInstance().menu_music.pause();
	        	    	ResourceController.getInstance().musicFlag = false;
	            	}
	        	    break;
	            case TouchEvent.ACTION_MOVE:
	                break;
	            }
				return true;
			}
	    });
	    if(ResourceController.getInstance().musicFlag){
	    	resourceController.musicButton.setCurrentTileIndex(0);
	    }else{
	    	resourceController.musicButton.setCurrentTileIndex(1);
	    }
	    
	    if(!ResourceController.getInstance().soundFlag){
    		resourceController.soundButton.setCurrentTileIndex(1);
    	}else{
    		resourceController.soundButton.setCurrentTileIndex(0);
    	}
	    	
	    registerTouchArea(resourceController.soundButton);
	    registerTouchArea(resourceController.musicButton);
	    camera.setHUD(resourceController.soundHUD);
	}
	
	public void disposeHUD()
    {
    	camera.setHUD(null);
        camera.setCenter(400, 240);

        // TODO code responsible for disposing scene
        // removing all game scene objects.
    
    }
	
	public void updateButtonImage() { // pick the right button image according to the button status
		

		  timer =  new TimerHandler(1.0f, new ITimerCallback() {
	  	       	public void onTimePassed(TimerHandler pTimerHandler) {

	  	       	menuChildScene.detachChild(giftizMenuItem);
	  		  switch (GiftizSDK.Inner.getButtonStatus(activity)) {
	  	        case ButtonInvisible : 
	  	        	status = false;
	  	        	break;
	  			case ButtonBadge:
	  	        	status = true;
	  			    giftizMenuItem = new ScaleMenuItemDecorator(new SpriteMenuItem(MENU_GIFTIZ, resourceController.Giftizbutton_region2, vbom), 1.2f, 1);
	  			    menuChildScene.addMenuItem(giftizMenuItem);
	  			    giftizMenuItem.setPosition(45, 428);
	  			    break;
	  			case ButtonNaked:
	  			    giftizMenuItem = new ScaleMenuItemDecorator(new SpriteMenuItem(MENU_GIFTIZ, resourceController.Giftizbutton_region, vbom), 1.2f, 1);
	  			    menuChildScene.addMenuItem(giftizMenuItem);
	  			    giftizMenuItem.setPosition(45, 428);
	  			    status = true;
	  				break;
	  			case ButtonWarning:
	  			    giftizMenuItem = new ScaleMenuItemDecorator(new SpriteMenuItem(MENU_GIFTIZ, resourceController.Giftizbutton_region3, vbom), 1.2f, 1);
	  			    menuChildScene.addMenuItem(giftizMenuItem);
	  			    giftizMenuItem.setPosition(45, 428);
	  			    status = true;
	  				break;
	  			default:
	  				break;
	  	        }
	  		 
	  		 // setChildScene(menuChildScene);
	  		  menuChildScene.reset();		
	  	       		
	  	       	SceneController.getInstance().engine.unregisterUpdateHandler(timer);
	  	       	}
	  	       });
	  		SceneController.getInstance().engine.registerUpdateHandler(timer);

        }
	

	@Override
	public void createScene() {
	    createBackground();
	    status=true;
	    createMenuChildScene();
	    if(ResourceController.getInstance().musicFlag){
	    	ResourceController.getInstance().menu_music.play();
	    	ResourceController.getInstance().menu_music.setLooping(true);
	    }
	    createHUD();
	    creditwindow = new GameCreditsWindow(vbom){
	    	@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				switch(pSceneTouchEvent.getAction()) {
	            case TouchEvent.ACTION_DOWN:
	                break;
	            case TouchEvent.ACTION_UP:
	            	creditwindow.removedisplay(MainMenuScene.this);
	            	playMenuItem.setPosition(400, 180);
	        	    optionsMenuItem.setPosition(400, 70);
	        	    emailMenuItem.setPosition(750, 180);
	        	    rateMenuItem.setPosition(750, 70);
	        	    inviteMenuItem.setPosition(50, 180);
	        	    likeMenuItem.setPosition(50, 70);
	        	    break;
	            case TouchEvent.ACTION_MOVE:
	                break;
	            }
				return true;
			}
	    };
		
	}

	@Override
	public void onBackKeyPressed() {
		System.exit(0);
	}

	@Override
	public SceneType getSceneType() {
		return SceneType.SCENE_MENU;
	}

	@Override
	public void disposeScene() {
		// TODO Auto-generated method stub
		
	}
	
	private void createBackground()
	{
	    attachChild(new Sprite(400, 240, resourceController.menu_background_region, vbom)
	    {
	        @Override
	        protected void preDraw(GLState pGLState, Camera pCamera) 
	        {
	            super.preDraw(pGLState, pCamera);
	            pGLState.enableDither();
	        }
	    });
	}


}
