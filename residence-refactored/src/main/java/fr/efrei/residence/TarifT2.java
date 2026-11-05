package fr.efrei.residence;

public class TarifT2 implements TarifLogement {
    public double loyerDeBase(Logement l) {
        return l.getSurface() * 12 + 100;
    }
}
