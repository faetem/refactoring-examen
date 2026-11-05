package fr.efrei.residence.factory;

import fr.efrei.residence.CalculateurLoyer;

public class CalculateurFactory {
    private CalculateurFactory() {}
    public static CalculateurLoyer creer() { return new CalculateurLoyer(); }
}
