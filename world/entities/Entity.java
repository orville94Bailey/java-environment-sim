package org.world.entities;

import java.util.ArrayList;

import org.world.GameObject;

abstract class Entity extends GameObject {
	ArrayList<Float> Nutrients = null;
	
	Genome genes = null;
}
