package fr.efrei.residence;

public class TarifT1 implements TarifLogement {
    public double loyerDeBase(Logement l) {
        return l.getSurface() * 13 + 50;
    }
}
