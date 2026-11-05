package fr.efrei.residence.strategy.canal;

import fr.efrei.residence.Bail;
import fr.efrei.residence.Etudiant;
import fr.efrei.residence.Utils;
import fr.efrei.residence.factory.NotificateurFactory;

public class CanalSms implements CanalNotification {
    public void notifier(Etudiant e, String sujet, String message) {
        NotificateurFactory.creerSmsService().envoyerSms(e.getTelephone(), sujet + " - " + message);
    }
    public void relancer(Etudiant e, Bail b) {
        NotificateurFactory.creerSmsService().envoyerSms(e.getTelephone(),
                "Campus Vert : " + Utils.euros(b.soldeDu) + " impayés sur " + b.getId());
    }
}
