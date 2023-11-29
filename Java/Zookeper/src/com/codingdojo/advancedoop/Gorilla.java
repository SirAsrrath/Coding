package com.codingdojo.advancedoop;

public class Gorilla extends Mammal {
	
	public Gorilla(int energy) {
		super(energy);
	}
	
	
	public void throwSomething() {
		System.out.println("The gorilla has thrown something");
		energy = energy - 5;
	}
	
	public void eatBananas() {
		System.out.println("The gorilla ate a delicious banana");
		energy = energy + 10;
	}
	
	public void climb() {
		System.out.println("The gorilla climbed a tree");
		energy = energy - 10;
	}
}
