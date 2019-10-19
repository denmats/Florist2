package com.denmats.florist2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FlowerLab {
	private Flower flower;
	private int numOfFlowers;

	private Scanner sc = new Scanner(System.in);

	public FlowerLab(Flower flower) {
		this.flower = flower;
		setNumOfFlowers();
	}

	public Flower getFlower() {
		return flower;
	}

	public int getNumOfFlowers() {
		return numOfFlowers;
	}

	public void setFlower(Flower flower) {
		this.flower = flower;
	}

	public void setNumOfFlowers() {
		System.out.println("Enter number of flowers: ");
		if (sc.hasNext()) {
			try {
				this.numOfFlowers = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Wrong input. Ordered number of flowers is zero");
				this.numOfFlowers = 0;
			}
		}
	}

	@Override
	public String toString() {
		return "\nFlower: " + flower + ", numOfFlower=" + numOfFlowers + "\n";
	}
}
