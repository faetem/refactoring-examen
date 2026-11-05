package fr.efrei.residence.strategy.canal;

import fr.efrei.residence.Bail;
import fr.efrei.residence.Etudiant;

public interface CanalNotification {
    void notifier(Etudiant e, String sujet, String message);
    void relancer(Etudiant e, Bail b);
}

