package fr.efrei.residence.strategy.tarif;

import fr.efrei.residence.Logement;

public class TarifStudio implements TarifLogement {
    public double loyerDeBase(Logement l) {
        double loyer = l.getSurface() * 14;
        if (loyer < 350) loyer = 350;
        return loyer;
    }
}
