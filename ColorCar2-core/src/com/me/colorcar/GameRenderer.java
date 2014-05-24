package com.me.colorcar;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.me.Helpers.AssetLoader;
import com.me.Screens.GameScreen;

public class GameRenderer extends Sprite {
	
	private GameWorld myWorld;
	private ShapeRenderer shapeRenderer;
	private int gameHeight;	
	private SpriteBatch batch;
	private int score;	
	//Variables to control obstacle appearances
    private List<Obstacle> obstacles = new ArrayList<Obstacle>();
    private Random rn = new Random();
    private int sleepCount = 0; //Will keep bars apart enough to keep game playable
    private int chance = 25; //Odds of a bar appearing
    
    
	
	public GameRenderer(GameWorld world) {
		myWorld = world;		
		batch = new SpriteBatch();
		score = 0;
	}
	
	
	
	
	public void render() {
		// TODO Auto-generated method stub
		
		System.out.println("GameRenderer - render");
		
		
		
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		
		AssetLoader.sprite.draw(batch);
		AssetLoader.sprite1.draw(batch);
		AssetLoader.sprite2.draw(batch);
		
		AssetLoader.font.setScale(3f);
		AssetLoader.font.setColor(255.0f, 1.0f, 1.0f, 1.0f);
		AssetLoader.font.draw(batch, Integer.toString(score), GameScreen.deviceWidth /2, GameScreen.deviceHeight);
		
		System.out.println("GameRenderer - render");
		batch.end();
		
		//lines from top
		batch.begin();
		sleepCount--;
		if(rn.nextInt(chance) == 0) { //Creates obstacle when 0 is generated from range 0-chance
    		if(chance != 1)
    			chance--; //Slowly makes it more likely bar will appear until odds are 1/1
    		int color = rn.nextInt(3); //TODO Change 3 to difficulty variable
    		if(sleepCount <= 0) { //Creates obstacle if enough distance from last one
    			switch(color) { //Creates red blue or green based on difficulty
        			case 0: obstacles.add(new Obstacle(Color.RED, "Red", new Texture(Gdx.files.internal("data/Neon Red.jpg"))));
        			break;
        			case 1: obstacles.add(new Obstacle(Color.BLUE, "Blue", new Texture(Gdx.files.internal("data/Neon Blue.jpg"))));
        			break;
        			case 2: obstacles.add(new Obstacle(Color.GREEN, "Green", new Texture(Gdx.files.internal("data/Neon Green.jpg"))));
        			break;
        			//TODO add cases for yellow and white
    			}
    			sleepCount = 100; //Keeps another bar from appearing for 100 frames
    		}
    	}
		for(int i = 0; i < obstacles.size(); i++) { //Loop to allow each obstacle on the screen to act
    		Obstacle obstacle = obstacles.get(i);
    	
    		//Moving each obstacle down toward car
    		obstacle.act();
    		obstacle.draw(batch);
    		
    		
    			
    	/**
    		if(AssetLoader.Bcar.g
    		//Checking each obstacle for collision with car
    		if(ColorCarGame.getBoundingRectangle().overlaps(obstacle.getBoundingRectangle()) && (obstacle.isScoredOn() == false)) {
    			if(ColorCarGame.getLabel().equals(obstacle.getColorLabel())) { //If colors are the same score goes up
    				score++;		
    			}
    			else { //Otherwise game is over
    			
    				System.out.println("Game Over");
    				//System.exit(0); //Added a termination of program when losing
    			}
    			obstacle.setScoredOn(true); //Keeps obstacle collision from being counted more than once
    		
    		}
    		if(obstacles.get(i).getY() > deviceHeight) //Removing all obstacles that are below the car (i.e. off-screen)
    			obstacles.remove(i);
    	
		**/
    		
		}
		batch.end();
	}
	/**
	public void scale() {
		//Getting information about device screen ratio
		float deviceWidth = Gdx.graphics.getWidth();
		float deviceHeight = Gdx.graphics.getHeight();
		float deviceAspectRatio = deviceWidth/deviceHeight;
		
		float scalar = deviceAspectRatio / GameScreen.VIRTUAL_ASPECT_RATIO;
		setSize(getWidth()/scalar, getHeight()/scalar);
	} **/

}
