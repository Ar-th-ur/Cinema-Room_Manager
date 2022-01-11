package com.company;

import java.util.Scanner;

public class Cinema {
	private static final Scanner scanner = new Scanner(System.in);
	private static int[][] seats;
	private static int rows;
	private static int lines;
	private static int purchasedTickets;
	private static int income;

	public static void main(String[] args) {
		rows = getWithQuestion("Enter the number of rows:");
		lines = getWithQuestion("Enter the number of seats in each row:");
		seats = new int[rows][lines];

		int choice = -1;
		while (choice != 0) {
			choice = menu();
			switch (choice) {
				case 1 -> showTheSeats();
				case 2 -> buyTicket();
				case 3 -> showStatistic();
			}
		}
	}

	private static void showStatistic() {
		float percentage = purchasedTickets * 100f / (rows * lines);
		int totalIncome = (rows - rows / 2) * 8 * lines + (rows / 2) * lines * 10;
		System.out.printf("""
				Number of purchased tickets: %d
				Percentage: %.2f%%
				Current income: $%d
				Total income: $%d
				""", purchasedTickets, percentage, income, totalIncome);
	}

	private static int menu() {
		return getWithQuestion("""
				1. Show the seats
				2. Buy a ticket
				3. Statistics
				0. Exit""");
	}

	private static void buyTicket() {
		while (true) {
			int sr = getWithQuestion("Enter a row number:");
			int sl = getWithQuestion("Enter a seat number in that row:");

			try {
				if (seats[sr - 1][sl - 1] == 1) {
					System.out.println("That ticket has already been purchased!");
					continue;
				}
			} catch (Exception e) {
				System.out.println("Wrong input!");
				continue;
			}

			seats[sr - 1][sl - 1] = 1;
			purchasedTickets++;

			int priceForTicket = 10;
			if (rows * lines > 60 && sr >= rows - rows / 2) {
				priceForTicket = 8;
			}
			income += priceForTicket;
			System.out.println("Ticket price: $" + priceForTicket);
			return;
		}
	}

	public static int getWithQuestion(String question) {
		System.out.println(question);
		return scanner.nextInt();
	}

	public static void showTheSeats() {
		System.out.print("Cinema:\n ");
		for (int i = 1; i <= lines; i++) {
			System.out.print(" " + i);
		}
		System.out.println();
		for (int i = 0; i < rows; i++) {
			System.out.print(i + 1);
			for (int j = 0; j < lines; j++) {
				if (seats[i][j] == 1) {
					System.out.print(" B");
				} else {
					System.out.print(" S");
				}
			}
			System.out.println();
		}
	}
}