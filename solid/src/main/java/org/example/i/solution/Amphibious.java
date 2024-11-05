package org.example.i.solution;

public class Amphibious implements Drivable, Sailable {

	@Override
	public void sail() {
		System.out.println("Amphibious sailes");
	}

	@Override
	public void drive() {
		System.out.println("Amphibious drives");
	}

}
