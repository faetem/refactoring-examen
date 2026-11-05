package fr.efrei.residence.decorator;

public class OptionParking extends OptionLoyer {
    public OptionParking(ComposantLoyer interne) { super(interne); }
    public double montant() { return interne.montant() + 45; }
    protected String libelle() { return "parking"; }
}
