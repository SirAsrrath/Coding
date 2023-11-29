package com.codingdojo.advancedoop;

public class Mammal {
	protected int energy = 100;
	
	public Mammal(int energy) {
		this.energy = energy;
	}

	public void displayEnergy() {
		System.out.println("The energy is: " + energy);
	}
	
// Getters & Setters
	
	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}
}
