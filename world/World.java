package org.world;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import org.graphics.FillMode;
import org.graphics.Graphics;
import org.graphics.Renderer;
import org.world.entities.Cow;
import org.world.tiles.Tile;

public class World {
	private static ArrayList<GameObject> _gameObjectList;
	
	public static int mapWidth = Renderer.GetWindowWidth()/GameObject.tilesize;
	public static int mapHeight = Renderer.GetWindowHeight()/GameObject.tilesize;
	
	
	public static void Update() {
		for(GameObject go : _gameObjectList)
		{
			go.Update();
		}
	}
	
	public static void Render() {
		for(GameObject go : _gameObjectList)
		{
			go.Render();
		}
	}
	
	public static void Init()
	{
		_gameObjectList = new ArrayList<>();
		
		for(int i = 0; i < mapHeight; i ++)
		{
			for(int j = 0; j < mapWidth; j ++)
			{
				_gameObjectList.add(new Tile(j,i));
			}
		}
		
		for(int i = 0; i < 10; i ++)
		{
			int x=ThreadLocalRandom.current().nextInt(0,mapWidth+1);
			int y=ThreadLocalRandom.current().nextInt(0,mapHeight+1);
			System.out.println("X:" + x + " Y:" + y);
			_gameObjectList.add(new Cow(x,y));
		}
	}

	public static Tile GetTile(int x, int y) {
		for(GameObject go : _gameObjectList)
		{
			if(go.getClass() == Tile.class)
			{
				if(go.x == x && go.y == y)
				{
					return (Tile)go;
				}
			}
		}
		return null;
	}
	
}
