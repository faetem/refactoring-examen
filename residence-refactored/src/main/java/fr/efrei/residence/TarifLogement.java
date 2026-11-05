package fr.efrei.residence;

public interface TarifLogement {
    double loyerDeBase(Logement l);

    default double coefficientMenage() { return 1.08; }
    default double supplementFibre()   { return 20; }
    default double charges()           { return 35; }
}

