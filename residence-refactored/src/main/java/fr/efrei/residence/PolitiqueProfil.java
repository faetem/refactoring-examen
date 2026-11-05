package fr.efrei.residence;

public interface PolitiqueProfil {
    double appliquerRemise(double loyer, int echelon);
    boolean estSolvable(double ressourcesMensuelles, double totalMensuel);
    double caution(double loyer);
    double fraisDossier();
    int dureePreavisJours();
    double penaliteRetard(double loyerChargesComprises);
    boolean recoitToujoursEmail();
}

