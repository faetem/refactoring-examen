package fr.efrei.residence.decorator;

public class OptionFibre extends OptionLoyer {
    private final double supplement;
    public OptionFibre(ComposantLoyer interne, double supplement) {
        super(interne);
        this.supplement = supplement;
    }
    public double montant() { return interne.montant() + supplement; }
    protected String libelle() { return "fibre"; }
}
