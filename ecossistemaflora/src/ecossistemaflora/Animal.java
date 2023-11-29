package ecossistemaflora;

import java.util.List;

public class Animal extends SerVivo {
    public Animal(String nome, int qtdAnimal, int idade, char sexo, boolean predador) {
        super(nome, qtdAnimal, idade, sexo, predador);
    }

    public void mover() {
        System.out.println("Animal " + getNome() + " se move.");
    }

    public void reproduzir(List<SerVivo> outrosSerVivos) {
        System.out.println("Animal " + getNome() + " se reproduz.");
    }

    public void cacar(List<SerVivo> outrosSerVivos) {
        System.out.println("Animal " + getNome() + " caça.");
    }

    public void crescer() {
        System.out.println("Animal " + getNome() + " cresce.");
    }
}