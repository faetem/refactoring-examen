package fr.efrei.residence.factory;

import fr.efrei.residence.Etudiant;
import fr.efrei.residence.contrat.Canal;
import fr.efrei.residence.contrat.Profil;

public class EtudiantFactory {
    private EtudiantFactory() {}

    public static Etudiant creer(String nom, String prenom, String email, String telephone, String adresse,
                                 Profil profil, int echelonBourse, double ressources, boolean pmr,
                                 Canal canalPrefere) {
        return new Etudiant(nom, prenom, email, telephone, adresse, profil, echelonBourse, ressources, pmr,
                canalPrefere);
    }
}
