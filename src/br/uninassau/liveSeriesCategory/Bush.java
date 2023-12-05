package br.uninassau.liveSeriesCategory;

import java.util.Random;
import java.util.Set;

import br.uninassau.settings.Coordenadas;

public class Bush extends Tree {
	Random random = new Random();
	private int cycleToGrow = 0;

	public Bush(Set<Coordenadas> posicoesUsadas, int mapSize) {
		super(posicoesUsadas, mapSize);
	}

	public boolean newBush() {
		cycleToGrow++;
		if (cycleToGrow == 5) {
			cycleToGrow = 0;
			return true;
		} else
			return false;
	}

	public int quantityOfNewBush() {
		return random.nextInt(8, 10);
	}
}
