package fr.efrei.residence;

public class PolitiqueInternational implements PolitiqueProfil {
    public double appliquerRemise(double loyer, int echelon) { return loyer; }
    public boolean estSolvable(double ressources, double total) { return ressources >= total * 3; }
    public double caution(double loyer) { return loyer * 2; }
    public double fraisDossier() { return 150; }
    public int dureePreavisJours() { return 30; }
    public double penaliteRetard(double cc) {
        double p = cc * 0.05;
        if (p < 10) p = 10;
        return Utils.arrondir(p);
    }
    public boolean recoitToujoursEmail() { return true; }
}
