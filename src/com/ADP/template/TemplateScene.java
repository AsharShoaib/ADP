package com.ADP.template;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.Scene;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import android.app.Activity;

import com.ADP.controller.*;
import com.ADP.controller.SceneController.SceneType;

/**
 * 
 * @author Ashar Shoaib
 * @version 1.0
 *
 */

public abstract class TemplateScene extends Scene {
	
	//Variable
	
	protected Engine engine;
	protected Activity activity;
	protected ResourceController resourceController;
	protected VertexBufferObjectManager vbom;
	protected Camera camera;
	
	//Constructor
	
	public TemplateScene(){
		
		this.resourceController = ResourceController.getInstance();
		this.engine = resourceController.engine;
		this.activity = resourceController.activity;
		this.vbom = resourceController.vbom;
		this.camera = resourceController.camera;
		createScene();
	}
	
	//Abstract Classes
	
	public abstract void createScene();
    
    public abstract void onBackKeyPressed();
    
    public abstract SceneType getSceneType();
    
    public abstract void disposeScene();
    
	
	
}
