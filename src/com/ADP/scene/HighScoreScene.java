package com.ADP.scene;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.opengl.util.GLState;
import org.andengine.util.adt.align.HorizontalAlign;

import com.ADP.controller.ResourceController;
import com.ADP.controller.SceneController;
import com.ADP.controller.SceneController.SceneType;
import com.ADP.pyramidmovers.GameActivity;
import com.ADP.template.TemplateScene;

public class HighScoreScene  extends TemplateScene {
	
	//Variables
	
	private Sprite background;
	private Text HighScore1;
	private Text HighScore2;
	private Text HighScore3;
	private Text HighScore4;
	private Text HighScore5;
	private Text HighScore6;
	private Text HighScore7;
	private Text HighScore8;
	private Text HighScore9;
	private Text HighScore10;
	private Text HighScore11;
	private Text HighScore22;
	private Text HighScore33;
	private Text HighScore44;
	private Text HighScore55;
	private Text HighScore66;
	private Text HighScore77;
	private Text HighScore88;
	private Text HighScore99;
	private Text HighScore1010;


	
	
	//Class
	@Override
	public void createScene() {
		createBackground();
		if(!ResourceController.getInstance().gameMode){
    		
			createText();

    	}else{
			createText2();
    	}
	}

	private void createText2() {
		HighScore1 = new Text(400, 330, resourceController.font, 
	    		"HighScore1.setText(Level 1 - Least Number Of Moves:  +((GameActivity) activity).getLevelScore(1) + Best Time:  +((GameActivity) activity).getLevelTime(1) + Level Passed = +((GameActivity) activity).isLevelBeat(1)); "
	    		, new TextOptions(HorizontalAlign.CENTER), vbom);
	    HighScore2 = new Text(400, 300, resourceController.font,
	    		"HighScore1.setText(Level 1 - Least Number Of Moves:  +((GameActivity) activity).getLevelScore(1) + Best Time:  +((GameActivity) activity).getLevelTime(1) + Level Passed = +((GameActivity) activity).isLevelBeat(1)); "
	    		, new TextOptions(HorizontalAlign.CENTER), vbom);
	    HighScore3 = new Text(400, 270, resourceController.font, 
	    		"HighScore1.setText(Level 1 - Least Number Of Moves:  +((GameActivity) activity).getLevelScore(1) + Best Time:  +((GameActivity) activity).getLevelTime(1) + Level Passed = +((GameActivity) activity).isLevelBeat(1)); "
	    		, new TextOptions(HorizontalAlign.CENTER), vbom);
	    HighScore4 = new Text(400, 240, resourceController.font, 
	    		"HighScore1.setText(Level 1 - Least Number Of Moves:  +((GameActivity) activity).getLevelScore(1) + Best Time:  +((GameActivity) activity).getLevelTime(1) + Level Passed = +((GameActivity) activity).isLevelBeat(1)); "
	    		, new TextOptions(HorizontalAlign.CENTER), vbom);
	    HighScore5 = new Text(400, 210, resourceController.font, 
	    		"HighScore1.setText(Level 1 - Least Number Of Moves:  +((GameActivity) activity).getLevelScore(1) + Best Time:  +((GameActivity) activity).getLevelTime(1) + Level Passed = +((GameActivity) activity).isLevelBeat(1)); "
	    		, new TextOptions(HorizontalAlign.CENTER), vbom);
	    HighScore6 = new Text(400, 180, resourceController.font, 
	    		"HighScore1.setText(Level 1 - Least Number Of Moves:  +((GameActivity) activity).getLevelScore(1) + Best Time:  +((GameActivity) activity).getLevelTime(1) + Level Passed = +((GameActivity) activity).isLevelBeat(1)); "
	    		, new TextOptions(HorizontalAlign.CENTER), vbom);
	    HighScore7 = new Text(400, 150, resourceController.font, 
	    		"HighScore1.setText(Level 1 - Least Number Of Moves:  +((GameActivity) activity).getLevelScore(1) + Best Time:  +((GameActivity) activity).getLevelTime(1) + Level Passed = +((GameActivity) activity).isLevelBeat(1)); "
	    		, new TextOptions(HorizontalAlign.CENTER), vbom);
	    HighScore8 = new Text(400, 120, resourceController.font, 
	    		"HighScore1.setText(Level 1 - Least Number Of Moves:  +((GameActivity) activity).getLevelScore(1) + Best Time:  +((GameActivity) activity).getLevelTime(1) + Level Passed = +((GameActivity) activity).isLevelBeat(1)); "
	    		, new TextOptions(HorizontalAlign.CENTER), vbom);
	    HighScore9 = new Text(400, 90, resourceController.font, 
	    		"HighScore1.setText(Level 1 - Least Number Of Moves:  +((GameActivity) activity).getLevelScore(1) + Best Time:  +((GameActivity) activity).getLevelTime(1) + Level Passed = +((GameActivity) activity).isLevelBeat(1)); "
	    		, new TextOptions(HorizontalAlign.CENTER), vbom);
	    HighScore10 = new Text(400, 60, resourceController.font, 
	    		"HighScore1.setText(Level 1 - Least Number Of Moves:  +((GameActivity) activity).getLevelScore(1) + Best Time:  +((GameActivity) activity).getLevelTime(1) + Level Passed = +((GameActivity) activity).isLevelBeat(1)); "
	    		, new TextOptions(HorizontalAlign.CENTER), vbom);
	    
	    HighScore11 = new Text(398, 330, resourceController.font, 
	    		"HighScore1.setText(Level 1 - Least Number Of Moves:  +((GameActivity) activity).getLevelScore(1) + Best Time:  +((GameActivity) activity).getLevelTime(1) + Level Passed = +((GameActivity) activity).isLevelBeat(1)); "
	    		, new TextOptions(HorizontalAlign.CENTER), vbom);
	    HighScore22 = new Text(398, 300, resourceController.font,
	    		"HighScore1.setText(Level 1 - Least Number Of Moves:  +((GameActivity) activity).getLevelScore(1) + Best Time:  +((GameActivity) activity).getLevelTime(1) + Level Passed = +((GameActivity) activity).isLevelBeat(1)); "
	    		, new TextOptions(HorizontalAlign.CENTER), vbom);
	    HighScore33 = new Text(398, 270, resourceController.font, 
	    		"HighScore1.setText(Level 1 - Least Number Of Moves:  +((GameActivity) activity).getLevelScore(1) + Best Time:  +((GameActivity) activity).getLevelTime(1) + Level Passed = +((GameActivity) activity).isLevelBeat(1)); "
	    		, new TextOptions(HorizontalAlign.CENTER), vbom);
	    HighScore44 = new Text(398, 240, resourceController.font, 
	    		"HighScore1.setText(Level 1 - Least Number Of Moves:  +((GameActivity) activity).getLevelScore(1) + Best Time:  +((GameActivity) activity).getLevelTime(1) + Level Passed = +((GameActivity) activity).isLevelBeat(1)); "
	    		, new TextOptions(HorizontalAlign.CENTER), vbom);
	    HighScore55 = new Text(398, 210, resourceController.font, 
	    		"HighScore1.setText(Level 1 - Least Number Of Moves:  +((GameActivity) activity).getLevelScore(1) + Best Time:  +((GameActivity) activity).getLevelTime(1) + Level Passed = +((GameActivity) activity).isLevelBeat(1)); "
	    		, new TextOptions(HorizontalAlign.CENTER), vbom);
	    HighScore66 = new Text(398, 180, resourceController.font, 
	    		"HighScore1.setText(Level 1 - Least Number Of Moves:  +((GameActivity) activity).getLevelScore(1) + Best Time:  +((GameActivity) activity).getLevelTime(1) + Level Passed = +((GameActivity) activity).isLevelBeat(1)); "
	    		, new TextOptions(HorizontalAlign.CENTER), vbom);
	    HighScore77 = new Text(398, 150, resourceController.font, 
	    		"HighScore1.setText(Level 1 - Least Number Of Moves:  +((GameActivity) activity).getLevelScore(1) + Best Time:  +((GameActivity) activity).getLevelTime(1) + Level Passed = +((GameActivity) activity).isLevelBeat(1)); "
	    		, new TextOptions(HorizontalAlign.CENTER), vbom);
	    HighScore88 = new Text(398, 120, resourceController.font, 
	    		"HighScore1.setText(Level 1 - Least Number Of Moves:  +((GameActivity) activity).getLevelScore(1) + Best Time:  +((GameActivity) activity).getLevelTime(1) + Level Passed = +((GameActivity) activity).isLevelBeat(1)); "
	    		, new TextOptions(HorizontalAlign.CENTER), vbom);
	    HighScore99 = new Text(398, 90, resourceController.font, 
	    		"HighScore1.setText(Level 1 - Least Number Of Moves:  +((GameActivity) activity).getLevelScore(1) + Best Time:  +((GameActivity) activity).getLevelTime(1) + Level Passed = +((GameActivity) activity).isLevelBeat(1)); "
	    		, new TextOptions(HorizontalAlign.CENTER), vbom);
	    HighScore1010 = new Text(398, 60, resourceController.font, 
	    		"HighScore1.setText(Level 1 - Least Number Of Moves:  +((GameActivity) activity).getLevelScore(1) + Best Time:  +((GameActivity) activity).getLevelTime(1) + Level Passed = +((GameActivity) activity).isLevelBeat(1)); "
	    		, new TextOptions(HorizontalAlign.CENTER), vbom);
	
	    
	    
	    HighScore1.setScale(0.7f); 
	    HighScore11.setScale(0.7f); 
	    String s;
    	if(((GameActivity) activity).isLevelBeat(21).equalsIgnoreCase("true")){
    		s = "Yes";
    	}else{
    		s = "No";
    	}
	    HighScore1.setText("Level 1   -   Least Number Of Moves: " +((GameActivity) activity).getLevelScore(21) + "    Best Time: " +((GameActivity) activity).getLevelTime(21) + "    Level Passed = " +
	    		s); 
	    HighScore11.setText("Level 1   -   Least Number Of Moves: " +((GameActivity) activity).getLevelScore(21) + "    Best Time: " +((GameActivity) activity).getLevelTime(21) + "    Level Passed = " +
	    		s); 
	    
	    if(((GameActivity) activity).isLevelUnLocked(22).equalsIgnoreCase("true")){
	    	
	    	if(((GameActivity) activity).isLevelBeat(22).equalsIgnoreCase("true")){
	    		s = "Yes";
	    	}else{
	    		s = "No";
	    	}
	    	HighScore2.setText("Level 2   -   Least Number Of Moves: " +((GameActivity) activity).getLevelScore(22) + "    Best Time: " +((GameActivity) activity).getLevelTime(22) + "   Level Passed = " +
		    		s); 
		    HighScore2.setScale(0.7f); 
		    
		    HighScore22.setText("Level 2   -   Least Number Of Moves: " +((GameActivity) activity).getLevelScore(22) + "    Best Time: " +((GameActivity) activity).getLevelTime(22) + "   Level Passed = " + s); 
		    HighScore22.setScale(0.7f); 

	    }else{
		    HighScore2.setText("Level 2 is not yet unlocked! ");
		    HighScore22.setText("Level 2 is not yet unlocked! ");

	    }
	   
	    
	    if(((GameActivity) activity).isLevelUnLocked(23).equalsIgnoreCase("true")){
	    	
	    	if(((GameActivity) activity).isLevelBeat(23).equalsIgnoreCase("true")){
	    		s = "Yes";
	    	}else{
	    		s = "No";
	    	}
	    	HighScore3.setText("Level 3   -   Least Number Of Moves: " +((GameActivity) activity).getLevelScore(23) + "    Best Time: " +((GameActivity) activity).getLevelTime(23) + "   Level Passed = " +
		    		s); 
		    HighScore3.setScale(0.7f); 
		    
		    HighScore33.setText("Level 3   -   Least Number Of Moves: " +((GameActivity) activity).getLevelScore(23) + "    Best Time: " +((GameActivity) activity).getLevelTime(23) + "   Level Passed = " +
		    		s); 
		    HighScore33.setScale(0.7f); 

	    }else{
		    HighScore3.setText("Level 3 is not yet unlocked! "); 
		    HighScore33.setText("Level 3 is not yet unlocked! "); 

	    	
	    }
	    
	    if(((GameActivity) activity).isLevelUnLocked(24).equalsIgnoreCase("true")){
	    	
	    	if(((GameActivity) activity).isLevelBeat(24).equalsIgnoreCase("true")){
	    		s = "Yes";
	    	}else{
	    		s = "No";
	    	}
	    	HighScore4.setText("Level 4   -   Least Number Of Moves: " +((GameActivity) activity).getLevelScore(24) + "    Best Time: " +((GameActivity) activity).getLevelTime(24) + "   Level Passed = " +
		    		s); 
		    HighScore4.setScale(0.7f); 
		    HighScore44.setText("Level 4   -   Least Number Of Moves: " +((GameActivity) activity).getLevelScore(24) + "    Best Time: " +((GameActivity) activity).getLevelTime(24) + "   Level Passed = " +
		    		s); 
		    HighScore44.setScale(0.7f); 

	    }else{
		    HighScore4.setText("Level 4 is not yet unlocked!");
		    HighScore44.setText("Level 4 is not yet unlocked!");

	    }
	    if(((GameActivity) activity).isLevelUnLocked(25).equalsIgnoreCase("true")){
	    	if(((GameActivity) activity).isLevelBeat(25).equalsIgnoreCase("true")){
	    		s = "Yes";
	    	}else{
	    		s = "No";
	    	}
	    	HighScore5.setText("Level 5   -   Least Number Of Moves: " +((GameActivity) activity).getLevelScore(25) + "    Best Time: " +((GameActivity) activity).getLevelTime(25) + "   Level Passed = " +
		    		s);
		    HighScore5.setScale(0.7f); 
		    
		    HighScore55.setText("Level 5   -   Least Number Of Moves: " +((GameActivity) activity).getLevelScore(25) + "    Best Time: " +((GameActivity) activity).getLevelTime(25) + "   Level Passed = " +
		    		s);
		    HighScore55.setScale(0.7f); 

	    }else{
		    HighScore5.setText("Level 5 is not yet unlocked!");
		    HighScore55.setText("Level 5 is not yet unlocked!");

	    }
	    if(((GameActivity) activity).isLevelUnLocked(26).equalsIgnoreCase("true")){
	    	if(((GameActivity) activity).isLevelBeat(26).equalsIgnoreCase("true")){
	    		s = "Yes";
	    	}else{
	    		s = "No";
	    	}
	    	HighScore6.setText("Level 6   -   Least Number Of Moves: " +((GameActivity) activity).getLevelScore(26) + "    Best Time: " +((GameActivity) activity).getLevelTime(26) + "   Level Passed = " +
		    		s);
		    HighScore6.setScale(0.7f); 
		    
		    HighScore66.setText("Level 6   -   Least Number Of Moves: " +((GameActivity) activity).getLevelScore(26) + "    Best Time: " +((GameActivity) activity).getLevelTime(26) + "   Level Passed = " +
		    		s);
		    HighScore66.setScale(0.7f);

	    }else{
		    HighScore6.setText("Level 6 is not yet unlocked!");
		    HighScore66.setText("Level 6 is not yet unlocked!");

	    }
	    if(((GameActivity) activity).isLevelUnLocked(27).equalsIgnoreCase("true")){
	    	if(((GameActivity) activity).isLevelBeat(27).equalsIgnoreCase("true")){
	    		s = "Yes";
	    	}else{
	    		s = "No";
	    	}
	    	HighScore7.setText("Level 7   -   Least Number Of Moves: " +((GameActivity) activity).getLevelScore(27) + "    Best Time: " +((GameActivity) activity).getLevelTime(27) + "   Level Passed = " +
		    		s);
		    HighScore7.setScale(0.7f); 
		    
		    HighScore77.setText("Level 7   -   Least Number Of Moves: " +((GameActivity) activity).getLevelScore(27) + "    Best Time: " +((GameActivity) activity).getLevelTime(27) + "   Level Passed = " +
		    		s);
		    HighScore77.setScale(0.7f);

	    }else{
		    HighScore7.setText("Level 7 is not yet unlocked!");
		    HighScore77.setText("Level 7 is not yet unlocked!");

	    }
	    if(((GameActivity) activity).isLevelUnLocked(28).equalsIgnoreCase("true")){
	    	if(((GameActivity) activity).isLevelBeat(28).equalsIgnoreCase("true")){
	    		s = "Yes";
	    	}else{
	    		s = "No";
	    	}
	    	HighScore8.setText("Level 8   -   Least Number Of Moves: " +((GameActivity) activity).getLevelScore(28) + "    Best Time: " +((GameActivity) activity).getLevelTime(28) + "   Level Passed = " +
		    		s);
		    HighScore8.setScale(0.7f); 
		    
		    HighScore88.setText("Level 8   -   Least Number Of Moves: " +((GameActivity) activity).getLevelScore(28) + "    Best Time: " +((GameActivity) activity).getLevelTime(28) + "   Level Passed = " +
		    		s);
		    HighScore88.setScale(0.7f);

	    }else{
		    HighScore8.setText("Level 8 is not yet unlocked!");
		    HighScore88.setText("Level 8 is not yet unlocked!");

	    }
	    
	    if(((GameActivity) activity).isLevelUnLocked(29).equalsIgnoreCase("true")){
	    	if(((GameActivity) activity).isLevelBeat(29).equalsIgnoreCase("true")){
	    		s = "Yes";
	    	}else{
	    		s = "No";
	    	}
	    	HighScore9.setText("Level 9   -   Least Number Of Moves: " +((GameActivity) activity).getLevelScore(29) + "    Best Time: " +((GameActivity) activity).getLevelTime(29) + "   Level Passed = " +
		    		s);
		    HighScore9.setScale(0.7f); 
		    
		    HighScore99.setText("Level 9   -   Least Number Of Moves: " +((GameActivity) activity).getLevelScore(29) + "    Best Time: " +((GameActivity) activity).getLevelTime(29) + "   Level Passed = " +
		    		s);
		    HighScore99.setScale(0.7f);

	    }else{
		    HighScore9.setText("Level 9 is not yet unlocked!");
		    HighScore99.setText("Level 9 is not yet unlocked!");

	    }
	    if(((GameActivity) activity).isLevelUnLocked(30).equalsIgnoreCase("true")){
	    	if(((GameActivity) activity).isLevelBeat(30).equalsIgnoreCase("true")){
	    		s = "Yes";
	    	}else{
	    		s = "No";
	    	}
	    	HighScore10.setText("Level 30   -   Least Number Of Moves: " +((GameActivity) activity).getLevelScore(30) + "    Best Time: " +((GameActivity) activity).getLevelTime(30) + "   Level Passed = " +
		    		s);
		    HighScore10.setScale(0.7f); 
		    
		    HighScore1010.setText("Level 30   -   Least Number Of Moves: " +((GameActivity) activity).getLevelScore(30) + "    Best Time: " +((GameActivity) activity).getLevelTime(30) + "   Level Passed = " +
		    		s);
		    HighScore1010.setScale(0.7f);

	    }else{
		    HighScore10.setText("Level 10 is not yet unlocked!");
		    HighScore1010.setText("Level 10 is not yet unlocked!");

	    }
	    
	    HighScore11.setColor(0, 0, 0);
	    HighScore22.setColor(0, 0, 0);
	    HighScore33.setColor(0, 0, 0);
	    HighScore44.setColor(0, 0, 0);
	    HighScore55.setColor(0, 0, 0);
	    HighScore66.setColor(0, 0, 0);
	    HighScore77.setColor(0, 0, 0);
	    HighScore88.setColor(0, 0, 0);
	    HighScore99.setColor(0, 0, 0);
	    HighScore1010.setColor(0, 0, 0);
	    
	    this.attachChild(HighScore1);
	    this.attachChild(HighScore2);
	    this.attachChild(HighScore3);
	    this.attachChild(HighScore4);
	    this.attachChild(HighScore5);
	    this.attachChild(HighScore6);
	    this.attachChild(HighScore7);
	    this.attachChild(HighScore8);
	    this.attachChild(HighScore9);
	    this.attachChild(HighScore10);
	    this.attachChild(HighScore11);
	    this.attachChild(HighScore22);
	    this.attachChild(HighScore33);
	    this.attachChild(HighScore44);
	    this.attachChild(HighScore55);
	    this.attachChild(HighScore66);
	    this.attachChild(HighScore77);
	    this.attachChild(HighScore88);
	    this.attachChild(HighScore99);
	    this.attachChild(HighScore1010);
		
	}

