package fr.efrei.residence;

public class PolitiqueAlternant implements PolitiqueProfil {
    public double appliquerRemise(double loyer, int echelon) { return loyer * 0.90; }
    public boolean estSolvable(double ressources, double total) { return ressources >= total * 2; }
    public double caution(double loyer) { return loyer; }
    public double fraisDossier() { return 100; }
    public int dureePreavisJours() { return 15; }
    public double penaliteRetard(double cc) {
        double p = cc * 0.05;
        if (p < 10) p = 10;
        return Utils.arrondir(p);
    }
    public boolean recoitToujoursEmail() { return false; }
}
