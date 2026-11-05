package fr.efrei.residence;

import fr.efrei.residence.contrat.Profil;
import fr.efrei.residence.contrat.TypeLogement;
import fr.efrei.residence.decorator.*;
import fr.efrei.residence.strategy.profil.*;
import fr.efrei.residence.strategy.tarif.*;

import java.util.EnumMap;
import java.util.Map;

public class CalculateurLoyer {

    Map<TypeLogement, TarifLogement> tarifs = new EnumMap<>(TypeLogement.class);
    Map<Profil, PolitiqueProfil> politiques = new EnumMap<>(Profil.class);

    public CalculateurLoyer() {
        tarifs.put(TypeLogement.STUDIO, new TarifStudio());
        tarifs.put(TypeLogement.T1, new TarifT1());
        tarifs.put(TypeLogement.T2, new TarifT2());
        tarifs.put(TypeLogement.COLOCATION, new TarifColocation());

        politiques.put(Profil.STANDARD, new PolitiqueStandard());
        politiques.put(Profil.BOURSIER, new PolitiqueBoursier());
        politiques.put(Profil.ALTERNANT, new PolitiqueAlternant());
        politiques.put(Profil.INTERNATIONAL, new PolitiqueInternational());
    }

    private TarifLogement tarif(Logement l) {
        TarifLogement t = tarifs.get(l.getType());
        if (t == null) {
            throw new IllegalArgumentException("Type de logement inconnu : " + l.getType());
        }
        return t;
    }

    public PolitiqueProfil politique(Profil profil) {
        PolitiqueProfil p = politiques.get(profil);
        if (p == null) {
            throw new IllegalArgumentException("Profil inconnu : " + profil);
        }
        return p;
    }

    public double calculerLoyer(Logement l, Profil profil, int echelon, boolean parking, boolean menage,
                                boolean laverie, boolean fibre, boolean assurance) {
        return calculerLoyer(l, politique(profil), echelon, parking, menage, laverie, fibre, assurance);
    }

    /**
     * Loyer mensuel hors charges, options comprises, remise déduite.
     */
    public double calculerLoyer(Logement l, PolitiqueProfil politique, int echelon, boolean parking, boolean menage,
                                boolean laverie, boolean fibre, boolean assurance) {

        TarifLogement tarif = tarif(l);

        // loyer de base selon le type
        double base = tarif.loyerDeBase(l);

        if (l.isMeuble()) base = base * 1.15;
        if (l.getEtage() == 0) base = base * 0.95;

        // calcul du loyer selon les options
        ComposantLoyer loyer = new LoyerBase(base);
        if (menage) loyer = new OptionMenage(loyer, tarif.coefficientMenage());
        if (parking) loyer = new OptionParking(loyer);
        if (laverie) loyer = new OptionLaverie(loyer);
        if (fibre) loyer = new OptionFibre(loyer, tarif.supplementFibre());
        if (assurance) loyer = new OptionAssurance(loyer);
        loyer = new RemiseProfil(loyer, politique, echelon);

        return Math.round(loyer.montant() * 100.0) / 100.0;

    }

    public double calculerCharges(Logement l) {
        return tarif(l).charges();
    }
}
