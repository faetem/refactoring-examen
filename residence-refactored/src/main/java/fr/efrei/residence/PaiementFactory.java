package fr.efrei.residence;

import java.time.LocalDate;

public class PaiementFactory {
    private PaiementFactory() {}

    public static Paiement creer(String mois, LocalDate date, double montant, double penalite, double du) {
        return new Paiement(mois, date, montant, penalite, du);
    }
}
