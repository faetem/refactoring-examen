package fr.efrei.residence.decorator;

public class OptionMenage extends OptionLoyer {
    private final double coefficient;
    public OptionMenage(ComposantLoyer interne, double coefficient) {
        super(interne);
        this.coefficient = coefficient;
    }
    public double montant() { return interne.montant() * coefficient; }
    protected String libelle() { return "ménage"; }
}
