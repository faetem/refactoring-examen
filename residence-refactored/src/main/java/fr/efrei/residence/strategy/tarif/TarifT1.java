package fr.efrei.residence.strategy.tarif;

import fr.efrei.residence.Logement;

public class TarifT1 implements TarifLogement {
    public double loyerDeBase(Logement l) {
        return l.getSurface() * 13 + 50;
    }
}
