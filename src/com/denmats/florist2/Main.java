package com.denmats.florist2;

public class Main {

	public final static Flower[] listOfFlowers = new Flower[10];

	public static void main(String[] args) {

		listOfFlowers[0] = new Flower(1, "Tulip", 15, 3.2f);
		listOfFlowers[1] = new Flower(2, "Daffodil", 20, 2.5f);
		listOfFlowers[2] = new Flower(3, "Poppy", 25, 2.1f);
		listOfFlowers[3] = new Flower(4, "Sunflower", 18, 2.4f);
		listOfFlowers[4] = new Flower(5, "Bluebell", 14, 1.5f);
		listOfFlowers[5] = new Flower(6, "Rose", 25, 5f);
		listOfFlowers[6] = new Flower(7, "Snowdrop", 30, 3.5f);
		listOfFlowers[7] = new Flower(8, "Orchid", 16, 4.5f);
		listOfFlowers[8] = new Flower(9, "Iris", 20, 2.7f);
		listOfFlowers[9] = new Flower(10, "Peony", 50, 3.2f);

		for (int i = 0; i < 10; i++) {
			System.out.println(listOfFlowers[i]);
		}

		new Statistics();
	}

}
