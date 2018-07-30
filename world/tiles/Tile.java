package org.world.tiles;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import org.core.HelperFunctions;
import org.graphics.Graphics;
import org.world.GameObject;
import org.world.NutrientTypes;

public class Tile extends GameObject{
	private ArrayList<Float> MaxNutrients;
	private ArrayList<Float> Nutrients;
	private float _maxNutrients;
	
	public Tile(int x, int y)
	{
		MaxNutrients = new ArrayList<Float>();
		Nutrients = new ArrayList<Float>();
		
		this.height = tilesize;
		this.width = tilesize;
		
		this.x = x;
		this.y = y;
		
		for(int i = 0; i < NutrientTypes.values().length; i ++)
		{
			MaxNutrients.add(HelperFunctions.generateRandomFloat(0f, 5f));
			Nutrients.add(HelperFunctions.generateRandomFloat(0, MaxNutrients.get(i)));
		}
	}
	
	public boolean HasEnoughToEat(NutrientTypes nutrient, float hunger)
	{
		if(Nutrients.get(nutrient.ordinal()) >= hunger)
		{
			return true;
		}
		return false;
	}
	
	public void LoseNutrient(NutrientTypes nutrient, float amount)
	{
		Nutrients.set(nutrient.ordinal(), Math.max(0, Nutrients.get(nutrient.ordinal()) - amount));
	}
	
 	float GetMaxNutrients()
	{
		return _maxNutrients;
	}
	
	public void Render()
	{
		Graphics.SetColor(Nutrients.get(NutrientTypes.R.ordinal())/MaxNutrients.get(NutrientTypes.R.ordinal()),
				Nutrients.get(NutrientTypes.G.ordinal())/MaxNutrients.get(NutrientTypes.G.ordinal()),
				Nutrients.get(NutrientTypes.B.ordinal())/MaxNutrients.get(NutrientTypes.B.ordinal()),
				.75f);
		Graphics.FillRect(x*tilesize, y*tilesize, width, height);
	}
	
	public void Update()
	{
		int random = ThreadLocalRandom.current().nextInt(1000);
		
		if(random >= NutrientTypes.values().length)
		{
			return;
		}
		
		if(MaxNutrients.get(random) > Nutrients.get(random))
		{
			Nutrients.set(random,
					Math.min(MaxNutrients.get(random), 
							Nutrients.get(random) + HelperFunctions.generateRandomFloat(-1f, 1f))
					);
		}
	}
}
