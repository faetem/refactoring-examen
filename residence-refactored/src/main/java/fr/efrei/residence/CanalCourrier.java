package fr.efrei.residence;

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
