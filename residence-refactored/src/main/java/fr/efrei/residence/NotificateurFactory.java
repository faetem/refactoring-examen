package fr.efrei.residence;

public class NotificateurFactory {
    private NotificateurFactory() {}

    public static SmsService creerSmsService() {
        return new SmsService();
    }

    public static CourrierService creerCourrierService() {
        return new CourrierService();
    }
}
