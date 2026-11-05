package fr.efrei.residence.strategy.tarif;

import fr.efrei.residence.Logement;

public class TarifColocation implements TarifLogement {
    public double loyerDeBase(Logement l) {
        return l.getSurface() * 11 / l.getNombrePlaces();
    }
    public double coefficientMenage() { return 1.04; } // parties communes déjà nettoyées
    public double supplementFibre()   { return 0; }    // fibre incluse en coloc
    public double charges()           { return 25; }
}
