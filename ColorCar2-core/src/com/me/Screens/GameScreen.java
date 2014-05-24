package com.me.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.me.Helpers.AssetLoader;
import com.me.colorcar.GameRenderer;
import com.me.colorcar.GameWorld;

public class GameScreen extends Sprite implements Screen {
	
	private GameWorld world;
	private GameRenderer renderer;
	
	public static int deviceWidth;
	public static int deviceHeight;
    public static final int VIRTUAL_WIDTH = 1080; //All sprites will be scaled assuming a 720x1280 device
    public static final int VIRTUAL_HEIGHT = 1920;
    public static final float VIRTUAL_ASPECT_RATIO = (float)VIRTUAL_HEIGHT/(float)VIRTUAL_WIDTH;
    private OrthographicCamera camera;
	
	public GameScreen() {
		System.out.println("GameScreen Attatched");
		deviceWidth = Gdx.graphics.getWidth();
        deviceHeight = Gdx.graphics.getHeight();
        System.out.println(deviceHeight);
        camera = new OrthographicCamera(deviceWidth, deviceHeight);
        System.out.println(deviceWidth);
		//float gameWidth = 1080;
		//float gameHeight = screenHeight / (screenWidth / gameWidth);
		
		world = new GameWorld(); //initialize world
		renderer = new GameRenderer(world); //initialize renderer
		
	}
	
	
	@Override
	public void render(float delta) { //game loop
		// TODO Auto-generated method stub
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		camera.update();
		world.update(delta);
		renderer.render();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		System.out.println("GameScreen - resizing");
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("GameScreen - show called");
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		System.out.println("GameScreen - hide called");
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		System.out.println("GameScreen - pause called");
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		System.out.println("GameScreen - resume called");
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
