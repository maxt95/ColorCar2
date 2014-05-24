package com.me.colorcar;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Obstacle extends Sprite {
	//Class variables
		private Random rn;
		private Color color;
		private String colorLabel; //String representation of color
		private boolean scoredOn; //Keeps obstacle from being counted more than once
		
		/**
		 * Constructor for obstacles. Sets color, colorLabel, and scales it to block
		 * the entire width of the screen
		 * @param color
		 * @param colorLabel
		 * @param tx
		 */
		public Obstacle(Color color, String colorLabel, Texture tx) {
			super(tx); //Assigns texture to obstacle
			this.color = color;
			this.colorLabel = colorLabel;
			scoredOn = false;
			setColor(color);
			setX(0); setY(Gdx.graphics.getHeight());
			scale();
		}
		
		/**
		 * Scales obstacle based on screen resolution
		 */
		public void scale() {
			int deviceWidth = Gdx.graphics.getWidth();
			int deviceHeight = Gdx.graphics.getHeight();
			setSize(deviceWidth, deviceHeight / 20);
		}
		
		/**
		 * Each obstacle moves down five pixels with each game loop iteration
		 */
		public void act() {
			translateY(-5f);
		}

		public Color getColor() {
			return color;
		}

		public void setColor(Color color) {
			this.color = color;
		}

		public boolean isScoredOn() {
			return scoredOn;
		}

		public void setScoredOn(boolean scoredOn) {
			this.scoredOn = scoredOn;
		}
		
		public String getColorLabel() {
			return colorLabel;
		}

		public void setColorLabel(String colorLabel) {
			this.colorLabel = colorLabel;
		}
}
