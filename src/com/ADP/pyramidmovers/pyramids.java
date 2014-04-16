package com.ADP.pyramidmovers;

import java.util.Stack;

import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

public class pyramids extends Sprite {
	 private int mWeight;
	    private Stack<?> mStack; //this represents the stack that this ring belongs to
	    private Sprite platform;
	    private int color;
	    
	 
	    public pyramids(int weight, float pX, float pY, ITextureRegion pTextureRegion, VertexBufferObjectManager pVertexBufferObjectManager) {
	        super(pX, pY, pTextureRegion, pVertexBufferObjectManager);
	        this.mWeight = weight;
	        color = 0;
	    }
	    
	 
	    public int getmWeight() {
	        return mWeight;
	    }
	 
	    public Stack getmStack() {
	        return mStack;
	    }
	 
	    public void setmStack(Stack mStack) {
	        this.mStack = mStack;
	    }
	 
	    public Sprite getmPlatform() {
	        return platform;
	    }
	 
	    public void setmPlatform(Sprite Platform) {
	        this.platform = Platform;
	    }
	    
	    public int getmColor() {
	        return color;
	    }
	 
	    public void setmColor(int Color) {
	        this.color = Color;
	    }
}
