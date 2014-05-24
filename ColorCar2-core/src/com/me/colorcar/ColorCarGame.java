package com.me.colorcar;

import java.util.List;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Helpers.AssetLoader;
import com.me.Screens.GameScreen;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class ColorCarGame extends Game {

	private List<Texture> textures; //List of files to cycle through for color change
	private List<String> colorLabels; //Strings with color names
	private int colorIndex; //Index to select a color from colors
	private int labelIndex; //Index to select a label from labels
	private String label; //Label that will be assigned string based on color
	
	public SpriteBatch batch;
	public BitmapFont font;
	private int deviceWidth, deviceHeight;
	private OrthographicCamera cam;
	
	private Stage stage;
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		System.out.println("Game Created!");
		AssetLoader.load();
		batch = new SpriteBatch();
		font = new BitmapFont();
		
		deviceWidth = Gdx.graphics.getWidth();
	    deviceHeight = Gdx.graphics.getHeight();
		cam = new OrthographicCamera(deviceWidth, deviceHeight);
		
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        stage = new Stage();
        stage.addActor(AssetLoader.sprite);
        
		this.setScreen(new MainMenuScreen(this));
		//setScreen(new GameScreen());
	}
	
	public void render() {
		super.render();
	}
	
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();
	}
	
	public void act() {
		//Increments index to select next one up
		colorIndex++;
		labelIndex++;
		if(colorIndex == textures.size()) { //Cycles index back to zero when out of range
			colorIndex = 0;
			labelIndex = 0;
		}
		
		//Updating color and label
		//setTexture(textures.get(colorIndex));
		//setLabel(colorLabels.get(labelIndex));
	}
}