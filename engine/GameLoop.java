package org.engine;

import org.graphics.Renderer;
import org.world.World;

public class GameLoop {

	private static boolean isRunning = false;
	
	public static void Start() {
		Thread thread = new Thread() {
			public void run() {
				
				isRunning = true;
				while(isRunning){
					//Poll input
					
					//Update game state
					World.Update();
					
					//Render
					Renderer.Render();
					
					try {
						Thread.sleep((long)750);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		thread.setName("GameLoop");
		thread.start();
	}
	
	public static void StopRunning()
	{
		isRunning = false;
	}
}
