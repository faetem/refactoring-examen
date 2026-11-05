package fr.efrei.residence.factory;

import fr.efrei.residence.CourrierService;
import fr.efrei.residence.SmsService;

public class NotificateurFactory {
    private NotificateurFactory() {}

    public static SmsService creerSmsService() {
        return new SmsService();
    }

    public static CourrierService creerCourrierService() {
        return new CourrierService();
    }
}
