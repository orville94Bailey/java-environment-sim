 package org.world.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

import org.graphics.Graphics;
import org.world.NutrientTypes;
import org.world.World;
import org.world.tiles.Tile;

public class Cow extends Entity {

	public Cow(int x, int y)
	{
		this.x = x;
		this.y = y;
		init();
	}
	
	private void init() {
		this.genes = Genome.RandomGenome();
		this.Nutrients = new ArrayList<Float>(Collections.nCopies(3, 0f));
	}
	
	public void Update(){
		if(!Eat())
		{
			Move();
		}
	}
	
	public void Render(){
		Graphics.SetColor(.36f, .2f, .09f, 1);
		Graphics.FillCircle(this.x * tilesize, this.y * tilesize, 2, 15);
	}
	
	private void Move()
	{
		switch(ThreadLocalRandom.current().nextInt(4))
		{
		case 0:
			if(this.x + 1 < World.mapWidth)
			{
				this.x ++;
			}
			break;
		case 1:
			if(this.x - 1 > -1)
			{
				this.x --;
			}
			break;
		case 2:
			if(this.y + 1 < World.mapHeight)
			{
				this.y ++;
			}
			break;
		case 3:
			if(this.y - 1 > -1)
			{
				this.y--;
			}
			break;
		}
	}

	private boolean Eat()
	{
		Tile tileHolder = World.GetTile(x,y);
		
		if(tileHolder.HasEnoughToEat(this.genes.Apetite, this.genes.Hunger))
		{
			tileHolder.LoseNutrient(this.genes.Apetite, this.genes.Hunger);
			int randomNutrient = ThreadLocalRandom.current().nextInt(NutrientTypes.values().length); 
			this.Nutrients.set(randomNutrient, Nutrients.get(randomNutrient) + this.genes.Hunger);
			
			return true;
		}
		return false;
	}
}
