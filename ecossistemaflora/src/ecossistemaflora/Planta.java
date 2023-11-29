package ecossistemaflora;

import java.util.List;

public class Planta extends SerVivo {
    public Planta(String nome, int qtdAnimal, int idade, char sexo, boolean predador) {
        super(nome, qtdAnimal, idade, sexo, predador);
    }

    public void crescer() {
        System.out.println("Planta " + getNome() + " cresce.");
    }

    public void polinizar(List<SerVivo> outrosSerVivos) {
        System.out.println("Planta " + getNome() + " poliniza.");
    }
}