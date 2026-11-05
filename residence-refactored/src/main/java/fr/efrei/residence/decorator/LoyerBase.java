package fr.efrei.residence.decorator;

import java.util.ArrayList;
import java.util.List;

public class LoyerBase implements ComposantLoyer {
    private final double montant;

    public LoyerBase(double montant) {
        this.montant = montant;
    }

    public double montant() { return montant; }
    public List<String> options() { return new ArrayList<>(); }
}
