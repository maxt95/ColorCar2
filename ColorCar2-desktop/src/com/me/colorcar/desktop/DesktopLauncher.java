package com.me.colorcar.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.me.colorcar.ColorCarGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "ColorCar";
		cfg.width = 272;
		cfg.height = 408;
		new LwjglApplication(new ColorCarGame(), cfg);
	}
}
