package br.uninassau.settings;

public class Mapa {
	private int mapSize;
	private char[][] map;
	private int cycle = 1;

	public final String ANSI_RESET = "\u001B[0m";
	public final String ANSI_VERMELHO = "\u001B[31m";
	public final String ANSI_VERDE = "\u001B[32m";

	public Mapa(int mapSize) {
		this.mapSize = mapSize;
		// mapa j� construido
		/// a ideia � ele ser construido uma vez apenas e sofrer altera��es.
		// est� aqui dentro para criar o mapa quando j� tiver o tamanho do mapa
		this.map = constructorMap(); // se estiver fora ele cria o mapa antes do tamanho
	}

	public int getCycle() {
		return cycle;
	}

	public void setCycle(int cycle) {
		this.cycle = cycle;
	}

	// Cronstrução do mapa
	public char[][] constructorMap() {
		char[][] map = new char[mapSize][mapSize];
		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++) {
				map[j][i] = '.';
			}
		}
		return map;
	}

	public void viewMap(int liveQuantityOfTiger, int liveQuantityOfRabbit, int liveQuantityOfDeer,
			int liveQuantityOfBush, Colisao colision) {
		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++) {
				if (map[j][i] == 'X')
					System.out.print(ANSI_VERMELHO + map[j][i] + " " + ANSI_RESET);
				else if (map[j][i] == 'c' || map[j][i] == 'v')
					System.out.print(ANSI_VERDE + map[j][i] + " " + ANSI_RESET);
				else
					System.out.print(map[j][i] + " ");
			}
			if (i == 0) {
				System.out.printf("| Ciclo do mapa: %d | Tamanho: %dx%d%n", cycle, mapSize, mapSize);
			} else if (i == 1) {
				System.out.printf("| Tigres(T) vivos = %d%n", liveQuantityOfTiger);
			} else if (i == 2) {
				System.out.printf("| Coelhos(C) vivos = %d%n", liveQuantityOfRabbit);
			} else if (i == 3) {
				System.out.printf("| Veados(V) vivos = %d%n", liveQuantityOfDeer);
			} else if (i == 4) {
				System.out.printf("| Arbustos(*) quantidades = %d%n", liveQuantityOfBush);
			} else if (i == 5) {
				if (colision.animalIsDead && !colision.herbivoreFed) {
					System.out.println("| " + ANSI_VERMELHO + "Tigre acaba de matar um Animal" + ANSI_RESET);
					colision.animalIsDead = false;
				} else if (!colision.animalIsDead && colision.herbivoreFed) {
					System.out.println("| " + ANSI_VERDE + "Um Herbivoro alimentou-se" + ANSI_RESET);
					colision.herbivoreFed = false;
				} else if (colision.animalIsDead && colision.herbivoreFed) {
					System.out.println("| " + ANSI_VERMELHO + "Tigre acaba de matar um Animal" + ANSI_RESET + " | "
							+ ANSI_VERDE + "Herbivoro abacou de alimentar-se" + ANSI_RESET);
					colision.animalIsDead = false;
					colision.herbivoreFed = false;
				} else
					System.out.println("| ");
			}else {
				System.out.println("| ");
			}
		}
	}

	public void addObjectOnMap(int x, int y, char symbol) {
		map[x][y] = symbol;
	}

	public void removeObjectOnMap(int x, int y) {
		map[x][y] = '.';
	}
}
