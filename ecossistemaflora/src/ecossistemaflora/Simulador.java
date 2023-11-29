package ecossistemaflora;

public class Simulador {
    public static void main(String[] args) {
        Ecossistema ecossistema = new Ecossistema();

        Animal leao = new Animal("Leão", 100, 0, 'f', false);
        ecossistema.adicionarSerVivo(leao);
        Animal elefante = new Animal("Elefante", 50, 0, 'm', true);
        ecossistema.adicionarSerVivo(elefante);

        Planta planta = new Planta("Árvore", 100, 0, 'f', false);
        ecossistema.adicionarSerVivo(planta);

        FenomenoNatural chuva = new FenomenoNatural("Chuva");
        ecossistema.adicionarFenomenoNatural(chuva);

        for (int ciclo = 1; ciclo <= 2; ciclo++) {
            System.out.println("Ciclo " + ciclo);
            ecossistema.simularCiclo();

            for (SerVivo serVivo : ecossistema.getSeresVivos()) {
                if (serVivo instanceof Animal) {
                    Animal animal = (Animal) serVivo;
                    System.out.println(animal.getNome() + ";");
                }
            }
        }
    }
}
