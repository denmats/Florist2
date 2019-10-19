package com.denmats.florist2;

public class Flower {
	private final int flower_id;
	private final String flower_name;
	private final int numOfFlowerPetals;
	private final float flower_price;

	public Flower(int flower_id, String flower_name, int numOfFlowerPetals, float flower_price) {
		super();
		this.flower_id = flower_id;
		this.flower_name = flower_name;
		this.numOfFlowerPetals = numOfFlowerPetals;
		this.flower_price = flower_price;
	}

	public int getFlower_id() {
		return flower_id;
	}

	public String getFlower_name() {
		return flower_name;
	}

	public int getNumOfFlowerPetals() {
		return numOfFlowerPetals;
	}

	public float getFlower_price() {
		return flower_price;
	}

	@Override
	public String toString() {
		return "[" + flower_id + "]" + "\t" + flower_name + ", petals: " + numOfFlowerPetals + ", price: "
				+ flower_price + " \u20AC";
	}

}
