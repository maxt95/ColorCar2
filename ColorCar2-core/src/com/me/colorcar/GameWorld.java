package com.me.colorcar;

import com.badlogic.gdx.math.Rectangle;


public class GameWorld {
	
	

	
	private GameState currentState;
	
	public GameWorld() {
		//Initialized
		currentState = GameState.READY;
	}
	
	public void update(float delta) {
		// TODO Auto-generated method stub
		System.out.println("GameWorld - update");
		
		switch (currentState){
		case READY:
			updateReady(delta);
			break;
		case RUNNING:
		default:
			updateRunning(delta);
			break;
		}
		
				
	}
	
	private void updateReady(float delta) {
		
	}
	
	private void updateRunning(float delta) {

		//if () {
			//currentState = GameState.GAMEOVER;
		//
	}
	
	public boolean isReady() {
		return currentState == GameState.READY;
	}
	
	public void start() {
		currentState = GameState.RUNNING;
		
	}
	
	public void restart() {
		currentState = GameState.READY;
		//score = 0;
		currentState = GameState.READY;
	}
	public enum GameState {
		READY, RUNNING, GAMEOVER
	}
	
	
}
