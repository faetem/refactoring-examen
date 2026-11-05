package fr.efrei.residence.decorator;

import java.util.List;

public abstract class OptionLoyer implements ComposantLoyer {
    protected final ComposantLoyer interne;

    protected OptionLoyer(ComposantLoyer interne) {
        this.interne = interne;
    }

    protected abstract String libelle();

    public List<String> options() {
        List<String> liste = interne.options();
        liste.add(libelle());
        return liste;
    }
}

