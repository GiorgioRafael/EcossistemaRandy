package br.uninassau.liveSeriesCategory;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

import br.uninassau.settings.Coordenadas;

public class Animal {
	Random random = new Random();
	private Coordenadas point;
	private int lastMeal = 1;
	
	public int getLastMeal() {
		return lastMeal;
	}

	public Animal(Set<Coordenadas> posicoesUsadas, int mapSize) {
		this.point = setSpawn(posicoesUsadas, mapSize); 
	}

	public Coordenadas setSpawn(Set<Coordenadas> posicoesUsadas, int mapSize) {
		Random random = new Random();
		Coordenadas ponto;
		do {
			int x = random.nextInt(mapSize);
			int y = random.nextInt(mapSize);
			ponto = new Coordenadas(x, y); 
		} while (posicoesUsadas.contains(ponto));
		posicoesUsadas.add(ponto); 
		return ponto; 
	}

	public Coordenadas getPoint() {
		return point;
	}

	public boolean isNextPositionValid(int newX, int newY, ArrayList<Tree> trees) {
		for (Tree tree : trees) {
			if (tree.getPoint().getX() == newX && tree.getPoint().getY() == newY) {
				return false; 
			}
		}
		return true; 
	}

	public void move(int mapSize) {
		int direction = random.nextInt(4);
		int newX = point.getX();
		int newY = point.getY();

		switch (direction) {
		case 0: {
			point.setY((newY - 1) != -1 ? (newY - 1) : newY);
			break;
		}
		case 1: {
			point.setX((newX + 1) != mapSize ? (newX + 1) : newX);
			break;
		}
		case 2: {
			point.setY((newY + 1) != mapSize ? (newY + 1) : newY);
			break;
		}
		case 3: {
			point.setX((newX - 1) != -1 ? (newX - 1) : newX);
			break;
		}
		}
	}

	public boolean starve() {
		lastMeal++;
		return (lastMeal == 15) ? true : false;
	}

	public void food() {
		lastMeal = 0;
	}
}
