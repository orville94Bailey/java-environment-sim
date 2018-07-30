package org.core;

import java.util.concurrent.ThreadLocalRandom;

public class HelperFunctions {
	public static float generateRandomFloat(float min, float max) {
		  if (min >= max)
		    throw new IllegalArgumentException("max must be greater than min");
		  float result = ThreadLocalRandom.current().nextFloat() * (max - min) + min;
		  if (result >= max) // correct for rounding
		    result = Float.intBitsToFloat(Float.floatToIntBits(max) - 1);
		  return result;
		}
}
