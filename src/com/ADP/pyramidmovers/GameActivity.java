package com.ADP.pyramidmovers;

import java.io.IOException;

import org.andengine.engine.Engine;
import org.andengine.engine.LimitedFPSEngine;
import org.andengine.engine.camera.Camera;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.WakeLockOptions;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.opengl.view.RenderSurfaceView;
import org.andengine.ui.activity.BaseGameActivity;

import com.ADP.controller.ResourceController;
import com.ADP.controller.SceneController;
import com.ADP.scene.MainMenuScene;
import com.facebook.Session;
import com.purplebrain.giftiz.sdk.GiftizSDK;
import com.purplebrain.giftiz.sdk.GiftizSDK.Inner.ButtonNeedsUpdateDelegate;




import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * 
 * @author Ashar Shoaib
 * @version 1.0
 *
 */
public class GameActivity extends BaseGameActivity implements ButtonNeedsUpdateDelegate 
{
	private Camera camera;
	public myDatabase myDB;
	private boolean mIsPausedBefore;


	
	private static int CAMERA_WIDTH = 800;
	private static int CAMERA_HEIGHT = 480;
	
	
	
	@Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);
    }
	
    public EngineOptions onCreateEngineOptions()
    {
    	camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
        EngineOptions engineOptions = new EngineOptions(true, ScreenOrientation.LANDSCAPE_FIXED, new FillResolutionPolicy(), this.camera);
        engineOptions.getAudioOptions().setNeedsMusic(true).setNeedsSound(true);
        engineOptions.setWakeLockOptions(WakeLockOptions.SCREEN_ON);
        return engineOptions;    }

    public void onCreateResources(OnCreateResourcesCallback pOnCreateResourcesCallback) throws IOException
    {
    	ResourceController.prepareController(mEngine, this, this.camera, getVertexBufferObjectManager());
    	myDB = new myDatabase(this);
    	pOnCreateResourcesCallback.onCreateResourcesFinished();
    }

    public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback) throws IOException
    {
        GiftizSDK.Inner.setButtonNeedsUpdateDelegate(this);
        SceneController.getInstance().createSplashScene(pOnCreateSceneCallback);
    
    }

    public void onPopulateScene(Scene pScene, OnPopulateSceneCallback pOnPopulateSceneCallback) throws IOException
    {
    	mEngine.registerUpdateHandler(new TimerHandler(2f, new ITimerCallback(){
    		
    		public void onTimePassed (final TimerHandler pTimerHandler){
    			mEngine.unregisterUpdateHandler(pTimerHandler);
                SceneController.getInstance().createMenuScene();
                
               // System.out.println(isLevelUnLocked(1));
               // System.out.println(isLevelUnLocked(2));
               // System.out.println(unLockLevel(2, "true"));
                //System.out.println(getLevelScore(1));
               // myDB.addLevel(2, "false", "false", "0", "0");
                

    		}
    	}));
        
    	pOnPopulateSceneCallback.onPopulateSceneFinished();
    }
    
    @Override
    public Engine onCreateEngine(EngineOptions pEngineOptions) 
    {
        return new LimitedFPSEngine(pEngineOptions, 60);
    }
    
    @Override
    public void onPause() {
            if (this.mEngine != null && mEngine.isRunning()) {
                    //pause stuff here, pause game, stop music etc.
            	if(ResourceController.getInstance().musicFlag && !ResourceController.getInstance().menu_music.isReleased() ){
            	    ResourceController.getInstance().menu_music.pause();
            	    ResourceController.getInstance().menu_music.setLooping(false);
            	    ResourceController.getInstance().musicFlag = false;
            	}
            	if(ResourceController.getInstance().isGameRunning && !ResourceController.getInstance().game_music.isReleased() ){
            	    ResourceController.getInstance().game_music.pause();
            	    ResourceController.getInstance().game_music.setLooping(false);
            	    ResourceController.getInstance().musicFlag = false;
            	}
                GiftizSDK.onPauseMainActivity(this);

                this.mEngine.stop();
            }
            mIsPausedBefore = true;
            super.onPause();
    }
     
    @Override
    public synchronized void onWindowFocusChanged(boolean pHasWindowFocus) {
            super.onWindowFocusChanged(pHasWindowFocus);
            GiftizSDK.onResumeMainActivity(this);
            if (pHasWindowFocus) {
                    if ( mIsPausedBefore) {
                    	
                    	if(ResourceController.getInstance().isGameRunning){
                    		ResourceController.getInstance().game_music.resume();
                     	    ResourceController.getInstance().game_music.setLooping(true);
                    	}else{
                    		if(!ResourceController.getInstance().musicFlag){
                    			if(!ResourceController.getInstance().menu_music.isReleased()){
	        	            	    ResourceController.getInstance().menu_music.resume();
	        	            	    ResourceController.getInstance().menu_music.setLooping(true);
	        	            	    ResourceController.getInstance().musicFlag = true;
                    			}
                        	}
                       

                    	}
                                              //resume stuff (resume music etc.)
                         mIsPausedBefore = false;
                         this.mEngine.start();
                    } else {
                    	//onPause();
                    }
            }
     }
    
   
    
    @Override
    public void onDestroy()
    {
        super.onDestroy();
            
        if (this.isGameLoaded())
        {
            System.exit(0);    
        }
    }
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) 
    {  
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
            SceneController.getInstance().getCurrentScene().onBackKeyPressed();
        }
        return false; 
    }
    
   
    
    public String isLevelUnLocked(int levelNum){
    	String myReturn = myDB.isLevelUnLocked(levelNum);
    	myDB.close();
    	return myReturn;
    }
       
    public int unLockLevel(int levelNum, String isUnLocked){
    	int myReturn = myDB.unLockLevel(levelNum, isUnLocked);
    	myDB.close();
    	return myReturn;
    }
    public int getLevelScore(int levelNum){
    	int myReturn = myDB.getLevelScore(levelNum);
    	myDB.close();
    	return myReturn;
    }
       
    public int setLevelScore(int levelNum, String isUnLocked){
    	System.out.println("poop  "+ isUnLocked);
    	int myReturn = myDB.setLevelScore(levelNum, isUnLocked);
    	myDB.close();
    	return myReturn;
    }
    public int getLevelStar(int levelNum){
    	int myReturn = myDB.getLevelStar(levelNum);
    	myDB.close();
    	return myReturn;
    }
       
    public int setLevelStar(int levelNum, String isUnLocked){
    	int myReturn = myDB.setLevelStar(levelNum, isUnLocked);
    	myDB.close();
    	return myReturn;
    }
    public String isLevelBeat(int levelNum){
    	String myReturn = myDB.isLevelBeat(levelNum);
    	myDB.close();
    	return myReturn;
    }
       
    public int setLevelBeat(int levelNum, String isUnLocked){
    	int myReturn = myDB.setLevelBeat(levelNum, isUnLocked);
    	myDB.close();
    	return myReturn;
    }
    
    public float getLevelTime(int levelNum){
    	float myReturn = myDB.getLevelTime(levelNum);
    	myDB.close();
    	return myReturn;
    }
       
    public int setLevelTime(int levelNum, String isUnLocked){
    	int myReturn = myDB.setLevelTime(levelNum, isUnLocked);
    	myDB.close();
    	return myReturn;
    }

	@Override
	public void buttonNeedsUpdate() {
	}
	
	
	public boolean isOnline() {
	    ConnectivityManager cm =
	        (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo netInfo = cm.getActiveNetworkInfo();
	    if (netInfo != null && netInfo.isConnectedOrConnecting()) {
	        return true;
	    }
	    return false;
	}

	
	
	
	

}

