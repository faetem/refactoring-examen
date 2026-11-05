package fr.efrei.residence;

import fr.efrei.residence.contrat.StatutBail;
import fr.efrei.residence.decorator.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static fr.efrei.residence.contrat.StatutBail.*;

public class Bail {

    private String id;
    private Etudiant etudiant;
    private Logement logement;
    private LocalDate dateSignature;
    private LocalDate dateEntree;
    private LocalDate dateFin;
    private StatutBail statut; // SIGNE, ACTIF, PREAVIS, TERMINE, ANNULE

    private double loyerHorsCharges;
    private double charges;
    private double caution;
    private double fraisDossier;

    public boolean parking;
    public boolean menage;
    public boolean laverie;
    public boolean fibre;
    public boolean assurance;

    public List<Paiement> paiements = new ArrayList<Paiement>();
    public double soldeDu = 0;
    public double retenues = 0;
    public double cautionRestituee = 0;

    public Bail(String id, Etudiant etudiant, Logement logement, LocalDate dateSignature) {
        this.id = id;
        this.etudiant = etudiant;
        this.logement = logement;
        this.dateSignature = dateSignature;
        this.statut = SIGNE;
    }

    public String getId() { return id; }
    public Etudiant getEtudiant() { return etudiant; }
    public Logement getLogement() { return logement; }
    public LocalDate getDateSignature() { return dateSignature; }
    public LocalDate getDateEntree() { return dateEntree; }
    public void setDateEntree(LocalDate d) { this.dateEntree = d; }
    public LocalDate getDateFin() { return dateFin; }
    public void setDateFin(LocalDate d) { this.dateFin = d; }
    public StatutBail getStatut() { return statut; }
    public void setStatut(StatutBail statut) { this.statut = statut; }
    public double getLoyerHorsCharges() { return loyerHorsCharges; }
    public void setLoyerHorsCharges(double l) { this.loyerHorsCharges = l; }
    public double getCharges() { return charges; }
    public void setCharges(double c) { this.charges = c; }
    public double getLoyerChargesComprises() { return Utils.arrondir(loyerHorsCharges + charges); }
    public double getCaution() { return caution; }
    public void setCaution(double c) { this.caution = c; }
    public double getFraisDossier() { return fraisDossier; }
    public void setFraisDossier(double f) { this.fraisDossier = f; }

    public String listerOptions() {
        ComposantLoyer c = new LoyerBase(0);
        if (menage) c = new OptionMenage(c, 1);
        if (parking) c = new OptionParking(c);
        if (laverie) c = new OptionLaverie(c);
        if (fibre) c = new OptionFibre(c, 0);
        if (assurance) c = new OptionAssurance(c);

        List<String> options = c.options();
        if (options.isEmpty()) return "aucune";
        return String.join(", ", options);

    }

    /**
     * Quittance de loyer pour un mois payé (format AAAA-MM).
     */
    public String genererQuittance(String mois) {
        Paiement p = null;
        for (Paiement x : paiements) {
            if (x.mois.equals(mois)) p = x;
        }
        if (p == null) {
            return "Aucun paiement pour " + mois;
        }
        String q = "";
        q += "==========================================\n";
        q += "   RÉSIDENCE CAMPUS VERT - QUITTANCE\n";
        q += "==========================================\n";
        q += "Bail      : " + id + "\n";
        q += "Locataire : " + etudiant.getNomComplet() + " (" + etudiant.getProfil() + ")\n";
        q += "Logement  : " + logement.getNumero() + " - " + logement.getType() + " " + logement.getSurface() + " m²";
        if (logement.isMeuble()) q += " meublé";
        q += "\n";
        q += "Période   : " + mois + "\n";
        q += "Options   : " + listerOptions() + "\n";
        q += "------------------------------------------\n";
        q += "Loyer HC  : " + Utils.euros(loyerHorsCharges) + "\n";
        q += "Charges   : " + Utils.euros(charges) + "\n";
        if (p.penalite > 0) {
            q += "Pénalité  : " + Utils.euros(p.penalite) + "\n";
        }
        q += "Total dû  : " + Utils.euros(p.du) + "\n";
        q += "Payé le   : " + Utils.date(p.date) + " : " + Utils.euros(p.montant) + "\n";
        if (p.montant < p.du) {
            q += "RESTE DÛ  : " + Utils.euros(Utils.arrondir(p.du - p.montant)) + "\n";
        }
        q += "==========================================";
        return q;
    }
}
