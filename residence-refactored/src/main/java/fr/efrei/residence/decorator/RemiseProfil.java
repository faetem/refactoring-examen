package fr.efrei.residence.decorator;

import fr.efrei.residence.strategy.profil.PolitiqueProfil;

import java.util.List;

public class RemiseProfil implements ComposantLoyer {
    private final ComposantLoyer interne;
    private final PolitiqueProfil politique;
    private final int echelon;

    public RemiseProfil(ComposantLoyer interne, PolitiqueProfil politique, int echelon) {
        this.interne = interne;
        this.politique = politique;
        this.echelon = echelon;
    }

    public double montant() { return politique.appliquerRemise(interne.montant(), echelon); }
    public List<String> options() { return interne.options(); }
}
