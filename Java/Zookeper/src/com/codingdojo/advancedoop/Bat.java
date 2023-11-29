package com.codingdojo.advancedoop;

public class Bat extends Mammal {
	
	public Bat(int energy) {
		super(energy);
	}
	
	
	public void fly() {
		System.out.println("The bat is airborne");
		energy = energy - 50;
	}
	
	public void eatHumans() {
		System.out.println("The bat ate a delicious human");
		energy = energy + 25;
	}
	
	public void attackTown() {
		System.out.println("The bat attacked a town!");
		energy = energy - 100;
	}
}
