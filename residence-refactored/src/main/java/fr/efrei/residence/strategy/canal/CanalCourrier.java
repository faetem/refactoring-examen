package fr.efrei.residence.strategy.canal;

import fr.efrei.residence.Bail;
import fr.efrei.residence.Etudiant;
import fr.efrei.residence.Utils;
import fr.efrei.residence.factory.NotificateurFactory;

public class CanalCourrier implements CanalNotification {
    public void notifier(Etudiant e, String sujet, String message) {
        NotificateurFactory.creerCourrierService().imprimerEtPoster(e.getNomComplet(), e.getAdresse(), sujet, message);
    }
    public void relancer(Etudiant e, Bail b) {
        NotificateurFactory.creerCourrierService().imprimerEtPoster(e.getNomComplet(), e.getAdresse(),
                "Relance loyer impayé",
                "Il reste " + Utils.euros(b.soldeDu) + " à régler sur le bail " + b.getId() + ".");
    }
}
