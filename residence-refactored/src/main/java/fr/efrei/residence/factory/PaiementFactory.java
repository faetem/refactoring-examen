package fr.efrei.residence.factory;

import fr.efrei.residence.Paiement;

import java.time.LocalDate;

public class PaiementFactory {
    private PaiementFactory() {}

    public static Paiement creer(String mois, LocalDate date, double montant, double penalite, double du) {
        return new Paiement(mois, date, montant, penalite, du);
    }
}
