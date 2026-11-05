package fr.efrei.residence.factory;

import fr.efrei.residence.Bail;
import fr.efrei.residence.Etudiant;
import fr.efrei.residence.Logement;

import java.time.LocalDate;

public class BailFactory {

    private BailFactory() {}

    public static Bail creer(String id, Etudiant e, Logement logement, LocalDate dateSignature,
                             boolean parking, boolean menage, boolean laverie, boolean fibre, boolean assurance,
                             double loyer, double charges, double caution, double fraisDossier) {
        Bail b = new Bail(id, e, logement, dateSignature);
        b.parking = parking;
        b.menage = menage;
        b.laverie = laverie;
        b.fibre = fibre;
        b.assurance = assurance;
        b.setLoyerHorsCharges(loyer);
        b.setCharges(charges);
        b.setCaution(caution);
        b.setFraisDossier(fraisDossier);
        return b;
    }
}
