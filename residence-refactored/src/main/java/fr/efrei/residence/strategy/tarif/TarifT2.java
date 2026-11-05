package fr.efrei.residence.strategy.tarif;

import fr.efrei.residence.Logement;

public class TarifT2 implements TarifLogement {
    public double loyerDeBase(Logement l) {
        return l.getSurface() * 12 + 100;
    }
}
