package fr.efrei.residence.strategy.profil;

public class PolitiqueBoursier implements PolitiqueProfil {
    public double appliquerRemise(double loyer, int echelon) {
        double taux = echelon * 0.05;
        if (taux > 0.30) taux = 0.30;
        return loyer * (1 - taux);
    }
    public boolean estSolvable(double ressources, double total) { return true; } // garantie Visale
    public double caution(double loyer) { return 0; }
    public double fraisDossier() { return 0; }
    public int dureePreavisJours() { return 15; }
    public double penaliteRetard(double cc) { return 0; }
    public boolean recoitToujoursEmail() { return false; }
}
