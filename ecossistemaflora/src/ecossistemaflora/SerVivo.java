package ecossistemaflora;

public class SerVivo {
    protected String nome;
    protected int qtdAnimal;
    protected int idade;
    protected char sexo;
    protected boolean predador;

    public SerVivo(String nome, int qtdAnimal, int idade, char sexo, boolean predador) {
        this.nome = nome;
        this.qtdAnimal = qtdAnimal;
        this.idade = idade;
        this.sexo = sexo;
        this.predador = predador;
    }

    public String getNome() {
        return nome;
    }
}
