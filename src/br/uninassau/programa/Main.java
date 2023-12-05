package br.uninassau.programa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import br.uninassau.animal.Deer;
import br.uninassau.animal.Rabbit;
import br.uninassau.animal.Tiger;
import br.uninassau.liveSeriesCategory.Bush;
import br.uninassau.liveSeriesCategory.Tree;
import br.uninassau.settings.Colisao;
import br.uninassau.settings.Coordenadas;
import br.uninassau.settings.Mapa;
import br.uninassau.settings.Menu;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Set<Coordenadas> positionsUsed = new HashSet<Coordenadas>();

		Scanner in = new Scanner(System.in);
		Menu menu = new Menu(in);
		in.close();

		Mapa map = new Mapa(menu.getMapSize());

		int cycle = map.getCycle();

		ArrayList<Tiger> tigers = new ArrayList<Tiger>();
		ArrayList<Rabbit> rabbits = new ArrayList<Rabbit>();
		ArrayList<Deer> deers = new ArrayList<Deer>();
		ArrayList<Tree> trees = new ArrayList<Tree>();
		ArrayList<Bush> bushs = new ArrayList<Bush>();

		for (int i = 0; i < menu.getAmountTree(); i++) {
			trees.add(new Tree(positionsUsed, menu.getMapSize()));
		}
		for (int i = 0; i < menu.getAmountTiger(); i++) {
			tigers.add(new Tiger(positionsUsed, menu.getMapSize()));
		}
		for (int i = 0; i < menu.getAmountRabbit(); i++) {
			rabbits.add(new Rabbit(positionsUsed, menu.getMapSize()));
		}
		for (int i = 0; i < menu.getAmountDeer(); i++) {
			deers.add(new Deer(positionsUsed, menu.getMapSize()));
		}
		for (int i = 0; i < menu.getAmountBush(); i++) {
			bushs.add(new Bush(positionsUsed, menu.getMapSize()));
		}

		Colisao Colisao = new Colisao();

		while (true) {

			Colisao.collisionTigerAndRabbit(tigers, rabbits);
			Colisao.collisionTigerAndDeer(tigers, deers);
			Colisao.collisionRabbitAndBush(positionsUsed ,rabbits, bushs);
			Colisao.collisionDeerAndBush(positionsUsed, deers, bushs);

			for (Bush i : bushs) {
				map.addObjectOnMap(i.getPoint().getX(), i.getPoint().getY(), '*');
			}
			if(!tigers.isEmpty()) {
			for (Tiger i : tigers) {
				if (i.getLastMeal() == 0)
					map.addObjectOnMap(i.getPoint().getX(), i.getPoint().getY(), 'X');
				else
					map.addObjectOnMap(i.getPoint().getX(), i.getPoint().getY(), 'T');
			}
			}
			for (Rabbit i : rabbits) {
				if (i.getLastMeal() == 0)
					map.addObjectOnMap(i.getPoint().getX(), i.getPoint().getY(), 'c');
				else
					map.addObjectOnMap(i.getPoint().getX(), i.getPoint().getY(), 'C');
			}
			for (Deer i : deers) {
				if (i.getLastMeal() == 0)
					map.addObjectOnMap(i.getPoint().getX(), i.getPoint().getY(), 'v');
				else
					map.addObjectOnMap(i.getPoint().getX(), i.getPoint().getY(), 'V');
			}
			for (Tree i : trees) {
				map.addObjectOnMap(i.getPoint().getX(), i.getPoint().getY(), '#');
			}

			map.setCycle(cycle++);

			map.viewMap(tigers.size(), rabbits.size(), deers.size(), bushs.size(), Colisao);
			System.out.println(); 

			if(tigers.isEmpty()) {
				System.out.println("Os Carnivoros acabaram");
				System.out.println("Os herbivoros viveram em Paz (Só restou eles)");
				break;
			}
			if (rabbits.isEmpty() && deers.isEmpty()) {
				System.out.println("Os Herbivoros acabaram");
				System.out.println("Devido a falta de presas os tigre comeram sua propria especie.");
				break;
			}
			for (Tiger i : tigers) {
				map.removeObjectOnMap(i.getPoint().getX(), i.getPoint().getY());
				do {
					i.move(menu.getMapSize());
				} while (Colisao.collisionAnimalAndAnimal(i, tigers) || Colisao.collisionAnimalAndTree(i, trees));
			}
			for (Rabbit i : rabbits) {
				map.removeObjectOnMap(i.getPoint().getX(), i.getPoint().getY());
				do {
					i.move(menu.getMapSize());
				} while (Colisao.collisionAnimalAndAnimal(i, rabbits) || Colisao.collisionAnimalAndTree(i, trees));
			}
			for (Deer i : deers) {
				map.removeObjectOnMap(i.getPoint().getX(), i.getPoint().getY());
				do {
					i.move(menu.getMapSize());
				} while (Colisao.collisionAnimalAndAnimal(i, rabbits) || Colisao.collisionAnimalAndTree(i, trees));

			}

			for (Iterator<Tiger> iterator = tigers.iterator(); iterator.hasNext();) {
				Tiger tiger = iterator.next();
				if (tiger.starve()) {
					iterator.remove();
				}
			}
			for (Iterator<Rabbit> iterator = rabbits.iterator(); iterator.hasNext();) {
				Rabbit rabbit = iterator.next();
				if (rabbit.starve()) {
					iterator.remove();
				}
			}
			for (Iterator<Deer> iterator = deers.iterator(); iterator.hasNext();) {
				Deer deer = iterator.next();
				if (deer.starve()) {
					iterator.remove();
				}
			}
			if (bushs.isEmpty() || !bushs.isEmpty()) {
				if (bushs.isEmpty()) 
					bushs.add(new Bush(positionsUsed, menu.getMapSize()));
				if (bushs.get(0).newBush()) {
					for (int i = 0; i < bushs.get(0).quantityOfNewBush(); i++) {
						bushs.add(new Bush(positionsUsed, menu.getMapSize()));
					}
				}
			}
			Thread.sleep(3000);
		}
	}
}