package com.denmats.florist2;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Statistics {
	private List<FlowerLab> flowers;

	private static Scanner sc = new Scanner(System.in);

	public Statistics() {
		super();
		this.flowers = new ArrayList<>();

		addFlower();
		System.out.println(getFlowers());
		System.out.println("Total Price: "
				+ NumberFormat.getCurrencyInstance(Locale.GERMANY).format(getTotalPriceOfAllSoldFlowers(flowers)));
		System.out.println("Weighted Average Price: "
				+ NumberFormat.getCurrencyInstance(Locale.GERMANY).format(getWeightedAveragePrice(flowers)));
		System.out.println(
				"Average Price: " + NumberFormat.getCurrencyInstance(Locale.GERMANY).format(getAveragePrice(flowers)));
		System.out.println(
				"Median Price: " + NumberFormat.getCurrencyInstance(Locale.GERMANY).format(getMedianPrice(flowers)));
		System.out.println("The most popular flower(s):  " + getTheMostPopularFlower());
	}

	public List<FlowerLab> getFlowers() {
		return flowers;
	}

	private void addFlower() {
		boolean isAnotherFlower = true;

		while (isAnotherFlower) {
			System.out.println("Enter number of flower 1-10 or q - exit: ");
			if (sc.hasNextLine()) {
				switch (sc.nextLine()) {
				case "1":
					flowers.add(new FlowerLab(new Flower(1, "Tulip", 15, 3.2f)));
					break;
				case "2":
					flowers.add(new FlowerLab(new Flower(2, "Daffodil", 20, 2.5f)));
					break;
				case "3":
					flowers.add(new FlowerLab(new Flower(3, "Poppy", 25, 2.1f)));
					break;
				case "4":
					flowers.add(new FlowerLab(new Flower(4, "Sunflower", 18, 2.4f)));
					break;
				case "5":
					flowers.add(new FlowerLab(new Flower(5, "Bluebell", 14, 1.5f)));
					break;
				case "6":
					flowers.add(new FlowerLab(new Flower(6, "Rose", 25, 5f)));
					break;
				case "7":
					flowers.add(new FlowerLab(new Flower(7, "Snowdrop", 30, 3.5f)));
					break;
				case "8":
					flowers.add(new FlowerLab(new Flower(8, "Orchid", 16, 4.5f)));
					break;
				case "9":
					flowers.add(new FlowerLab(new Flower(9, "Iris", 20, 2.7f)));
					break;
				case "10":
					flowers.add(new FlowerLab(new Flower(10, "Peony", 50, 3.2f)));
					break;
				case "q":
				case "Q":
					isAnotherFlower = false;
					break;
				default:
					System.out.println("There is no such a flower");
					break;
				}
			}
		}
	}

	public float getTotalPriceOfAllSoldFlowers(List<FlowerLab> flowers) {
		float totalPrice = 0;
		for (FlowerLab f : flowers) {
			totalPrice += f.getNumOfFlowers() * f.getFlower().getFlower_price();
		}

		return totalPrice;
	}

	public float getWeightedAveragePrice(List<FlowerLab> flowers) {
		int totalNum = 0;
		for (FlowerLab f : flowers) {
			totalNum += f.getNumOfFlowers();
		}

		return getTotalPriceOfAllSoldFlowers(flowers) / totalNum;
	}

	public float getAveragePrice(List<FlowerLab> flowers) {
		float priceOfAllSoldFlowers = 0;
		int numOfAllSoldFlowers = 0;
		for (FlowerLab f : flowers) {
			priceOfAllSoldFlowers += f.getFlower().getFlower_price();
			numOfAllSoldFlowers++;
		}

		return priceOfAllSoldFlowers / numOfAllSoldFlowers;
	}

	public float getMedianPrice(List<FlowerLab> flowers) {
		float tab[] = new float[flowers.size()];
		float medianPrice = 0;
		int counter = 0;
		for (FlowerLab f : flowers) {
			tab[counter] = f.getFlower().getFlower_price();
			counter++;
		}

		Arrays.sort(tab);
		// System.out.println(Arrays.toString(tab));

		int index = tab.length / 2;
		if (tab.length % 2 != 0 || tab.length == 1) {
			medianPrice = tab[index];
		}

		if (tab.length % 2 == 0) {
			medianPrice = (tab[index - 1] + tab[index]) / 2;
		}

		return medianPrice;
	}

	public List<String> getTheMostPopularFlower() {
		Flower[] listOfFlowers = Main.listOfFlowers;
		List<String> popularity = new ArrayList<>();
		int[] amount = new int[10];

		// Group up and match up amount of flowers with flower's id.
		// flower's id is reduced by 1 due to match up amount[] length
		// id starts from 1 to 10, the array starts from 0 to 9
		for (int i = 0; i < flowers.size(); i++) {
			amount[flowers.get(i).getFlower().getFlower_id() - 1] += flowers.get(i).getNumOfFlowers();
		}

		// Search for maximum amount of flowers
		int maximum = 0;
		for (int i = 0; i < 10; i++) {
			if (maximum < amount[i]) {
				maximum = amount[i];
			}
		}

		// Match up maximum with flower name
		// Add the most popular flower name to list
		for (int i = 0; i < 10; i++) {
			if (amount[i] == maximum) {
				popularity.add(listOfFlowers[i].getFlower_name());
			}
		}

		return popularity;
	}

}// End of class
