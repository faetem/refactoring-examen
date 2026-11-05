package fr.efrei.residence.strategy.canal;

import fr.efrei.residence.Bail;
import fr.efrei.residence.EmailService;
import fr.efrei.residence.Etudiant;
import fr.efrei.residence.Utils;

public class CanalEmail implements CanalNotification {
    public void notifier(Etudiant e, String sujet, String message) {
        EmailService.envoyer(e.getEmail(), sujet, message);
    }
    public void relancer(Etudiant e, Bail b) {
        EmailService.envoyer(e.getEmail(), "RELANCE - loyer impayé",
                "Bonjour " + e.getPrenom() + ", il reste " + Utils.euros(b.soldeDu)
                        + " à régler sur le bail " + b.getId() + ".");
    }
}
