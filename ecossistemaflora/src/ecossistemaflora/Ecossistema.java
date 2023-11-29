package ecossistemaflora;

import java.util.ArrayList;
import java.util.List;

public class Ecossistema {
    private List<SerVivo> seresVivos = new ArrayList<>();

    public void adicionarSerVivo(SerVivo serVivo) {
        seresVivos.add(serVivo);
    }

    public List<SerVivo> getSeresVivos() {
        return seresVivos;
    }

    public void simularCiclo() {
        for (SerVivo serVivo : seresVivos) {
            if (serVivo instanceof Animal) {
                Animal animal = (Animal) serVivo;
                animal.mover();
                animal.crescer();
                animal.reproduzir(seresVivos);
                animal.cacar(seresVivos);
            } else if (serVivo instanceof Planta) {
                Planta planta = (Planta) serVivo;
                planta.crescer();
                planta.polinizar(seresVivos);
            }
        }
    }

    public void adicionarFenomenoNatural(FenomenoNatural fenomenoNatural) {
        seresVivos.add(fenomenoNatural);
    }
}