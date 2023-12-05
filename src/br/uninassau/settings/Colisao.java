package br.uninassau.settings;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import br.uninassau.animal.Deer;
import br.uninassau.animal.Rabbit;
import br.uninassau.animal.Tiger;
import br.uninassau.liveSeriesCategory.Animal;
import br.uninassau.liveSeriesCategory.Bush;
import br.uninassau.liveSeriesCategory.Tree;

public class Colisao {
	protected boolean animalIsDead = false;
	protected boolean herbivoreFed = false;

	public void collisionTigerAndRabbit(ArrayList<Tiger> tigers, ArrayList<Rabbit> rabbits) {

		Iterator<Rabbit> rabbitIterator = rabbits.iterator();
	
		while (rabbitIterator.hasNext()) {
			Rabbit rabbit = rabbitIterator.next(); 
			for (Tiger tiger : tigers) {
				if (tiger.getPoint().equals(rabbit.getPoint())) {
					animalIsDead = true;
					rabbitIterator.remove(); 
					tiger.food(); 
					break; 
				}
			}
		}
	}

	public void collisionTigerAndDeer(ArrayList<Tiger> tigers, ArrayList<Deer> deers) {
		Iterator<Deer> deerIterator = deers.iterator(); 
		while (deerIterator.hasNext()) {
			Deer deer = deerIterator.next(); 
			for (Tiger tiger : tigers) {
				if (tiger.getPoint().equals(deer.getPoint())) {
					animalIsDead = true;
					deerIterator.remove(); 
					tiger.food();
					break;
				}
			}
		}
	}

	public boolean collisionAnimalAndTree(Animal animal, ArrayList<Tree> trees) {
		for (Tree tree : trees) {
			if (animal.getPoint().equals(tree.getPoint())) {
				return true; 
			}
		}
		return false;
	}


	public boolean collisionAnimalAndAnimal(Animal animal, ArrayList<? extends Animal> animals) {
		for (Animal otherAnimal : animals) {
			if (!animal.equals(otherAnimal) && animal.getPoint().equals(otherAnimal.getPoint())) {
				return true;
			}
		}
		return false; 
	}

	public void collisionRabbitAndBush(Set<Coordenadas> posicoesUsadas, ArrayList<Rabbit> rabbits, ArrayList<Bush> bushs) {
		Iterator<Bush> bushIterator = bushs.iterator(); 
	

		while (bushIterator.hasNext()) {
			Bush bush = bushIterator.next();
			for (Rabbit rabbit : rabbits) {
				if (rabbit.getPoint().equals(bush.getPoint())) {
					bushIterator.remove(); // 
					posicoesUsadas.removeAll(posicoesUsadas);
					rabbit.food();
					herbivoreFed = true;
					break; 
				}
			}
		}
	}

	// veado comer um arbusto
	public void collisionDeerAndBush(Set<Coordenadas> posicoesUsadas, ArrayList<Deer> deers, ArrayList<Bush> bushs) {
		Iterator<Bush> bushIterator = bushs.iterator();
		while (bushIterator.hasNext()) {
			Bush bush = bushIterator.next();
			for (Deer deer : deers) {
				if (deer.getPoint().equals(bush.getPoint())) {
					bushIterator.remove();
					posicoesUsadas.removeAll(posicoesUsadas);
					deer.food();
					herbivoreFed = true;
					break;
				}
			}
		}
	}
}
