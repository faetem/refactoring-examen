package fr.efrei.residence;

import fr.efrei.residence.contrat.TypeLogement;

public class LogementFactory {
    private LogementFactory() {}

    public static Logement creer(TypeLogement type, String numero, double surface,
                                 int etage, boolean meuble, int param) {
        switch (type) {
            case STUDIO: return new Studio(numero, surface, etage, meuble);
            case T1:     return new T1(numero, surface, etage, meuble);
            case T2:     return new T2(numero, surface, etage, meuble, param);
            case COLOCATION: return new Colocation(numero, surface, etage, meuble, param);
            default:
                throw new IllegalArgumentException("Type de logement inconnu : " + type);
        }
    }

    public static Logement depuisLigneCatalogue(String ligne) {
        String[] t = ligne.split(";");
        return creer(TypeLogement.valueOf(t[0]), t[1], Double.parseDouble(t[2]),
                Integer.parseInt(t[3]), Boolean.parseBoolean(t[4]), Integer.parseInt(t[5]));
    }
}
