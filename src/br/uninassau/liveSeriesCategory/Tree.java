package br.uninassau.liveSeriesCategory;

import java.util.Random;
import java.util.Set;

import br.uninassau.settings.Coordenadas;

public class Tree {
	Random random = new Random();
	protected Coordenadas point;

	public Tree(Set<Coordenadas> posicoesUsadas, int mapSize) {
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
}
