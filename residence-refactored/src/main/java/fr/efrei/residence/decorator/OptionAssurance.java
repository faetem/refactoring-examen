package fr.efrei.residence.decorator;

public class OptionAssurance extends OptionLoyer {
    public OptionAssurance(ComposantLoyer interne) { super(interne); }
    public double montant() { return interne.montant() + 9; }
    protected String libelle() { return "assurance"; }
}
