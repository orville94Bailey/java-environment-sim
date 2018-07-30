package org.world.entities;

import java.util.concurrent.ThreadLocalRandom;

import org.core.HelperFunctions;
import org.world.NutrientTypes;

public class Genome {
	public float EatEfficiency;
	public int OldAgeLimit;
	public float Hunger;
	public float HungryLevel;
	public NutrientTypes Apetite;
	
	public float MoveCost;
	
	public int BreedingCooldown;
	public float BreedingChance;
	
	public int Min_Healthy_R;
	public int Min_Healthy_G;
	public int Min_Healthy_B;
	
	public int Max_Healthy_R;
	public int Max_Healthy_G;
	public int Max_Healthy_B;
	public int Max_Health;
	
	public static Genome RandomGenome()
	{
		Genome genomeHolder = new Genome();
		
		genomeHolder.Apetite= NutrientTypes.values()[ThreadLocalRandom.current().nextInt(NutrientTypes.values().length)];
		
		genomeHolder.Hunger = HelperFunctions.generateRandomFloat(.3f, 1.2f);
	    
	    genomeHolder.BreedingCooldown = ThreadLocalRandom.current().nextInt(20,30);

	    genomeHolder.Min_Healthy_R = ThreadLocalRandom.current().nextInt(20,30);
	    genomeHolder.Max_Healthy_R = ThreadLocalRandom.current().nextInt(genomeHolder.Min_Healthy_R,genomeHolder.Min_Healthy_R + 30);
	    genomeHolder.Min_Healthy_G = ThreadLocalRandom.current().nextInt(20,30);
	    genomeHolder.Max_Healthy_G = ThreadLocalRandom.current().nextInt(genomeHolder.Min_Healthy_G,genomeHolder.Min_Healthy_G + 30);
	    genomeHolder.Min_Healthy_B = ThreadLocalRandom.current().nextInt(20,30);
	    genomeHolder.Max_Healthy_B = ThreadLocalRandom.current().nextInt(genomeHolder.Min_Healthy_B,genomeHolder.Min_Healthy_B + 30);

	    genomeHolder.HungryLevel = ((genomeHolder.Min_Healthy_R + genomeHolder.Max_Healthy_R) /2f) +
	    		((genomeHolder.Min_Healthy_G + genomeHolder.Max_Healthy_G) /2f) +
	    		((genomeHolder.Min_Healthy_B + genomeHolder.Max_Healthy_B) /2f);

	    genomeHolder.MoveCost = HelperFunctions.generateRandomFloat(0.01f, 0.5f);
	    genomeHolder.BreedingChance = HelperFunctions.generateRandomFloat(0f,.03f);
	    genomeHolder.OldAgeLimit = ThreadLocalRandom.current().nextInt(8000,10000);
	    genomeHolder.EatEfficiency = HelperFunctions.generateRandomFloat(.2f,1f);
		
		return genomeHolder;
	}
}
