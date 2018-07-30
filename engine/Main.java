package org.engine;

import org.graphics.Renderer;
import org.world.World;

public class Main {

	public static void main(String[] args) {
		Renderer.init();
		World.Init();
		GameLoop.Start();
	}

}