	public void createText(){
		HighScore1 = new Text(400, 330, resourceController.font, 
	    		"HighScore1.setText(Level 1 - Least Number Of Moves:  +((GameActivity) activity).getLevelScore(1) + Best Time:  +((GameActivity) activity).getLevelTime(1) + Level Passed = +((GameActivity) activity).isLevelBeat(1)); "
	    		, new TextOptions(HorizontalAlign.CENTER), vbom);
	    HighScore2 = new Text(400, 272, resourceController.font,
	    		"HighScore1.setText(Level 1 - Least Number Of Moves:  +((GameActivity) activity).getLevelScore(1) + Best Time:  +((GameActivity) activity).getLevelTime(1) + Level Passed = +((GameActivity) activity).isLevelBeat(1)); "
	    		, new TextOptions(HorizontalAlign.CENTER), vbom);
	    HighScore3 = new Text(400, 224, resourceController.font, 
	    		"HighScore1.setText(Level 1 - Least Number Of Moves:  +((GameActivity) activity).getLevelScore(1) + Best Time:  +((GameActivity) activity).getLevelTime(1) + Level Passed = +((GameActivity) activity).isLevelBeat(1)); "
	    		, new TextOptions(HorizontalAlign.CENTER), vbom);
	    HighScore4 = new Text(400, 176, resourceController.font, 
	    		"HighScore1.setText(Level 1 - Least Number Of Moves:  +((GameActivity) activity).getLevelScore(1) + Best Time:  +((GameActivity) activity).getLevelTime(1) + Level Passed = +((GameActivity) activity).isLevelBeat(1)); "
	    		, new TextOptions(HorizontalAlign.CENTER), vbom);
	    HighScore5 = new Text(400, 128, resourceController.font, 
	    		"HighScore1.setText(Level 1 - Least Number Of Moves:  +((GameActivity) activity).getLevelScore(1) + Best Time:  +((GameActivity) activity).getLevelTime(1) + Level Passed = +((GameActivity) activity).isLevelBeat(1)); "
	    		, new TextOptions(HorizontalAlign.CENTER), vbom);
	    HighScore6 = new Text(400, 70, resourceController.font, 
	    		"HighScore1.setText(Level 1 - Least Number Of Moves:  +((GameActivity) activity).getLevelScore(1) + Best Time:  +((GameActivity) activity).getLevelTime(1) + Level Passed = +((GameActivity) activity).isLevelBeat(1)); "
	    		, new TextOptions(HorizontalAlign.CENTER), vbom);
	    
	    HighScore11 = new Text(398, 328, resourceController.font, 
	    		"HighScore1.setText(Level 1 - Least Number Of Moves:  +((GameActivity) activity).getLevelScore(1) + Best Time:  +((GameActivity) activity).getLevelTime(1) + Level Passed = +((GameActivity) activity).isLevelBeat(1)); "
	    		, new TextOptions(HorizontalAlign.CENTER), vbom);
	    HighScore22 = new Text(398, 270, resourceController.font,
	    		"HighScore1.setText(Level 1 - Least Number Of Moves:  +((GameActivity) activity).getLevelScore(1) + Best Time:  +((GameActivity) activity).getLevelTime(1) + Level Passed = +((GameActivity) activity).isLevelBeat(1)); "
	    		, new TextOptions(HorizontalAlign.CENTER), vbom);
	    HighScore33 = new Text(398, 222, resourceController.font, 
	    		"HighScore1.setText(Level 1 - Least Number Of Moves:  +((GameActivity) activity).getLevelScore(1) + Best Time:  +((GameActivity) activity).getLevelTime(1) + Level Passed = +((GameActivity) activity).isLevelBeat(1)); "
	    		, new TextOptions(HorizontalAlign.CENTER), vbom);
	    HighScore44 = new Text(398, 174, resourceController.font, 
	    		"HighScore1.setText(Level 1 - Least Number Of Moves:  +((GameActivity) activity).getLevelScore(1) + Best Time:  +((GameActivity) activity).getLevelTime(1) + Level Passed = +((GameActivity) activity).isLevelBeat(1)); "
	    		, new TextOptions(HorizontalAlign.CENTER), vbom);
	    HighScore55 = new Text(398, 126, resourceController.font, 
	    		"HighScore1.setText(Level 1 - Least Number Of Moves:  +((GameActivity) activity).getLevelScore(1) + Best Time:  +((GameActivity) activity).getLevelTime(1) + Level Passed = +((GameActivity) activity).isLevelBeat(1)); "
	    		, new TextOptions(HorizontalAlign.CENTER), vbom);
	    HighScore66 = new Text(398, 68, resourceController.font, 
	    		"HighScore1.setText(Level 1 - Least Number Of Moves:  +((GameActivity) activity).getLevelScore(1) + Best Time:  +((GameActivity) activity).getLevelTime(1) + Level Passed = +((GameActivity) activity).isLevelBeat(1)); "
	    		, new TextOptions(HorizontalAlign.CENTER), vbom);
	
	    
	    
	    HighScore1.setScale(0.7f); 
	    HighScore11.setScale(0.7f); 
	    String s;
    	if(((GameActivity) activity).isLevelBeat(1).equalsIgnoreCase("true")){
    		s = "Yes";
    	}else{
    		s = "No";
    	}
	    HighScore1.setText("Level 1   -   Least Number Of Moves: " +((GameActivity) activity).getLevelScore(1) + "    Best Time: " +((GameActivity) activity).getLevelTime(1) + "    Level Passed = " +
	    		s); 
	    HighScore11.setText("Level 1   -   Least Number Of Moves: " +((GameActivity) activity).getLevelScore(1) + "    Best Time: " +((GameActivity) activity).getLevelTime(1) + "    Level Passed = " +
	    		s); 
	    
	    if(((GameActivity) activity).isLevelUnLocked(2).equalsIgnoreCase("true")){
	    	
	    	if(((GameActivity) activity).isLevelBeat(2).equalsIgnoreCase("true")){
	    		s = "Yes";
	    	}else{
	    		s = "No";
	    	}
	    	HighScore2.setText("Level 2   -   Least Number Of Moves: " +((GameActivity) activity).getLevelScore(2) + "    Best Time: " +((GameActivity) activity).getLevelTime(2) + "   Level Passed = " +
		    		s); 
		    HighScore2.setScale(0.7f); 
		    
		    HighScore22.setText("Level 2   -   Least Number Of Moves: " +((GameActivity) activity).getLevelScore(2) + "    Best Time: " +((GameActivity) activity).getLevelTime(2) + "   Level Passed = " + s); 
		    HighScore22.setScale(0.7f); 

	    }else{
		    HighScore2.setText("Level 2 is not yet unlocked! ");
		    HighScore22.setText("Level 2 is not yet unlocked! ");

	    }
	   
	    
	    if(((GameActivity) activity).isLevelUnLocked(3).equalsIgnoreCase("true")){
	    	
	    	if(((GameActivity) activity).isLevelBeat(3).equalsIgnoreCase("true")){
	    		s = "Yes";
	    	}else{
	    		s = "No";
	    	}
	    	HighScore3.setText("Level 3   -   Least Number Of Moves: " +((GameActivity) activity).getLevelScore(3) + "    Best Time: " +((GameActivity) activity).getLevelTime(3) + "   Level Passed = " +
		    		s); 
		    HighScore3.setScale(0.7f); 
		    
		    HighScore33.setText("Level 3   -   Least Number Of Moves: " +((GameActivity) activity).getLevelScore(3) + "    Best Time: " +((GameActivity) activity).getLevelTime(3) + "   Level Passed = " +
		    		s); 
		    HighScore33.setScale(0.7f); 

	    }else{
		    HighScore3.setText("Level 3 is not yet unlocked! "); 
		    HighScore33.setText("Level 3 is not yet unlocked! "); 

	    	
	    }
	    
	    if(((GameActivity) activity).isLevelUnLocked(4).equalsIgnoreCase("true")){
	    	
	    	if(((GameActivity) activity).isLevelBeat(4).equalsIgnoreCase("true")){
	    		s = "Yes";
	    	}else{
	    		s = "No";
	    	}
	    	HighScore4.setText("Level 4   -   Least Number Of Moves: " +((GameActivity) activity).getLevelScore(4) + "    Best Time: " +((GameActivity) activity).getLevelTime(4) + "   Level Passed = " +
		    		s); 
		    HighScore4.setScale(0.7f); 
		    HighScore44.setText("Level 4   -   Least Number Of Moves: " +((GameActivity) activity).getLevelScore(4) + "    Best Time: " +((GameActivity) activity).getLevelTime(4) + "   Level Passed = " +
		    		s); 
		    HighScore44.setScale(0.7f); 

	    }else{
		    HighScore4.setText("Level 4 is not yet unlocked!");
		    HighScore44.setText("Level 4 is not yet unlocked!");

	    }
	    if(((GameActivity) activity).isLevelUnLocked(5).equalsIgnoreCase("true")){
	    	if(((GameActivity) activity).isLevelBeat(5).equalsIgnoreCase("true")){
	    		s = "Yes";
	    	}else{
	    		s = "No";
	    	}
	    	HighScore5.setText("Level 5   -   Least Number Of Moves: " +((GameActivity) activity).getLevelScore(5) + "    Best Time: " +((GameActivity) activity).getLevelTime(5) + "   Level Passed = " +
		    		s);
		    HighScore5.setScale(0.7f); 
		    
		    HighScore55.setText("Level 5   -   Least Number Of Moves: " +((GameActivity) activity).getLevelScore(5) + "    Best Time: " +((GameActivity) activity).getLevelTime(5) + "   Level Passed = " +
		    		s);
		    HighScore55.setScale(0.7f); 

	    }else{
		    HighScore5.setText("Level 5 is not yet unlocked!");
		    HighScore55.setText("Level 5 is not yet unlocked!");

	    }
	    if(((GameActivity) activity).isLevelUnLocked(6).equalsIgnoreCase("true")){
	    	if(((GameActivity) activity).isLevelBeat(6).equalsIgnoreCase("true")){
	    		s = "Yes";
	    	}else{
	    		s = "No";
	    	}
	    	HighScore6.setText("Level 6   -   Least Number Of Moves: " +((GameActivity) activity).getLevelScore(6) + "    Best Time: " +((GameActivity) activity).getLevelTime(6) + "   Level Passed = " +
		    		s);
		    HighScore6.setScale(0.7f); 
		    
		    HighScore66.setText("Level 6   -   Least Number Of Moves: " +((GameActivity) activity).getLevelScore(6) + "    Best Time: " +((GameActivity) activity).getLevelTime(6) + "   Level Passed = " +
		    		s);
		    HighScore66.setScale(0.7f);

	    }else{
		    HighScore6.setText("Level 6 is not yet unlocked!");
		    HighScore66.setText("Level 6 is not yet unlocked!");

	    }
	    HighScore11.setColor(0, 0, 0);
	    HighScore22.setColor(0, 0, 0);
	    HighScore33.setColor(0, 0, 0);
	    HighScore44.setColor(0, 0, 0);
	    HighScore55.setColor(0, 0, 0);
	    HighScore66.setColor(0, 0, 0);
	
	    this.attachChild(HighScore1);
	    this.attachChild(HighScore2);
	    this.attachChild(HighScore3);
	    this.attachChild(HighScore4);
	    this.attachChild(HighScore5);
	    this.attachChild(HighScore6);
	    this.attachChild(HighScore11);
	    this.attachChild(HighScore22);
	    this.attachChild(HighScore33);
	    this.attachChild(HighScore44);
	    this.attachChild(HighScore55);
	    this.attachChild(HighScore66);

	}
	@Override
	public void onBackKeyPressed() {
		
		if(!ResourceController.getInstance().gameMode){
    		
	        SceneController.getInstance().loadGameOptionScene();

    	}else{
        	SceneController.getInstance().loadGameOrderOptionScene();
    	}
		
	}

	@Override
	public SceneType getSceneType() {
		return SceneType.SCENE_HIGHSCORE;
	}

	@Override
	public void disposeScene() {
		background.detachSelf();
		background.dispose();
		this.detachSelf();
		this.dispose();
	}
	
	
	
	public void createBackground(){
		
		background = new Sprite(400,240, ResourceController.getInstance().HighScore, vbom){
			@Override
			protected void preDraw(GLState pGLState, Camera pCamera){
				super.preDraw(pGLState, pCamera);
			    pGLState.enableDither();
			    
			}
			
			
		};
		
		attachChild(background);

	}
	
	






}
