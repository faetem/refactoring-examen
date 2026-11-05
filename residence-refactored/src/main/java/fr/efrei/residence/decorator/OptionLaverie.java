package fr.efrei.residence.decorator;

public class OptionLaverie extends OptionLoyer {
    public OptionLaverie(ComposantLoyer interne) { super(interne); }
    public double montant() { return interne.montant() + 12; }
    protected String libelle() { return "laverie"; }
}
