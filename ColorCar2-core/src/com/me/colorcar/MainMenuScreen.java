package com.me.colorcar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Helpers.AssetLoader;
import com.me.Screens.GameScreen;

public class MainMenuScreen implements Screen {

	final ColorCarGame game;
	private BitmapFont font;
	public SpriteBatch batch;
	
	public MainMenuScreen(final ColorCarGame gam) {
		game = gam;
		batch = new SpriteBatch();
		
	}
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        
        //System.out.println("Main Menu");
        
        //batch.setProjectionMatrix(camera.combined);
        
        font = new BitmapFont();
		font.setColor(0.0f, 0.0f, 1.0f, 1.0f);
		
		batch.begin();
		AssetLoader.font.draw(batch, "Test", 200, 200);
		//System.out.println("ColorCar");
		batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen());
            dispose();
        }
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
}
