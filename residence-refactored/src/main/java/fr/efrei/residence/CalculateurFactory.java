package fr.efrei.residence;

public class CalculateurFactory {
    private CalculateurFactory() {}
    public static CalculateurLoyer creer() { return new CalculateurLoyer(); }
}
