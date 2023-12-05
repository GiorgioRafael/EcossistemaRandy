package br.uninassau.settings;

import java.util.Scanner;

public class Menu {

	private int mapSize;
	private int amountTiger;
	private int amountRabbit;
	private int amountDeer;
	private int amountArvore;
	private int amountBush;
	private int control;
	private boolean controlWhile = false;

	//call menu
	public Menu(Scanner in) {
		homeMenu(in);
	}

	public int getMapSize() {
		return mapSize;
	}

	public int getAmountTiger() {
		return amountTiger;
	}

	public int getAmountRabbit() {
		return amountRabbit;
	}
	
	public int getAmountDeer() {
		return amountDeer;
	}

	public int getAmountTree() {
		return amountArvore;
	}
	
	public int getAmountBush() {
		return amountBush;
	}
	public void homeMenu(Scanner in) {
		do {
			System.out.println("+-------------------------------------------+");
			System.out.println("|      		Iniciar o programa          |");
			System.out.println("+-------------------------------------------+");
			System.out.println("|    Pressione 1 para iniciar o programa    |");
			System.out.println("|    Outro número = finalizar o programa    |");
			System.out.println("+-------------------------------------------+");
			System.out.print("| Digite aqui: ");
			control = in.nextInt();
			if (control == 1) {
				mapSize = 12;
				amountTiger = 4;
				amountRabbit = 15;
				amountDeer = 10;
				amountArvore = 8;
				amountBush = 18;
				controlWhile = false;
			} else {
				System.exit(0);
			}
		} while (controlWhile);

	}
}
