package com.me.Helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class AssetLoader extends Sprite {
	
	
	public static Texture bluecar, redcar, greencar;
	public static TextureRegion Bcar, Rcar, Gcar;
	public static BitmapFont font;
	static Sprite sprite1;
	static Sprite sprite2;
	
	public static Texture texture, texture1, texture2;
	static int deviceWidth = Gdx.graphics.getWidth();
	static int deviceHeight = Gdx.graphics.getHeight();
	
	private static Stage stage;
	
	public class BlueCar extends Actor {
        Texture texture = new Texture(Gdx.files.internal("data/bluecar.png"));
       
    }
	
	public static void load() {
		
		//Draws Blue Car
		texture = new Texture(Gdx.files.internal("data/bluecar.png"));
		//texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		stage = new Stage();
		BlueCar myActor = new BlueCar();
		stage.addActor(myActor);
		
		//sprite = new Sprite(texture);
		//sprite.setX(Gdx.graphics.getWidth() / 1.5f);
		//sprite.setSize(deviceWidth / 4.5f, deviceHeight / 6.5f);
		
		
		//Draws Green Car
		texture2 = new Texture(Gdx.files.internal("data/greencar.png"));
		//texture2.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		sprite2 = new Sprite(texture2);
		sprite2.setX(Gdx.graphics.getWidth() / 2.5f);
		sprite2.setSize(deviceWidth / 4.5f, deviceHeight / 6.5f);
		//Draws Red Car
		texture1 = new Texture(Gdx.files.internal("data/redcar.png"));
		//texture1.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		sprite1 = new Sprite(texture1);
		sprite1.setX(Gdx.graphics.getWidth() / 4.5f);
		sprite1.setSize(deviceWidth / 4.5f, deviceHeight / 6.5f);
		//Draws Font
		font = new BitmapFont();
		font.setScale(1, 1);
		font.setColor(255.0f, 1.0f, 1.0f, 1.0f);
		
		
	}
	public void scale() {
		
		setSize(deviceWidth, deviceHeight / 20);
	}
	
	public static void dispose() {
		font.dispose();
		texture.dispose();
		texture1.dispose();
		texture2.dispose();
	}
}
